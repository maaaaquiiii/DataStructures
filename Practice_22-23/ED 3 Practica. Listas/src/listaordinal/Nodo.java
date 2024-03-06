package listaordinal;

public class Nodo {

    private Producto producto;
    private Nodo siguiente;

    public Nodo(Producto producto, Nodo siguiente) {
        this.producto = producto;
        this.siguiente = siguiente;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
}
