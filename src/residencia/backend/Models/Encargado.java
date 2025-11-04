package residencia.backend.Models;

public class Encargado extends Persona {
    private String turno;

    public Encargado(int cod, int dni, String nombre, String apellido, String turno) {
        super(cod, dni, nombre, apellido);
        this.turno = turno;
    }

    public String getTurno() { return turno; }

    public static Encargado fromString(String linea) {
        String[] partes = linea.split(",");
        return new Encargado(Integer.parseInt(partes[0]), Integer.parseInt(partes[1]), partes[2], partes[3], partes[4]);
    }
    
    @Override
    public String toString() {
        return super.toString() + "," + turno;
    }
}
