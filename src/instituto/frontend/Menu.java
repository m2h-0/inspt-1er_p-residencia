package instituto.frontend;

import java.util.Scanner;

public class Menu implements MenuConector {
    
    private int op;
    private final Scanner sc = new Scanner(System.in);

    public Menu() {
    }
    
    @Override
    public void iniciarMenu() {
        do {
            System.out.println("******* MENÚ *******");
            System.out.println(" 1. Estudiantes.");
            System.out.println(" 2. Materias.");
            System.out.println(" 0. SALIR.");
            System.out.print(" **** OPCIÓN: ");
            op = sc.nextInt();
            sc.nextLine();

            switch (op) {
                case 1 -> estudiantes();
                case 2 -> materias();
                case 0 -> System.out.println("Saliendo del sistema");
                default -> System.out.println("Opción inválida, intente de nuevo.");
            }
        } while (op != 0);
    }
    
    public void estudiantes() {
        MenuEstudiante menu = new MenuEstudiante();
        menu.iniciarMenu();
    }
    
    public void materias() {
        MenuMateria menu = new MenuMateria();
        menu.iniciarMenu();
    }
}
