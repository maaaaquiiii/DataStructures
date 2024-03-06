import java.util.Stack;

/**
 * Clase UtilizacionStack, para desarrollar los ejercicios propuestos en el apartado 3
 * @author
 * @version
 */

/*
Realizado por Esperanza MAcarena Plaza Martínez
Número de matrícula: br0427
*/

public class UtilizacionStack {

    /**
     * Método que recibe un texto y una lista de etiquetas. Comprueba si todas las etiquetas
     * del texto están balanceadas (cada etiqueta de apertura se corresponde con una de cierre)
     *
     * @param lista contiene las etiquetas que queremos analizar.
     * @param texto que contiene el contenido de una página html
     * @return verdadero si las etiquetas están balanceadas, falso en caso contrario
     */
    public boolean comprobarLineaStack (ListaEtiquetas lista, String texto) {
        String[] palabras;
        Stack<String> pilaEtiquetas = new Stack<String>();

        palabras = texto.split(" "); //Se separa el texto buscando los espacios en blanco
        for(int i = 0; i < palabras.length; i++) { //Se recorre el array
            if(lista.esEtiqueta(palabras[i])) { //Se comprueba que sea etiqueta
                if(lista.esApertura(palabras[i])) { //Se comprueba si es apertura
                    pilaEtiquetas.push(palabras[i]); //Se mete en la pila
                    System.out.println("Etiqueta de apertura " + palabras[i]);
                } else if(lista.esCierre(palabras[i])) { //Se comprueba si la etiqueta de la cima es pareja
                    System.out.println("Cierre de apertura " + palabras[i]);
                    String cima = pilaEtiquetas.pop(); //Contenido de la cima
                    System.out.println("Etiqueta de apertura en la cima " + cima);
                    if(lista.emparejados(cima, palabras[i])) { //Este caso dice si estan emparejadas
                        System.out.println("Emparejadas: " + cima + palabras[i]);
                    } else {
                        System.out.println("NO emparejadas: " + cima + palabras[i]); //este caso comrpueba que no es emparejada y se vuelve a meter en la pila
                        pilaEtiquetas.push(cima);
                    }
                }
            }
        }
        //Comrpueba que en la pila original no haya nada
        if(pilaEtiquetas.isEmpty()) {
            return true;
        } else {
            System.out.println("La pila no esta vacia");
            this.mostrarInverso(pilaEtiquetas);
            return false;
        }
    }
    /**
     * Método que muestra el contenido de la pila
     * @param pila la pila que deseamos mostrar
     */
    public void mostrar (Stack <String> pila)  {
        mostrarRecursivo(pila);
    }
    private void mostrarRecursivo(Stack <String> pila) {
        if(pila.isEmpty()) {
            System.out.println("FONDO PILA");
        } else {
            String cima = pila.pop();
            System.out.println(cima);
            this.mostrarRecursivo(pila);
            pila.push(cima);
        }
    }
    /**
     * Método que muestra el contenido de la pila invertido (el fondo arriba y la cima abajo)
     * @param pila la pila que deseamos mostrar
     */
    public void mostrarInverso(Stack <String> pila) {
        mostrarInversoRecrusivo(pila);
    }
    private void mostrarInversoRecrusivo(Stack <String> pila) {
        if(pila.isEmpty()) {
            System.out.println("FONDO PILA");
        } else {
            String dato = pila.pop();
            mostrarInversoRecrusivo(pila);
            System.out.println(dato);
            pila.push(dato);
        }
    }
}
