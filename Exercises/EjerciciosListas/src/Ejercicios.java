public class Ejercicios {
    private Nodo inicio;

    public Ejercicios(){

    }

    public void duplicarParesQuitarImpares( ListaOrdinal lista){
		Nodo actual = null;
        Nodo anterior = null;
		actual = inicio;
		while (actual != null){
			if(actual.getDato() % 2 == 0){
				Nodo nuevo = new Nodo(actual.getDato(), actual.getSiguiente());
				actual.setSiguiente(nuevo);
				actual = nuevo.getSiguiente();
				anterior = nuevo;
			} else{ // borrar nodo actual
				if(this.inicio == actual){
					inicio = inicio.getSiguiente();
				} else{
					anterior.setSiguiente(actual.getSiguiente());
				}
				actual=actual.getSiguiente();
			}
		}
	}

    public void eliminarRepetidos(int dato){
		Nodo actual = inicio;
		while (actual!=null && actual.getDato()!=dato){
			actual=actual.getSiguiente();
		}
		if(actual!=null){
			Nodo anterior = actual;
			actual = actual.getSiguiente();
			while (actual!=null){
				if(actual.getDato()==dato){
					anterior.setSiguiente(actual.getSiguiente());
					actual=actual.getSiguiente();
				}else{
					anterior=actual;
					actual=actual.getSiguiente();
				}
			}
		}
	}

    public void triplicar(){
		Nodo actual = inicio;
		while (actual!=null){
			Nodo nuevo1 = new Nodo(actual.getDato(),actual.getSiguiente());
			Nodo nuevo2 = new Nodo(actual.getDato(),nuevo1);
			actual.setSiguiente(nuevo2);
			actual=nuevo1.getSiguiente();
		}
	}


}



/*
	public void insertarAContinuacion(int base, int nuevo){
		Nodo actual = inicio;
		while(actual!=null){
			if(actual.getDato()!=base){
				actual=actual.getSiguiente();
			}else{
				Nodo nodo = new Nodo(nuevo, actual.getSiguiente());
				actual.setSiguiente(nodo);
				actual=nodo.getSiguiente();
			}
		}
	}





	public boolean contieneEjer9 (int valor){
		Nodo actual, anterior;
		actual = inicio;
		anterior = null;
		while (actual!=null && actual.getDato()!=valor){
			anterior = actual;
			actual = actual.getSiguiente();
		}
		if(actual==null){
			return false;
		}else {
			anterior.setSiguiente(actual.getSiguiente());
			actual.setSiguiente(inicio);
			inicio = actual;
			return true;
		}
	}
	public void imagenEspecular(){
		Nodo aux = inicio;
		while (aux!=null){
			Nodo nuevo = new Nodo(aux.getDato(), inicio);
			inicio = nuevo;
			aux = aux.getSiguiente();
		}
	}

	public void insertarCeros(){
		Nodo actual = inicio;
		int suma = 0;
		while (actual!=null){
			suma += actual.getDato();
			actual=actual.getSiguiente();
		}
		actual=inicio;
		while (actual!=null){
			if(actual.getDato()==suma){
				Nodo nuevo = new Nodo(0, actual.getSiguiente());
				actual.setSiguiente(nuevo);
				actual = actual.getSiguiente();
			}else{
				actual = actual.getSiguiente();
			}
		}
	}

	public void insertarCerosRec(){
		if(!this.vacia()){
			this.insertarCerosRecAux(0);
		}
	}

	private int insertarCerosRecAux(int suma){
		int x=0;
		if(!this.vacia()){
			int e = this.inicio.getDato();
			inicio = inicio.getSiguiente();
			x = this.insertarCerosRecAux(suma + e);
			if(x==e){
				Nodo nuevo = new Nodo(0,inicio);
				inicio = nuevo;
			}
			Nodo nuevo = new Nodo(e,inicio);
			inicio = nuevo;
			return x;
		}else
			return suma;
	}
*/
