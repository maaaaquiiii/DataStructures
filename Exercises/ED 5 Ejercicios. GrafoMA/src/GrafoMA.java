public class GrafoMA {
    private int numVertices;          // Número de vértices.
    private boolean dirigido;
    private boolean[][] matrizAdy;    // Matriz de adyacencias del grafo.


    public GrafoMA(int numVertices, boolean dirigido) { //construye una matriz de nxn sin arcos
        this.dirigido = dirigido;
        this.numVertices = numVertices;
        matrizAdy = new boolean[numVertices][numVertices];
        this.inicializaMA();
    }

    private void inicializaMA() {
        for (int i = 0; i < numVertices; i++)
            for (int j = 0; j < numVertices; j++)
                matrizAdy[i][j] = false;
    }

    public int getNumVertices() {
        return numVertices;
    }

    public boolean getDirigido() {
        return dirigido;
    }


    // ------------------------------------

    // MÉTODOS PARA INSERTAR Y ELIMINAR VERTICES

    // ------------------------------------

    public void insertarArista(int u, int v) {
        if (this.verticeEnRango(u) && this.verticeEnRango(v)) {
            matrizAdy[u][v] = true;
            if (!dirigido) {
                matrizAdy[v][u] = true;
            }
        } else {
            System.out.println("Error, los vertices " + u + ", " + v + " no se encuentran en el grafo.");
        }
    }

    public boolean verticeEnRango(int v) {
        return (v < numVertices) && (v >= 0);
    }


    public void eliminarArista(int u, int v) {
        if (this.verticeEnRango(u) && this.verticeEnRango(v)) {
            matrizAdy[u][v] = false;
            if (!dirigido) {
                matrizAdy[v][u] = false;
            }
        } else {
            System.out.println("Error, los vertices " + u + ", " + v + " no se encuentran en el grafo.");
        }
    }

    public boolean existeArista(int u, int v) {
        if (this.verticeEnRango(u) && this.verticeEnRango(v)) {
            return matrizAdy[u][v];
        } else {
            return false;
        }
    }

    public int gradoEntrada(int v) {
        int resultado = 0;
        if (verticeEnRango(v)) {
            for (int i = 0; i < numVertices; i++) {     //Recorrer columna v
                if (matrizAdy[i][v]) {
                    resultado++;
                }
            }
        }
        return resultado;
    }

    public int gradoSalida(int v) {
        int resultado = 0;
        if (verticeEnRango(v)) {
            for (int j = 0; j < numVertices; j++) {     //Recorrer fila v
                if (matrizAdy[v][j]) {
                    resultado++;
                }
            }
        }
        return resultado;
    }

    public int incidencia(int v) {
        int resultado = 0;
        if (verticeEnRango(v)) {
            if (!dirigido) {
                resultado = gradoEntrada(v);
            } else {
                resultado = gradoEntrada(v) + gradoSalida(v);
            }
        }
        return resultado;
    }

    public int numAristas() {   // Número total de aristas del grafo
        int resultado = 0;
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                if (matrizAdy[i][j]) {
                    if (dirigido || i >= j) {
                        resultado++;
                    }
                }
            }
        }
        return resultado;
    }


    public void mostrar() {
        System.out.println("La matriz contiene " + numVertices + " vertices");
        if (dirigido) {
            System.out.println("Es dirigido");
        } else {
            System.out.println("No es dirigido");
        }
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                if (matrizAdy[i][j]) {
                    System.out.print("T ");
                } else {
                    System.out.print("F ");
                }
            }
            System.out.println();
        }
    }

    public void profundidadDesdeVertice(int v) {
        if (this.verticeEnRango(v)) {
            boolean[] visitados = new boolean[numVertices];
            for (int i = 0; i < numVertices; i++) {
                visitados[i] = false;
            }
            // Realizar recorrido desde el vértice v.
            this.recorridoEnProfundidad(v, visitados);
            System.out.println();
        }
    }


    public void recorridoEnProfundidad(int v, boolean[] visitados) {
        visitados[v] = true;   // Nodo v visitado
        //System.out.print(v + " ");
        // Recorrido desde vértices adyacentes a v
        for (int i = 0; i < numVertices; i++) {
            if (this.existeArista(v, i) && !visitados[i])
                this.recorridoEnProfundidad(i, visitados);
        }
    }


    public void profundidadCompleto() {
        boolean[] visitados = new boolean[numVertices];
        for (int i = 0; i < numVertices; i++) {
            visitados[i] = false;
        }
        // Realizar recorrido desde cada vértice hasta que todos hayan sido visitados.
        for (int i = 0; i < numVertices; i++) {
            if (!visitados[i]) {
                recorridoEnProfundidad(i, visitados);
            }
        }
    }

    public void amplitudDesdeVertice(int v) {
        boolean[] visitados = new boolean[numVertices];
        for (int i = 0; i < numVertices; i++) {
            visitados[i] = false;
        }
        this.recorrerAmplitudVertice(v, visitados);
        System.out.println();
    }

    private void recorrerAmplitudVertice(int v, boolean[] visitados) {
        Cola cola = new Cola();
        cola.encolar(v);    //Encolar y marcar como visitado
        visitados[v] = true;
        while (!cola.vacia()) {
            int vertice = cola.desencolar();  // Desencolar
            System.out.print(vertice + " ");  // Visualizar
            // Encolar vértices adyacentes a v
            for (int j = 0; j < numVertices; j++) {
                if (existeArista(vertice, j) && !visitados[j]) {
                    cola.encolar(j);
                    visitados[j] = true;
                }
            }
        }
    }

    public void amplitudCompleto() {
        boolean[] visitados = new boolean[numVertices];
        for (int i = 0; i < numVertices; i++) {
            visitados[i] = false;
        }
        for (int i = 0; i < numVertices; i++) {
            // Recorrer en amplitud desde vértice i
            if (!visitados[i]) {
                this.recorrerAmplitudVertice(i, visitados);
            }
        }
        System.out.println();
    }

    public boolean esConexo() {
        if (numVertices > 0) {
            boolean[] visitados = new boolean[numVertices];
            for (int i = 0; i < numVertices; i++) {
                visitados[i] = false;
            }
            if (dirigido) {
                this.recorridoEnProfundidadCadena(0, visitados);
            } else {
                this.recorridoEnProfundidad(0, visitados);
            }
            // Comprobar si todos los elementos de visitados son true
            boolean conexo = true;
            int i = 0;
            while (i < visitados.length && conexo) {
                conexo = visitados[i];
                i++;
            }
            return conexo;
        } else {
            return false;
        }
    }

    public void recorridoEnProfundidadCadena(int v, boolean[] visitados) {
        visitados[v] = true;
        // Para cada Vértice adyacentes desde v
        for (int i = 0; i < numVertices; i++) {
            if ((this.existeArista(v, i) || this.existeArista(i, v)) && !visitados[i]) {
                this.recorridoEnProfundidadCadena(i, visitados);
            }
        }
    }

    private boolean esArbolGN() {
        return this.esConexo() && this.numAristas() == numVertices - 1;
    }

    private boolean esArbolGD() {
        boolean encontradaRaiz = false;
        boolean cumpleArbol = this.esConexo();
        int v = 0;
        while (v < numVertices && cumpleArbol) {
            int gradoEnt = this.gradoEntrada(v);
            if (gradoEnt == 0) {
                if (encontradaRaiz) {
                    cumpleArbol = false;
                } else {
                    encontradaRaiz = true;
                }
            } else if (gradoEnt > 1) {
                cumpleArbol = false;
            }
            v++;
        }
        return cumpleArbol && encontradaRaiz;
    }

    public boolean esArbol() {
        if (numVertices <= 0) {
            return true;   // Arbol vacío
        } else {
            if (!dirigido) {
                return this.esArbolGN();
            } else {
                return this.esArbolGD();
            }
        }
    }

    // EJERCICIO 12
    public boolean existeCaminoCorto(int u, int v) {
        boolean resultado = false;
        if (u >= 0 && u < numVertices && v >= 0 && v < numVertices) {
            if (matrizAdy[u][v]) {
                resultado = true;
            } else {
                int i = 0;
                while (!resultado && i < numVertices) {
                    resultado = matrizAdy[u][i] && matrizAdy[i][v];
                    i++;
                }
            }
        }
        return resultado;
    }

    public boolean existeCaminoCorto2(int u, int v) {
        boolean resul = false;
        if ((v < numVertices) && (v >= 0) && (u < numVertices) && (u >= 0)) {
            boolean[] visitados = new boolean[numVertices];
            for (int i = 0; i < numVertices; i++) {
                visitados[i] = false;
            }
            // Realizar recorrido desde el vértice u.
            this.profundidadHastaDos(u, visitados, 0);
            resul = visitados[v];
        }
        return resul;
    }

    private void profundidadHastaDos(int v, boolean[] visitados, int longitud) {
        visitados[v] = true;
        // Vértices adyacentes a v
        if (longitud < 2) {
            for (int i = 0; i < numVertices; i++) {
                if (existeArista(v, i) && !visitados[i])
                    profundidadHastaDos(i, visitados, longitud + 1);
            }
        }
    }
}
