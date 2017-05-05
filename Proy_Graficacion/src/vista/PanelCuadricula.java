package vista;

import modelo.Pixel;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author Administrator
 */
public class PanelCuadricula extends JPanel{
    private Color color1 = Color.WHITE;
    private Color color2 = Color.ORANGE;
    private Pixel[][] cuadricula;

    public PanelCuadricula() {
        inicializarCuadricula();
        setBackground(Color.BLACK);
        setSize(cuadricula.length*11, cuadricula.length*11);
    }
    
    @Override
    public void paint(Graphics g)
    {
        super.paint(g);
        g.setColor(color1);
        for (int i = 0; i < cuadricula.length; i++) {
            for (int j = 0; j < cuadricula.length; j++) {
                int x = cuadricula[i][j].x;
                int y = cuadricula[i][j].y;
                if(cuadricula[i][j].estaEncendido()){
                    g.setColor(color2);
                }else{
                    g.setColor(color1);
                }
                g.fillRect(x, y, 10, 10);
            }
        }
    }

    private void inicializarCuadricula() {
        cuadricula = new Pixel[25][25];
        int x = 0;
        int y = 0;
        for (int i = 0; i < cuadricula.length; i++) {
            for (int j = 0; j < cuadricula.length; j++) {
                cuadricula [i][j] = new Pixel(x,y);
                x += 11;
            }
            y += 11;
            x = 0;
        }
    }
    
    public void pintar(int x,int y){
        int t = cuadricula.length;
        cuadricula[t-y-1][x].encender();
        repaint();
    }

    public void borrar() {
        inicializarCuadricula();
        repaint();
    }
}
