public class Arbol {
    private NodoArbol raiz;

    public Arbol() {
        raiz = null;
    }

    public Arbol(int dato) {
        raiz = new NodoArbol(dato);
    }


    public Arbol(int dato, Arbol izquierdo, Arbol derecho) {
        NodoArbol nodoIzq = null;
        NodoArbol nodoDer = null;
        if (izquierdo != null) {
            nodoIzq = izquierdo.raiz;
        }
        if (derecho != null) {
            nodoDer = derecho.raiz;
        }
        raiz = new NodoArbol(dato, nodoIzq, nodoDer);
    }

    /**
     * Recorrido en preorden
     */
    public void preOrden() {
        System.out.print("Preorden: ");
        this.preOrdenRec(raiz);
        System.out.println();
    }

    private void preOrdenRec(NodoArbol nodo) {
        if (nodo != null) {
            System.out.print(nodo.getDato() + "  ");
            this.preOrdenRec(nodo.getIzquierdo());
            this.preOrdenRec(nodo.getDerecho());
        }
    }

    /**
     * Recorrido en orden central
     */
    public void ordenCentral() {
        System.out.print("Orden Central: ");
        this.ordenCentralRec(raiz);
        System.out.println();
    }

    private void ordenCentralRec(NodoArbol nodo) {
        if (nodo != null) {
            this.ordenCentralRec(nodo.getIzquierdo());
            System.out.print(nodo.getDato() + "  ");
            this.ordenCentralRec(nodo.getDerecho());
        }
    }

    /**
     * Recorrido en postorden
     */
    public void postOrden() {
        System.out.print("Postorden: ");
        this.postOrdenRec(raiz);
        System.out.println();
    }

    private void postOrdenRec(NodoArbol nodo) {
        if (nodo != null) {
            this.postOrdenRec(nodo.getIzquierdo());
            this.postOrdenRec(nodo.getDerecho());
            System.out.print(nodo.getDato() + "  ");
        }
    }

    /**
     * Recorrido en amplitud con una cola de nodos del árbol
     */
    public void amplitud() {
        Cola cola = new Cola();
        System.out.print("Amplitud: ");
        if (raiz != null) {
            cola.encolar(raiz);
            while (!cola.vacia()) {
                NodoArbol nodo = cola.desencolar();
                System.out.print(nodo.getDato() + "  ");
                if (nodo.getIzquierdo() != null) {
                    cola.encolar(nodo.getIzquierdo());
                }
                if (nodo.getDerecho() != null) {
                    cola.encolar(nodo.getDerecho());
                }
            }
        }
        System.out.println();
    }

    //---------------------------------- EJERCICIOS----------------------------------
    //Ejercicio 1
    public boolean contiene(int dato) {
        return this.contiene(raiz, dato);
    }

    private boolean contiene(NodoArbol nodo, int dato){
        if(nodo == null){
            return false;
        }
        else {
            return nodo.getDato() == dato || this.contiene(nodo.getIzquierdo(), dato)
            || this.contiene(nodo.getDerecho(), dato);
        }
    }

    //Ejercicio 2
    public boolean contieneHoja(int dato){
        return this.contieneHoja(dato, raiz);
    }

    private boolean contieneHoja (int dato, NodoArbol nodo){
        boolean resultado;

        if (nodo == null) {
            resultado = false;
        } 
        else if (nodo.getDato() == dato && nodo.getDerecho() == null && nodo.getIzquierdo() == null) {
            resultado = true;
        } 
        else {
            resultado = this.contieneHoja (dato, nodo.getIzquierdo()) || this.contieneHoja (dato, nodo.getDerecho());
        }
        return resultado;
    }

