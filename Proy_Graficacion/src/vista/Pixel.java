
package vista;

import java.awt.Point;

/**
 *
 * @author Administrator
 */
public class Pixel extends Point{
    private boolean power;

    public Pixel(int x, int y) {
        super(x, y);
        power = false;
    }
    public void encender(){
        power = true;
    }
    boolean estaEncendido() {
        return power;
    }
}
