public class Ejercicios {
    public Ejercicios(){

    }

    public void invertirColas(Cola cola) {
        int dato = 0;
    
        if(!cola.vacia()) {
            dato = cola.desencolar();
            invertirColas(cola);
            cola.encolar(dato);
        }
    }

    public int posicionCola(Cola cola, int dato){
        int lenght = cola.getNumElementos();
        int elem = 0;
        int pos = -1;
        
        for(int i = 1; i <= lenght; i++){
            elem = cola.desencolar();
            cola.encolar(elem);
            if(elem == dato && pos == -1){
                pos = i;
            }
        }
        return pos;
    }

    public Cola mezclarColas(Cola cola1, Cola cola2){
        Cola cola3 = new Cola();
        int dato1 = 0;
        
        
        while(!cola1.vacia() || !cola2.vacia()){
            if(!cola1.vacia()){
                dato1 = cola1.desencolar();
                cola3.encolar(dato1);
            }
            if(!cola2.vacia()){
                dato1 = cola2.desencolar();
                cola3.encolar(dato1);
            }
        }

        while(!cola3.vacia()){
            dato1 = cola3.desencolar();
            cola1.encolar(dato1);
        }
        return cola1;
    }
        //int dato2 = 0;
        // dato1 = cola1.desencolar();
        // dato2 = cola2.desencolar();
        // if(cola1.getNumElementos() >= cola2.getNumElementos()){
        //     cola3.encolar(dato1);
        //     cola3.encolar(dato2);
        // } else{
        //     cola3.encolar(dato2);
        //     cola3.encolar(dato1);
        // }


    public void sustituirSegmentoImpares (Cola c){
        
    }
}
