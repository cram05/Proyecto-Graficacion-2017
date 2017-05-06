package vista;

import modelo.RunnablePintar;
import algoritmos.BresenhamCirculo;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import modelo.AnimacionCircunferencia;

/**
 *
 * @author Carlos Ramos
 */
public class PanelCircunferenciaFill extends JPanel{
    private PanelCuadricula panel;
    private JTextField fieldRadio;
    private JButton botonDibujar;
    private JButton botonPintar;
    private PanelColores paletaColores;
    
    public PanelCircunferenciaFill(PanelColores paletaColores) {
        this.paletaColores = paletaColores;
        setLayout(null);
        setSize(600, 450);

        JLabel titulo = new JLabel("CIRCUNFERENCIA");
        titulo.setBounds(120, 30, 400, 50);  
        titulo.setFont(new Font("Tahoma", 1, 17));
        titulo.setForeground(Color.ORANGE);
        this.add(titulo);
        
        JLabel titulo1 = new JLabel("Algoritmo de Bresenham");
        titulo1.setBounds(100,50,200,50); 
        titulo1.setFont(new Font("Arial", 3, 15));
        titulo1.setForeground(Color.WHITE);
        this.add(titulo1); 
        
        panel = new PanelCuadricula();
        panel.setLocation(50, 90);
        add(panel);
        
        JLabel label1 = new JLabel("Radio");
        label1.setBounds(70,380,70,25);
        label1.setForeground(Color.WHITE);
        this.add(label1);
        
        fieldRadio = new JTextField("5");
        fieldRadio.setBounds(70,400,50,25);
        this.add(fieldRadio);
        
        colocarCoordenadas();
        
        botonDibujar = new JButton("Dibujar");
        botonDibujar.setBounds(140, 400, 80, 25);
        botonDibujar.setForeground(Color.white);//color de la letra
        botonDibujar.setBackground(Color.GREEN);//color boton
        botonDibujar.addActionListener(new AccionBotonDibujar());
        botonDibujar.setFocusable(true);
        add(botonDibujar);
        
        botonPintar = new JButton("Pintar");
        botonPintar.setBounds(240, 400, 80, 25);
        botonPintar.setForeground(Color.white);//color de la letra
        botonPintar.setBackground(Color.GREEN);//color boton
        botonPintar.addActionListener(new AccionBotonPintar());
        botonPintar.setFocusable(true);
        botonPintar.setEnabled(false);
        add(botonPintar);
        
        //fondo===========================================
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, getWidth(), getHeight());
        panel.setBackground(new Color(80, 80, 80));
        add(panel);
        setVisible(true);
    }

    private void colocarCoordenadas() {
        Font fuente = new Font("TimesRoman", 3, 8);
        JLabel x = new JLabel("0"); 
        x.setBounds(182,360,20,20); 
        x.setFont(fuente); x.setForeground(Color.WHITE);
        this.add(x);
        int a=193;
        for (int i = 1; i < 13; i++) {
             JLabel x1 = new JLabel(""+i+"");  
             x1.setForeground(Color.WHITE);
             x1.setBounds(a,365,15,10); this.add(x1); x1.setFont(fuente); 
             a += 11;
        }
        int b=171;
        for (int i = 1; i < 13; i++) {
             JLabel x1 = new JLabel("-"+i+"");  
             x1.setForeground(Color.WHITE);
             x1.setBounds(b,365,15,10); this.add(x1); x1.setFont(fuente); 
             b -= 11;
        }
        //----------------------------------------------------------------------
        int c=211;
        for (int i = 1; i < 13; i++) {
             JLabel y = new JLabel(""+i+"");  
             y.setForeground(Color.WHITE);
             y.setBounds(41,c,15,10); this.add(y); y.setFont(fuente);
             c -= 11;
        }
        int d=234;
        for (int i = 1; i < 13; i++) {
             JLabel y = new JLabel("-"+i+"");  
             y.setForeground(Color.WHITE);
             y.setBounds(38,d,15,10); this.add(y); y.setFont(fuente); 
             d += 11;
        }
        JLabel y = new JLabel("0");  y.setBounds(41,217,20,20); y.setFont(fuente);this.add(y);
        y.setForeground(Color.WHITE);
    }

    private class AccionBotonDibujar implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent e) {
            Color color = paletaColores.getColorContorno();
            panel.borrar();
            try {
                int radio = Integer.parseInt(fieldRadio.getText());
                if(radio <= 11){
                    String modo = "normal";
                    BresenhamCirculo bres = new BresenhamCirculo(panel);
                    Thread hilo1 = new Thread (new AnimacionCircunferencia(bres, radio, modo, color));
                    hilo1.start();
                    botonPintar.setEnabled(true);
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "ingrese numero");
            }
        }
    }
    
    private class AccionBotonPintar implements ActionListener {
        int xc = 12;//centro
        int yc = 12;//centro
        @Override
        public void actionPerformed(ActionEvent e) {
            Color color = paletaColores.getColorFondo();
            //`pintamos la figura
            Thread hilo1 = new Thread (new RunnablePintar(panel, color, xc, yc));
            hilo1.start();
        }
    }
}
