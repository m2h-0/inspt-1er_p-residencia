package residencia.frontend;

import residencia.frontend.Interfaces.Mensajes;

public class SalidaConsola implements Mensajes {

    @Override
    public void imprimir(String str) {
        System.out.println(str);
    }
}
