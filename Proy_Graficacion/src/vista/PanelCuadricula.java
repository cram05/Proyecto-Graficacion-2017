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
    private Pixel[][] cuadricula;
    private final int tamPixel = 10;

    public PanelCuadricula() {
        inicializarCuadricula();
        setBackground(Color.BLACK);
        setSize(cuadricula.length*(tamPixel+1), cuadricula.length*(tamPixel+1));//+1 para la separacion entre pixeles
    }
    
    @Override
    public void paint(Graphics g)
    {
        super.paint(g);
        for (int i = 0; i < cuadricula.length; i++) {
            for (int j = 0; j < cuadricula.length; j++) {
                int x = cuadricula[i][j].x;
                int y = cuadricula[i][j].y;
                Color miColor = cuadricula[i][j].getColor();
                g.setColor(miColor);
                g.fillRect(x, y, tamPixel, tamPixel);
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
                x += tamPixel+1; //+1 para la separacion entre pixeles
            }
            y += tamPixel+1;    //+1 para la separacion entre pixeles
            x = 0;
        }
    }
    
    public void borrar() {
        inicializarCuadricula();
        repaint();
    }

    public Pixel[][] getCuadricula() {
        return cuadricula;
    }

    public void pintar(int x, int y, Color color) {
        cuadricula[cuadricula.length-y-1][x].setColor(color);
        repaint();
    }
    
}
