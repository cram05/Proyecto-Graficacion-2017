package algoritmos;

import java.awt.Color;
import java.awt.Point;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Primitiva2DLinea;
import vista.PanelCuadricula;

public class BresenhamLinea extends Primitiva2DLinea{
    
    PanelCuadricula panel;
            
    public BresenhamLinea(PanelCuadricula panel) {
        this.panel = panel;
    }
    
    @Override
    public void dibujarLinea(Point ini, Point fin, String modo, Color color){
        int x0=ini.x; int y0=ini.y; int x1=fin.x; int y1=fin.y;
        if(modo.equals("Linea Gruesa")){
            lineaGruesa(x0, y0, x1, y1, color);
        }
        else{
            if(modo.equals("Linea Segmentada")){
                lineaSegmentada(x0, y0, x1, y1, color);
            }
            else{

                int dx = Math.abs(x1 - x0);
                int dy = Math.abs(y1 - y0);

                int sx = x0 < x1 ? 1 : -1; 
                int sy = y0 < y1 ? 1 : -1; 

                int err = dx-dy;
                int e2;
                while (true) 
                {
                    panel.pintar(x0, y0, color);
                    try {
                    Thread.sleep(550);
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
    }
    
    public void lineaSegmentada(int x0, int y0, int x1, int y1, Color color) 
    {                    
        int dx = Math.abs(x1 - x0);
        int dy = Math.abs(y1 - y0);
        boolean aux = true;
 
        int sx = x0 < x1 ? 1 : -1; 
        int sy = y0 < y1 ? 1 : -1; 
 
        int err = dx-dy;
        int e2;
 
        while (true) 
        {
            if(aux == true){
            panel.pintar(x0, y0, color);
            try {
            Thread.sleep(550);
            } catch (InterruptedException ex) {
                Logger.getLogger(PanelCuadricula.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            if (x0 == x1 && y0 == y1) 
                break;
 
            e2 = 2 * err;
            if (e2 > -dy) 
            {
                err = err - dy;
                x0 = x0 + sx;
            }
 
            if (e2 < dx) 
            {
                err = err + dx;
                y0 = y0 + sy;
            }
            aux = false;
           }
           else{ 
            if (x0 == x1 && y0 == y1) 
                break;
 
            e2 = 2 * err;
            if (e2 > -dy) 
            {
                err = err - dy;
                x0 = x0 + sx;
            }
 
            if (e2 < dx) 
            {
                err = err + dx;
                y0 = y0 + sy;
            }
            aux = true;
            }
        }   		  
    } 

     public void lineaGruesa(int x0, int y0, int x1, int y1, Color color) 
    {                   
        int dx = Math.abs(x1 - x0);
        int dy = Math.abs(y1 - y0);
 
        int sx = x0 < x1 ? 1 : -1; 
        int sy = y0 < y1 ? 1 : -1; 
 
        int err = dx-dy;
        int e2;
    if((x0-x1)!=0){
        double m = (y0 - y1)/(x0 - x1);
        
      if(m<=0){
        while (true) 
        {
            panel.pintar(x0, y0, color);
            panel.pintar(x0, y0+1, color);
            try {
            Thread.sleep(550);
            } catch (InterruptedException ex) {
                Logger.getLogger(PanelCuadricula.class.getName()).log(Level.SEVERE, null, ex);
            }
 
            if (x0 == x1 && y0 == y1) 
                break;
 
            e2 = 2 * err;
            if (e2 > -dy) 
            {
                err = err - dy;
                x0 = x0 + sx;
            }
 
            if (e2 < dx) 
            {
                err = err + dx;
                y0 = y0 + sy;
            }
        }   
    }
    
      else if(m > 0){
         while (true) 
        {
            panel.pintar(x0, y0, color);
            panel.pintar(x0+1, y0, color);
            try {
            Thread.sleep(550);
            } catch (InterruptedException ex) {
                Logger.getLogger(PanelCuadricula.class.getName()).log(Level.SEVERE, null, ex);
            }
 
            if (x0 == x1 && y0 == y1) 
                break;
 
            e2 = 2 * err;
            if (e2 > -dy) 
            {
                err = err - dy;
                x0 = x0 + sx;
            }
 
            if (e2 < dx) 
            {
                err = err + dx;
                y0 = y0 + sy;
            }
        }   
      }
      
  }else{
         while (true) 
        {
            panel.pintar(x0, y0, color);
            panel.pintar(x0+1, y0, color);
            try {
            Thread.sleep(550);
            } catch (InterruptedException ex) {
                Logger.getLogger(PanelCuadricula.class.getName()).log(Level.SEVERE, null, ex);
            }
 
            if (x0 == x1 && y0 == y1) 
                break;
 
            e2 = 2 * err;
            if (e2 > -dy) 
            {
                err = err - dy;
                x0 = x0 + sx;
            }
 
            if (e2 < dx) 
            {
                err = err + dx;
                y0 = y0 + sy;
            }
        }   
        
    }
 }
}
