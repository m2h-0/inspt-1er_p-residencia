package residencia.backend.Models;

public class Estudiante extends Persona {

    public Estudiante(int cod, int dni, String nombre, String apellido) {
        super(cod, dni, nombre, apellido);
    }

    public static Estudiante fromString(String linea) {
        String[] partes = linea.split(",");
        return new Estudiante(Integer.parseInt(partes[0]), Integer.parseInt(partes[1]), partes[2], partes[3]);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
