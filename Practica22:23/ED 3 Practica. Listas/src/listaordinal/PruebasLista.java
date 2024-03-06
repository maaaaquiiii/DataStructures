package listaordinal;
import java.util.LinkedList;

public class PruebasLista {
    public static void main(String[] args) {
        ListaOrdinal lista = new ListaOrdinal();
        Producto mesa = new Producto("Mesa escritorio", 185, 2);
        Producto silla = new Producto("Silla oficina", 95.9f, 4);
        Producto mesaCocina = new Producto("Mesa cocina", 125, 1);
        Producto sillon = new Producto("Sillon reclinable", 230, 2);
        
        lista.insertar(mesa);
        lista.insertar(silla);
        lista.insertar(mesaCocina);
        lista.insertar(sillon);
        System.out.println("--------------- Productos en la lista ---------------");
        lista.mostrar();
        System.out.println("Despues de borrar las sillas de oficina");
        lista.borrar(silla);
        lista.mostrar();

        //Apartado 3
        Factura factura = new Factura("12345678B", "117/03/2021");
        System.out.println("--------------- Factura ---------------");

        //Apartado 3.1
        factura.addProducto(mesa);
        factura.addProducto(silla);
        factura.addProducto(mesaCocina);
        factura.addProducto(sillon);
        factura.mostrar();

        int unidadesEliminadas;
        System.out.println("---------------------------------------------------------------------------");
        unidadesEliminadas = factura.eliminarProducto(silla, 2);
        unidadesEliminadas += factura.eliminarProducto(sillon, 3);
        System.out.println("Se han eliminado " + unidadesEliminadas + " unidades");
        factura.mostrar();
        System.out.println("---------------------------------------------------------------------------");
        factura.mayoresPrecios(100);
        factura.mostrar();


        LinkedList<Producto> listaEnlazada = new LinkedList<Producto>();
        FacturaBib factura2 = new FacturaBib("88888888D", "08/08/2008", listaEnlazada);
        Producto armario = new Producto("Armario", 385, 5);
        Producto cama = new Producto("Cama", 255, 3);
        Producto cama2 = new Producto("Cama", 255, 2);
        Producto armario2 = new Producto("Armario", 385, 1);
        
        System.out.println("\n--------------- FacturaBib ---------------");
        factura2.addProduct(armario);
        factura2.addProduct(cama);
        factura2.addProduct(cama2);
        factura2.mostrar();
        factura2.mayoresPrecios(250);
        factura2.eliminarProducto(armario2, 1);
        factura2.mostrar();
    }
}
