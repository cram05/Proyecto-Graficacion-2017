package vista;

import java.awt.Color;
import javax.swing.JPanel;

/**
 *
 * @author Carlos Ramos
 */
public class VentanaPrincipal2 extends javax.swing.JFrame {
    private PanelCircunferenciaFill panelCirculo;
       private PanelCuadradoFill panelCuadrado;
       private PanelTrianguloFill panelTriangulo;
       
    public VentanaPrincipal2() {
        PanelColores paletaColores = new PanelColores();
        paletaColores.setLocation(350, 130);
        paletaColores.setSize(126, 253);
        add(paletaColores);
        
        initComponents();
            panelCuadrado = new PanelCuadradoFill(paletaColores);
            panelCuadrado.setLocation(0, -30);
            panelTriangulo = new PanelTrianguloFill(paletaColores);
            panelTriangulo.setLocation(0, -30);
        panelCirculo = new PanelCircunferenciaFill(paletaColores);
        panelCirculo.setLocation(0, -30);
        PanelCircunferencia.add(panelCirculo);
            PanelCuadradito.add(panelCuadrado);
            PanelTriangulito.add(panelTriangulo);
        
        JPanel fondo = new JPanel();
        fondo.setBounds(0, 0, getWidth(), getHeight());
        fondo.setBackground(new Color(80, 80, 80));
        add(fondo);
        setVisible(true);
        
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        PanelCircunferencia = new javax.swing.JPanel();
        PanelCuadradito = new javax.swing.JPanel();
        PanelTriangulito = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(java.awt.Color.orange);
        jLabel4.setText("PINTADO DE FIGURAS");

        javax.swing.GroupLayout PanelCircunferenciaLayout = new javax.swing.GroupLayout(PanelCircunferencia);
        PanelCircunferencia.setLayout(PanelCircunferenciaLayout);
        PanelCircunferenciaLayout.setHorizontalGroup(
            PanelCircunferenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 520, Short.MAX_VALUE)
        );
        PanelCircunferenciaLayout.setVerticalGroup(
            PanelCircunferenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 433, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Circunferencia", PanelCircunferencia);

        javax.swing.GroupLayout PanelCuadraditoLayout = new javax.swing.GroupLayout(PanelCuadradito);
        PanelCuadradito.setLayout(PanelCuadraditoLayout);
        PanelCuadraditoLayout.setHorizontalGroup(
            PanelCuadraditoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 520, Short.MAX_VALUE)
        );
        PanelCuadraditoLayout.setVerticalGroup(
            PanelCuadraditoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 433, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Cuadrado", PanelCuadradito);

        javax.swing.GroupLayout PanelTriangulitoLayout = new javax.swing.GroupLayout(PanelTriangulito);
        PanelTriangulito.setLayout(PanelTriangulitoLayout);
        PanelTriangulitoLayout.setHorizontalGroup(
            PanelTriangulitoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 520, Short.MAX_VALUE)
        );
        PanelTriangulitoLayout.setVerticalGroup(
            PanelTriangulitoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 433, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Triangulo", PanelTriangulito);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(168, 168, 168)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTabbedPane1))
        );

        jTabbedPane1.getAccessibleContext().setAccessibleName("Circunferencia");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPrincipal2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelCircunferencia;
    private javax.swing.JPanel PanelCuadradito;
    private javax.swing.JPanel PanelTriangulito;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
}
