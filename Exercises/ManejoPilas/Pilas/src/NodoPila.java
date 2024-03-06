public class NodoPila {

    private int dato;
    private NodoPila siguiente;

    public NodoPila(int dato, NodoPila siguiente) {
        this.dato = dato;
        this.siguiente = siguiente;
    }

    public NodoPila getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoPila siguiente) {
        this.siguiente = siguiente;
    }

    public int getDato() {
        return dato;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }
}