    //Ejercicio 3
    public int numHojas(){
        return this.numHojas(raiz);
    }
    /*
    Este metodo devuelve de manera recursiva el numero de nodos que hay.
    En el primer if si el arbol esta vacio el contador es 0, en el else if basicamente hace que 
    si el nodo de la derecha es igual que al de la izquierda el contador es 1 debido a que son iguales, 
    y en el else al ser distintos se suma los dos nodos y se vuelve a llamar a la funcion para que recorra el arbol
    */
    public int numHojas (NodoArbol nodo) {
        int count = 0;

        if (nodo == null) {
            count = 0;
        }
        else if (nodo.getDerecho() == null && nodo.getIzquierdo() == null) {
            count = 1;
        }
        else {
            count = this.numHojas(nodo.getDerecho()) + this.numHojas(nodo.getIzquierdo());
        }
        return count;
    }

    //Ejercicio 4
    public int sumaDatosImparesDosHijos() {
        return this.sumaDatosImparesDosHijos(raiz);
    }

    /*
    Este metodo devuelve la suma de los datos impares de los nodos de forma recursiva.
    Si el arbol esta vacio devuelve 0, debido a que no hay nodos.
    En cambio si el arbol no esta vacio se hacen dos variables que van a servir para la suma de cada lado,
    y si el dato es impar ( no es divisible entre 2) y los nodos de cada lado no estan vacios, 
    por lo tanto se ve que tiene dos hijos, se suma el valor del nodo con la suma anterior de cada lado.
    */
    private int sumaDatosImparesDosHijos (NodoArbol nodo){
        int suma;

        if (nodo == null) {
            suma = 0;
        }
        else {
            int sumaDcho = this.sumaDatosImparesDosHijos(nodo.getDerecho());
            int sumaIzq = this.sumaDatosImparesDosHijos(nodo.getIzquierdo());
            if ((nodo.getDato() % 2 == 1) && (nodo.getDerecho() != null) && (nodo.getIzquierdo() != null)) {
                suma = nodo.getDato() + sumaDcho + sumaIzq; 
            }
            else {
                suma = sumaDcho + sumaIzq;
            }
        }
        return suma;
    }

    //Ejercicio 5
    public boolean igual (Arbol arbol) {
        return this.igual (this.raiz, arbol.raiz);
    }
    /*
    En este metodo te pide si el arbol es un arbol binario perfecto o no,
    para ello tenemos que recorrer todos sus nodos.
    Si desde el nodo en el que estamos tiene dos hijos revuelve true, 
    pero si en uno tiene otro nodo mientras que el otro no es falso.
    Para recorrer el arbol de manera recursiva comparamos los valores de los dos nodos para saber si 
    tienen el mismo valor y llamamos al metodo dos veces, una para pasar al lado izquierdo 
    y la otra para comparar el lado derecho
    */
    private boolean igual (NodoArbol nodo1, NodoArbol nodo2){
        boolean resultado;

        if (nodo1 == null && nodo2 == null) {
            resultado = true;
        } else if (nodo1 == null || nodo2 == null) {
            resultado = false;
        } 
        else {
            resultado = nodo1.getDato() == nodo2.getDato() &&
            this.igual(nodo1.getIzquierdo(), nodo2.getIzquierdo()) &&
            this.igual(nodo1.getDerecho(), nodo2.getDerecho());
        }
        return resultado;
    }

    //Ejercicio 6
    public int sumaDatosNiveles(int nivel){
        if (nivel >= 1) {
            return this.sumaDatosNiveles(raiz, nivel, 1);
        } else {
            return 0;
        }
    }
    /*
    Para este metodo, te pide que hagas la suma total de un nivel y para ello hay que crear una variable
    para que guarde el total de la suma.
    Comprobamos que los nodos no esten vacios, si alguno esta vacio el total es 0 debido a que no se suma,
    Si estamos en el nivel en el que nos piden que hagamos la suma, cogemos el el valor del nodo.
    Si el nivel es menor al actual, se iguala el total es la suma de los valores de los nodos 
    y hacemos la llamada recursiva
    */
    private int sumaDatosNiveles(NodoArbol nodo, int nivel, int nivelActual){
        int total = 0;

        if (nodo == null) {
            total = 0;
        }
        else if (nivelActual == nivel) {
            total = nodo.getDato();
        }
        else {
            total = this.sumaDatosNiveles(nodo.getDerecho(), nivel, nivelActual + 1) + 
            this.sumaDatosNiveles(nodo.getIzquierdo(), nivel, nivelActual + 1);
        }
        return total;
    }

