package modelo;

import algoritmos.BresenhamCirculo;
import java.awt.Color;

/**
 *
 * @author Carlos Ramos
 */
public class AnimacionCircunferencia implements Runnable{
    private Primitiva2DCirculo primitiva;
    private int radio;
    private String modo;
    private Color color;
    
    public AnimacionCircunferencia(Primitiva2DCirculo bres, int r, String modo, Color color) {
        this.primitiva = bres;
        radio = r;
        this.modo = modo;
        this.color = color;
    }

    @Override
    public void run() {
        primitiva.dibujarCirculo(radio, modo, color);
    }
    
}
