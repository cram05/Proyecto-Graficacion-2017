package vista;

import modelo.Pixel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;
import modelo.runnables.RunnablePintar;

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
        addMouseListener(new MouseListenerPintar(this));
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
    
    private class MouseListenerPintar implements MouseListener {
        PanelCuadricula panel;
        private MouseListenerPintar(PanelCuadricula aThis) {
            panel = aThis;
        }
        @Override
        public void mouseClicked(MouseEvent e) {
            int yc = convertir(e.getX()) - 1;//-1 x los indices de la matriz
            int xc = convertir(e.getY()) - 1;
            Color color = paletaColores.getColorFondo();
            //`pintamos la figura
            Thread hiloPintar = new Thread (new RunnablePintar(panel, color, xc, yc));
            hiloPintar.start();
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }
        @Override
        public void mouseReleased(MouseEvent e) {
        }
        @Override
        public void mouseEntered(MouseEvent e) {
        }
        @Override
        public void mouseExited(MouseEvent e) {
        }

        private int convertir(int x) {
            return x/11 + 1;
        }
    }
    private PanelColores paletaColores;
    public void setPaletaColores(PanelColores paletaColores) {
        this.paletaColores = paletaColores;
    }
}
