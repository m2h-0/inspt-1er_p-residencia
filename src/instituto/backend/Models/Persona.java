package instituto.backend.Models;

import instituto.backend.Interfaces.Almacenable;

public class Persona implements Almacenable {

    private int cod;
    private final int dni;
    private final String nombre;
    private final int edad;

    public Persona(int cod, int dni, String nombre, int edad) {
        this.dni = dni;
        this.nombre = nombre;
        this.edad = edad;
    }

    public int getDni() { return dni; }
    public String getNombre() { return nombre; }
    public int getEdad() { return edad; }

    public static Persona fromString(String linea) {
        String[] partes = linea.split(",");
        return new Persona(
                Integer.parseInt(partes[0]), 
                Integer.parseInt(partes[1]), 
                partes[2], 
                Integer.parseInt(partes[3])
        );
    }

    @Override
    public int getCod() {
        return cod;
    }
 
    @Override
    public String toString() {
        return dni + "," + nombre + "," + edad;
    }
}
