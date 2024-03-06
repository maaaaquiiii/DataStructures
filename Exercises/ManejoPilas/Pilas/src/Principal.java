public class Principal {
    public static void main(String[] args) {
        Pila pila = new Pila();
        Ejercicios ej = new Ejercicios();

        pila.apilar(6);
        pila.apilar(3);
        for(int i = 1; i < 3; i++){
            pila.apilar(i);
        }
        pila.apilar(8);
        pila.mostrar();
    
        //Ejercicio 1
        System.out.println("Ejercicio 1");
        ej.devolverNveces(pila, 2);
        pila.mostrar();

        //Ejercicio 2
        System.out.println("Ejercicio 2");
        ej.reorganizar(pila, 3);
        pila.mostrar();
        ej.reorganizar(pila, 7);
        pila.mostrar();

        //Ejercicio 3
        System.out.println("Ejercicio 3");
        System.out.println(ej.numElements(pila));

        //Se vuelve a rellenar la pila ya que esta vacia por el ejercicio 3
        pila.apilar(4);
        for(int i = 1; i <= 3; i++){
            pila.apilar(i);
        }
        for(int i = 3; i < 6; i++){
            pila.apilar(i * i);
        }
        pila.apilar(5);
        pila.apilar(7);
        pila.apilar(8);

        //Ejercicio 4
        System.out.println("Ejercicio 4");
        pila.mostrar();
        ej.eliminarPos(pila);
        pila.mostrar();

        //Ejercicio 5
        pila.mostrar();
        System.out.println("Ejercicio 5");
        ej.moverElemento(pila);
        pila.mostrar();

        //Ejercicio 6
        System.out.println("Ejercicio 6");
        ej.hacerPilaCapicua(pila);
        pila.mostrar();
        
        
        //Ejercicio 7
        System.out.println("Ejercicio 7");
        pila.mostrar();
        System.out.println("El dato eliminado estaba repetido: " + ej.eliminarDato(pila, 2) + " veces");
        pila.mostrar();

        //Ejercicio 8
        System.out.println("Ejercicio 8");
        System.out.println("El mayor de la pila es: " + ej.mayorElemento(pila));
        pila.mostrar();

        //Ejercicio 9
        System.out.println("Ejercicio 9");
        ej.quitarPosiciones(pila);
        pila.mostrar();

        //Ejercicio 10
        System.out.println("Ejercicio 10");
        ej.ponerFondoDiferenciaMaximoMinimo(pila);
        
        //Ejercicio Examen
        System.out.println("Ejercicio Examen");
        pila.mostrar();
        System.out.println(ej.comprobarOrdenacion(pila));
    }
}

/*
        Pila pila = new Pila();
        Ejercicio1 ej1 = new Ejercicio1();

        for(int i = 1; i < 4; i++){
            pila.apilar(i);
        }
        pila.mostrar();
        System.out.println("Ejercicio1");
        ej1.devolverNveces(pila, 2);
        pila.mostrar();
*/

