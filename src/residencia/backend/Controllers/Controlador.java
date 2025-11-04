package residencia.backend.Controllers;

import residencia.frontend.Interfaces.Mensajes;
import residencia.frontend.Menus;
import residencia.frontend.SalidaConsola;

public class Controlador {
    private Menus menus;
    private ControladorEstudiante conEst;
    private ControladorMateria conMat;
    private Mensajes mensajes;// interfaz para salida de mensajes
    
    public Controlador() {
        menus = new Menus();
        conEst = new ControladorEstudiante();
        conMat = new ControladorMateria();
        mensajes = new SalidaConsola();// puede cambiarse SalidaConsola por otra clase de impresión tipo Mensajes
    }

    public void iniciar() {
        int op;

        do {
            op = menus.menuPpal();
            switch (op) {
                case 1 -> estudiantes();
                case 2 -> materias();
                case 0 -> mensajes.imprimir("Saliendo del sistema.");
                default -> mensajes.imprimir("Opción inválida, intente nuevamente.");
            }
        } while (op != 0);
    }

    public void estudiantes() {
        int op;

        do {
            op = menus.menuEstudiante();
            switch (op) {
                case 1 -> conEst.listar();
                case 2 -> conEst.agregar();
                case 3 -> conEst.actualizar();
                case 4 -> conEst.eliminar();
            }
        } while (op != 0);
    }

    public void materias() {
        int op;

        do {
            op = menus.menuMateria();
            switch (op) {
                case 1 -> conMat.listar();
                case 2 -> conMat.agregar();
                case 3 -> conMat.actualizar();
                case 4 -> conMat.eliminar();
            }
        } while (op != 0);
    }
}
