package instituto.backend.Controllers;

import instituto.Connections.BDArchivos;
import instituto.backend.Models.Estudiante;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EstudianteDAO extends ArchivoDAO {
    private static final String NOM_ARCHIVO = "estudiantes.txt";
    private final BDArchivos bda;

    public EstudianteDAO() {
        super(NOM_ARCHIVO);
        bda = getBda();
    }

    public void crearEstudiante(Estudiante e) {
        if (!existe(e.getDni())){
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(bda.getNomArc(), true))) {
                bw.write(e.toString());
                bw.newLine();
            } catch (IOException ex) {
                System.out.println("ERROR: " + ex.getMessage());
            }finally{
                System.out.println("Estudiante agregado...");
            }
        }else
            System.out.println("ERROR: Estudiante ya registrado");
    }

    public boolean existe(int dni) {
        boolean encontrado = false;
        List<Estudiante> lista = leerEstudiantes();
        for (Estudiante e : lista) {
            if (e.getDni() == dni) {
                encontrado = true;
            }
        }
        return encontrado;
    }

    public List<Estudiante> leerEstudiantes() {
        List<Estudiante> lista = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(bda.getNomArc()))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                lista.add(Estudiante.fromString(linea));
            }
        } catch (IOException ex) {
            System.out.println("ERROR: " + ex.getMessage());
        }
        return lista;
    }

    public void actualizarEstudiante(int dni, Estudiante nuevo) {
        List<Estudiante> lista = leerEstudiantes();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(bda.getNomArc()))) {
            for (Estudiante e : lista) {
                if (e.getDni() == dni) {
                    bw.write(nuevo.toString());
                } else {
                    bw.write(e.toString());
                }
                bw.newLine();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void eliminarEstudiante(int dni) {
        List<Estudiante> lista = leerEstudiantes();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(bda.getNomArc()))) {
            for (Estudiante e : lista) {
                if (e.getDni() != dni) {
                    bw.write(e.toString());
                    bw.newLine();
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
