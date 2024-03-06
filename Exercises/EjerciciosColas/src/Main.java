public class Main {
    public static void main(String[] args) {
        Cola cola = new Cola();
        Cola cola1 = new Cola();
        Ejercicios ej = new Ejercicios();

        cola.encolar(1);
        cola.encolar(5);
        cola.encolar(4);
        cola.encolar(2);
        cola.encolar(20);


       cola.mostrar();
        //Ejercicio 1
        System.out.println("Ejercicio 1");
        ej.invertirColas(cola);
        cola.mostrar();

        //Ejercicio 2
        System.out.println("Ejercicio 2");
        cola.mostrar();
        System.out.println("El numero esta en la posicion: " + ej.posicionCola(cola, 5));

        //Ejercicio 3
        cola1.encolar(7);
        cola1.encolar(3);
        cola1.encolar(6);
        for(int i = 8; i <= 10; i++){
            cola1.encolar(i);
        }
        cola.mostrar();
        cola1.mostrar();
        System.out.println("Ejercicio 3");
        ej.mezclarColas(cola, cola1);
        cola.mostrar();
    }
}
