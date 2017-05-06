
package modelo;

import java.awt.Color;
import java.awt.Point;

/**
 *
 * @author Administrator
 */
public class Pixel extends Point{
    private Color color;
    
    public Pixel(int x, int y) {
        super(x, y);
        color = Color.WHITE;//sin color
    }
    
    public boolean estaPintado() {
        return !color.equals(Color.WHITE);
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
    
}
