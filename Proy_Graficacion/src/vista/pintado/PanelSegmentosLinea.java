/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.pintado;

import algoritmos.BresenhamLinea;
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
import modelo.runnables.AnimacionLinea;
import vista.PanelColores;
import vista.PanelCuadricula;


/**
 *
 * @author HP
 */
public class PanelSegmentosLinea extends JPanel {
    private PanelCuadricula panel;
    private JTextField campoX1;
    private JTextField campoY1;
    private JTextField campoX2;
    private JTextField campoY2;
    private JButton botonDibujar;
    private JButton botonBorrarTodo;
    private PanelColores paletaColores;
    
    private JButton borrar; 
    
    public PanelSegmentosLinea(PanelColores paletaColores) {
        this.paletaColores = paletaColores;
        setLayout(null);
        setSize(600, 450);
        
        JLabel titulo = new JLabel("SEGMENTOS DE LINEAS");
        titulo.setBounds(120, 30, 400, 50);  
        titulo.setFont(new Font("Tahoma", 1, 17));
        titulo.setForeground(Color.ORANGE);
        this.add(titulo);
        
        JLabel titulo1 = new JLabel("Algoritmo de Bresenham");
        titulo1.setBounds(140,50,200,50); 
        titulo1.setFont(new Font("Arial", 3, 15));
        titulo1.setForeground(Color.WHITE);
        this.add(titulo1); 
        
        panel = new PanelCuadricula();
        panel.setLocation(50, 90);
        panel.setPaletaColores(paletaColores);//nuevo
        this.add(panel);
        
        JLabel label1 = new JLabel("X1");
        JLabel label2 = new JLabel("Y1");
        JLabel label3 = new JLabel("X2");
        JLabel label4 = new JLabel("Y2");
        
        label1.setBounds(65,380,25,25);this.add(label1);
        label2.setBounds(105,380,25,25); this.add(label2);
        label3.setBounds(175,380,25,25); this.add(label3);
        label4.setBounds(210,380,25,25); this.add(label4);
        
        label1.setForeground(Color.WHITE);
        label2.setForeground(Color.WHITE);
        label3.setForeground(Color.WHITE);
        label4.setForeground(Color.WHITE);
        
        this.add(label1);
        this.add(label2);
        this.add(label3);
        this.add(label4);
        
        campoX1 = new JTextField("0");
        campoY1 = new JTextField("0");
        campoX2 = new JTextField("15");
        campoY2 = new JTextField("10");
        
        
        campoX1.setBounds(65,400,25,25);this.add(campoX1);
        campoY1.setBounds(100,400,25,25);this.add(campoY1); 
        campoX2.setBounds(170,400,25,25);this.add(campoX2);
        campoY2.setBounds(205,400,25,25);this.add(campoY2);
        

        colocarCoordenadas();
        
        botonDibujar = new JButton("Dibujar");
        botonDibujar.setBounds(240, 400, 80, 25);
        botonDibujar.setForeground(Color.white);//color de la letra
        botonDibujar.setBackground(Color.GREEN);//color boton
        botonDibujar.addActionListener(new PanelSegmentosLinea.AccionBotonDibujar());
        botonDibujar.setFocusable(true);
        add(botonDibujar);
        
      
        
        borrar = new JButton("Borrar");
         borrar.setBounds(340, 400, 80, 25);
        borrar.setForeground(Color.black);//color de la letra
        borrar.setBackground(Color.GREEN);//color boton
        borrar.addActionListener(new PanelSegmentosLinea.ActionBotonBorrar());
        borrar.setFocusable(true);
        borrar.setEnabled(false);
        add(borrar);
        
        botonBorrarTodo = new JButton("Borrar Todo");
        botonBorrarTodo.setBounds(430, 400, 80, 25);
        botonBorrarTodo.setForeground(Color.black);//color de la letra
        botonBorrarTodo.setBackground(Color.RED);//color boton
        botonBorrarTodo.addActionListener(new PanelSegmentosLinea.ActionBotonBorrar());
        botonBorrarTodo.setFocusable(true);
        add(botonBorrarTodo);
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

    public JButton getBotonBorrarTodo() {
        return botonBorrarTodo;
    }
    
    private class AccionBotonDibujar implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent e) {
                Color color = paletaColores.getColorContorno();
                try {
                    int x1 = Integer.parseInt(campoX1.getText());
                    int y1 = Integer.parseInt(campoY1.getText());
                    int x2 = Integer.parseInt(campoX2.getText());
                    int y2 = Integer.parseInt(campoY2.getText());
                    Point p1 = new Point(x1,y1);
                    Point p2 = new Point(x2,y2);
                    if(x1<=24 && y1<=24 && x2<=24 && y2<=24){
                    String modo = "normal";
                    BresenhamLinea brese = new BresenhamLinea(panel);
                    Thread hilo1 = new Thread (new AnimacionLinea(brese, p1, p2,modo,color));
                        hilo1.start();
                        borrar.setEnabled(true);
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "ingrese numero");
                }
            
        }
    }
    
    private class ActionBotonBorrar implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            Object boton = e.getSource();
            if(boton == getBotonBorrarTodo()){
                panel.borrar();
            }else{
                try {
                    int x1 = Integer.parseInt(campoX1.getText());
                    int y1 = Integer.parseInt(campoY1.getText());
                    int x2 = Integer.parseInt(campoX2.getText());
                    int y2 = Integer.parseInt(campoY2.getText());
                    Point p1 = new Point(x1,y1);
                    Point p2 = new Point(x2,y2);
                    if(x1<=24 && y1<=24 && x2<=24 && y2<=24){
                    String modo = "normal";
                    BresenhamLinea brese = new BresenhamLinea(panel);
                    Thread hilo1 = new Thread (new AnimacionLinea(brese, p1, p2,modo,Color.white));
                        hilo1.start();
                        borrar.setEnabled(false);  
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error");
                }
            }
        }
    
    }
    

   
}
