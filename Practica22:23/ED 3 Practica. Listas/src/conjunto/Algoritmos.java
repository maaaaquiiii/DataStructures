package conjunto;

public class Algoritmos {
    public Algoritmos() {

    }

    public Conjunto interseccion(Conjunto conjunto1, Conjunto conjunto2) {
        Conjunto newConjunto = new Conjunto();

        if(conjunto1.vacio() || conjunto2.vacio()){
            return newConjunto;
        } //Devuelve el conjunto vacio creado debido a que uno de los conjuntos es vacio

        int[] array1 = conjunto1.toArray();


        for(int i = 0; i < array1.length; i++) {
            if(conjunto2.contiene(array1[i])) {
                newConjunto.insertar(array1[i]);
            }
        }

        return newConjunto;
    }


}
