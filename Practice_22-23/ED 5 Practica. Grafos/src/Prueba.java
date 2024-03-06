
public class Prueba {
    public static void main (String [] args) {
        int numeroContactos = 10;  
        Persona[] contactos = new Persona[numeroContactos];

        contactos[0] = new Persona("Juan Nadie", "111111", "C/ Uno");
        contactos[1] = new Persona("Jose Cuervo", "222222", "C/ Dos");
        contactos[2] = new Persona("Eva Adan", "333333", "C/ Tres");
        contactos[3] = new Persona("Alicia Maravillas", "777777", "C/ Cuatro");
        contactos[4] = new Persona("Alan Turing","999999","C/ Cinco");
        contactos[5] = new Persona("Guillermo Tell","157267","C/ Seis");
        contactos[6] = new Persona("Julio Catedrales","123456","C/ Siete");
        contactos[7] = new Persona("Lucas Pato","231465","C/ Ocho");
        contactos[8] = new Persona("Paula Vázquez","654321","C/ Nueve" );
        contactos[9] = new Persona("Clara Oscuro","123654","C/ Dos" );

        AmigosETSISI g = new AmigosETSISI(numeroContactos, contactos);
        g.insertaRelacion(0, 1);
        g.insertaRelacion(0, 3);
        g.insertaRelacion(0, 4);
        g.insertaRelacion(0, 5);
        g.insertaRelacion(1, 4);
        g.insertaRelacion(4,5);
        g.insertaRelacion(6,8);
        g.insertaRelacion(2,7);
        g.insertaRelacion(2,9);
        g.insertaRelacion(9,7);

        g.mostrarRed();
        System.out.println("APARTADO 2.2.1. PRUEBAS DE mostrarGrupos");
        System.out.println("Numero de componentes conexas:" + g.mostrarGrupos());
        System.out.println("----------------------------------------------------");

        System.out.println("\nAPARTADO 2.2.2. PRUEBAS DE amigosIndirectos.");
        System.out.println("Los amigos indirectos de Alicia son:\n");
        g.mostrarAmigosIndirectos("Alicia Maravillas");
        System.out.println("----------------------------------------------------");

        System.out.println("\nAPARTADO 2.2.3. PRUEBAS DE noSonAmigos.");
        System.out.println("Juan Nadie[0] vs Alan Turing[4]");
        System.out.println("La respuesta es: " + g.noSonAmigos(contactos[0],contactos[4]));//Caso falso
        System.out.println("--------------------------------");
        System.out.println("Juan Nadie[0] vs Clara Oscuro[9]");
        System.out.println("La respuesta es: " + g.noSonAmigos(contactos[0],contactos[9])); //Caso correcto

        System.out.println("----------------------------------------------------");

        System.out.println("\nAPARTADO 2.2.4. PRUEBAS DE mostrarMiembrosSiAmigos.");
        g.mostrarMiembrosSiAmigos(contactos[2], contactos[9]);
        g.mostrarMiembrosSiAmigos(contactos[2], contactos[8]);
        System.out.println("----------------------------------------------------");

        System.out.println("\nEJERCICIO EXAMEN PRACTICAS. masAntiguo.");
        g.masAntiguo(contactos[4]);
        g.masAntiguo(contactos[2]);

    }

}
