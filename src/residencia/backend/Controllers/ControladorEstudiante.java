package residencia.backend.Controllers;

import residencia.backend.Models.Estudiante;
import residencia.frontend.EntradaConsola;
import residencia.frontend.Interfaces.Entrada;
import residencia.frontend.Interfaces.Mensajes;
import residencia.frontend.SalidaConsola;

public class ControladorEstudiante {

    public final EstudianteDAO dao;
    private final Entrada entrada;
    private final Mensajes mensajes;

    public ControladorEstudiante() {
        dao = new EstudianteDAO();
        entrada = new EntradaConsola();
        mensajes = new SalidaConsola();
    }
    
    public void listar() {
        mensajes.imprimir("LISTA DE ESTUDIANTES...");
        mensajes.imprimir("DNI:\t\tNombre:\t\tEdad:");
        for (Estudiante e : dao.leerEstudiantes()) {
            mensajes.imprimir(e.getDni() + "\t\t" + e.getNombre() + "\t\t" + e.getApellido());
        }
    }

    public void agregar() {
        int cod = dao.ultimo().getCod();
        mensajes.imprimir("Ingrese dni: ");
        int dni = entrada.entero();
        mensajes.imprimir("Ingrese nombre: ");
        String nombre = entrada.cadena();
        mensajes.imprimir("Ingrese edad: ");
        String apellido = entrada.cadena();
        dao.crearEstudiante(new Estudiante(cod, dni, nombre, apellido));
    }

    public void actualizar() {
        mensajes.imprimir("Ingrese el código del estudiante a actualizar: ");
        int cod = entrada.entero();
        mensajes.imprimir("Ingrese dni: ");
        int dni = entrada.entero();
        mensajes.imprimir("Ingrese nuevo nombre: ");
        String nombre = entrada.cadena();
        mensajes.imprimir("Ingrese apellido: ");
        String apellido = entrada.cadena();
        dao.actualizarEstudiante(dni, new Estudiante(cod, dni, nombre, apellido));
    }

    public void eliminar() {
        mensajes.imprimir("Ingrese el código del estudiante a eliminar: ");
        int cod = entrada.entero();
        dao.eliminarEstudiante(cod);
    }
}
