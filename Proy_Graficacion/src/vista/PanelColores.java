package vista;

import java.awt.Color;
import javax.swing.JColorChooser;

/**
 *
 * @author Carlos Ramos
 */
public class PanelColores extends javax.swing.JPanel {
    private Color colorFondo;
    private Color colorContorno;
    
    public PanelColores() {
        initComponents();
        colorFondo = Color.BLUE;
        colorContorno = Color.ORANGE;
        pintarPaneles();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        panelContorno = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        panelFondo = new javax.swing.JPanel();

        setBackground(new java.awt.Color(80, 80, 80));
        setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 2, true));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 204, 0));
        jLabel1.setText("Paleta de Colores");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        panelContorno.setBackground(java.awt.Color.orange);
        panelContorno.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panelContorno.setPreferredSize(new java.awt.Dimension(70, 70));
        panelContorno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelContornoMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelContornoLayout = new javax.swing.GroupLayout(panelContorno);
        panelContorno.setLayout(panelContornoLayout);
        panelContornoLayout.setHorizontalGroup(
            panelContornoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );
        panelContornoLayout.setVerticalGroup(
            panelContornoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Color 2");

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Color1");

        panelFondo.setBackground(new java.awt.Color(0, 51, 255));
        panelFondo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panelFondo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelFondoMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelFondoLayout = new javax.swing.GroupLayout(panelFondo);
        panelFondo.setLayout(panelFondoLayout);
        panelFondoLayout.setHorizontalGroup(
            panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );
        panelFondoLayout.setVerticalGroup(
            panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(panelContorno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(panelFondo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(panelFondo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(panelContorno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void panelFondoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelFondoMouseClicked
        colorFondo = JColorChooser.showDialog(this, "Seleccion color" , Color.BLUE); 
        if(colorFondo != null) 
            panelFondo.setBackground(colorFondo);        
    }//GEN-LAST:event_panelFondoMouseClicked

    private void panelContornoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelContornoMouseClicked
        colorContorno = JColorChooser.showDialog(this, "Seleccion color" , Color.ORANGE); 
        if(colorContorno != null) 
            panelContorno.setBackground(colorContorno);   
    }//GEN-LAST:event_panelContornoMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel panelContorno;
    private javax.swing.JPanel panelFondo;
    // End of variables declaration//GEN-END:variables

    public void pintarPaneles() {
        panelFondo.setBackground(colorFondo);
        panelContorno.setBackground(colorContorno);
    }

    public Color getColorFondo() {
        return colorFondo;
    }

    public Color getColorContorno() {
        return colorContorno;
    }
    
}
