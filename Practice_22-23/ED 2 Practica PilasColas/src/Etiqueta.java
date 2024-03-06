/**
 * Clase para la gestión de etiquetas en html
 *
 * Esta clase se entrega completamente desarrollada, no se tiene que modificar
 *
 * @author Pilar Martinez Garcia
 * @version 1.0
 */

/*
Realizado por Esperanza MAcarena Plaza Martínez
Número de matrícula: br0427
*/

public class Etiqueta {
    /**
     * Atributo para almacenar el String de una etiqueta de apertura
     */
    private String apertura;
    /**
     * Atributo para almacenar el String de una etiqueta de cierre
     */
    private String cierre;

    /**
     * Constructor de la clase, crea las etiquetas de apertura y cierre a partir de un String
     * @param dato parte central de la etiqueta
     */
    public Etiqueta (String dato) {
        apertura = "<"+dato+">";
        cierre = "</"+dato+">";
    }

    /**
     * @return el valor de apertura
     */
    public String getApertura() {
        return apertura;
    }

    /**
     * @return el valor de cierre
     */
    public String getCierre() {
        return cierre;
    }

}
