package algoritmos;

import modelo.Primitiva2DCirculo;
import java.awt.Point;
import java.util.logging.Level;
import java.util.logging.Logger;
import vista.PanelCuadricula;

/**
 *
 * @author Carlos Ramos
 */
public class BresenhamCirculo extends Primitiva2DCirculo{
    private PanelCuadricula panel;
    
    public BresenhamCirculo(PanelCuadricula panel) {
        this.panel = panel;
    }
    
    @Override
    public void circulo(int radio, String modo){
        //////////
        boolean segmentado = modo.equals("Linea Segmentada");
        boolean grueso = modo.equals("Linea Gruesa");
        ///////////////
        int x = radio;
        int y = 0;
        int e = 0;
        int inc = 1;//incremento
        if(segmentado)
            inc = 2;
        while(x >= y){
            panel.pintar(x+12, y+12);
            panel.pintar(y+12, x+12);
            panel.pintar(-x+12, y+12);
            panel.pintar(-y+12, x+12);
            panel.pintar(-x+12, -y+12);
            panel.pintar(-y+12, -x+12);
            panel.pintar(x+12, -y+12);
            panel.pintar(y+12, -x+12);
            if(grueso){
                panel.pintar(x+13, y+12);
                panel.pintar(y+12, x+13);
                panel.pintar(-x+11, y+12);
                panel.pintar(-y+12, x+13);
                panel.pintar(-x+11, -y+12);
                panel.pintar(-y+12, -x+11);
                panel.pintar(x+13, -y+12);
                panel.pintar(y+12, -x+11);
            }
            try {
                Thread.sleep(450);
            } catch (InterruptedException ex) {
                Logger.getLogger(BresenhamCirculo.class.getName()).log(Level.SEVERE, null, ex);
            }
            e = e + 2*y + 1;
            y = y + inc;
            if(2*e > (2*x - 1)){
                x = x - 1;
                e = e - 2*x +1;
            }
        }
        System.out.println("exitoso BresenhamCirculo");
    }
    
}
