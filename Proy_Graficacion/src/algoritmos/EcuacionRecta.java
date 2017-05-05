
package algoritmos;
import modelo.Primitiva2DLinea;
import java.awt.Point;
import java.util.logging.Level;
import java.util.logging.Logger;
import vista.PanelCuadricula;

/**
 *
 * @author Carlos Ramos
 */
public class EcuacionRecta extends Primitiva2DLinea{
    private PanelCuadricula panel;

    public EcuacionRecta(PanelCuadricula panel) {
        this.panel = panel;
    }
    
    @Override
    public void linea(Point ini, Point fin, String modo){
        //////////
        boolean segmentado = modo.equals("Linea Segmentada");
        boolean grueso = modo.equals("Linea Gruesa");
        //////////
        float dy = fin.y - ini.y;
        float dx = fin.x - ini.x;
        float m = dy/dx;
        float b = ini.y - m * ini.x;
        int x = ini.x;
        int y = ini.y;
        int dxAbs = Math.abs((int)dx);
        int dyAbs = Math.abs((int)dy);
        int inc = 1; //incremento que se asigna a 'x' o 'y'
        if(segmentado){
            inc = 2;
            dxAbs = dxAbs/2;
            dyAbs = dyAbs/2;
        }
        if(dx == 0){ //linea en el eje 'y'
            if(ini.y > fin.y){
                inc *= -1;
            }
            for (int i = 0; i <= dyAbs; i++) {
                panel.pintar(x, y);
                if(grueso)
                    panel.pintar(x+1, y);
                try {
                    Thread.sleep(250);
                } catch (InterruptedException ex) {
                    Logger.getLogger(EcuacionRecta.class.getName()).log(Level.SEVERE, null, ex);
                }
                y += inc;
            }
        }else{
            if(m == 0){//eje 'x'
                if(ini.x > fin.x){
                    inc *= -1;
                }
                for (int i = 0; i <= dxAbs; i++) {
                    panel.pintar(x, y);
                    if(grueso)
                        panel.pintar(x, y+1);
                    try {
                        Thread.sleep(250);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(EcuacionRecta.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    x += inc;
                }
            }else{
                //primer y tercer cuadrante 
                if(ini.x > fin.x){
                    inc *= -1;
                }
                if(m > 0 && m <= 1){//primer octante
                    for(int i = 0; i <= dxAbs; i++){
                        y = Math.round(m * x + b);
                        panel.pintar(x, y);
                        if(grueso)
                            panel.pintar(x, y+1);
                        try {
                            Thread.sleep(250);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(EcuacionRecta.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        x = x + inc;
                    }
                }else{
                    if(m > 1){//2do octante
                        for (int i = 0; i <= dyAbs; i++) {
                            x = Math.round((y - b)/m);
                            panel.pintar(x, y);
                            if(grueso)
                                panel.pintar(x, y+1);
                            try {
                                Thread.sleep(250);
                            } catch (InterruptedException ex) {
                                Logger.getLogger(EcuacionRecta.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            y = y + inc;
                        }
                    } else{
                //segundo y cuarto cuadrante --------------------------------
                        if(ini.x < fin.x){
                            inc *= -1;
                        }
                        if(m <= -1){//cuarto octante
                            for (int i = 0; i <= dyAbs; i++) {
                                x = Math.round((y - b)/m);
                                panel.pintar(x, y);
                                if(grueso)
                                    panel.pintar(x, y+1);
                                try {
                                    Thread.sleep(250);
                                } catch (InterruptedException ex) {
                                    Logger.getLogger(EcuacionRecta.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                y = y + inc;
                            }
                        }else{//m<0 && m > -1
                            for(int i = 0; i <= dxAbs; i++){
                                y = Math.round(m * x + b);
                                panel.pintar(x, y);
                                if(grueso)
                                    panel.pintar(x+1, y);
                                try {
                                    Thread.sleep(250);
                                } catch (InterruptedException ex) {
                                    Logger.getLogger(EcuacionRecta.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                x = x - inc;
                            }
                        }
                    }
                }
            }
        }
        System.out.println("Ec. Recta exitoso");
                
    }
    
}
