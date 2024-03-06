public class Principal {
    public static void main(String[] args){
        // Arbol a4 = new Arbol(4);
        // Arbol a5 = new Arbol(5);
        // Arbol a2 = new Arbol(2, a4, a5);
        // Arbol a8 = new Arbol(8);
        // Arbol a7 = new Arbol(7);
        // Arbol a3 = new Arbol(3, a8, a7);
        // Arbol a1 = new Arbol(1, a2, a3);
        // System.out.println("Recorridos:");
        // a1.preOrden();
        // a1.ordenCentral();
        // a1.postOrden();
        // a1.amplitud();
        // System.out.println("--------------------");

        // //Ejercicios
        // System.out.println("EJERCICIO 1");
        // System.out.println("Contiene el 7: " + a1.contiene(7));
        // System.out.println("Contiene el 17: " + a1.contiene(17));
        // System.out.println("--------------------");

        // System.out.println("EJERCICIO 2");
        // System.out.println("Contiene en Hoja el 7: " + a1.contieneHoja(7));
        // System.out.println("Contiene en Hoja el 3: " + a1.contieneHoja(3));
        // System.out.println("Contiene en Hoja el 17: " + a1.contieneHoja(17));
        // System.out.println("--------------------");

        // System.out.println("EJERCICIO 3");
        // System.out.println("Número de hojas: " + a1.numHojas());
        // System.out.println("--------------------");
        // System.out.println("EJERCICIO 4: ");
        // System.out.println("Suma datos impares dos hijos: " + a1.sumaDatosImparesDosHijos());
        // System.out.println("--------------------");

        // System.out.println("EJERCICIO 5");
        // Arbol arbol9 = new Arbol(9);
        // Arbol arbol15 = new Arbol(15);
        // Arbol arbol4 = new Arbol(4, arbol9, arbol15);
        // // Arbol arbol4 = new Arbol(4);
        // Arbol arbol5 = new Arbol(5);
        // Arbol arbol2 = new Arbol(2, arbol4, arbol5);
        // Arbol arbol8 = new Arbol(8);
        // Arbol arbol7 = new Arbol(7);
        // Arbol arbol3 = new Arbol(3, arbol8, arbol7);
        // Arbol arbol1 = new Arbol(1, arbol2, arbol3);
        // System.out.println("Son iguales los árboles: " + a1.igual(arbol1));
        // System.out.println("--------------------");

        // System.out.println("EJERCICIO 6");
        // System.out.println("Suma datos nivel 2: " + a1.sumaDatosNiveles(2));
        // System.out.println("Suma datos nivel 3: " + a1.sumaDatosNiveles(3));
        // System.out.println("--------------------");

        // System.out.println("EJERCICIO 7");
        // System.out.println("altura del árbol: " + arbol1.altura());
        // System.out.println("--------------------");

        // System.out.println("EJERCICIO 8");
        // arbol1.completar2Hijos();
        // arbol1.ordenCentral();
        // System.out.println("--------------------");

        // System.out.println("EJERCICIO 9");
        // System.out.println("sumarHojasNivel 2: " + a1.sumaHojasNivel(2));
        // System.out.println("sumarHojasNivel 3: " + a1.sumaHojasNivel(3));
        // System.out.println("sumarHojasNivel 4: " + a1.sumaHojasNivel(4));
        // System.out.println("--------------------");
        
        // System.out.println("EJERCICIO 10");
        // System.out.println("Arbol por niveles antes de invertir");
        // a1.amplitud();
        // System.out.println("Después de invertir");
        // a1.invertir();
        // a1.amplitud();

        // System.out.println("EJERCICIO 11");
        // System.out.println("Es univaluado: " + a1.esUnivaluado());
        // Arbol un1 = new Arbol(4);
        // Arbol un2 = new Arbol(4);
        // Arbol un = new Arbol(4, un1, un2);
        // System.out.println("Es univaluado: " + un.esUnivaluado());

        System.out.println("Ejercicio examen");
        Arbol ab6 = new Arbol(6);
        Arbol ab3 = new Arbol(3);
        Arbol ab12 = new Arbol(12, ab6, ab3);
        Arbol ab14 = new Arbol(14);
        Arbol ab18= new Arbol(18, ab12, ab14);
        ab18.preOrden();
        ab18.ordenCentral();
        ab18.postOrden();
        ab18.amplitud();
        System.out.println("Son los hijos menores que su padre? " + ab18.sonHijosMenores());
        System.out.println();
        Arbol a6 = new Arbol(6);
        Arbol a4 = new Arbol(4, null, a6);
        Arbol a5 = new Arbol(5);
        Arbol a8 = new Arbol(8, a4, a5);
        a8.preOrden();
        a8.ordenCentral();
        a8.postOrden();
        a8.amplitud();
        System.out.println("Son los hijos menores que su padre? " + a8.sonHijosMenores());
        
        // ab6.diferencia();
        // System.out.println();
        // ab6.preOrden();
    }
}
