public class Main {
    public static void main(String[] args) {
        ListaOrdinal lista = new ListaOrdinal();
        Ejercicios ej = new Ejercicios();

        lista.insertar(1);
        lista.insertar(5);
        lista.insertar(4);
        lista.insertar(2);
        lista.insertar(3);
        lista.mostrar();

        //Ejercicio 1
        System.out.println("Ejercicio 1");
        ej.duplicarParesQuitarImpares(lista);
        lista.mostrar();
    }
}
