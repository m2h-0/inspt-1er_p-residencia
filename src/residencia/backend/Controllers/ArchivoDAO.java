package residencia.backend.Controllers;

import java.io.BufferedReader;
import residencia.Connections.BDArchivos;
import residencia.backend.Interfaces.Almacenable;
import residencia.backend.Interfaces.CrudDAO;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import residencia.backend.Interfaces.Relacion;

public class ArchivoDAO implements CrudDAO<Almacenable> {
    private final String nomArc;
    private BDArchivos bda;
    private final Function<String, Almacenable> fromString;

    // recibe función fromString para listar()
    // fromString recibe String y devuelve Almacenable
    public ArchivoDAO(String nomArc, Function<String, Almacenable> fromString) {
        this.nomArc = nomArc;
        this.bda = new BDArchivos(nomArc);
        this.fromString = fromString;
    }

    @Override
    public void guardar(Almacenable dato) {
        String strDato;
        if (!existe(dato.getCod())){
            strDato = dato.toString();
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(bda.getNomArc(), true))) {
                bw.write(strDato);
                bw.newLine();
            } catch (IOException ex) {
                System.out.println("ERROR: " + ex.getMessage());
            }finally{
                System.out.println("Dato agregado correctamente: " + strDato);
            }
        }else
            System.out.println("Dato registrado anteriormente.");
    }

    @Override
    public Almacenable buscar(int cod) {
        Almacenable dato = null;
        List<Almacenable> lista = listar();
        for (Almacenable a : lista) {
            if (a.getCod() == cod) {
                dato = a;
            }
        }
        return dato;
    }
    public Relacion buscarRelacion(int cod1, int cod2) {
        Relacion r, dato = null;
        List<Almacenable> lista = listar();
        for (Almacenable a : lista) {
            r = (Relacion) a;
            if (r.getCod() == cod1 && r.getCod2() == cod2) {
                dato = r;
            }
        }
        return dato;
    }

    public boolean existe(int cod) {
        return buscar(cod) != null;
    }
    public boolean existeRelacion(int cod1, int cod2) {
        return buscarRelacion(cod1, cod2) != null;
    }

    // listar genérico, requiere recibir fromString por constructor
    // Alternativa: sobrescribir método en subclases
    @Override
    public List<Almacenable> listar() {
        List<Almacenable> lista = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(bda.getNomArc()))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                Almacenable a = fromString.apply(linea);// aplica función fromString <String, Almacenable>
                lista.add(a);
            }
        } catch (IOException ex) {
            System.out.println("ERROR: " + ex.getMessage());
        }
        return lista;
    }

    // Requiere de listar para volver a escribir el archivo completo
    @Override
    public void actualizar(int cod, Almacenable nuevo) {
        List<Almacenable> lista = listar();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(bda.getNomArc()))) {
            for (Almacenable a : lista) {
                if (a.getCod() == cod) {
                    bw.write(nuevo.toString());
                } else {
                    bw.write(a.toString());
                }
                bw.newLine();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void eliminar(int cod) {
        List<Almacenable> lista = listar();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(bda.getNomArc()))) {
            for (Almacenable a : lista) {
                if (a.getCod() != cod) {
                    bw.write(a.toString());
                    bw.newLine();
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    // Requiere conocer el tipo de Almacenable
//    private Almacenable ultimo(){
//        Almacenable ult = null;
//        try (BufferedReader br = new BufferedReader(new FileReader(bda.getNomArc()))) {
//            String linea;
//            while ((linea = br.readLine()) != null) {
////                lista.add(Materia.fromString(linea));
//            }
////            ult = Almacenable.fromString(linea);
//        } catch (IOException ex) {
//            System.out.println("ERROR: " + ex.getMessage());
//        }
//        return ult;
//    }

    public BDArchivos getBda() {
        return bda;
    }
}