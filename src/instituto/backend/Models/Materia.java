package instituto.backend.Models;

import instituto.backend.Interfaces.Almacenable;

public class Materia implements Almacenable {
    private final int cod;
    private final String nombre;

    public Materia(int cod, String nombre) {
        this.cod = cod;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public static Materia fromString(String linea) {
        String[] partes = linea.split(",");
        return new Materia(Integer.parseInt(partes[0]), partes[1]);
    }

    @Override
    public int getCod() {
        return cod;
    }

    @Override
    public String toString() {
        return cod + "," + nombre;
    }
}
