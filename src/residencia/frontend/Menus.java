package residencia.frontend;

import java.util.Scanner;

public class Menus {
    
    private final Scanner sc = new Scanner(System.in);

    public Menus() {
    }
    
    public int menuPpal() {
        int op;

        System.out.println("******* MENÚ *******");
        System.out.println(" 1. Estudiantes.");
        System.out.println(" 2. Materias.");
        System.out.println(" 0. SALIR.");
        System.out.print(" **** OPCIÓN: ");
        op = sc.nextInt();
        sc.nextLine();

        return op;
    }
    
    public int menuEstudiante() {
        int op;

        System.out.println("******* MENÚ *******");
        System.out.println(" 1. Lista estudiantes.");
        System.out.println(" 2. Agregar estudiante.");
        System.out.println(" 3. Actualizar estudiante.");
        System.out.println(" 4. Eliminar estudiante.");
        System.out.println(" 0. SALIR.");
        System.out.print(" **** OPCIÓN: ");
        op = sc.nextInt();
        sc.nextLine();

        return op;
    }
    
    public int menuMateria() {
        int op;

        System.out.println("******* MENÚ *******");
        System.out.println(" 1. Lista materias.");
        System.out.println(" 2. Agregar materia.");
        System.out.println(" 3. Actualizar materia.");
        System.out.println(" 4. Eliminar materia.");
        System.out.println(" 0. SALIR.");
        System.out.print(" **** OPCIÓN: ");
        op = sc.nextInt();
        sc.nextLine();

        return op;
    }
}
