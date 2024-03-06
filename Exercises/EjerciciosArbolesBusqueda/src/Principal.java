public class Principal {
    public static void main(String[] args) throws Exception {
        ArbolBinarioBusqueda alumnos = new ArbolBinarioBusqueda();
		Alumno pepe = new Alumno("Pepe", "Pso. La Parra");
		Alumno juan = new Alumno("Juan", "C/ El Duende");
		Alumno sandra = new Alumno("Sandra", "C/ Miralles");
		Alumno maria = new Alumno("María", "Avda. Marqués de Lino");
		alumnos.insertar(7, pepe);
		alumnos.insertar(17, juan);
		alumnos.insertar(1, sandra);
		alumnos.insertar(27, maria);

		System.out.println("Preorden mostrando el nivel de cada nodo:");
		alumnos.preOrdenNivel();
		System.out.println("--------------------");

        System.out.println("EJERCICIO 12");
		System.out.println("claves en orden descendente:");
		alumnos.mostrarClavesDescendente();
		System.out.println("\n--------------------");

        System.out.println("EJERCICIO 13");
		System.out.println("Claves que tienen sólo un hijo en orden descendente:");
		alumnos.mostrarClavesHijo();
		System.out.println("\n--------------------");

        System.out.println("EJERCICIO 14");
		System.out.println("Claves entre 7 y 27, ordenadas ascendentemente:");
		alumnos.mostrarClavesEntreDos(6, 27);
		System.out.println("\n--------------------");

        System.out.println("EJERCICIO 15");
		System.out.println("Es hoja el 17? "+ alumnos.comprobarSiEnHoja(17));
        System.out.println("Es hoja el 25? "+ alumnos.comprobarSiEnHoja(25));
		System.out.println("\n--------------------");

        System.out.println("EJERCICIO 16");
		System.out.println("antecesores comunes a 1 y 27");
		System.out.println(alumnos.antecesoresComunes(1, 27));
		System.out.println("--------------------");

		System.out.println("EJERCICIO 17");
		System.out.println("diferencia Niveles entre 7 y 27");
		System.out.println(alumnos.diferenciaNiveles(7,27));
		System.out.println("--------------------");

		System.out.println("EJERCICIO 18");
		System.out.println("mayor diferencia de claves:");
		System.out.println(alumnos.mayorDiferencia());
		System.out.println("--------------------");
    }
}
