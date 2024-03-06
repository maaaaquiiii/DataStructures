public class Pruebas {

    public static void main(String[] args) {
        Algoritmos algoritmos = new Algoritmos();

        System.out.println("EJERCICIO 1");
        final int VERTICES_1 = 5;
        GrafoMA grafo1 = new GrafoMA(VERTICES_1, false);   // Grafo de 5 vértices no dirigido
        grafo1.insertarArista(0, 1);
        grafo1.insertarArista(0, 4);
        grafo1.insertarArista(1, 2);
        grafo1.insertarArista(1, 3);
        grafo1.insertarArista(3, 4);
        System.out.println("Grafo original:");
        grafo1.mostrar();
        System.out.println("Numero de Aristas: " + grafo1.numAristas());
        System.out.println("Grafo complementario:");
        GrafoMA complementario = algoritmos.complementario(grafo1);
        complementario.mostrar();
        System.out.println("---------------------------------");

        System.out.println("EJERCICIO 2");
        final int VERTICES_2 = 5;
        GrafoMA grafo2 = new GrafoMA(VERTICES_2, false);   // Grafo de 5 vértices no dirigido
        grafo2.insertarArista(0, 1);
        grafo2.insertarArista(0, 4);
        grafo2.insertarArista(1, 2);
        grafo2.insertarArista(1, 3);
        grafo2.insertarArista(2, 2);
        grafo2.insertarArista(3, 4);
        grafo2.insertarArista(4, 4);
        System.out.println("Grafo original:");
        grafo2.mostrar();
        System.out.println("Después de desconectar el vértice 4:");
        algoritmos.desconectaVertice(grafo2, 4);
        grafo2.mostrar();
        System.out.println("---------------------------------");

        System.out.println("EJERCICIO 3");
        final int VERTICES_3 = 4;
        GrafoMA grafo3 = new GrafoMA(VERTICES_3, true);   // Grafo de 4 vértices dirigido
        grafo3.insertarArista(0, 1);
        grafo3.insertarArista(0, 2);
        grafo3.insertarArista(1, 1);
        grafo3.insertarArista(1, 3);
        grafo3.insertarArista(2, 1);
        grafo3.insertarArista(3, 1);
        System.out.println("Grafo original:");
        grafo3.mostrar();
        System.out.println("Vértice receptivo: " + algoritmos.primerVerticeReceptivo(grafo3));
        System.out.println("---------------------------------");

        System.out.println("EJERCICIO 5");
        final int VERTICES_5 = 5;
        GrafoMA grafo5 = new GrafoMA(VERTICES_5, false);   // Grafo de 5 vértices no dirigido
        grafo5.insertarArista(0, 1);
        grafo5.insertarArista(0, 4);
        grafo5.insertarArista(1, 2);
        grafo5.insertarArista(1, 3);
        grafo5.insertarArista(2, 2);
        grafo5.insertarArista(3, 4);
        grafo5.insertarArista(4, 4);
        System.out.println("Grafo original:");
        grafo5.mostrar();
        System.out.println("Número de bucles: " + algoritmos.numBucles(grafo5));
        System.out.println("---------------------------------");

        System.out.println("EJERCICIO 6");
        final int VERTICES_6 = 6;
        GrafoMA grafo6 = new GrafoMA(VERTICES_6, false);   // Grafo de 6 vértices no dirigido
        grafo6.insertarArista(0, 1);
        grafo6.insertarArista(1, 3);
        grafo6.insertarArista(3, 4);
        grafo6.insertarArista(4, 0);
        grafo6.insertarArista(2, 5);
        System.out.println("Grafo original:");
        grafo6.mostrar();
        System.out.println("Número de componentes conexas: " + algoritmos.numeroComponentesConexas(grafo6));
        System.out.println("---------------------------------");

        System.out.println("EJERCICIO 7");
        final int VERTICES_7 = 5;
        GrafoMA grafo7 = new GrafoMA(VERTICES_7, false);   // Grafo de 5 vértices no dirigido
        grafo7.insertarArista(1, 2);
        grafo7.insertarArista(1, 3);
        grafo7.insertarArista(1, 4);
        grafo7.insertarArista(2, 3);
        grafo7.insertarArista(3, 4);
        System.out.println("Grafo original:");
        grafo7.mostrar();
        System.out.println("Vertice desconectado: " + algoritmos.verticeDesconectado(grafo7));
        System.out.println("---------------------------------");

        System.out.println("EJERCICIO 8");
        final int VERTICES_8 = 5;
        GrafoMA grafo8 = new GrafoMA(VERTICES_8, true);   // Grafo de 5 vértices dirigido
        grafo8.insertarArista(0, 1);
        grafo8.insertarArista(2, 0);
        grafo8.insertarArista(2, 3);
        grafo8.insertarArista(3, 0);
        grafo8.insertarArista(3, 1);
        grafo8.insertarArista(4, 1);
        grafo8.insertarArista(4, 3);
        System.out.println("Grafo original:");
        grafo8.mostrar();
        System.out.println("Grafo traspuesto:");
        GrafoMA traspuesto = algoritmos.grafoTraspuesto(grafo8);
        traspuesto.mostrar();
        System.out.println("---------------------------------");

        System.out.println("EJERCICIO 9");
        final int VERTICES_9 = 5;
        GrafoMA grafo9 = new GrafoMA(VERTICES_9, true);   // Grafo de 9 vértices dirigido
        grafo9.insertarArista(0, 4);
        grafo9.insertarArista(1, 0);
        grafo9.insertarArista(1, 2);
        grafo9.insertarArista(2, 3);
        grafo9.insertarArista(3, 0);
        grafo9.insertarArista(3, 1);
        System.out.println("Grafo original:");
        grafo9.mostrar();
        System.out.println("Vertice 0 alcanza el resto?: " + algoritmos.verticeAlcanzaResto(grafo9, 0));
        System.out.println("Vertice 1 alcanza el resto?: " + algoritmos.verticeAlcanzaResto(grafo9, 1));
        System.out.println("Vertice 2 alcanza el resto?: " + algoritmos.verticeAlcanzaResto(grafo9, 2));
        System.out.println("Vertice 3 alcanza el resto?: " + algoritmos.verticeAlcanzaResto(grafo9, 3));
        System.out.println("Vertice 4 alcanza el resto?: " + algoritmos.verticeAlcanzaResto(grafo9, 4));
        System.out.println("---------------------------------");

        System.out.println("EJERCICIO 10");
        final int VERTICES_10 = 5;
        GrafoMA grafo10 = new GrafoMA(VERTICES_10, true);   // Grafo de 9 vértices dirigido
        grafo10.insertarArista(0, 1);
        grafo10.insertarArista(1, 2);
        grafo10.insertarArista(2, 3);
        grafo10.insertarArista(3, 4);
        grafo10.insertarArista(4, 0);
        System.out.println("Grafo original:");
        grafo10.mostrar();
        System.out.println("Es regular (todos igual grado entrada y todos igual grado salida): " + algoritmos.esRegular(grafo10));
        System.out.println("---------------------------------");

        System.out.println("EJERCICIO 11");
        final int VERTICES_11 = 5;
        GrafoMA grafo11 = new GrafoMA(VERTICES_11, true);   // Grafo de 5 vértices dirigido
        grafo11.insertarArista(0, 1);
        grafo11.insertarArista(1, 2);
        grafo11.insertarArista(2, 3);
        grafo11.insertarArista(3, 4);
        grafo11.insertarArista(4, 0);
        System.out.println("Grafo original:");
        grafo11.mostrar();
        System.out.println("Es regular (todos igual grado entrada que de salida): " + algoritmos.esRegular2(grafo11));
        System.out.println("---------------------------------");

        System.out.println("EJERCICIO 12");
        final int VERTICES_12 = 5;
        GrafoMA grafo12 = new GrafoMA(VERTICES_12, true);   // Grafo de 5 vértices dirigido
        grafo12.insertarArista(0, 1);
        grafo12.insertarArista(1, 2);
        grafo12.insertarArista(1, 3);
        grafo12.insertarArista(2, 2);
        grafo12.insertarArista(3, 4);
        grafo12.insertarArista(4, 4);
        System.out.println("Grafo original:");
        grafo12.mostrar();
        System.out.println("Existe camino corto entre 0 y 3 " + grafo12.existeCaminoCorto(0, 3));
        System.out.println("Existe camino corto entre 0 y 3 " + grafo12.existeCaminoCorto2(0, 3));
        System.out.println("---------------------------------");

        System.out.println("EJERCICIO 13");
        final int VERTICES_13 = 6;
        GrafoMA grafo13 = new GrafoMA(VERTICES_13, false);   // Grafo de 6 vértices no dirigido
        grafo13.insertarArista(0, 1);
        grafo13.insertarArista(1, 3);
        grafo13.insertarArista(3, 4);
        grafo13.insertarArista(4, 0);
        grafo13.insertarArista(2, 5);
        System.out.println("Grafo original:");
        grafo13.mostrar();
        System.out.println("Están en distinta componente 0 y 4 " +
                algoritmos.verticesDistintaComponenteConexa(grafo13,0, 4));
        System.out.println("Están en distinta componente 0 y 2 " +
                algoritmos.verticesDistintaComponenteConexa(grafo13,0, 2));
        System.out.println("---------------------------------");

        System.out.println("EJERCICIO 14");
        final int VERTICES_14 = 6;
        GrafoMA grafo14 = new GrafoMA(VERTICES_14, false);   // Grafo de 6 vértices no dirigido
        grafo14.insertarArista(0, 1);
        grafo14.insertarArista(1, 3);
        grafo14.insertarArista(3, 4);
        grafo14.insertarArista(4, 0);
        grafo14.insertarArista(2, 5);
        System.out.println("Grafo original:");
        grafo14.mostrar();
        System.out.println("Número de vértices de la componente conexa del 0: " +
                algoritmos.numeroVerticesComponenteConexa(grafo14, 0));
        System.out.println("Número de vértices de la componente conexa del 2: " +
                algoritmos.numeroVerticesComponenteConexa(grafo14, 2));
        System.out.println("---------------------------------");

        System.out.println("EJERCICIO 14 A");
        final int VERTICES_14A = 6;
        GrafoMA grafo14A = new GrafoMA(VERTICES_14A, false);   // Grafo de 6 vértices no dirigido
        grafo14A.insertarArista(0, 1);
        grafo14A.insertarArista(1, 3);
        grafo14A.insertarArista(3, 4);
        grafo14A.insertarArista(4, 0);
        grafo14A.insertarArista(2, 5);
        System.out.println("Grafo original:");
        grafo14A.mostrar();
        System.out.println("Origen de la componente conexa de mayor tamaño: " +
                algoritmos.compoConexaMasVertices(grafo14A));
        System.out.println("---------------------------------");

        System.out.println("EJERCICIO 14 B");
        final int VERTICES_14B = 6;
        GrafoMA grafo14B = new GrafoMA(VERTICES_14B, true);   // Grafo de 6 vértices dirigido
        grafo14B.insertarArista(0, 1);
        grafo14B.insertarArista(1, 3);
        grafo14B.insertarArista(3, 4);
        grafo14B.insertarArista(4, 0);
        grafo14B.insertarArista(2, 5);
        System.out.println("Grafo original:");
        grafo14B.mostrar();
        System.out.println("Origen de la componente conexa de mayor tamaño: " +
                algoritmos.compoConexaMasVertices(grafo14B));
        System.out.println("---------------------------------");
    }
}
