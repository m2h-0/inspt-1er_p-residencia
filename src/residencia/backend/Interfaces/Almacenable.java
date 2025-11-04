package residencia.backend.Interfaces;

public interface Almacenable<T> {
    public int getCod();
    @Override
    public String toString();
    public T fromString(String str);
}
