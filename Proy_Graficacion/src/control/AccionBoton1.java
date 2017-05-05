package control;

import algoritmos.BresenhamCirculo;
import algoritmos.CoordenadasPolares;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JRadioButton;
import modelo.AnimacionCuadro;
import vista.VentanaCirculo;

/**
 *
 * @author tutoriales
 */
public class AccionBoton1 implements ActionListener {
    VentanaCirculo vc;
    public AccionBoton1(VentanaCirculo vc) {
        this.vc = vc;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        vc.panel1.borrar();
        vc.panel2.borrar();
        int r = Integer.parseInt(vc.textR.getText());
        if(r <= 11){
            String modo = "normal";
            if(vc.radio2.isSelected()){
                modo = "Linea Gruesa";
            }else{
                if(vc.radio3.isSelected())
                    modo = "Linea Segmentada";
            }
            BresenhamCirculo bres = new BresenhamCirculo(vc.getPanel1());
            Thread hilo1 = new Thread (new AnimacionCuadro(bres, r, modo));
            hilo1.start();

            CoordenadasPolares corPol = new CoordenadasPolares(vc.getPanel2());
            Thread hilo2 = new Thread (new AnimacionCuadro(corPol, r, modo));
            hilo2.start();
        }
    }
    
}
