package residencia.backend.Models;

import residencia.backend.Interfaces.Relacion;

public class Asignacion implements Relacion {
    private final int codEnc;
    private final int codEst;

    public Asignacion(int idEnc, int idEst) {
        this.codEnc = idEnc;
        this.codEst = idEst;
    }

    public int getCodEnc() { return codEnc; }
    public int getCodEst() { return codEst; }

    public static Asignacion fromString(String linea) {
        String[] partes = linea.split(",");
        return new Asignacion(Integer.parseInt(partes[0]), Integer.parseInt(partes[1]));
    }

    @Override
    public int getCod() { return codEnc; }
    @Override
    public int getCod2(){ return codEst; }
    @Override
    public String toString() {
        return codEnc + "," + codEst;
    }
}
