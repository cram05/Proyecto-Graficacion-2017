package algoritmos;

import java.awt.Color;
import modelo.Primitiva2DCirculo;
import java.util.logging.Level;
import java.util.logging.Logger;
import vista.PanelCuadricula;

public class CoordenadasPolares extends Primitiva2DCirculo{
    PanelCuadricula panel;
    
    public CoordenadasPolares(PanelCuadricula panel) {
        this.panel = panel;
    }
    
    @Override
    public void dibujarCirculo(int radio, String modo, Color color){
        boolean segmentado = modo.equals("Linea Segmentada");
        boolean grueso = modo.equals("Linea Gruesa");
        double anguloBeta = (segmentado) ? Math.toRadians(15) : Math.toRadians(9);
        int x = radio;
        int y = 0;
        while(x >= y){
            panel.pintar(x+12, y+12, color);
            panel.pintar(y+12, x+12, color);
            panel.pintar(-x+12, y+12, color);
            panel.pintar(-y+12, x+12, color);
            panel.pintar(-x+12, -y+12, color);
            panel.pintar(-y+12, -x+12, color);
            panel.pintar(x+12, -y+12, color);
            panel.pintar(y+12, -x+12, color);
            if(grueso){
                panel.pintar(x+13, y+12, color);
                panel.pintar(y+12, x+13, color);
                panel.pintar(-x+11, y+12, color);
                panel.pintar(-y+12, x+13, color);
                panel.pintar(-x+11, -y+12, color);
                panel.pintar(-y+12, -x+11, color);
                panel.pintar(x+13, -y+12, color);
                panel.pintar(y+12, -x+11, color);
            }
            try {
                Thread.sleep(450);
            } catch (InterruptedException ex) {
                Logger.getLogger(CoordenadasPolares.class.getName()).log(Level.SEVERE, null, ex);
            }
            x = (int) Math.round(x*Math.cos(anguloBeta) - y*Math.sin(anguloBeta));
            y = (int) Math.round(y*Math.cos(anguloBeta) + x*Math.sin(anguloBeta));
        }
        System.out.println("coordenadas polares termino!!!");
    }
}
