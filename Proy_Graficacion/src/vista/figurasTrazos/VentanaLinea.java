package vista.figurasTrazos;

import control.AccionBotonDibujarLinea;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import vista.PanelCuadricula;

/**
 *
 * @author Administrator
 */
public class VentanaLinea extends JPanel{
    public PanelCuadricula panel1;
    public PanelCuadricula panel2;
    public JTextField campoX1;
    public JTextField campoY1;
    public JTextField campoX2;
    public JTextField campoY2;
    public JComboBox lista1;
    public JComboBox lista2;
    public JRadioButton radio1;
    public JRadioButton radio2;
    public JRadioButton radio3;
    
    public VentanaLinea() {
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setSize(800, 500);
        //setLocationRelativeTo(null);
        
        panel1 = new PanelCuadricula();
        panel1.setLocation(50, 90);
        add(panel1);
        
        panel2 = new PanelCuadricula();
        panel2.setLocation(420, 90);
        add(panel2);
        //----------------------------------------------------------------------
        campoX1 = new JTextField("0");
        campoY1 = new JTextField("0");
        campoX2 = new JTextField("15");
        campoY2 = new JTextField("10");
        
        Font fuente = new Font("TimesRoman", 3, 9);
        Font fuente1 = new Font("Tahoma", 3, 20);
        
        JLabel titulo = new JLabel("PROYECTO DE GRAFICACIÓN - LINEA");
        titulo.setBounds(200, 0, 400, 50);  
        titulo.setFont(new Font("Tahoma", 3, 17));
        titulo.setForeground(Color.ORANGE);
        this.add(titulo);
        
        String[] lineas = { "Linea Bresenham", "Linea DDA", "Linea Ecuacion"};
        lista1 = new JComboBox(lineas);
        lista1.setBounds(120,65,130,20); this.add(lista1);
        
        lista2 = new JComboBox(lineas);
        lista2.setBounds(500,65,130,20);this.add(lista2);
        
        //numeros para primer cuadro----------------------------------------
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
        //numeros para segundo cuadro-----------------------------------------
        int c=355;
        for (int i = 0; i < 25; i++) {
             JLabel x1 = new JLabel(""+i+"");  
             x1.setForeground(Color.WHITE);
             x1.setBounds(407,c,15,10); this.add(x1); x1.setFont(fuente); 
             c -= 11;
        }
        int d=420;
         for (int i = 0; i < 25; i++) {
             JLabel x1 = new JLabel(""+i+"");  
             x1.setForeground(Color.WHITE);
             x1.setBounds(d,367,15,10); this.add(x1); x1.setFont(fuente); 
             d += 11;
        }
        //----------------------------------------   
        campoX1.setBounds(65,400,25,25);;this.add(campoX1);
        campoY1.setBounds(100,400,25,25);this.add(campoY1); 
        campoX2.setBounds(170,400,25,25);this.add(campoX2);
        campoY2.setBounds(205,400,25,25);this.add(campoY2);
        
        JButton boton1 = new JButton("Dibujar");
        boton1.setBounds(240, 400, 80, 25);
        boton1.setForeground(Color.white);//color de la letra
        boton1.setBackground(Color.GREEN);//color boton
        boton1.addActionListener(new AccionBotonDibujarLinea(this));
        boton1.setFocusable(true);
        this.add(boton1);
        
        JLabel label1 = new JLabel("X1");label1.setForeground(Color.WHITE);
        JLabel label2 = new JLabel("Y1");label2.setForeground(Color.WHITE);
        JLabel label3 = new JLabel("X2");label3.setForeground(Color.WHITE);
        JLabel label4 = new JLabel("Y2");label4.setForeground(Color.WHITE);
        label1.setBounds(70,380,25,25);this.add(label1);
        label2.setBounds(105,380,25,25); this.add(label2);
        label3.setBounds(175,380,25,25); this.add(label3);
        label4.setBounds(210,380,25,25); this.add(label4);
     //--------------------------------------------------------------------------   
        radio1=new JRadioButton("Linea Normal");
        radio1.setForeground(Color.WHITE);
        radio1.setContentAreaFilled(false);
        radio1.setBounds(330,400,120,30);
        radio1.setSelected(true);
        this.add(radio1);
        radio2=new JRadioButton("Linea Gruesa");
        radio2.setForeground(Color.WHITE);
        radio2.setContentAreaFilled(false);
        radio2.setBounds(455,400,150,30);
        this.add(radio2);
        radio3=new JRadioButton("Linea Segmentada");
        radio3.setForeground(Color.WHITE);
        radio3.setContentAreaFilled(false);
        radio3.setBounds(580,400,150,30);
        this.add(radio3);
        
        ButtonGroup grupo = new ButtonGroup();
        grupo.add(radio1);
        grupo.add(radio2);
        grupo.add(radio3);
        
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, getWidth(), getHeight());
        panel.setBackground(new Color(80, 80, 80));
        add(panel);
        setVisible(true);
    }
    
}
