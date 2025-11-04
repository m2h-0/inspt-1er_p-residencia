package instituto.backend.Controllers;

import instituto.Connections.BDArchivos;
import instituto.backend.Interfaces.Almacenable;
import instituto.backend.Models.Materia;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MateriaDAO extends ArchivoDAO {
    private static final String NOM_ARCHIVO = "materias.txt";
    private final BDArchivos bda;

    public MateriaDAO() {
        super(NOM_ARCHIVO);
        bda = getBda();
    }

//    public void crearMateria(Materia m) {
//        if (!existe(m.getCod())){
//            try (BufferedWriter bw = new BufferedWriter(new FileWriter(bda.getNomArc(), true))) {
//                bw.write(m.toString());
//                bw.newLine();
//            } catch (IOException ex) {
//                System.out.println("ERROR: " + ex.getMessage());
//            }finally{
//                System.out.println("Estudiante agregado...");
//            }
//        }else
//            System.out.println("ERROR: Estudiante ya registrado");
//    }
//
//    public boolean existe(int cod) {
//        boolean encontrado = false;
//        List<Materia> lista = leerMaterias();
//        for (Materia m : lista) {
//            if (m.getCod() == cod) {
//                encontrado = true;
//            }
//        }
//        return encontrado;
//    }

    public List<Almacenable> listar() {
        List<Almacenable> lista = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(bda.getNomArc()))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                lista.add(Materia.fromString(linea));
            }
        } catch (IOException ex) {
            System.out.println("ERROR: " + ex.getMessage());
        }
        return lista;
    }

//    public void actualizarMateria(int cod, Materia nuevo) {
//        List<Materia> lista = leerMaterias();
//        try (BufferedWriter bw = new BufferedWriter(new FileWriter(bda.getNomArc()))) {
//            for (Materia m : lista) {
//                if (m.getCod() == cod) {
//                    bw.write(nuevo.toString());
//                } else {
//                    bw.write(m.toString());
//                }
//                bw.newLine();
//            }
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }
//    }

//    public void eliminarMateria(int cod) {
//        List<Materia> lista = leerMaterias();
//        try (BufferedWriter bw = new BufferedWriter(new FileWriter(bda.getNomArc()))) {
//            for (Materia m : lista) {
//                if (m.getCod() != cod) {
//                    bw.write(m.toString());
//                    bw.newLine();
//                }
//            }
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }
//    }

    private Materia ultimo(){
        Materia ult = null;
        try (BufferedReader br = new BufferedReader(new FileReader(bda.getNomArc()))) {
            String linea;
            while ((linea = br.readLine()) != null) {
//                lista.add(Materia.fromString(linea));
            }
            ult = Materia.fromString(linea);
        } catch (IOException ex) {
            System.out.println("ERROR: " + ex.getMessage());
        }
        return ult;
    }
}
