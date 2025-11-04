package residencia.frontend;

import java.util.Scanner;
import residencia.frontend.Interfaces.Entrada;

public class EntradaConsola implements Entrada {
    private final Scanner sc;

    public EntradaConsola() {
        this.sc = new Scanner(System.in);
    }

    @Override
    public int entero() {
        int dato = sc.nextInt();
        
        sc.nextLine();
        return dato;
    }

    @Override
    public String cadena() {
        return sc.nextLine();
    }

    @Override
    public float flotante() {
        float dato = sc.nextFloat();
        
        sc.nextLine();
        return dato;
    }
}
