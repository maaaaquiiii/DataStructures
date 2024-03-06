public class Ejercicios {
    public Ejercicios(){

    }

    public Pila devolverNveces(Pila pila, int n){
        int dato = 0;

       //Rellenar la pila auxiliar con los datos repetidos n veces de la pila principal
        if(pila.vacia()){
            return pila;
        } else{
            dato = pila.desapilar();
            devolverNveces(pila, n);
            for(int i = 0; i < n; i++){
                pila.apilar(dato);
            }
        }
        return pila;
    }

    public Pila reorganizar(Pila pila, int n){
        if(pila.vacia()){
            return pila;
        } else{
            int dato = pila.desapilar();
            pila.apilar(dato);
        }
        pila.apilar(n);
        return pila;
    }

    public int numElements(Pila pila) {
        int dato = 0;
        int count = 0;

        if (pila.vacia()) {
            return 0;
        } else {
            dato = pila.desapilar();
            count = 1 + numElements(pila);
            if(dato > count){
                return 1;
            }
            else if (dato == count){
                return 0;
            }
            else{
                return -1;
            }
        }

    }

    public void eliminarPos(Pila pila){
        eliminarPos(pila, 3);
    }
    private int eliminarPos(Pila pila, int pos){
        int dato = 0;
        int elemento = 0;

        if(!pila.vacia()){
            elemento = pila.desapilar();
            pos++;
            if(!pila.vacia()){
                dato = eliminarPos(pila, pos);
            } else{
                dato = elemento;
            }
            if(pos != dato){
                pila.apilar(elemento);
            }
        }
        return dato;
    }

    public void moverElemento(Pila pila){
        int elem = 0;
        int dato = 0;

        if(!pila.vacia()){
            elem = pila.desapilar();
            dato = pila.desapilar();
            if(elem == dato){
                pila.apilar(dato);
            }
            pila.apilar(elem);
        }
    }


    public void hacerPilaCapicua(Pila pila) {
        int dato = 0;

        if(pila.vacia()) {
            return;
        } else {
            dato = pila.desapilar();

        }
    }

    public int eliminarDato(Pila pila, int dato){
       int elem = 0;
       int count = 0;
        
       if(pila.vacia()){
           return 0;
       } else{
            elem = pila.desapilar();
            count = eliminarDato(pila, dato);
            if(dato != elem){
                pila.apilar(elem);
            } else{
                count++;
            }
       }
       return count;
    }

    public int mayorElemento(Pila pila){
        int mayor = 0;
        int dato = 0;

        if(!pila.vacia()){
            dato = pila.desapilar();
            mayor = mayorElemento(pila);
            if(dato > mayor){
                mayor = dato;
            }
            pila.apilar(dato);
        }

        return mayor;
    }

    public Pila quitarPosiciones(Pila pila){
        return this.quitarPosiciones(pila, 0);
    }
    private Pila quitarPosiciones(Pila pila, int pos){
        int elemento = 0;

        if(pila.vacia()){
            return new Pila();
        } else{
            elemento = pila.desapilar();
            pos++;
            Pila result = this.quitarPosiciones(pila, pos);
            if(pos % 2 == 0){
                result.apilar(elemento);
            } else{
                pila.apilar(elemento);
            }
            return result;
        }
    }

    public void ponerFondoDiferenciaMaximoMinimo(Pila pila){
        if(!pila.vacia()){
            this.ponerFondoDiferenciaMaximoMinimo(pila, Integer.MAX_VALUE, -1);
        }
    }
    private void ponerFondoDiferenciaMaximoMinimo(Pila pila, int minimo, int maximo){
        int dato = 0;

        if(!pila.vacia()){
            dato = pila.desapilar();
            if(dato > maximo){
                maximo = dato;
            }
            if(dato < minimo){
                minimo = dato;
            }
            ponerFondoDiferenciaMaximoMinimo(pila, minimo, maximo);
            pila.apilar(dato);
        } else{
            pila.apilar(maximo - minimo);
        }
    }


    public boolean comprobarOrdenacion(Pila pila){
        return comprobarOrdenacion(pila, 0);
    }
    private boolean comprobarOrdenacion(Pila pila, int anterior){
        int dato = 0;
        boolean isTrue = true;
        
        if(!pila.vacia()){
            dato = pila.desapilar();
            if(dato > anterior){
                anterior = dato;
                isTrue  = comprobarOrdenacion(pila, anterior);
            } else{
                isTrue = false;
            }
            pila.apilar(dato);
        }
        return isTrue;
    }
}

