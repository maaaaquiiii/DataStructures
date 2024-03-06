package conjunto;
import java.util.Arrays;

public class PruebasConjunto {

    public static void main(String[] args) {
        Conjunto conjunto = new Conjunto();

        conjunto.insertar(4);
        conjunto.insertar(6);
        conjunto.insertar(2);
        conjunto.insertar(4);
        conjunto.insertar(-2);
        conjunto.mostrar();

        //Apartado 5.2
        int[] myArray = new int[conjunto.getNumElementos()];
        myArray = conjunto.toArray();
        System.out.println("\nApartado 5.2\nEl array contiene: " + Arrays.toString(myArray));

        //Apartado 5.3
        System.out.println("\nApartado 5.3\nEl numero mayor " + conjunto.mayor());

        //Apartado 5.4

        System.out.println("\nApartado 5.4\nEl subconjunto entre 3 y 6 es: ");
        conjunto.subconjunto(3, 6).mostrar();;

        //Apartado 5.5
        Conjunto conjunto2 = new Conjunto();
        System.out.println("\nApartado 5.5");
        conjunto2.insertar(2);
        conjunto2.insertar(4);
        System.out.println("El conjunto 2 es: ");
        conjunto2.mostrar();
        System.out.println("\nEs igual que el conjunto de trabajo? " + conjunto.equals(conjunto2));
        conjunto2.insertar(6);
        System.out.println("\nEl conjunto 2 es: ");
        conjunto2.mostrar();
        System.out.println("\nEs igual que el conjunto de trabajo? " + conjunto.equals(conjunto2));
        conjunto2.mostrar();

        //Apartado 6.1
        Conjunto intersection = new Conjunto();
        Algoritmos algoritmo = new Algoritmos();

        System.out.println("\nApartado 6.1");
        intersection.insertar(4);
        intersection.insertar(5);
        System.out.println("La interseccion del conjunto [4, 5] es: ");
        algoritmo.interseccion(intersection,conjunto).mostrar();
    }

}
