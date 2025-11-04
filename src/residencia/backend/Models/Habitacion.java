package residencia.backend.Models;

import residencia.backend.Interfaces.Almacenable;

public class Habitacion implements Almacenable {
    private final int cod;
    private final int piso;
    private boolean ocupado;

    public Habitacion(int cod, int piso) {
        this.cod = cod;
        this.piso = piso;
        this.ocupado = false;
    }
    public Habitacion(int cod, int piso, boolean ocupado) {
        this.cod = cod;
        this.piso = piso;
        this.ocupado = ocupado;
    }
    
    public static Habitacion fromString(String linea) {
        String[] partes = linea.split(",");
        return new Habitacion(Integer.parseInt(partes[0]), Integer.parseInt(partes[1]), Boolean.parseBoolean(partes[2]));
    }
    
    public int getPiso() { return piso; }
    public boolean isOcupado() { return ocupado; }
    public String getEstado() { return ocupado ? "ocupado" : "libre"; }
    public void toggleOcupado(boolean ocupado) { this.ocupado = !ocupado; }

    @Override
    public int getCod() { return cod; }
    @Override
    public String toString() {
        return cod + "," + piso + "," + ocupado;
    }
}
