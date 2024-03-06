package conjunto;

public class Conjunto {

    private Nodo inicio;
    private int numElementos;

    public Conjunto() {
        inicio = null;
        numElementos = 0;
    }

    public boolean vacio() {
        return inicio == null;
    }

    /**
     * Inserta el dato en la posición que le corresponde
     */
    public boolean insertar(int dato) {
        if (dato >= 0) {
            Nodo anterior = null;
            Nodo actual = inicio;
            while ((actual != null) && (actual.getDato() < dato)) {  // Buscar posición de inserción
                anterior = actual;
                actual = actual.getSiguiente();
            }
            if ((actual == null) || (actual.getDato() > dato)) {  // Insertar antes de actual
                Nodo nuevo = new Nodo(dato, actual);
                if (actual == inicio) {  // insertar al principio de la lista
                    inicio = nuevo;
                } else {
                    anterior.setSiguiente(nuevo);
                }
                numElementos++;
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }


    /**
     * Determina si la clave recibida como parámetro existe en la lista.
     */
    public boolean contiene(int dato) {
        Nodo actual = inicio;
        while ((actual != null) && (actual.getDato() < dato)) {  // Buscar dato
            actual = actual.getSiguiente();
        }
        return (actual != null) && (actual.getDato() == dato);
    }

    /**
     * Elimina de la lista el alumno con número de matrícula clave,
     * en caso de existir.
     */
    public boolean borrar(int dato) {
        Nodo actual = inicio;
        Nodo anterior = null;
        while ((actual != null) && (actual.getDato() < dato)) {  // Buscar dato
            anterior = actual;
            actual = actual.getSiguiente();
        }
        if ((actual == null) || (actual.getDato() > dato)) {  // No existe clave
            return false;
        } else {  // Clave encontrada
            if (actual == inicio) {    // eliminar el primero de la lista
                inicio = actual.getSiguiente();
            } else {
                anterior.setSiguiente(actual.getSiguiente());
            }
            numElementos--;
            return true;
        }
    }

    public int getNumElementos() {
        return numElementos;
    }

    public void mostrar() {
        if (this.vacio()) {
            System.out.println ("Conjunto vacío");
        } else {
            System.out.print("[ " + inicio.getDato());
            Nodo actual = inicio.getSiguiente();
            while (actual != null) {
                System.out.print(", " + actual.getDato());
                actual = actual.getSiguiente();
            }
            System.out.println(" ]");
        }
    }

    //Devuelve un array con los elementos del conjunto

    public int[] toArray() {
        int [] array = new int[getNumElementos()];
        Nodo actual = inicio;

        for(int i = 0; i < array.length; i++) {
            array[i] = actual.getDato();
            actual = actual.getSiguiente();
        }

        return array;
    }

    //Devuelve el elemento mayor del conjunto

    public int mayor() {
        Nodo actual = inicio;

        if(vacio()) {
            return -1;
        }
        while(actual.getSiguiente() != null) { //Mientras que el nodo siguiente no sea vacio
            actual = actual.getSiguiente(); //se va acutalizando el nodo y comp se ordena de mayor a menor siempre se queda con el elemento mayor
        }
        return actual.getDato();
    }

    //Devuelve un subconjunto con los elementos que se encuentran en el rango pasado por parametro

    public Conjunto subconjunto(int inferior, int superior) {
        Nodo actual = inicio;
        Conjunto newConjunto = new Conjunto();

        while (actual != null && actual.getDato() < inferior) {
            // Se busca el primer elemento dentro de los límites
            actual = actual.getSiguiente();
        }
        while (actual != null && actual.getDato() <= superior){
            newConjunto.insertar(actual.getDato());
            actual = actual.getSiguiente();
        }

        return newConjunto;
    }

    //Devuelve true si dos conjuntos son iguales

    public boolean equals(Conjunto conjunto) {
        Nodo actual = inicio;

        if(this.getNumElementos() != conjunto.getNumElementos()){ //Si el numero de elementos es distinto al del conjunto del parametro
            return false;
        }
        while(actual.getSiguiente() != null) {  //Mientras que haya nodo siguiente
            if(this.mayor() != conjunto.mayor()) { //Si los numeros de los dos conjuntos no son iguales
                return false;
            }
            actual = actual.getSiguiente(); //se va acutalizando el nodo
            borrar(mayor());
            conjunto.borrar(mayor());
        }
        return true;
    }




}
