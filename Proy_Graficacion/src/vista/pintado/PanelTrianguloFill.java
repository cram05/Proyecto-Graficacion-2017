/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.pintado;
import modelo.runnables.RunnablePintar;
import algoritmos.DDA;
import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
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
 * @author gary
 */
public class PanelTrianguloFill extends JPanel {
    private PanelCuadricula panel2;
    private JTextField fieldOrigenX;
    private JTextField fieldOrigenY;
    private JTextField fieldLado;
    private JButton botonDibujar;
    private JButton botonPintar;
    private PanelColores paletaColores;
    
    public PanelTrianguloFill(PanelColores paletaColores) {
        this.paletaColores = paletaColores;
        setLayout(null);
        setSize(600, 450);

        JLabel titulo = new JLabel("TRIANGULO");
        titulo.setBounds(120, 30, 400, 50);  
        titulo.setFont(new Font("Tahoma", 1, 17));
        titulo.setForeground(Color.ORANGE);
        this.add(titulo);
        
        JLabel titulo1 = new JLabel("Algoritmo DDA");
        titulo1.setBounds(120,50,200,50); 
        titulo1.setFont(new Font("Arial", 3, 15));
        titulo1.setForeground(Color.WHITE);
        this.add(titulo1); 
        
        panel2 = new PanelCuadricula();
        panel2.setLocation(50, 90);
        panel2.setPaletaColores(paletaColores);//nuevo
        add(panel2);
        
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
        fieldLado = new JTextField("13");
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
    public ArrayList<Integer> ddaEquis(Point ini,Point fin){
        ArrayList<Integer> equis = new ArrayList<Integer>();
        
                int xIni=ini.x; int yIni=ini.y; int xFin=fin.x; int yFin=fin.y;
                double dx = xFin - xIni;
                double dy = yFin - yIni;           
                if(Math.abs(dx) > Math.abs(dy)){
                    double m = dy/dx;
                    double b = Math.round(yIni - m*xIni);
                    if(dx < 0)
                        dx = -1;
                    else
                        dx = 1;
                           equis.add(xIni);
                    while(xIni != xFin){
                        xIni += dx;
                        yIni =  (int) Math.round(m * xIni + b);
                        equis.add(xIni);
                    }
                }
                else{
                           equis.add(xIni);
                    if(dy != 0){
                        double m =(double) dx/dy;
                        double b = xIni - (m*yIni);
                        if(dy < 0)
                            dy = -1;
                        else
                            dy = 1;
                        while(yIni != yFin) { 
                            yIni += dy;
                            xIni =  (int) Math.round(m*yIni + b);
                              equis.add(xIni);
                        }
                    }
                } 
        return equis;
    }
    
    public ArrayList<Integer> ddaYe(Point ini,Point fin){
        ArrayList<Integer> ye = new ArrayList<Integer>();
        
                int xIni=ini.x; int yIni=ini.y; int xFin=fin.x; int yFin=fin.y;
                double dx = xFin - xIni;
                double dy = yFin - yIni;           
                if(Math.abs(dx) > Math.abs(dy)){
                    double m = dy/dx;
                    double b = Math.round(yIni - m*xIni);
                    if(dx < 0)
                        dx = -1;
                    else
                        dx = 1;
                           ye.add(yIni);
                    while(xIni != xFin){
                        xIni += dx;
                        yIni =  (int) Math.round(m * xIni + b);
                        ye.add(yIni);
                    }
                }
                else{
                           ye.add(yIni);
                    if(dy != 0){
                        double m =(double) dx/dy;
                        double b = xIni - (m*yIni);
                        if(dy < 0)
                            dy = -1;
                        else
                            dy = 1;
                        while(yIni != yFin) { 
                            yIni += dy;
                            xIni =  (int) Math.round(m*yIni + b);
                              ye.add(yIni);
                        }
                    }
                } 
        return ye;
    }
    
    private class AccionBotonDibujar1 implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent e) {
            Color color = paletaColores.getColorContorno();
            panel2.borrar();
            ArrayList<Integer> linea = new ArrayList<Integer>();
             ArrayList<Integer> linea2 = new ArrayList<Integer>();
            try {
                int lado = Integer.parseInt(fieldLado.getText());
                int px = Integer.parseInt(fieldOrigenX.getText());
                int py = Integer.parseInt(fieldOrigenY.getText());
                //============
                /*double lado1 = (double) lado; 
                double d = Math.round((lado1/2.0)+1);
                 int xx = (int) d + px;
                 int yy = lado+py; //(int) Math.round(Math.sqrt(Math.pow(lado, 2) - Math.pow(xx, 2)));
                 //System.out.println("x: "+xx + " y: "+yy);
                 //System.out.println("pot: "+Math.pow(2, 4));*/
                //============
                
                    String modo = "normal";
                    DDA dda = new DDA(panel2);
                    linea = ddaEquis(new Point(px,py),new Point(px+lado-1,py));
                    linea2 = ddaYe(new Point(px,py),new Point(px,py+lado-1));
                    double lado1 = lado*1.0; 
                    double d = Math.round((lado1/2.0)-1);
                    int aux = (int)d;
                     int xx = 0;
                     int yy = 0;
                     
                     for(int i=0;i<linea.size();i++){
                        if(i==aux){
                          xx = linea.get(i);
                              System.out.println("esto es x:"+xx);
                        }else {}
                           
                      }
                     int solo = linea2.size()-2;
                     for(int j=0;j<linea2.size();j++){
                        if(j==solo){
                          yy = linea2.get(j);
                              System.out.println("estoes y:"+yy);
                        }else {}
                         
                      }
                    Thread hilo1 = new Thread (new AnimacionLinea(dda,new Point(px,py),new Point(px+lado-1,py), modo, color));
                    Thread hilo2 = new Thread (new AnimacionLinea(dda,new Point(px,py),new Point(xx,yy), modo, color));
                    Thread hilo3 = new Thread (new AnimacionLinea(dda,new Point(xx,yy),new Point(px+lado-1,py), modo, color));
                    hilo1.start();
                    hilo2.start();
                    hilo3.start();
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
            /*Color color = paletaColores.getColorFondo();
            Thread hilo4 = new Thread (new RunnablePintar(panel2, color, tx+18, ty+5));
            hilo4.start();*/
        }
    }
}


