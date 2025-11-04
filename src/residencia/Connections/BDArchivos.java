package residencia.Connections;

import residencia.backend.Interfaces.Conector;
import java.io.File;
import java.io.IOException;

public class BDArchivos implements Conector {
    private final String nomArc;

    public BDArchivos(String archivo) {
        this.nomArc = archivo;
    }
    

    public String getNomArc() { return nomArc; }

    @Override
    public void inicializarBD() {
        try {
            File archivo = new File(nomArc);
            if (!archivo.exists()) {
                if (archivo.createNewFile()) {
                    System.out.println("Archivo creado...");
                }
            } else {
                System.out.println("Archivo existente...");
            }
        } catch (IOException ex) {
            System.out.println("ERROR: " + ex.getMessage());
        }
    }
}
