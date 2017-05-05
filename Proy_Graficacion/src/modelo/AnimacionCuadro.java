package modelo;

import algoritmos.BresenhamCirculo;
import algoritmos.EcuacionRecta;
import java.awt.Point;

/**
 *
 * @author Carlos Ramos
 */
public class AnimacionCuadro implements Runnable{
    private Primitiva2DCirculo primitiva;
    private int radio;
    private String modo;
    public AnimacionCuadro(Primitiva2DCirculo bres, int r, String modo) {
        this.primitiva = bres;
        radio = r;
        this.modo = modo;
    }

    @Override
    public void run() {
        primitiva.circulo(radio, modo);
    }
    
}
