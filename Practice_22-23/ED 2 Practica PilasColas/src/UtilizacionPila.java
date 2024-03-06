/**
 * Clase UtilizacionPila, para desarrollar los ejercicios propuestos en el
 * apartado 2
 *
 * @author
 * @version
 */

/*
Realizado por Esperanza MAcarena Plaza Martínez
Número de matrícula: br0427
*/

public class UtilizacionPila {

    /**
     * TO-Do 1: Método que recibe un texto y una lista de etiquetas. Comprueba
     * si todas las etiquetas del texto están balanceadas (cada etiqueta de
     * apertura se corresponde con una de cierre)
     *
     * @param lista contiene las etiquetas que queremos analizar.
     * @param texto que contiene el contenido de una página html
     * @return verdadero si las etiquetas están balanceadas, falso en caso contrario
     */
    public boolean comprobarTexto (ListaEtiquetas lista, String texto) {
        Pila pilaEtiquetas = new Pila(); 
        String[] palabrasTexto = texto.split(" ");

        for(int i = 0; i < palabrasTexto.length; i++) {
            if(lista.esEtiqueta(palabrasTexto[i])) {
                if(lista.esApertura(palabrasTexto[i])) {
                    pilaEtiquetas.apilar(palabrasTexto[i]);
                    System.out.println(" ");
                } else if (lista.esCierre(palabrasTexto[i])) {
                    String cima = pilaEtiquetas.desapilar();
                    if(lista.emparejados(cima, palabrasTexto[i])) {
                        System.out.println("Emparejadas: " + cima + palabrasTexto[i]);
                    } else {
                        System.out.println("NO emparejadas: " + cima + palabrasTexto[i]); 
                        pilaEtiquetas.apilar(cima);
                    }
                }
            }
        }
        if(!pilaEtiquetas.vacia()) {
            mostrarInverso(pilaEtiquetas);
            return false;
        }
        return true;
    }

    public void mostrarInverso(Pila pila) {
        this.mostrarInversoRecrusivo(pila);
    }
    private void mostrarInversoRecrusivo(Pila pila){
        if(!pila.vacia()){
            String dato = pila.desapilar();
            mostrarInversoRecrusivo(pila);
            System.out.println(dato);
            pila.apilar(dato);
        }
    }
}

