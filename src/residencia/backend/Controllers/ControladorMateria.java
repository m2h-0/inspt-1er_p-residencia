package residencia.backend.Controllers;

import residencia.backend.Models.Materia;
import residencia.backend.Interfaces.Almacenable;
import residencia.frontend.EntradaConsola;
import residencia.frontend.Interfaces.Entrada;
import residencia.frontend.Interfaces.Mensajes;
import residencia.frontend.SalidaConsola;

public class ControladorMateria {

    public final MateriaDAO dao;
    private final Entrada entrada;
    private Mensajes mensajes;

    public ControladorMateria() {
        dao = new MateriaDAO();
        entrada = new EntradaConsola();
        mensajes = new SalidaConsola();
    }
    
    public void listar() {
        mensajes.imprimir("LISTA DE MATERIAS...");
        mensajes.imprimir("Código:\t\tNombre:");
        for (Almacenable m : dao.listar()) {
            mensajes.imprimir(m.getCod() + "\t\t" + ((Materia) m).getNombre());
        }
    }

    public void agregar() {
        String nombre;
        mensajes.imprimir("Ingrese código: ");
        int cod = entrada.entero();
        entrada.cadena();
        
        mensajes.imprimir("Ingrese nombre: ");
        nombre = entrada.cadena();
        dao.crearMateria(new Materia(cod, nombre));
        while(nombre.isEmpty()){
            mensajes.imprimir("El nombre no puede estar vacío. Intente nuevamente: ");
            nombre = entrada.cadena();
            dao.crearMateria(new Materia(cod, nombre));
        }
    }

    public void actualizar() {
        mensajes.imprimir("Ingrese código: ");
        int cod = entrada.entero();
        mensajes.imprimir("Ingrese nuevo nombre: ");
        String nombre = entrada.cadena();
        dao.actualizarMateria(cod, new Materia(cod, nombre));
    }

    public void eliminar() {
        mensajes.imprimir("Ingrese código: ");
        int cod = entrada.entero();
        dao.eliminarMateria(cod);
    }
}
