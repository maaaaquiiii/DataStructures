package listaordinal;
import java.util.Iterator;
import java.util.LinkedList;


public class FacturaBib {
    private String dni;
    private String fecha;
    private LinkedList<Producto> listaProductos = new LinkedList<Producto>();
    private boolean cobrada;

    public FacturaBib(String dni, String fecha, LinkedList<Producto> listaProductos) {
        this.dni = dni;
        this.fecha = fecha;
        this.listaProductos = listaProductos;
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

    public void addProduct(Producto producto) {
        if(listaProductos.contains(producto)){
            int pos = listaProductos.indexOf(producto);
            Producto old = listaProductos.get(pos);
            old.setUnidades(old.getUnidades()+ producto.getUnidades());
        } else {
            listaProductos.add(producto);
        }
    }

    public void mostrar() {
        System.out.println("FACTURA de: " +  dni + " Fecha: " + fecha);
        for(Producto producto : listaProductos) {
            producto.mostrar();
        }
        System.out.println("IMPORTE TOTAL: " + importeTotal() + " €");
    }

    public float importeTotal() {
        Producto producto = new Producto("", 0.0f, 0);
        float total = 0.0f;
        Iterator<Producto> iterator = listaProductos.iterator();

        while(iterator.hasNext()) {
            producto = iterator.next();
            total += (producto.getUnidades() * producto.getPrecio());
        }
        return total;
    }

    public int eliminarProducto(Producto producto, int unidades) {
        int eliminadas = 0;
        
        if(listaProductos.contains(producto)){
            int pos = listaProductos.indexOf(producto);
            Producto product = listaProductos.get(pos);
            if (product.getUnidades() > producto.getUnidades()){
                product.setUnidades(product.getUnidades() - producto.getUnidades());
                eliminadas = producto.getUnidades();
            } else {
                // en este caso eliminamos el producto
                listaProductos.remove(producto);
                eliminadas = product.getUnidades();
            }
        }
        return eliminadas;
    }

    public LinkedList<Producto> mayoresPrecios(float precio) {
        Producto producto = new Producto("", 0.0f, 0);
        Iterator<Producto> iterator = listaProductos.iterator();
        LinkedList<Producto> listaMayores = new LinkedList<Producto>();

        while(iterator.hasNext()) {
            producto = iterator.next();
            if(producto.getPrecio() > precio) {
                listaMayores.add(producto);
            }
        }
        System.out.println("Se han obtenido " + listaMayores.size() + " producto(s) con precio mayor a " + precio + " € por unidad");
        return listaMayores;
    }
}
