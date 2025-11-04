package instituto.frontend;

import instituto.backend.Controllers.EstudianteDAO;
import instituto.backend.Models.Estudiante;
import java.util.Scanner;

public class MenuEstudiante implements MenuConector {

    public final EstudianteDAO dao;
    private int op;
    private final Scanner sc = new Scanner(System.in);

    public MenuEstudiante() {
        dao = new EstudianteDAO();
    }
    
    @Override
    public void iniciarMenu() {
        do {
            System.out.println("******* MENÚ *******");
            System.out.println(" 1. Lista estudiantes.");
            System.out.println(" 2. Agregar estudiante.");
            System.out.println(" 3. Actualizar estudiante.");
            System.out.println(" 4. Eliminar estudiante.");
            System.out.println(" 0. SALIR.");
            System.out.print(" **** OPCIÓN: ");
            op = sc.nextInt();
            sc.nextLine();

            switch (op) {
                case 1 -> listar();
                case 2 -> agregar();
                case 3 -> actualizar();
                case 4 -> eliminar();
            }
        } while (op != 0);
    }

    public void listar() {
        System.out.println("LISTA DE ESTUDIANTES...");
        System.out.println("DNI:\t\tNombre:\t\tEdad:");
        for (Estudiante e : dao.leerEstudiantes()) {
            System.out.println(e.getDni() + "\t\t" + e.getNombre() + "\t\t" + e.getEdad());
        }
    }

    public void agregar() {
        System.out.print("Ingrese dni: ");
        int dni = sc.nextInt();
        sc.nextLine();
        System.out.print("Ingrese nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Ingrese edad: ");
        int edad = sc.nextInt();
        sc.nextLine();
        dao.crearEstudiante(new Estudiante(dni, nombre, edad));
    }

    public void actualizar() {
        System.out.print("Ingrese dni: ");
        int dni = sc.nextInt();
        sc.nextLine();
        System.out.print("Ingrese nuevo nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Ingrese edad: ");
        int edad = sc.nextInt();
        sc.nextLine();
        dao.actualizarEstudiante(dni, new Estudiante(dni, nombre, edad));
    }

    public void eliminar() {
        System.out.print("Ingrese dni: ");
        int dni = sc.nextInt();
        sc.nextLine();
        dao.eliminarEstudiante(dni);
    }
}