    //Ejercicio 7
    public int altura(){
        return this.altura(raiz);
    }
    /*
    En este metodo te pide hallar la altura del arbol. Para ello se crea una variable para ir guardando
    el numero de pisos que tiene el arbol.
    Primero hay que recorrer el arbol, de forma que si el nodo esta vacio el resultado es 0.
    Sino se crean dos variables para recorrer el arbol por los lados, en la cuales se hacen la llamda recursiva 
    con cada nodo de lado correspondiente, si el en la parte parte derecha es mayor que la izquierda 
    se suma 1 a la altura derecha y se iguala al resultado, sino al reves, se suma enla altura izquierda
    */
    private int altura(NodoArbol nodo){
        int resultado = 0;

        if(nodo == null){
            resultado = 0;
        }
        else{
            int alturaDcha = this.altura(nodo.getDerecho());
            int alturaIzq = this.altura(nodo.getIzquierdo());
            if(alturaDcha > alturaIzq){
                resultado = alturaDcha + 1; 
            }
            else{
                resultado = alturaIzq + 1;
            }
        }
        return resultado;
    }

    //Ejercicio 8
    public void completar2Hijos(){
        this.completar2Hijos(raiz, 1);
    }
    /*
    Para este metodo se recorrer el arbol, de forma que si el nodo no es null, compara tanto el nodo 
    derecho como el izquierdo para que no esten vacios, y si es asi se llama al metodo (para hacerlo de manera recursiva)
    pero añadiendo un nivel.
    Si en un nivel el nodo izquierdo es null, se crea un nodo nuevo y se vuelve a llamar al metodo.
    Y se hace lo mismo en la parte izquierda del arbol
    */
    private void completar2Hijos(NodoArbol nodo, int nivel){
        if (nodo != null) {
            if (nodo.getDerecho() != null && nodo.getIzquierdo() != null) {
                completar2Hijos(nodo.getDerecho(), nivel + 1);
                completar2Hijos(nodo.getIzquierdo(), nivel + 1);
            } 
            else if (nodo.getDerecho() != null) {  
                nodo.setIzquierdo(new NodoArbol(nivel + 1, null, null));
                completar2Hijos(nodo.getDerecho(), nivel + 1);
            } 
            else if (nodo.getIzquierdo() != null) { 
                nodo.setDerecho(new NodoArbol(nivel + 1, null, null));
                completar2Hijos(nodo.getIzquierdo(), nivel + 1);
            }  
        }
    }

    //Ejercicio 9
    public int sumaHojasNivel(int maxNivel) {
        if (maxNivel > 1) {
            return this.sumaHojasNivel(maxNivel, raiz, 1);
        } else {
            return 0;
        }
    }
    /*
    Para este metodo se recorrer el arbol, de forma que si el nodo es null o el nivel es mayoe o igual
    que el nivel maximo que se pasa por parametro, el resultado es 0
    Si los dos nodos son null, el resultado es el valor del nodo
    y si no, el resultado es la suma de los nodos tanto izquiedo como derecho. Y aqui se hace la llamada
    recursiva
    */
    private int sumaHojasNivel(int maxNivel, NodoArbol nodo, int nivel) {
        int resultado;
        if ((nodo == null) || (nivel >= maxNivel)) {
            resultado = 0;
        } 
        else if ((nodo.getDerecho() == null) && (nodo.getIzquierdo() == null)) {
            resultado = nodo.getDato();
        } 
        else {
            resultado = this.sumaHojasNivel(maxNivel, nodo.getDerecho(), nivel + 1) +
                    this.sumaHojasNivel(maxNivel, nodo.getIzquierdo(), nivel + 1);
        }
        return resultado;
    }

