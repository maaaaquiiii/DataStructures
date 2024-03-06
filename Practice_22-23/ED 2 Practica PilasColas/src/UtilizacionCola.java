/**
 * Clase UtilizacionCola, para desarrollar los ejercicios propuestos en el
 * apartado 4
 *
 * @author
 */

/*
Realizado por Esperanza MAcarena Plaza Martínez
Número de matrícula: br0427
*/

public class UtilizacionCola {

    /**
     * TO-DO 1: Método que recibe una lista de etiquetas html y un String
     * conteniendo una página html.
     * Genera una cola que contiene las etiquetas de la lista contenidas en el texto
     *
     * @param lista lista que contiene las etiquetas que queremos comprobar
     * @param texto la página que vamos a analizar
     * @return la cola que contiene las etiquetas de la lista contenidas en el texto
     */
    public Cola leerTexto(ListaEtiquetas lista, String texto) {
        Cola cola = new Cola();
        String[] palabras = texto.split(" "); //Se separa el texto buscando los espacios en blanco

        for(int i = 0; i < palabras.length; i++) { //Recorre el array
            if(lista.esEtiqueta(palabras[i])) { //Se comrpueba que sea etiqueta
                String dato = palabras[i];
                cola.encolar(dato);
            }
        }
        
        return cola;
    }

    /**
     * Método que recibe una cola y una lista de etiquetas. Comprueba si todas las etiquetas
     * de la cola están balanceadas (cada etiqueta de apertura se corresponde con una de cierre)
     *
     * @param cola  que contiene las etiquetas extraídas de una página html
     * @param lista contiene las etiquetas que queremos analizar.
     * @return verdadero si las etiquetas están balanceadas, falso en caso contrario
     */
    public boolean comprobarHtml(Cola cola, ListaEtiquetas lista) {
        Pila pilaAux = new Pila();
        boolean balanceado = true;
        int i = 0;
        String etiqueta;

        // Se itera tantas veces como elemento tenga la cola
        while (balanceado && i < cola.getNumElementos()) {
            // Se desencola la etiqueta
            etiqueta = cola.desencolar();
            // Se comprueba si la etiqueta es de apertura o de cierre
            if (lista.esApertura(etiqueta)) {
                // si es de apertura, se mete en la pila
                pilaAux.apilar(etiqueta);
            } else if (lista.esCierre(etiqueta)) {
                // Se comprueba si la etiqueta de cierre tiene apertura en la pila
                balanceado = (pilaAux.desapilar().equals(etiqueta));
            } else {
                balanceado = false; // Se iguala balanceado a false y no es etiqueta
            }
            // volvemos a encolar la etiqueta para que la cola quede al final igual
            cola.encolar(etiqueta);
        }
        // si quedan elementos en la pila auxiliar se muestran y devuelve falso
        if (!pilaAux.vacia()) {
            // quedan elementos
            System.out.println("En la pila quedan elementos !!!!");
            pilaAux.mostrar();
            balanceado=false;
        }
        return balanceado;
    }


}
