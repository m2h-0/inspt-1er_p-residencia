package residencia.backend.Controllers;

import residencia.backend.Models.Materia;
import java.util.Scanner;
import residencia.backend.Interfaces.Almacenable;
import residencia.frontend.Interfaces.Mensajes;
import residencia.frontend.SalidaConsola;

public class ControladorMateria {

    public final MateriaDAO dao;
    private int op;
    private final Scanner sc = new Scanner(System.in);
    private Mensajes mensajes;

    public ControladorMateria() {
        dao = new MateriaDAO();
        mensajes = new SalidaConsola();
    }
    
    public void listar() {
        System.out.println("LISTA DE MATERIAS...");
        System.out.println("Código:\t\tNombre:");
        for (Almacenable m : dao.listar()) {
            System.out.println(m.getCod() + "\t\t" + ((Materia) m).getNombre());
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
