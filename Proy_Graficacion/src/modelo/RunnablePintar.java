package modelo;

import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Pintador;
import vista.PanelCuadricula;

/**
 *
 * @author Carlos Ramos
 */
public class RunnablePintar implements Runnable {
    private PanelCuadricula panel;
    private int xc;
    private int yc;
    private Color colorBg;
    
    public RunnablePintar(PanelCuadricula panel1, Color color, int xc, int yc) {
        panel = panel1;
        this.xc = xc;
        this.yc = yc;
        colorBg = color;
    }

    @Override
    public void run() {
        Pintador pintor = new Pintador(panel, colorBg);
        try {
            pintor.pintarFigura(xc, yc);
        } catch (InterruptedException ex) {
            Logger.getLogger(RunnablePintar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
