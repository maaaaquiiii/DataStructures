package listaordinal;

public class Factura {
    private String dni;
    private String fecha;
    private ListaOrdinal listaProductos;
    private boolean cobrada;

    public Factura(String dni, String fecha) {
        this.dni = dni;
        this.fecha = fecha;
        listaProductos = new ListaOrdinal();
        cobrada = false;
    }

    public String getDNI() {
        return dni;
    }

    public String getFecha() {
        return fecha;
    }

    public boolean estaCobrada() {
        return cobrada;
    }

    public void cobrada() {
        cobrada = true;
    }

    public void addProducto(Producto producto) {
        if(listaProductos.contiene(producto)){
            int pos = listaProductos.posicion(producto);
            Producto product = listaProductos.getElemento(pos);
            product.setUnidades(product.getUnidades() + producto.getUnidades());
        } else {
            listaProductos.insertar(producto);
        }
    }

    public void mostrar() {
        System.out.println("FACTURA de: " +  this.dni + " Fecha: " + this.fecha);
        listaProductos.mostrar(); //Se muestra la lista de productos
        System.out.println("IMPORTE TOTAL: " + importeTotal() + " €");
    }

    public float importeTotal() {
        Iterador iterator = listaProductos.getIterador(); //Nos da un iterado relacionado a la lista con la que estamos trabajando
        Producto producto = new Producto("", 0.0f, 0); //se crea un nuevo producto
        float total = 0.0f;

        while(iterator.hasNext()) { //Mientras que el iterador tenga siguiente
            producto = iterator.next(); //el producto sea el siguiente
            total += (producto.getPrecio() * producto.getUnidades()); //Se suma las unidades que haya por el precio mas lo anterior
        }
        return total;
    }

    public int eliminarProducto(Producto producto, int unidades) {
        int udEliminadas = 0;

        if(listaProductos.contiene(producto)) {
            int pos = listaProductos.posicion(producto);
            Producto product = listaProductos.getElemento(pos);
            if (product.getUnidades() > producto.getUnidades()) {
                product.setUnidades(product.getUnidades() - producto.getUnidades());
                udEliminadas = producto.getUnidades();
            } else {
                // en este caso eliminamos el producto
                listaProductos.borrar(producto);
                udEliminadas = product.getUnidades();
            }

        }
        return udEliminadas;
    }

    public ListaOrdinal mayoresPrecios(float precio) {
        Iterador iterator = listaProductos.getIterador();
        Producto producto = new Producto("", 0.0f, 0);
        ListaOrdinal ListaMayores = new ListaOrdinal();

        while(iterator.hasNext()) { //Mientras que el siguiente no sea vacio
            producto = iterator.next(); //El producto es el siguiente
            if(producto.getPrecio() > precio) { //Si el precio del producto es menor que el del parametro
                ListaMayores.insertar(producto); //Borra el producto
            }
        }
        System.out.println("Se han obtenido " + listaProductos.getNumElementos() + " producto(s) con precio mayor a " + precio + " € por unidad");
        return ListaMayores;
    }
}
