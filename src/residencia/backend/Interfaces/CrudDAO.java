package instituto.backend.Interfaces;

import java.util.List;

public interface CrudDAO<T> {
    public void guardar(T dato);
    public T buscar(int cod);
    public List<T> listar();
    public void actualizar(int cod, T nuevo);
    public void eliminar(int cod);
}
