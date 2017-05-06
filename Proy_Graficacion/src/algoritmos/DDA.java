package algoritmos;

import java.awt.Color;
import java.awt.Point;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Primitiva2DLinea;
import modelo.Primitiva2DLinea;
import vista.PanelCuadricula;

/**
 *thread tiempo igualar tiempo
 * @author HP
 */
public class DDA extends Primitiva2DLinea{
    PanelCuadricula panel;
    Color color;
    public DDA(PanelCuadricula panel){
        this.panel = panel;
    }
    @Override
    public void dibujarLinea(Point ini, Point fin, String modo, Color color){
        this.color = color;
        if(modo.equals("Linea Gruesa")){
            lineaGruesa(ini, fin);
        }
        else{
            if(modo.equals("Linea Segmentada")){
                lineaSegmentada(ini, fin);
            }
            else{
                int xIni=ini.x; int yIni=ini.y; int xFin=fin.x; int yFin=fin.y;
                double dx = xFin - xIni;
                double dy = yFin - yIni;           
                if(Math.abs(dx) > Math.abs(dy)){
                    double m = dy/dx;
                    double b = Math.round(yIni - m*xIni);
                    if(dx < 0)
                        dx = -1;
                    else
                        dx = 1;
                        panel.pintar(xIni, yIni, color);
                        try {
                            Thread.sleep(250);
                        }catch (InterruptedException ex) {
                        Logger.getLogger(PanelCuadricula.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    while(xIni != xFin){
                        xIni += dx;
                        yIni =  (int) Math.round(m * xIni + b);
                        panel.pintar(xIni, yIni, color);
                        try {
                            Thread.sleep(250);
                        }catch (InterruptedException ex) {
                            Logger.getLogger(PanelCuadricula.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
                else{
                    panel.pintar(xIni, yIni, color);
                    try {
                        Thread.sleep(250);
                    }catch (InterruptedException ex) {
                        Logger.getLogger(PanelCuadricula.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    if(dy != 0){
                        double m =(double) dx/dy;
                        double b = xIni - (m*yIni);
                        if(dy < 0)
                            dy = -1;
                        else
                            dy = 1;
                        while(yIni != yFin) { 
                            yIni += dy;
                            xIni =  (int) Math.round(m*yIni + b);
                            panel.pintar(xIni, yIni, color);
                            try {
                                Thread.sleep(250);
                            }catch (InterruptedException ex) {
                                Logger.getLogger(PanelCuadricula.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }
                }
            }
        }  
        System.out.println("DDA exitoso");
    }

   
    public void lineaGruesa(Point ini, Point fin) {
        double dx = fin.x - ini.x;
        double dy = fin.y - ini.y;           
        if(Math.abs(dx) > Math.abs(dy))
        {
            double m = dy/dx;
            double b = Math.round(ini.y - m*ini.x);
            if(dx < 0)
            {
                dx = -1;
            }else{
                dx = 1;
            }
            panel.pintar(ini.x, ini.y, color);
            panel.pintar(ini.x, ini.y+1, color);
            try {
                Thread.sleep(250);
            }catch (InterruptedException ex) {
                Logger.getLogger(PanelCuadricula.class.getName()).log(Level.SEVERE, null, ex);
            }
            while(ini.x != fin.x)
            {
                ini.x += dx;
                ini.y =  (int) Math.round(m * ini.x + b);
                panel.pintar(ini.x, ini.y, color);
                try {
                panel.pintar(ini.x, ini.y+1, color);
                    Thread.sleep(250);
                }catch (InterruptedException ex) {
                    Logger.getLogger(PanelCuadricula.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        else
        {
            panel.pintar(ini.x, ini.y, color);
            panel.pintar(ini.x, ini.y+1, color);
            try {
                Thread.sleep(250);
            }catch (InterruptedException ex) {
                Logger.getLogger(PanelCuadricula.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(dy != 0)
            {
                 
                double m =(double) dx/dy;
                double b = ini.x - (m*ini.y);
                if(dy < 0)
                    dy = -1;
                else
                    dy = 1;
                while(ini.y != fin.y)
                { 
                    ini.y += dy;
                    ini.x =  (int) Math.round(m*ini.y + b);
                    panel.pintar(ini.x, ini.y, color);
                    panel.pintar(ini.x, ini.y+1, color);
                    try {
                        Thread.sleep(250);
                    }catch (InterruptedException ex) {
                        Logger.getLogger(PanelCuadricula.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
    }
   
    public void lineaSegmentada(Point ini, Point fin) {
        double dx = fin.x - ini.x;
        double dy = fin.y - ini.y; 
        boolean aux = false;          
        if(Math.abs(dx) > Math.abs(dy))
        {
            double m = dy/dx;
            double b = Math.round(ini.y - m*ini.x);
            if(dx < 0)
            {
                dx = -1;
            }else{
                dx = 1;
            }
            panel.pintar(ini.x, ini.y, color);
            try {
                Thread.sleep(250);
            }catch (InterruptedException ex) {
                Logger.getLogger(PanelCuadricula.class.getName()).log(Level.SEVERE, null, ex);
            }
            while(ini.x != fin.x)
            {
                
                ini.x += dx;
                ini.y =  (int) Math.round(m * ini.x + b);
                if(aux == true){
                    panel.pintar(ini.x, ini.y, color);
                    try {
                        Thread.sleep(250);
                    }catch (InterruptedException ex) {
                        Logger.getLogger(PanelCuadricula.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    aux = false;
                }
                else
                {
                    aux = true;
                }
            
            }
        }
        else
        {
            panel.pintar(ini.x, ini.y, color);
            try {
                Thread.sleep(250);
            }catch (InterruptedException ex) {
                Logger.getLogger(PanelCuadricula.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(dy != 0)
            {
                 
                double m =(double) dx/dy;
                double b = ini.x - (m* ini.y);
                if(dy < 0)
                    dy = -1;
                else
                    dy = 1;
                while(ini.y != fin.y)
                { 
                    ini.y += dy;
                    ini.x =  (int) Math.round(m*ini.y + b);
                    if(aux == true){
                    panel.pintar(ini.x, ini.y, color);
                    try {
                        Thread.sleep(250);
                    }catch (InterruptedException ex) {
                        Logger.getLogger(PanelCuadricula.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    aux = false;
                    }
                    else
                    {
                        aux = true;
                    }
                }
            }
        }
    } 
}
   
    

