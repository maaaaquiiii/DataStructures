package arbolBusqueda;

public class ArbolBinarioBusqueda {

	private NodoArbol raiz;

	public ArbolBinarioBusqueda() {
		raiz = null;
	}

	// Muestra los elementos del arbol binario en orden central ---------------
	public void mostrar() {
		this.mostrar(raiz, "  ");
	}

	private void mostrar(NodoArbol nodo, String espacios) {
		if (nodo != null) {
			this.mostrar(nodo.getIzquierdo(), espacios + "    ");
			System.out.print(espacios);
			nodo.getDato().mostrar();
			this.mostrar(nodo.getDerecho(), espacios + "    ");
		}
	}

	// Inserta un elemento con una cierta clave -------------------------------
	public void insertar(Alumno dato) {
		raiz = this.insertarRec(raiz, dato);
	}

	private NodoArbol insertarRec(NodoArbol nodo, Alumno dato){
		if (nodo == null) {     // Crear nuevo nodo
			nodo = new NodoArbol(dato);
		} else if (dato.getMatricula() < nodo.getDato().getMatricula()) {    // Subárbol izquierdo
			NodoArbol nuevoIzq = this.insertarRec(nodo.getIzquierdo(), dato);
			nodo.setIzquierdo(nuevoIzq);
		} else if (dato.getMatricula() > nodo.getDato().getMatricula()) {    // Subárbol derecho
			NodoArbol nuevoDer = this.insertarRec(nodo.getDerecho(), dato);
			nodo.setDerecho(nuevoDer);
		} else {      // Clave repetida
			System.out.println("Error. El alumno con matrícula " + dato.getMatricula() + " ya existe");
		}
		return nodo;    // Devolver la nueva raíz del subárbol
	}


	// ------------------------------------------------------------------------
	// TODO 3.2: Devuelve el numero de nodos del arbol de forma RECURSIVA
	public int getNumElementos() {
		return this.getNumElementos(raiz);
	}
	private int getNumElementos(NodoArbol node) {
		if(node == null) {
			return 0;
		} else {
			return 1 + getNumElementos(node.getIzquierdo()) + getNumElementos(node.getDerecho());
		}
	}

	// 					OTRA FORMA
	// public int getNumElementos() {
	// 	return this.getNumElementos(raiz);
	// }
	// private int getNumElementos(NodoArbol node) {
	// 	int count = 0;
	// 	if(nodo != null){
	// 		count = 1 + getNumElementos(node.getIzquierdo()) + getNumElementos(node.getDerecho());
	// 	}
	// 	return count;
	// }


	// ------------------------------------------------------------------------
	// TODO 3.3: Devuelve el numero de nodos del arbol con clave
	// menor a una clave dada de forma RECURSIVA
	public int getNumMenores(int clave) {
		return this.getNumMenores(raiz, clave);
	}
	private int getNumMenores(NodoArbol node, int clave) {
		if(node == null) {
			return 0;
		} else if(node.getDato().getMatricula() >= clave) {
			return getNumMenores(node.getIzquierdo(), clave);
		} else {
			return 1 + getNumMenores(node.getIzquierdo(), clave) 
				+ getNumMenores(node.getDerecho(), clave);
		}
	}

	// // 					OTRA FORMA
	// public int getNumMenores(int clave) {
	// 	return this.getNumMenores(raiz, clave);
	// }
	// private int getNumMenores(NodoArbol node, int clave) {
	// 	int count = 0;

	// 	if(nodo != null) {
	// 		if(node.getDato().getMatricula() < clave) {
	// 			count = 1 + getNumMenores(node.getIzquierdo(), clave) + getNumMenores(node.getDerecho(), clave);
	// 		} else {
	// 			count = getNumMenores(node.getIzquierdo(), clave);
	// 		}
	// 	} 
	// 	return count;
	// }


	// ------------------------------------------------------------------------
	// TODO 3.4: Devuelve el elemento con la menor clave de forma RECURSIVA
	public Alumno getMenorElemento() {
		return this.getMenorElemento(raiz);
	}
	private Alumno getMenorElemento(NodoArbol node) {
		if(node.getIzquierdo() == null) {
			return node.getDato();
		} else {
			return getMenorElemento(node.getIzquierdo());
		}
	}

	// // 					OTRA FORMA
	// public Alumno getMenorElemento() {
	// 	return this.getMenorElemento(raiz);
	// }
	// private Alumno getMenorElemento(NodoArbol node) {
	// 	Alumno alumno = null;
	// 	if(node.getIzquierdo() == null) {
	// 		alumno = node.getDato();
	// 	} else {
	// 		alumno = getMenorElemento(node.getIzquierdo());
	// 	}
	// 	return alumno;
	// }


	// ------------------------------------------------------------------------
	// TODO 3.5: Devuelve el número de nodos del árbol con clave mayor que
	// claveMinimo y menor que claveMaximo
	public int getNumIntermedios(int claveMinimo, int claveMaximo) {
		return this.getNumIntermedios(raiz, claveMinimo, claveMaximo);
	}
	private int getNumIntermedios(NodoArbol node, int claveMinimo, int claveMaximo) {
		if(node == null) {
			return 0;
		} else if(node.getDato().getMatricula() < claveMinimo) {
			return getNumIntermedios(node.getIzquierdo() ,claveMinimo, claveMaximo);
		} else if (node.getDato().getMatricula() >= claveMaximo) {
			return getNumIntermedios(node.getIzquierdo(), claveMinimo, claveMaximo);
		} else {
			return 1 + getNumIntermedios(node.getIzquierdo(), claveMinimo, claveMaximo) 
				+ getNumIntermedios(node.getDerecho(), claveMinimo, claveMaximo);
		}
	}

	// // 					OTRA FORMA
	// public int getNumIntermedios(int claveMinimo, int claveMaximo) {
	// 	return this.getNumIntermedios(raiz, claveMinimo, claveMaximo);
	// }
	// private int getNumIntermedios(NodoArbol node, int claveMinimo, int claveMaximo) {
	// 	int count = 0;
	// 	if(nodo != null) {
	// 		if(node.getDato().getMatricula() > claveMinimo && node.getDato().getMatricula() < claveMaximo) { 
	// 			count = 1 + getNumIntermedios(node.getIzquierdo(), claveMinimo, claveMaximo) + getNumIntermedios(node.getDerecho(), claveMinimo, claveMaximo);
	// 		} else {
	// 			count = getNumIntermedios(node.getIzquierdo(), claveMinimo, claveMaximo);
	// 		}
	// 	}
	// 	return count;
	// }


}
