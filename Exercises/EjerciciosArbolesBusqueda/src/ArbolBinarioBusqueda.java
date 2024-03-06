public class ArbolBinarioBusqueda {
    private NodoArbol raiz;
    private int numElementos;

    public ArbolBinarioBusqueda() {
        raiz = null;
        numElementos = 0;
    }

    public void preOrdenNivel() {
        this.preOrdenNivelRec(raiz, 1);
    }

    private void preOrdenNivelRec(NodoArbol nodo, int nivel) {
        if (nodo != null) {
            System.out.print("Nivel " + nivel + ".   ");
            nodo.getDato().mostrar();
            this.preOrdenNivelRec(nodo.getIzquierdo(), nivel + 1);
            this.preOrdenNivelRec(nodo.getDerecho(), nivel + 1);
        }
    }

    public Alumno getElemento(int clave) {
        return this.getElementoRec(raiz, clave);
    }

    private Alumno getElementoRec(NodoArbol nodo, int clave) {
        Alumno resultado = null;
        if (nodo == null) {
            resultado = null;
        } else if (nodo.getClave() == clave) {
            resultado = nodo.getDato();
        } else if (nodo.getClave() > clave) {
            resultado = this.getElementoRec(nodo.getIzquierdo(), clave);
        } else {
            resultado = this.getElementoRec(nodo.getDerecho(), clave);
        }
        return resultado;
    }

    public boolean contiene(int clave) {
        return (getElemento(clave) != null);
    }

    public void insertar(int clave, Alumno dato) {
        raiz = this.insertarRec(raiz, clave, dato);
    }

    private NodoArbol insertarRec(NodoArbol nodo, int clave, Alumno dato) {
        if (nodo == null) {     // Crear nuevo nodo
            nodo = new NodoArbol(clave, dato);
            numElementos++;
        } else if (clave < nodo.getClave()) {    // Subárbol izquierdo
            NodoArbol nuevoIzq = this.insertarRec(nodo.getIzquierdo(), clave, dato);
            nodo.setIzquierdo(nuevoIzq);
        } else if (clave > nodo.getClave()) {    // Subárbol derecho
            NodoArbol nuevoDer = this.insertarRec(nodo.getDerecho(), clave, dato);
            nodo.setDerecho(nuevoDer);
        } else {      // Clave repetida
            System.out.println("Error insercción. La clave " + clave + " ya existe");
        }
        return nodo;    // Devolver la nueva raíz del subárbol

    }

    //Ejercicio 12
    public void mostrarClavesDescendente() {
        this.mostrarClavesDescendenteRec(raiz);
    }
    /*
    Para recorrer el arbol se comprueba que el nodo no sea null
    Si no es null llamamos al nodo dcho del arbol para que imrpima la clave
    se imprime la clave y se llama al lado izquierdo
    */
    private void mostrarClavesDescendenteRec(NodoArbol nodo) {
        if (nodo != null) {
            this.mostrarClavesDescendenteRec(nodo.getDerecho());
            System.out.print(nodo.getClave() + " ");
            this.mostrarClavesDescendenteRec(nodo.getIzquierdo());
        }
    }

    //ejercicio 13
    public void mostrarClavesHijo(){
        this.mostrarClavesHijo(raiz);
    }
    /*
    Para este metodo, primero se comprueba que el nodo no sea null, después vuelve a llamar
    al método para recorrer el árbol por el lado dcho.
    Se compara el nodo izqdo sea null y el nodo dcho no sea null o viciversa y se imprime 
    la clave (el valor del nodo).
    Y se vuelve a llamar al método por el lado izqdo

    */
    private void mostrarClavesHijo(NodoArbol nodo){
        if(nodo != null){
            this.mostrarClavesHijo(nodo.getDerecho());
            if ((nodo.getIzquierdo() == null && nodo.getDerecho() != null) ||
                (nodo.getDerecho() == null && nodo.getIzquierdo() != null)) {
                    System.out.print(nodo.getClave() + " ");
            }
            this.mostrarClavesHijo(nodo.getIzquierdo());
        }
    }

    //Ejercicio 14
    public void mostrarClavesEntreDos(int c1, int c2){
        this.mostrarClavesEntreDos(raiz,c1, c2);
    }
    /*
    Para recorrer el arbol, se comprueba que el nodo no sea null, se vuelve a llamar al 
    método para recorrer el lado dcho del árbol, y se comrpueba que el valor del nodo este 
    entre los dos valores que se han pasado por parametro, y los que cumplan esa condición se 
    imprimen
    Se vuelve a hacer por el lado izqdo
    */
    private void mostrarClavesEntreDos(NodoArbol nodo, int c1, int c2){
        if(nodo != null){
            this.mostrarClavesEntreDos(nodo.getDerecho(), c1, c2);
                if (nodo.getClave() > c1 && nodo.getClave() < c2) {
                    System.out.print(nodo.getClave() + " ");
                }
                this.mostrarClavesEntreDos(nodo.getIzquierdo(), c1, c2);
        }
    }

    //Ejercicio 15
    public boolean comprobarSiEnHoja(int clave){
        return comprobarSiEnHoja(raiz, clave);
    }
    /*
    En este método, primero se comprueba que el nodo no sea null, porque sino no es verdadero,
    en cambio si la clave del nodo es igual a la clave que se ha pasado por parametro es verdadero,
    Y mientras que la clave del nodo es menor que ña clave, se recorre el lado dcho del arbol 
    y si la clave es mayor que la del parametro se recorre el lado izqdo
    */
    private boolean comprobarSiEnHoja(NodoArbol nodo, int clave){
        boolean resultado;

        if(nodo == null){
            resultado = false;
        }
        else if(nodo.getClave() == clave){
            resultado = true;
        }
        else if(nodo.getClave() < clave){
            resultado = this.comprobarSiEnHoja(nodo.getDerecho(), clave);
        }
        else{
            resultado = this.comprobarSiEnHoja(nodo.getIzquierdo(), clave);
        }

        return resultado;
    }

    //Ejercicio 16
    public int antecesoresComunes(int c1, int c2) {
        if (c1 < c2) {
            return this.antecesoresComunes(raiz, c1, c2);
        } 
        else {
            return this.antecesoresComunes(raiz, c2, c1);
        }
    }
    /*
    Para este método, se necesita una variable que se vaya sumando el resultado, para después
    devolverlo
    Primero se comprueba que si el nodo es null, el resultado es 0.
    Mientras que si la clave del nodo es mayor que el valor que se ha pasado por argumento
    se va sumando y se vuelve a llamarse así misma.
    En cambio si la clave del nodo es menor que el argumento, se suma uno y se vuelve a llamar
    asi misma.
    Pero si la clave del nodo es mayor que el argumento menor y mayor que el argumento mayor
    el resultado es 1
    Si no el resultado es 0
    En el metodo publico lo unico que hay que implementar es, que si c1 < c2, se mete el metodo
    auxiliar primero con c1 y despues c2, y si es al reves, primero se mete c2 y despues c1
    */
    private int antecesoresComunes(NodoArbol nodo, int menor, int mayor) {
        int resultado;

        if (nodo == null) {
            resultado = 0;
        } 
        else if (nodo.getClave() > mayor) {
            resultado = 1 + this.antecesoresComunes(nodo.getIzquierdo(), menor, mayor);
        } 
        else if (nodo.getClave() < menor) {
            resultado = 1 + this.antecesoresComunes(nodo.getDerecho(), menor, mayor);
        } 
        else if ((nodo.getClave() > menor) && (nodo.getClave() < mayor)) {
            resultado = 1;
        } 
        else {
            resultado = 0;
        }
        return resultado;
    }

    //Ejercicio 17
    public int diferenciaNiveles(int c1, int c2){
        int alturaC1 = this.alturaNiveles(raiz, c1);
        int alturaC2 = this.alturaNiveles(raiz, c2);

        if(alturaC1 < alturaC2){
            return alturaC2 - alturaC1;
        }
        else{
            return alturaC1 - alturaC2;
        }
    }
    /*
    Para recorrer el arbol, primero hay que comproobar si la clave del nodo en el que estamos
    es igual a la clave que se ha pasado por parametro y se suma 1 al resultado.
    Si la clave del nodo es mayor que la del parametro se recorre el lado izqdo sumando uno al resultado
    Y si la clave es menor que el parametro se recorre el lado dcho del arbol sumandose uno al resultado
    En el metodo publico lo unico que hay que implementar son dos variebles que llamen al metodo
    auxliar con la clave correspondiente. Para despues comparar si alturaC1 es menor que alturaC2
    que se reste correctamente todo.
    */
    private int alturaNiveles(NodoArbol nodo, int clave){
        int resultado;

        if(nodo.getClave() == clave){
            resultado = 1;
        }
        else if(nodo.getClave() > clave){
            resultado = 1 + alturaNiveles(nodo.getIzquierdo(), clave);
        }
        else{
            resultado = 1 + alturaNiveles(nodo.getDerecho(), clave);
        }
        return resultado;
    }

    //Ejercicio 18
    public int mayorDiferencia() {
        return this.claveMayor(raiz) - this.claveMenor(raiz);
    }
    /*
    Para este obtener el resultado deseado, hay que hacer dos metodos, uno en el que saque
    la clave menor, en el que si el nodo es null resultado = 0, si el nodo izqdo es null
    el resultado es la clave del nodo y sino es asi se vuelve a llamar al metodo.
    Para el método de sacar la clave mayor, se comprueba si el nodo es null,  el resultado
    es 0, en cambio si el nodo dcho es null, el resultado es la clave del nodo. Y si no
    se vuelve a llamar al metodo para que recorra el arbol.
    */
    private int claveMenor(NodoArbol nodo) {
        int resultado;

        if (nodo == null) {
            resultado = 0;
        } 
        else if (nodo.getIzquierdo() == null) {
            resultado = nodo.getClave();
        } 
        else {
            resultado = this.claveMenor(nodo.getIzquierdo());
        }
        return resultado;
    }
    private int claveMayor(NodoArbol nodo) {
        int resultado;

        if (nodo == null) {
            resultado = 0;
        } 
        else if (nodo.getDerecho() == null) {
            resultado = nodo.getClave();
        } 
        else {
            resultado = this.claveMayor(nodo.getDerecho());
        }
        return resultado;
    }

    //Ejercicio 19
    public int eliminarSucesores(int clave) {
        NodoArbol nodo = this.buscarClave(raiz, clave);
        int resultado;

        if (nodo != null) {
            resultado = this.numElementos(nodo.getIzquierdo()) +
                    this.numElementos(nodo.getDerecho());
            nodo.setIzquierdo(null);
            nodo.setDerecho(null);
        } else {
            resultado = 0;
        }
        return resultado;
    }
    /*
    Para eliminar una clave y sus nodos que esten en el arbol, hay que recorrer el arbol
    comrpobando si el nodo es null, devuelve una variable de tipo NodoArbol null,
    Si la clave del nodo en el que estamos es la clave metida como argumento, se igualan
    los nodos, si es mayor la clave qe el argumento, recorre el lado izquierdo, llamando
    al metodo, y si es menor recorre el lado derecho del arbol.
    En el segundo metodo primero se crea una variable int, después se comprueba que si el
    nodo es igual a null, el resultado es 0, si no se suma en el resultado 1 así mismo hasta 
    recorrer el árbol, para finalizar devuelve el resultado.
    En el metodo principal se crea un nodo igualandolo al metodo de buscar la clave y una
    variable int qpara el resultado.
    Se comprueba que el nodo no sea null, para igualar el resultado al metodo del numero de
    elementos que hay, tanto por el lado izq como por el dcho, y si la clave del nodo coincide
    con la clave del argumento, los nodos que salgan a continuacion de ese nodo son null.
    
    */
    private NodoArbol buscarClave(NodoArbol nodo, int clave) {
        if (nodo == null) {
            return null;
        } 
        else if (nodo.getClave() == clave) {
            return nodo;
        } 
        else if (nodo.getClave() > clave) {
            return this.buscarClave(nodo.getIzquierdo(), clave);
        } 
        else {
            return this.buscarClave(nodo.getDerecho(), clave);
        }
    }
    private int numElementos(NodoArbol nodo) {
        if (nodo == null) {
            return 0;
        } 
        else {
            return 1 + this.numElementos(nodo.getIzquierdo()) + this.numElementos(nodo.getDerecho());
        }
    }


}   
