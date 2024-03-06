public class GrafoLA {

    private int numVertices;          // Número de vértices.
    private boolean dirigido;
    private ListaCalificada[] listasAdy;    // Listas de de adyacencias del grafo.


    public GrafoLA(int numVertices, boolean dirigido) {
        this.dirigido = dirigido;
        this.numVertices = numVertices;
        this.listasAdy = new ListaCalificada[numVertices];
        for (int i = 0; i < numVertices; i++) {
            listasAdy[i] = new ListaCalificada();
        }
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
            listasAdy[u].insertar(v);
            if (!dirigido && u != v) {
                listasAdy[v].insertar(u);
            }
        } else {
            System.out.println("Error, los vertices " + u + ", " + v + " no se encuentran en el grafo.");
        }

    }

    private boolean verticeEnRango(int v) {
        return (v < numVertices) && (v >= 0);
    }

    public void eliminarArista(int u, int v) {
        if (this.verticeEnRango(u) && this.verticeEnRango(v)) {
            listasAdy[u].borrar(v);
            if (!dirigido) {
                listasAdy[v].borrar(u);
            }
        } else {
            System.out.println("Error, los vertices " + u + ", " + v + " no se encuentran en el grafo.");
        }
    }

    public boolean existeArista(int u, int v) {
        if (this.verticeEnRango(u) && this.verticeEnRango(v)) {
            return listasAdy[u].contiene(v);
        } else {
            return false;
        }

    }

    public int gradoEntrada(int v) {
        int resul = 0;
        if (this.verticeEnRango(v)) {
            for (int i = 0; i < numVertices; i++) {
                if (listasAdy[i].contiene(v)) {  // Buscar v en todas las listas
                    resul++;
                }
            }
        }
        return resul;

    }

    public int gradoSalida(int v) {
        if (this.verticeEnRango(v)) {
            return listasAdy[v].getNumElementos();
        } else {
            return 0;
        }
    }


    public int incidencia(int v) {
        int resul = 0;
        if ((v < numVertices) && (v >= 0)) {
            if (!dirigido) {
                resul = gradoEntrada(v);
            } else {
                resul = gradoEntrada(v) + gradoSalida(v);
            }
        }
        return resul;
    }

    public int numAristas() {   // Número total de aristas del grafo
        int aristas = 0;
        for (int i = 0; i < numVertices; i++) {
            aristas = aristas + listasAdy[i].getNumElementos();
        }
        if (!dirigido) {
            int bucles = 0;
            for (int i = 0; i < numVertices; i++) {
                if (listasAdy[i].contiene(i)) {
                    bucles++;
                }
            }
            int repetidas = (aristas - bucles) / 2;
            return aristas - repetidas;
        } else {
            return aristas;
        }
    }

    public void mostrar2() {
        System.out.println("El grafo contiene " + numVertices + " vertices");
        if (dirigido) {
            System.out.println("Es dirigido");
        } else {
            System.out.println("No es dirigido");
        }
        for (int v = 0; v < numVertices; v++) {
            System.out.print("Lista del vértice " + v + ": ");
            for (int i = 0; i < numVertices; i++) {
                if (listasAdy[v].contiene(i)) {  // Buscar en la lista de v
                    System.out.print(i + ", ");
                }
            }
            System.out.println();
        }
    }

    public void mostrar() {
        System.out.println("El grafo contiene " + numVertices + " vertices");
        if (dirigido) {
            System.out.println("Es dirigido");
        } else {
            System.out.println("No es dirigido");
        }
        for (int v = 0; v < numVertices; v++) {
            System.out.print("Lista del vértice " + v + ": ");
            Iterador it = listasAdy[v].getIterador();
            while (it.hasNext()) {
                int clave = it.next();
                System.out.print(clave + ", ");
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
        visitados[v] = true;    // Nodo v visitado
        System.out.print(v + " ");
        // Recorrido desde los vértices adyacentes a v
        Iterador it = listasAdy[v].getIterador();
        while (it.hasNext()) {
            int adyacente = it.next();
            if (!visitados[adyacente])
                this.recorridoEnProfundidad(adyacente, visitados);
        }
    }

    public void profundidadCompleto() {
        boolean[] visitados = new boolean[numVertices];
        for (int i = 0; i < numVertices; i++) {
            visitados[i] = false;
        }
        // Recorrido desde cada vértice hasta completar visitados
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
            // Encolar vértices adyacentes a vertice
            Iterador it = listasAdy[vertice].getIterador();
            while (it.hasNext()) {
                int adyacente = it.next();
                if (!visitados[adyacente]) {
                    cola.encolar(adyacente);
                    visitados[adyacente] = true;
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

    // EJERCICIO 2 BIS.
    public void desconectarVertice2(int v) {
        if (v < numVertices && v >= 0) {
            for (int i = 0; i < numVertices; i++) {
                if (i != v) {
                    listasAdy[i].borrar(v);
                }
            }
            for (int j = 0; j < numVertices; j++) {
                if (j != v) {
                    listasAdy[v].borrar(j);
                }
            }
        }
    }
    // SOLUCIÓN OPTIMIZADA
    public void desconectarVertice(int v) {
        if (v < numVertices && v >= 0) {
            for (int i = 0; i < numVertices; i++) {
                if (i != v) {
                    listasAdy[i].borrar(v);
                }
            }
            Iterador it = listasAdy[v].getIterador();
            while (it.hasNext()) {
                int destino = it.next();
                if (destino != v) {
                    listasAdy[v].borrar(destino);
                }
            }
        }
    }

    // EJERCICIO 3 BIS
    public int primerVerticeReceptivo() {
        boolean encontrado = false;
        int u = 0;
        while (u < numVertices && !encontrado) {
            boolean receptivo = true;
            int v = 0;
            while (v < numVertices && receptivo) {
                if (!listasAdy[v].contiene(u)) {
                    receptivo = false;
                } else {
                    v++;
                }
            }
            if (receptivo) {
                encontrado = true;
            } else {
                u++;
            }
        }
        if (encontrado) {
            return u;
        } else {
            return -1;
        }
    }

    // EJERCICIO 5 BIS
    public int numBucles() {
        int bucles = 0;
        for (int i = 0; i < numVertices; i++) {
            if (listasAdy[i].contiene(i)) {
                bucles++;
            }
        }
        return bucles;
    }

    // EJERCICIO 8 BIS

    public GrafoLA grafoTraspuesto() {
        GrafoLA traspuesto = new GrafoLA(numVertices, dirigido);
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                if (listasAdy[i].contiene(j)) {
                    traspuesto.listasAdy[j].insertar(i);
                }
            }
        }
        return traspuesto;
    }

    // SOLUCIÓN OPTIMIZADA
    public GrafoLA grafoTraspuesto2() {
        GrafoLA traspuesto = new GrafoLA(numVertices, dirigido);
        for (int i = 0; i < numVertices; i++) {
            Iterador it = listasAdy[i].getIterador();
            while (it.hasNext()) {
                int j = it.next();
                traspuesto.listasAdy[j].insertar(i);
            }
        }
        return traspuesto;
    }

    // EJERCICIO 10BIS
    public boolean esRegular() {
        boolean regular = true;
        if (!dirigido) {
            int i = 1;
            int grado = listasAdy[0].getNumElementos();
            while (i < numVertices && regular) {
                if (grado != listasAdy[i].getNumElementos()) {
                    regular = false;
                }
                i++;
            }
            return regular;
        } else {
            return false;
        }
    }
    // EJERCICIO 15
    public void completar() {
        for (int i = 0; i < numVertices; i++){
            for (int j = 0; j < numVertices; j++){
                if (i != j) {
                    listasAdy[i].insertar(j);
                } else {
                    listasAdy[i].borrar(j);
                }
            }
        }
    }




}
