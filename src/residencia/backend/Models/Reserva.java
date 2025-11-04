package residencia.backend.Models;

import residencia.backend.Interfaces.Relacion;

public class Reserva implements Relacion {
    private final int codHab;
    private final int codAlu;

    public Reserva(int codHab, int idAlu) {
        this.codHab = codHab;
        this.codAlu = idAlu;
    }

    public int getCodHab() { return codHab; }
    public int getIdAlu() { return codAlu; }

    public static Reserva fromString(String linea) {
        String[] partes = linea.split(",");
        return new Reserva(Integer.parseInt(partes[0]), Integer.parseInt(partes[1]));
    }

    @Override
    public int getCod() { return codHab; }
    @Override
    public int getCod2(){ return codAlu; }
    @Override
    public String toString() {
        return codHab + "," + codAlu;
    }
}
