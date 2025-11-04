package residencia.backend.Controllers;

import residencia.backend.Models.Estudiante;
import java.util.Scanner;
import residencia.frontend.Interfaces.Mensajes;
import residencia.frontend.SalidaConsola;

public class ControladorEstudiante {

    public final EstudianteDAO dao;
    private int op;
    private final Scanner sc = new Scanner(System.in);
    private Mensajes mensajes;

    public ControladorEstudiante() {
        dao = new EstudianteDAO();
        mensajes = new SalidaConsola();
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
