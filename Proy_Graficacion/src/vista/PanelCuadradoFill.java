/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;
import modelo.RunnablePintar;
import algoritmos.DDA;
import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import modelo.AnimacionLinea;
/**
 *
 * @author gary
 */
public class PanelCuadradoFill extends JPanel {
    private PanelCuadricula panel1;
    private JTextField fieldOrigenX;
    private JTextField fieldOrigenY;
    private JTextField fieldLado;
    private JButton botonDibujar;
    private JButton botonPintar;
    private PanelColores paletaColores;
    
    public PanelCuadradoFill(PanelColores paletaColores) {
        this.paletaColores = paletaColores;
        setLayout(null);
        setSize(600, 450);

        JLabel titulo = new JLabel("CUADRADO");
        titulo.setBounds(120, 30, 400, 50);  
        titulo.setFont(new Font("Tahoma", 1, 17));
        titulo.setForeground(Color.ORANGE);
        this.add(titulo);
        
        JLabel titulo1 = new JLabel("Algoritmo DDA");
        titulo1.setBounds(120,50,200,50); 
        titulo1.setFont(new Font("Arial", 3, 15));
        titulo1.setForeground(Color.WHITE);
        this.add(titulo1); 
        
        panel1 = new PanelCuadricula();
        panel1.setLocation(50, 90);
        add(panel1);
        
        JLabel label1 = new JLabel("Origen");
        label1.setBounds(90,380,70,25);
        label1.setForeground(Color.WHITE);
        this.add(label1);
        JLabel label2 = new JLabel("Lado");
        label2.setBounds(170,380,70,25);
        label2.setForeground(Color.WHITE);
        this.add(label2);
        JLabel label3 = new JLabel("X:");
        label3.setBounds(55,400,25,25);
        label3.setForeground(Color.WHITE);
        this.add(label3);
        JLabel label4 = new JLabel("Y:");
        label4.setBounds(105,400,25,25);
        label4.setForeground(Color.WHITE);
        this.add(label4);
        
        fieldOrigenX = new JTextField("2");
        fieldOrigenX.setBounds(70,400,25,25);
        this.add(fieldOrigenX);
        fieldOrigenY = new JTextField("2");
        fieldOrigenY.setBounds(120,400,25,25);
        this.add(fieldOrigenY);
        fieldLado = new JTextField("9");
        fieldLado.setBounds(171,400,25,25);
        this.add(fieldLado);
        
        colocarCoordenadas();
        
        botonDibujar = new JButton("Dibujar");
        botonDibujar.setBounds(230, 400, 80, 25);
        botonDibujar.setForeground(Color.white);//color de la letra
        botonDibujar.setBackground(Color.GREEN);//color boton
        botonDibujar.addActionListener(new AccionBotonDibujar1());
        botonDibujar.setFocusable(true);
        add(botonDibujar);
        
        botonPintar = new JButton("Pintar");
        botonPintar.setBounds(340, 400, 80, 25);
        botonPintar.setForeground(Color.white);//color de la letra
        botonPintar.setBackground(Color.GREEN);//color boton
        botonPintar.addActionListener(new AccionBotonPintar1());
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
        int a=355;
        for (int i = 0; i < 25; i++) {
             JLabel x1 = new JLabel(""+i+""); 
             x1.setForeground(Color.WHITE);
             x1.setBounds(37,a,15,10); this.add(x1); x1.setFont(fuente); 
             a -= 11;
        }
         int b=50;
        for (int i = 0; i < 25; i++) {
             JLabel x1 = new JLabel(""+i+"");  
             x1.setForeground(Color.WHITE);
             x1.setBounds(b,367,15,10); this.add(x1); x1.setFont(fuente); 
             b += 11;
        }
    }

    private class AccionBotonDibujar1 implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent e) {
            Color color = paletaColores.getColorContorno();
            panel1.borrar();
            try {
                //int radio = Integer.parseInt(fieldRadio.getText());
                int lado = Integer.parseInt(fieldLado.getText());
                int px = Integer.parseInt(fieldOrigenX.getText());
                int py = Integer.parseInt(fieldOrigenY.getText());
               // if(radio <= 11){
                    String modo = "normal";
                    //BresenhamCirculo bres = new BresenhamCirculo(panel);
                    DDA dda = new DDA(panel1);
                    Thread hilo1 = new Thread (new AnimacionLinea(dda,new Point(px,py),new Point(px+lado-1,py), modo, color));
                    Thread hilo2 = new Thread (new AnimacionLinea(dda,new Point(px,py),new Point(px,py+lado-1), modo, color));
                    Thread hilo3 = new Thread (new AnimacionLinea(dda,new Point(px+lado-1,py+lado-1),new Point(px,py+lado-1), modo, color));
                    Thread hilo4 = new Thread (new AnimacionLinea(dda,new Point(px+lado-1,py+lado-1),new Point(px+lado-1,py), modo, color));
                    hilo1.start();
                    hilo2.start();
                    hilo3.start();
                    hilo4.start();
                    botonPintar.setEnabled(true);
                
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "ingrese numero");
            }
        }
    }
    
    private class AccionBotonPintar1 implements ActionListener {
       int tx = Integer.parseInt(fieldOrigenX.getText());
       int ty = Integer.parseInt(fieldOrigenY.getText());
        @Override
        public void actionPerformed(ActionEvent e) {
            Color color = paletaColores.getColorFondo();
            Thread hilo5 = new Thread (new RunnablePintar(panel1, color, tx+1, ty+1));
            hilo5.start();
        }
    }
}

    

