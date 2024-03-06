
public class ListaCalificada {

    private Nodo inicio;
    private int numElementos;

    public ListaCalificada() {
        inicio = null;
        numElementos = 0;
    }

    public boolean vacia() {
        return inicio == null;
    }

    /** Inserta el alumno en la posición que le corresponde según la clave
     */
    public boolean insertar(int clave) {
        Nodo anterior = null;
        Nodo actual = inicio;
        while ((actual != null) && (actual.getClave() < clave)) {
            anterior = actual;
            actual = actual.getSiguiente();
        }
        if ((actual == null) || (actual.getClave() > clave)) {
            // Insertar antes de actual
            Nodo nuevo = new Nodo(clave, actual);
            if (actual == inicio) {  // insertar al principio de la lista
                inicio = nuevo;
            } else {
                anterior.setSiguiente(nuevo);
            }
            numElementos++;
            return true;
        } else {
            //System.out.println (
            //    "Clave duplicada (" + clave + "): no es posible insertar");
            return false;
        }
    }

    /** Determina si la clave recibida como parámetro existe en la lista.
     */
    public boolean contiene(int clave) {
        Nodo actual = inicio;
        while ((actual != null) && (actual.getClave() < clave)) {
            actual = actual.getSiguiente();
        }
        if ((actual == null) || (actual.getClave() > clave)) {
            return false;
        } else {
            return true;
        }
    }

    /** Elimina de la lista el alumno con número de matrícula clave,
     * en caso de existir.
     */
    public boolean borrar(int clave) {
        Nodo actual = inicio;
        Nodo anterior = null;
        while ((actual != null) && (actual.getClave() < clave)) {
            anterior = actual;
            actual = actual.getSiguiente();
        }
        if ((actual == null) || (actual.getClave() > clave)) {
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

    public Iterador getIterador() {
        return new Iterador(inicio);
    }

}
