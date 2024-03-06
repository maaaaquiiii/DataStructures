public class Cola {
    private NodoCola principio, fin;
    private int numElementos;

    public Cola() {
        principio = null;
        fin = null;
        numElementos = 0;
    }

    public boolean vacia() {   // Comprueba si la cola está vacía

        return principio == null;
    }


    public void encolar(int dato) {    // Coloca el elemento dato al final de la cola
        NodoCola nuevo;
        nuevo = new NodoCola (dato, null);
        if (principio != null)
            fin.setSiguiente(nuevo);
        else principio = nuevo;
        fin = nuevo;
        numElementos++;
    }

    public int desencolar() {    //Devuelve el elemento del primero de la cola y lo elimina Si la cola está vacía, devuelve como resultado 0 y un mensaje de error
        NodoCola nodo;
        int resultado = 9999;

        if (principio == null)
            System.out.println("Error, la cola está vacía");
        else {
            nodo = principio;
            principio = nodo.getSiguiente();
            resultado = nodo.getDato();
            if (principio == null)
                fin = null;

            numElementos--;
        }
        return resultado;
    }



    public int getPrimero() {  //Devuelve el elemento del primero de la cola Si la cola está vacía, devuelve como resultado -999 y un mensaje de error
        int resultado = -9999;
        if (!this.vacia()) {
            resultado = principio.getDato();
        } else
            System.out.println("Error, la cola está vacía");
        return resultado;
    }

    public void quitarPrimero() {
        if (principio == null)
            System.out.println("Error, la cola está vacía");
        else {
            NodoCola nodo = principio;
            principio = nodo.getSiguiente();
            if (principio == null)
                fin = null;
            numElementos--;
        }
    }

    public void mostrar() {     // Muestra por pantalla el contenido de la cola
        NodoCola auxiliar;
        System.out.println("Contenido de la cola: ");
        auxiliar = principio;
        while (auxiliar != null) {
            System.out.print(auxiliar.getDato() + "  ");
            auxiliar = auxiliar.getSiguiente();
        }
        System.out.println("FIN");
    }

    public int getNumElementos() {       // Devuelve el número de elementos de la cola
        return numElementos;
    }
}
