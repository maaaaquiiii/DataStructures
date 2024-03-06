public class Pruebas {
    public static void main(String[] args){
        System.out.println("EJERCICIO 2 BIS");
        final int VERTICES_2 = 5;
        GrafoLA grafo2 = new GrafoLA(VERTICES_2, true);   // Grafo de 12 vértices dirigido
        grafo2.insertarArista(0, 1);
        grafo2.insertarArista(1, 2);
        grafo2.insertarArista(1, 3);
        grafo2.insertarArista(2, 2);
        grafo2.insertarArista(3, 4);
        grafo2.insertarArista(4, 0);
        grafo2.insertarArista(4, 4);
        System.out.println("Grafo original:");
        grafo2.mostrar();
        System.out.println("Al desconectar el 4:");
        grafo2.desconectarVertice(4);
        grafo2.mostrar();
        System.out.println("---------------------------------");

        System.out.println("EJERCICIO 3 BIS");
        final int VERTICES_3 = 4;
        GrafoLA grafo3 = new GrafoLA(VERTICES_3, true);   // Grafo de 4 vértices dirigido
        grafo3.insertarArista(0, 1);
        grafo3.insertarArista(0, 2);
        grafo3.insertarArista(1, 1);
        grafo3.insertarArista(1, 3);
        grafo3.insertarArista(2, 1);
        grafo3.insertarArista(3, 1);
        System.out.println("Grafo original:");
        grafo3.mostrar();
        System.out.println("Vértice receptivo: " + grafo3.primerVerticeReceptivo());
        System.out.println("---------------------------------");

        System.out.println("EJERCICIO 5 BIS");
        final int VERTICES_5 = 5;
        GrafoLA grafo5 = new GrafoLA(VERTICES_5, false);   // Grafo de 5 vértices no dirigido
        grafo5.insertarArista(0, 1);
        grafo5.insertarArista(0, 4);
        grafo5.insertarArista(1, 2);
        grafo5.insertarArista(1, 3);
        grafo5.insertarArista(2, 2);
        grafo5.insertarArista(3, 4);
        grafo5.insertarArista(4, 4);
        System.out.println("Grafo original:");
        grafo5.mostrar();
        System.out.println("Número de bucles: " + grafo5.numBucles());
        System.out.println("---------------------------------");

        System.out.println("EJERCICIO 8 BIS");
        final int VERTICES_8 = 5;
        GrafoLA grafo8 = new GrafoLA(VERTICES_8, true);   // Grafo de 5 vértices dirigido
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
        GrafoLA traspuesto = grafo8.grafoTraspuesto();
        traspuesto.mostrar();
        System.out.println("---------------------------------");

        System.out.println("EJERCICIO 10 BIS");
        final int VERTICES_10 = 5;
        GrafoLA grafo10 = new GrafoLA(VERTICES_10, false);   // Grafo de 5 vértices no dirigido
        grafo10.insertarArista(0, 1);
        grafo10.insertarArista(1, 2);
        grafo10.insertarArista(2, 3);
        grafo10.insertarArista(3, 4);
        grafo10.insertarArista(4, 0);
        System.out.println("Grafo original:");
        grafo10.mostrar();
        System.out.println("Es regular: " + grafo10.esRegular());
        System.out.println("---------------------------------");

        System.out.println("EJERCICIO 15");
        final int VERTICES_15 = 5;
        GrafoLA grafo15 = new GrafoLA(VERTICES_15, true);   // Grafo de 5 vértices dirigido
        grafo15.insertarArista(0, 1);
        grafo15.insertarArista(1, 2);
        grafo15.insertarArista(2, 3);
        grafo15.insertarArista(3, 4);
        grafo15.insertarArista(4, 0);
        System.out.println("Grafo original:");
        grafo15.mostrar();
        grafo15.completar();
        System.out.println("Después de completar");
        grafo15.mostrar();
        System.out.println("---------------------------------");
    }
}