    //Ejercicio 10
    public void invertir() {
        this.invertir(raiz);
    }
    /*
    Para este metodo, se compueba que el nodo no sea null
    Se crea un nodo auxiliar que se iguala al valor del nodo izquierdo y se pone
    el valor del nodo izquierdo en el derecho, y viceversa
    Despues se llama a casa nodo dentro de la funcion, para que quede de manera recursiva
    */
    private void invertir(NodoArbol nodo) {
        if (nodo != null) {
            NodoArbol aux = nodo.getIzquierdo();
            nodo.setIzquierdo(nodo.getDerecho());
            nodo.setDerecho(aux);
            this.invertir(nodo.getIzquierdo());
            this.invertir(nodo.getDerecho());
        }
    }

    //Ejercicio 11
    public boolean esUnivaluado() {
        if (raiz == null) {
            return true;
        } else {
            return this.esUnivaluado(raiz, raiz.getDato());
        }
    }
    /*
    Este metodo te pide comprobar si todos los valores de los nodos son iguales, por lo tanto para recorrer 
    el arbol, primero se comprueba si el el nodo es null que devuelva true,
    si no el resultado es el dato que es igual al valor del nodo y asi recursivamente con cada lado
    */
    private boolean esUnivaluado(NodoArbol nodo, int dato) {
        if (nodo == null) {
            return true;
        } else {
            return dato == nodo.getDato() &&  this.esUnivaluado(nodo.getIzquierdo(), dato) &&
                    this.esUnivaluado(nodo.getDerecho(), dato);
        }
    }

    //Ejercicio Examen 
    public void diferencia() {
        this.diferencia(raiz);
    }

    private int diferencia(NodoArbol nodo) {
        int resultado = 0;

        if(nodo == null) {
            resultado = 0;
        } else {
            int parteIzq = diferencia(nodo.getIzquierdo());
            int parteDcha = diferencia(nodo.getDerecho());
            resultado = parteIzq + parteDcha + nodo.getDato();
            nodo.setDato(parteDcha - parteIzq); 
        }
        return resultado;
    }

    public int diferenciaNiveles(int clave1, int clave2) {
        return Math.abs(alturaClave(raiz, clave1) - alturaClave(raiz, clave2));
    }

    private int alturaClave(NodoArbol nodo, int clave) {
        if(nodo == null) {
            return 0;
        } else {
            if(nodo.getDato() == clave) {
                return 1;
            } else if(nodo.getDato() > clave) {
                return 1 + alturaClave(nodo.getIzquierdo(), clave);
            } else {
                return 1 + alturaClave(nodo.getDerecho(), clave);
            }
        }
    }

    //Ejercico examen junio 2023
    public boolean sonHijosMenores() {
        return sonHijosMenores(raiz, raiz.getDato());
    }

    private boolean sonHijosMenores(NodoArbol nodo, int anterior) {
        boolean check = false;
        if(nodo == null){
            check = true;
        } else {
            if(nodo.getDato() <= anterior) {
                check = sonHijosMenores(nodo.getIzquierdo(), nodo.getDato()) && sonHijosMenores(nodo.getDerecho(), nodo.getDato());
            } else {
                check = false;
            }
        }
        return check;
    }




    // public NodoArbol obtenerPredecesor(int valor) {
    //     return obtenerPredecesor(raiz, valor);
    // }
    // private NodoArbol obtenerPredecesor(NodoArbol nodo, int valor) {
    //     if(nodo != null) {
    //         if(nodo.getDato() == valor) {
    //             if(nodo.getIzquierdo() != null) {
    //                 NodoArbol predecesor = nodo.getIzquierdo();
    //                 while(predecesor.getDerecho() != null) {
    //                     predecesor = predecesor.getDerecho();
    //                 }
    //                 return predecesor;
    //             }
    //         } else if(nodo.getDato() > valor) {
    //             return obtenerPredecesor(nodo.getIzquierdo(), valor);
    //         } else {
    //             return obtenerPredecesor(nodo.getDerecho(), valor);
    //         }
    //     }
    // }
}






