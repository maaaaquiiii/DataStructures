public class Algoritmos {

    // EJERCICIO 1
    public GrafoMA complementario(GrafoMA grafo) {
        GrafoMA resultado = new GrafoMA(grafo.getNumVertices(),
        grafo.getDirigido());
        for (int i = 0; i < grafo.getNumVertices(); i++) {
            for (int j = 0; j < i; j++) {
                if (!grafo.existeArista(i, j)) {
                    resultado.insertarArista(i, j);
                }
            }
        }
        return resultado;
    }

    //EJERCICIO 2
    public void desconectaVertice(GrafoMA grafo, int v) {
        if (grafo.verticeEnRango(v)) {
            for (int i = 0; i < grafo.getNumVertices(); i++) {
                if (i != v) {
                    grafo.eliminarArista(i, v);
                }
            }
        }
    }

    // EJERCICIO 3
    public int primerVerticeReceptivo(GrafoMA grafo) {
        int u = 0;
        boolean encontrado = false;
        while (u < grafo.getNumVertices() && !encontrado) {
            int v = 0;
            boolean receptivo = true;
            while (v < grafo.getNumVertices() && receptivo) {
                if (!grafo.existeArista(v, u)) {
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
        if (!encontrado) {
            return -1;
        } else {
            return u;
        }
    }

    // EJERCICIO 4
    public int numAristasGrafoCompleto (int n) {
        return n * (n - 1) / 2;
    }


    // EJERCICIO 5
    public int numBucles(GrafoMA grafo) {
        int bucles = 0;
        for (int i = 0; i < grafo.getNumVertices(); i++) {
            if (grafo.existeArista(i, i)) {
                bucles++;
            }
        }
        return bucles;
    }

    // EJERCICIO 6
    public int numeroComponentesConexas(GrafoMA grafo) {
        int resultado = 0;
        boolean[] visitados = new boolean[grafo.getNumVertices()];
        for (int i = 0; i < grafo.getNumVertices(); i++) {
            visitados[i] = false; //Se inicializa la matriz de visitados a false
        }
        for (int i = 0; i < grafo.getNumVertices(); i++) {
            if (!visitados[i]) { //Si no esta visitado, recorre en profundidad
                grafo.recorridoEnProfundidad(i, visitados);
                resultado++;
            }
        }
        return resultado;
    }

    //EJERCICIO 7
    public int verticeDesconectado(GrafoMA grafo) {
        boolean encontrado = false;
        int u = 0;
        while (u < grafo.getNumVertices()  && !encontrado) {
            boolean conectado = false;
            int v = 0;
            while (v < grafo.getNumVertices() && !conectado) {
                if (grafo.existeArista(u, v)) {
                    conectado = true;
                } else {
                    v++;
                }
            }
            if (!conectado) {
                encontrado = true;
            } else {
                u++;
            }
        }
        if (!encontrado) {
            return -1;
        } else {
            return u;
        }
    }

    // EJERCICIO 8
    public GrafoMA grafoTraspuesto(GrafoMA grafo) {
        GrafoMA traspuesto = new GrafoMA(grafo.getNumVertices(), grafo.getDirigido());
        for (int i = 0; i < grafo.getNumVertices(); i++) {
            for (int j = 0; j < grafo.getNumVertices(); j++) {
                if (grafo.existeArista(i, j)) {
                    traspuesto.insertarArista(j, i);
                }
            }
        }
        return traspuesto;
    }

    //EJERCICIO 9
    public boolean verticeAlcanzaResto(GrafoMA grafo, int v) {
        if (v >= 0 && v < grafo.getNumVertices()) {
            boolean[] visitados = new boolean[grafo.getNumVertices()];
            for (int i = 0; i < grafo.getNumVertices(); i++) {
                visitados[i] = false;
            }
            grafo.recorridoEnProfundidad(v, visitados);
            boolean alcanzaResto = true;
            int j = 0;
            while (j < grafo.getNumVertices() && alcanzaResto) {
                if (!visitados[j]) {
                    alcanzaResto = false;
                }
                j++;
            }
            return alcanzaResto;
        } else {
            return false;
        }
    }

    //EJERCICIO 10
    public boolean esRegular (GrafoMA grafo) {
        int gradoSalida = grafo.gradoSalida(0);
        int gradoEntrada = grafo.gradoEntrada(0);
        boolean regular = true;
        int i = 1;
        while (i < grafo.getNumVertices() && regular) {
            regular = grafo.gradoSalida(i) == gradoEntrada &&
                    grafo.gradoEntrada(i) == gradoSalida;
            i++;
        }
        return regular;
    }

    //EJERCICIO 11
    public boolean esRegular2 (GrafoMA grafo) {
        boolean regular = true;
        int i = 0;
        while (i < grafo.getNumVertices() && regular) {
            regular = grafo.gradoSalida(i) == grafo.gradoEntrada(i);
            //Para i = 1
            //regular = grafo.gradoSalida(i) == grafo.gradoSalida()
            i++;
        }
        return regular;
    }

    // EJERCICIO 13
    public boolean verticesDistintaComponenteConexa(GrafoMA grafo, int v1, int v2) {
        boolean[] visitados = new boolean[grafo.getNumVertices()];
        for (int i = 0; i < grafo.getNumVertices(); i++) {
            visitados[i] = false; 
        }
        grafo.recorridoEnProfundidad(v1, visitados);
        return !visitados[v2];
    }

    // EJERCICIO 14
    public int numeroVerticesComponenteConexa(GrafoMA grafo, int v) {
        int resultado = 0;
        boolean[] visitados = new boolean[grafo.getNumVertices()];
        for (int i = 0; i < grafo.getNumVertices(); i++) {
            visitados[i] = false; }
        grafo.recorridoEnProfundidad(v, visitados);
        for (int i = 0; i < grafo.getNumVertices(); i++) {
            if (visitados[i]) {
                resultado++;
            }
        }
        return resultado;
    }
    // EJERCICIO 14 A
    public int compoConexaMasVertices(GrafoMA grafo) {
        if (grafo.getDirigido()) {
            return this.compoConexaMasVerticesNoDirigido(grafo);
        } else {
            return this.compoConexaMasVerticesDirigido(grafo);
        }
    }

    public int compoConexaMasVerticesNoDirigido(GrafoMA grafo) {
        boolean[] visitados = new boolean[grafo.getNumVertices()];
        int origenComponenteMayor = -1;
        int numVerticesMayorComponente = 0;
        for (int v=0; v < grafo.getNumVertices(); v++) {
            visitados[v] = false;
        }
        for(int i = 0; i < grafo.getNumVertices(); i++) {
            if (!visitados[i]) {
                int numVerticesAntes = this.numVisitados(visitados);
                grafo.recorridoEnProfundidad(i, visitados);
                int numVertices = this.numVisitados(visitados) - numVerticesAntes;
                if (numVertices > numVerticesMayorComponente) {
                    numVerticesMayorComponente = numVertices;
                    origenComponenteMayor = i;
                }
            }
        }
        return origenComponenteMayor;
    }

    private int numVisitados( boolean [] visitados) {
        int resultado = 0;
        for(int i = 0; i < visitados.length; i++)
            if (visitados[i]) {
                resultado++;
            }
        return resultado;
    }

    // EJERCICIO 14 B
    public int compoConexaMasVerticesDirigido(GrafoMA grafo) {
        boolean[] visitados = new boolean[grafo.getNumVertices()];
        int origenComponenteMayor = -1;
        int numVerticesMayorComponente = 0;
        for (int v=0; v < grafo.getNumVertices(); v++) {
            visitados[v] = false;
        }
        for(int i = 0; i < grafo.getNumVertices(); i++) {
            if (!visitados[i]) {
                int numVerticesAntes = this.numVisitados(visitados);
                grafo.recorridoEnProfundidadCadena(i, visitados);
                int numVertices = this.numVisitados(visitados) - numVerticesAntes;
                if (numVertices > numVerticesMayorComponente) {
                    numVerticesMayorComponente = numVertices;
                    origenComponenteMayor = i;
                }
            }
        }
        return origenComponenteMayor;
    }



}

