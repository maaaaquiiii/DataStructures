public class NodoCola {
    private int dato;
    private NodoCola siguiente;

    public NodoCola(int dato, NodoCola sig) {
        this.dato = dato;
        this.siguiente = sig;
    }

    public NodoCola getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoCola siguiente) {
        this.siguiente = siguiente;
    }

    public int getDato() {
        return dato;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }
}
