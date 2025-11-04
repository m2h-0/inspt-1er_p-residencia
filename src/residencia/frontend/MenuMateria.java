package residencia.frontend;

import residencia.backend.Controllers.MateriaDAO;
import residencia.backend.Models.Materia;
import java.util.Scanner;

public class MenuMateria implements MenuConector {

    public final MateriaDAO dao;
    private int op;
    private final Scanner sc = new Scanner(System.in);

    public MenuMateria() {
        dao = new MateriaDAO();
    }
    
    @Override
    public void iniciarMenu() {
        do {
            System.out.println("******* MENÚ *******");
            System.out.println(" 1. Lista materias.");
            System.out.println(" 2. Agregar materia.");
            System.out.println(" 3. Actualizar materia.");
            System.out.println(" 4. Eliminar materia.");
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
        System.out.println("LISTA DE MATERIAS...");
        System.out.println("Código:\t\tNombre:");
        for (Materia m : dao.leerMaterias()) {
            System.out.println(m.getCod() + "\t\t" + m.getNombre());
        }
    }

    public void agregar() {
        String nombre;
        System.out.print("Ingrese código: ");
        int cod = sc.nextInt();
        sc.nextLine();
        
        System.out.print("Ingrese nombre: ");
        nombre = sc.nextLine();
        dao.crearMateria(new Materia(cod, nombre));
        while(nombre.isEmpty()){
            System.out.print("El nombre no puede estar vacío. Intente nuevamente: ");
            nombre = sc.nextLine();
            dao.crearMateria(new Materia(cod, nombre));
        }
    }

    public void actualizar() {
        System.out.print("Ingrese código: ");
        int cod = sc.nextInt();
        sc.nextLine();
        System.out.print("Ingrese nuevo nombre: ");
        String nombre = sc.nextLine();
        dao.actualizarMateria(cod, new Materia(cod, nombre));
    }

    public void eliminar() {
        System.out.print("Ingrese código: ");
        int cod = sc.nextInt();
        sc.nextLine();
        dao.eliminarMateria(cod);
    }
}
