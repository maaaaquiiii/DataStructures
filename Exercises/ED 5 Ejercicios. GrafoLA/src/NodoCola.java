
public class NodoCola {

    private int dato;
    private NodoCola siguiente;

    public NodoCola(int dato, NodoCola siguiente) {
        this.dato = dato;
        this.siguiente = siguiente;
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
