package modelo;

import java.awt.Color;
import vista.PanelCuadricula;

/**
 * Esta clase hara el pintado con el 
 * "Algoritmo de inundacion"
 * @author Carlos Ramos
 */
public class Pintador {
    private int ancho;
    private int alto;
    private PanelCuadricula panel;
    private Color colorBg;
    private Pixel[][] cuadricula;

    public Pintador(PanelCuadricula panel, Color colorBg) {
        this.panel = panel;
        ancho = panel.getCuadricula().length;
        alto = panel.getCuadricula().length;
        this.colorBg = colorBg;
        cuadricula = panel.getCuadricula();
    }
    
    public void pintarFigura(int x, int y) throws InterruptedException{
        if(posicionValida(x, y)){//si la pos esta dentro la figura
            if(!estaPintado(x, y)){
                //panel.pintar(x, y, colorBg);//no funciona de esta manera!!!
                cuadricula[x][y].setColor(colorBg);
                panel.repaint();
                //System.out.println("x: "+x+" y: "+y);
                Thread.sleep(100);
                pintarFigura(x-1, y);
                pintarFigura(x, y+1);
                pintarFigura(x+1, y);
                pintarFigura(x, y-1);
            }
        }
    }

    private boolean posicionValida(int x, int y) {
        return x >= 0 && x < alto && y >= 0 && y < ancho;
    }

    private boolean estaPintado(int x, int y) {
        return panel.getCuadricula()[x][y].estaPintado();
    }
    
}
