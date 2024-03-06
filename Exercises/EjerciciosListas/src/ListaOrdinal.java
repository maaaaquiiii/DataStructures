public class ListaOrdinal {
    private Nodo inicio;
	private int numElementos;

	public ListaOrdinal() {
		inicio = null;		
		numElementos = 0;
	}

	public ListaOrdinal(int[] elementos){
		inicio = null;
		numElementos = elementos.length;
		Nodo actual = null;
		for(int i=0; i<elementos.length; i++){
			Nodo nuevo = new Nodo(elementos[i], null);
			if(actual==null){
				inicio=nuevo;
			}else{
				actual.setSiguiente(nuevo);
			}
			actual = nuevo;
		}
	}

	public void mostrar(){
		String cadena = "[";
		Iterador it = getIterador();
		while(it.hasNext()){
			int e = it.next();
			cadena += e + " ";
		}
		cadena += "]";
		System.out.println(cadena);
	}
	public boolean vacia() {
		return inicio == null;
	}

	/**
	 * Inserta el dato en la última posición de la lista
	 */
	public void insertar(int dato) {
		Nodo nuevo = new Nodo(dato, null);
		if (this.vacia()) {
			inicio = nuevo;
		} else {
			Nodo aux = inicio;
			while (aux.getSiguiente()!=null){
				aux=aux.getSiguiente();
			}
			aux.setSiguiente(nuevo);
		}
		numElementos++;
	}


	/**
	 * Busca el dato que ocupa la posición recibida como parámetro,
	 * en caso de existir.
	 */
	public int getElemento(int posicion) {
		Nodo actual;
		if ((posicion > numElementos - 1) || (posicion < 0)) {
			System.out.println("No existe la posición " + posicion);
			return -1;
		} else {
			actual = inicio;
			for (int i = 0; i < posicion; i++) {
				actual = actual.getSiguiente();
			}
			return actual.getDato();
		}
	}

	/**
	 * Borra el primer elemento de la lista cuyo dato coincide con el
	 * parámetro recibido.
	 */
	public void borrar(int dato) {
		Nodo actual = inicio;
		Nodo anterior = null;
		boolean borrado = false;
		while (actual != null && !borrado) {
			if (actual.getDato() == dato) {  // Borrar actual
				if (actual != inicio) {
					anterior.setSiguiente(actual.getSiguiente());
				} else {
					inicio = actual.getSiguiente();
				}
				numElementos--;
				borrado = true;
			} else {
				anterior = actual;
				actual = actual.getSiguiente();
			}
		}
	}

	/**
	 * Devuelve la primera posición en la que se encuentra el dato,
	 * en caso de existir. En caso contrario, devuelve -1
	 */

	public int posicion(int dato) {
		Nodo actual = inicio;
		int pos = 0;
		while (actual != null && actual.getDato() != dato) {
			actual = actual.getSiguiente();
			pos++;
		}
		if (actual != null) {
			return pos;
		} else {
			return -1;
		}
	}

	/**
	 * Determina si el dato recibido como parámetro existe en la lista.
	 */
	public boolean contiene(int dato) {
		return this.posicion(dato) >= 0;
	}

	public int getNumElementos() {
		return numElementos;
	}

	public Iterador getIterador() {
		return new Iterador(inicio);
	}

}
