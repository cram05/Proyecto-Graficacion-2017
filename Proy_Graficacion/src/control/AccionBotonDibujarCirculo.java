package control;

import algoritmos.BresenhamCirculo;
import algoritmos.CoordenadasPolares;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JRadioButton;
import modelo.runnables.AnimacionCircunferencia;
import vista.figurasTrazos.VentanaCirculo;

/**
 *
 * @author tutoriales
 */
public class AccionBotonDibujarCirculo implements ActionListener {
    VentanaCirculo vc;
    public AccionBotonDibujarCirculo(VentanaCirculo vc) {
        this.vc = vc;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        vc.panel1.borrar();
        vc.panel2.borrar();
        int r = Integer.parseInt(vc.fieldRadio.getText());
        if(r <= 11){
            String modo = "normal";
            if(vc.radioBtnGruesa.isSelected()){
                modo = "Linea Gruesa";
            }else{
                if(vc.radioBtnSegmentada.isSelected())
                    modo = "Linea Segmentada";
            }
            BresenhamCirculo bres = new BresenhamCirculo(vc.getPanel1());
            Thread hilo1 = new Thread (new AnimacionCircunferencia(bres, r, modo, Color.ORANGE));
            hilo1.start();

            CoordenadasPolares corPol = new CoordenadasPolares(vc.getPanel2());
            Thread hilo2 = new Thread (new AnimacionCircunferencia(corPol, r, modo, Color.ORANGE));
            hilo2.start();
        }
    }
    
}
