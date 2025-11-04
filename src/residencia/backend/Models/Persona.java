package residencia.backend.Models;

import residencia.backend.Interfaces.Almacenable;

public class Persona implements Almacenable {

    private int cod;
    private final int dni;
    private final String nombre;
    protected final String apellido;

    public Persona(int cod, int dni, String nombre, String apellido) {
        this.cod = cod;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public int getCod() { return cod; }
    public int getDni() { return dni; }
    public String getNombre() { return nombre; }
    public String getApellido() { return apellido; }

    public static Persona fromString(String linea) {
        String[] partes = linea.split(",");
        return new Persona(
                Integer.parseInt(partes[0]), 
                Integer.parseInt(partes[1]), 
                partes[2], 
                partes[3]
        );
    }

    @Override
    public String toString() {
        return cod + "," + dni + "," + nombre + "," + apellido;
    }
}
