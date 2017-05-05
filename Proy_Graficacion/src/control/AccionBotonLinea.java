package control;

import algoritmos.BresenhamLinea;
import algoritmos.DDA;
import algoritmos.EcuacionRecta;
import modelo.Primitiva2DLinea;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.AnimacionCuadroLinea;
import vista.VentanaLinea;

/**
 *
 * @author tutoriales
 */
public class AccionBotonLinea implements ActionListener {
    private VentanaLinea vl;
    
    public AccionBotonLinea(VentanaLinea v) {
        vl = v;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        vl.panel1.borrar();
        vl.panel2.borrar();
        int x1 = Integer.parseInt(vl.campoX1.getText());
        int y1 = Integer.parseInt(vl.campoY1.getText());
        int x2 = Integer.parseInt(vl.campoX2.getText());
        int y2 = Integer.parseInt(vl.campoY2.getText());
        if(intervalo(x1, y1, x2, y2)){
            String modo = "normal";
            if(vl.radio2.isSelected()){
                modo = "Linea Gruesa";
            }else{
                if(vl.radio3.isSelected())
                    modo = "Linea Segmentada";
            }
            
            String select1 = (String) vl.lista1.getSelectedItem();
            String select2 = (String) vl.lista2.getSelectedItem();
            
            Primitiva2DLinea alg1 = null;
            Primitiva2DLinea alg2 = null;
            switch (select1){
                case "Linea Bresenham": alg1 = new BresenhamLinea(vl.panel1); break;
                case "Linea DDA" :      alg1 = new DDA(vl.panel1); break;
                case "Linea Ecuacion" : alg1 = new EcuacionRecta(vl.panel1); break;
            }
            switch (select2){
                case "Linea Bresenham": alg2 = new BresenhamLinea(vl.panel2); break;
                case "Linea DDA" :      alg2 = new DDA(vl.panel2); break;
                case "Linea Ecuacion" : alg2 = new EcuacionRecta(vl.panel2); break;
            }
            Thread hilo1 = new Thread (new AnimacionCuadroLinea(alg1, new Point(x1, y1), new Point(x2, y2), modo));
            hilo1.start();

            Thread hilo2 = new Thread (new AnimacionCuadroLinea(alg2, new Point(x1, y1), new Point(x2, y2), modo));
            hilo2.start();
        }
    }

    private boolean intervalo(int x1, int y1, int x2, int y2) {
        return x1>=0 && x1<25 && y1>=0 && y1<25 && 
               x2>=0 && x2<25 && y2>=0 && y2<25;
    }
    
}
