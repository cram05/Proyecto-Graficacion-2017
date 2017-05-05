package modelo;

import modelo.Primitiva2DLinea;
import java.awt.Point;
import java.util.logging.Level;
import java.util.logging.Logger;
import vista.PanelCuadricula;

public class BresenhamLinea extends Primitiva2DLinea{
    
    PanelCuadricula panel;
            
    public BresenhamLinea(PanelCuadricula panel) {
        this.panel = panel;
    }
    
    @Override
    public void linea(Point ini, Point fin, String modo){   
        int x0=ini.x; int y0=ini.y; int x1=fin.x; int y1=fin.y;
        
        int dx = Math.abs(x1 - x0);
        int dy = Math.abs(y1 - y0);
 
        int sx = x0 < x1 ? 1 : -1; 
        int sy = y0 < y1 ? 1 : -1; 
 
        int err = dx-dy;
        int e2;
        while (true) 
        {
            panel.pintar(x0, y0);
            try {
            Thread.sleep(250);
            } catch (InterruptedException ex) {
                Logger.getLogger(PanelCuadricula.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (x0 == x1 && y0 == y1) 
                break;
            e2 = 2 * err;
            if (e2 > -dy){
                err = err - dy;
                x0 = x0 + sx;
            }
            if (e2 < dx){
                err = err + dx;
                y0 = y0 + sy;
            }
        }   
    }
}