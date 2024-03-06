package arbolNario;

public class ArbolNario {

	private NodoArbolNario raiz;

	public ArbolNario(int dato) {
		raiz = new NodoArbolNario(dato);
	}

	public void insertar(ArbolNario arbol) {
		raiz.getHijos().insertar(arbol.raiz);
	}

	// ------------------------------------------------------------------------
	// TODO 2.2: Mostrar el arbol recorriendo en profundidad de forma RECURSIVA
	public void mostrarProfundidadRecursivo() {
		System.out.print("Profundidad Recursivo: ");
		this.mostrarProfundidadRecursivo(raiz);
		System.out.println();
	}
	private void mostrarProfundidadRecursivo(NodoArbolNario node) {
		if (node != null) {
			//ListaNodosArbolNario list = node.getHijos();
			IteradorAdelanteListaNodosArbolNario itForward = node.getHijos().getIteradorAdelante();
			System.out.print(node.getDato() + " ");
			while(itForward.hasNext()){
				node = itForward.next();
				mostrarProfundidadRecursivo(node);
			}
		}

	}

	// ------------------------------------------------------------------------
	// TODO 2.3: Mostrar el arbol recorriendo en profundidad de forma ITERATIVA
	public void mostrarProfundidadIterativo() {
		System.out.print("Profundidad Iterativo: ");
		NodoArbolNario node = raiz;
		PilaNodosArbolNario stack = new PilaNodosArbolNario();

		stack.apilar(node);
		while(!stack.vacia()) {
			node = stack.desapilar();
			System.out.print(node.getDato() + " ");
			IteradorAtrasListaNodosArbolNario itBack = node.getHijos().getIteradorAtras();
			while(itBack.hasPrevious()) {
				stack.apilar(itBack.previous());
			}
		}
		System.out.println();
	}

	// ------------------------------------------------------------------------
	// TODO 2.4: Mostrar el arbol recorriendo en amplitud de forma ITERATIVA
	public void mostrarAmplitud() {
		System.out.print("Amplitud: ");
		NodoArbolNario node = raiz;
		if (node != null) {
			ColaNodosArbolNario queue = new ColaNodosArbolNario();
			queue.encolar(node);
			while(!queue.vacia()) {
				node = queue.desencolar();
				System.out.print(node.getDato() + " ");
				//ListaNodosArbolNario list = node.getHijos();
				IteradorAdelanteListaNodosArbolNario itForward = node.getHijos().getIteradorAdelante();
				while(itForward.hasNext()) {
					queue.encolar(itForward.next());
				}
			}
		}
		System.out.println();
	}
	
}