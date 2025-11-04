package residencia.backend.Controllers;

import residencia.Connections.BDArchivos;
import residencia.backend.Interfaces.Almacenable;
import residencia.backend.Interfaces.CrudDAO;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ArchivoDAO implements CrudDAO<Almacenable> {
    private String nomArc;
    private BDArchivos bda;

    public ArchivoDAO(String nomArc) {
        this.nomArc = nomArc;
        this.bda = new BDArchivos(nomArc);
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

    public boolean existe(int cod) {
        return buscar(cod) != null;
    }

    // Sobrescrito por subclases
    @Override
    public List<Almacenable> listar() {
//        List<Almacenable> lista = new ArrayList<>();
//        try (BufferedReader br = new BufferedReader(new FileReader(bda.getNomArc()))) {
//            String linea;
//            while ((linea = br.readLine()) != null) {
//                lista.add(Almacenable.fromString(linea));
//            }
//        } catch (IOException ex) {
//            System.out.println("ERROR: " + ex.getMessage());
//        }
//        return lista;
        return null;
    }

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

    public BDArchivos getBda() {
        return bda;
    }
}