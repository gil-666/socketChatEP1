
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author gil
 */
public class FCliente extends javax.swing.JFrame{
    
    public String nombre = "Cliente";
    public boolean sedioclick = false;
    public FCliente() {
        initComponents();
        setTitle("GilMessenger Client: "+nombre);
        LNombre.setText(nombre);
        jToolBar1.setFloatable(false);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("img/icon.png")));
        
    }

    public JCheckBox getChkBFondo() {
        return ChkBFondo;
    }

    public void setChkBFondo(JCheckBox ChkBFondo) {
        this.ChkBFondo = ChkBFondo;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jToolBar1 = new javax.swing.JToolBar();
        BLimpiar = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        BNombre = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        BVerRecibidos = new javax.swing.JButton();
        LNombre = new javax.swing.JLabel();
        PInterfaz = new javax.swing.JPanel();
        //BufferedImage image = null;
        //        try {
            //            image = ImageIO.read(getClass().getResource("/img/bg.jpg"));
            //        } catch (IOException e) {
            //            e.printStackTrace();
            //        }
        jLabel4 = new javax.swing.JLabel();
        PMensajes = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TAMensaje = new javax.swing.JTextArea();
        TFMensaje = new javax.swing.JTextField();
        BEnviar = new javax.swing.JButton();
        BEnviarArchivo = new javax.swing.JButton();
        ChkBFondo = new javax.swing.JCheckBox();
        jLabel5 = new javax.swing.JLabel();
        PFotoPerfil = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();

        jButton1.setText("jButton1");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("GilMessenger Client: ");
        setResizable(false);

        jPanel4.setBackground(new java.awt.Color(0, 204, 204));

        jLabel1.setFont(new java.awt.Font("PMingLiU-ExtB", 1, 36)); // NOI18N
        jLabel1.setText("GilMessenger Client");
        jLabel1.setToolTipText("");

        jLabel2.setText("Hola!, ");

        jToolBar1.setRollover(true);

        BLimpiar.setFont(new java.awt.Font("PMingLiU-ExtB", 1, 18)); // NOI18N
        BLimpiar.setText("Limpiar");
        BLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BLimpiarActionPerformed(evt);
            }
        });
        jToolBar1.add(BLimpiar);
        jToolBar1.add(jSeparator2);

        BNombre.setFont(new java.awt.Font("PMingLiU-ExtB", 1, 18)); // NOI18N
        BNombre.setText("Cambiar nombre de usuario");
        BNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BNombreActionPerformed(evt);
            }
        });
        jToolBar1.add(BNombre);
        jToolBar1.add(jSeparator1);

        BVerRecibidos.setFont(new java.awt.Font("PMingLiU-ExtB", 1, 18)); // NOI18N
        BVerRecibidos.setText("Ver archivos recibidos");
        BVerRecibidos.setFocusable(false);
        BVerRecibidos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BVerRecibidos.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BVerRecibidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BVerRecibidosActionPerformed(evt);
            }
        });
        jToolBar1.add(BVerRecibidos);

        LNombre.setText("<nombre>");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(0, 34, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(LNombre)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        //if (image != null) {
            //            ImageIcon icon = new ImageIcon(image.getScaledInstance(820, 500, Image.SCALE_SMOOTH));
            //            jLabel4.setIcon(icon);
            //        }

        PMensajes.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chat", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("PMingLiU-ExtB", 1, 18))); // NOI18N
        PMensajes.setOpaque(false);

        TAMensaje.setColumns(20);
        TAMensaje.setRows(5);
        jScrollPane1.setViewportView(TAMensaje);

        TFMensaje.setText("Escribe tu mensaje...");
        TFMensaje.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TFMensajeMouseClicked(evt);
            }
        });

        BEnviar.setFont(new java.awt.Font("PMingLiU-ExtB", 1, 24)); // NOI18N
        BEnviar.setText("Enviar");
        BEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BEnviarActionPerformed(evt);
            }
        });

        BEnviarArchivo.setFont(new java.awt.Font("PMingLiU-ExtB", 1, 18)); // NOI18N
        BEnviarArchivo.setText("Enviar archivo");
        BEnviarArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BEnviarArchivoActionPerformed(evt);
            }
        });

        ChkBFondo.setSelected(true);
        ChkBFondo.setText("Auto-desplegar al fondo");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("*limite 2MB >_<");

        javax.swing.GroupLayout PMensajesLayout = new javax.swing.GroupLayout(PMensajes);
        PMensajes.setLayout(PMensajesLayout);
        PMensajesLayout.setHorizontalGroup(
            PMensajesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PMensajesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PMensajesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(PMensajesLayout.createSequentialGroup()
                        .addGroup(PMensajesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(TFMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 466, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(PMensajesLayout.createSequentialGroup()
                                .addComponent(ChkBFondo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BEnviarArchivo)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BEnviar, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)))
                .addContainerGap())
        );
        PMensajesLayout.setVerticalGroup(
            PMensajesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PMensajesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PMensajesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PMensajesLayout.createSequentialGroup()
                        .addComponent(TFMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PMensajesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PMensajesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(BEnviarArchivo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(ChkBFondo))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PMensajesLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel5))))
                    .addComponent(BEnviar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        PFotoPerfil.setBackground(new java.awt.Color(149, 225, 134));
        PFotoPerfil.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        ImageIcon icon = new ImageIcon(getClass().getResource("/img/avatar.png"));
        if (icon != null) {
            ImageIcon scaledIcon = new ImageIcon(icon.getImage().getScaledInstance(88, 88, java.awt.Image.SCALE_SMOOTH));
            jLabel3.setIcon(scaledIcon);
        } else {
            System.err.println("Failed to load the image.");
        }

        javax.swing.GroupLayout PFotoPerfilLayout = new javax.swing.GroupLayout(PFotoPerfil);
        PFotoPerfil.setLayout(PFotoPerfilLayout);
        PFotoPerfilLayout.setHorizontalGroup(
            PFotoPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PFotoPerfilLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                .addContainerGap())
        );
        PFotoPerfilLayout.setVerticalGroup(
            PFotoPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PFotoPerfilLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout PInterfazLayout = new javax.swing.GroupLayout(PInterfaz);
        PInterfaz.setLayout(PInterfazLayout);
        PInterfazLayout.setHorizontalGroup(
            PInterfazLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PInterfazLayout.createSequentialGroup()
                .addContainerGap(8, Short.MAX_VALUE)
                .addComponent(PFotoPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PMensajes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(PInterfazLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 761, Short.MAX_VALUE))
        );
        PInterfazLayout.setVerticalGroup(
            PInterfazLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PInterfazLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PInterfazLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PMensajes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PInterfazLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(PFotoPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 290, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(23, Short.MAX_VALUE))
            .addGroup(PInterfazLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 446, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(PInterfaz, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PInterfaz, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void TFMensajeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TFMensajeMouseClicked
        if(!sedioclick){
            TFMensaje.setText("");
            sedioclick = true;
        }
        
    }//GEN-LAST:event_TFMensajeMouseClicked

    private void BEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BEnviarActionPerformed
        TFMensaje.setText("");
    }//GEN-LAST:event_BEnviarActionPerformed

    private void BLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BLimpiarActionPerformed
        TAMensaje.setText("");
    }//GEN-LAST:event_BLimpiarActionPerformed

    private void BNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BNombreActionPerformed
        nombre = JOptionPane.showInputDialog("Ingresa tu nuevo nombre de usuario", nombre);
        this.setTitle("GilMessenger Client: "+nombre);
        LNombre.setText(nombre);
    }//GEN-LAST:event_BNombreActionPerformed

    private void BEnviarArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BEnviarArchivoActionPerformed
        
    }//GEN-LAST:event_BEnviarArchivoActionPerformed

    private void BVerRecibidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BVerRecibidosActionPerformed
        try {
            String ruta = System.getProperty("user.dir") + File.separator + "src" + File.separator + "recibidos";
            File recibidos = new File(ruta);
            Desktop.getDesktop().open(recibidos);
        } catch (IOException ex) {
            Logger.getLogger(FCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_BVerRecibidosActionPerformed

    public JButton getBLimpiar() {
        return BLimpiar;
    }

    public void setBLimpiar(JButton BLimpiar) {
        this.BLimpiar = BLimpiar;
    }

    public JLabel getLNombre() {
        return LNombre;
    }

    public void setLNombre(JLabel LNombre) {
        this.LNombre = LNombre;
    }



    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public JButton getBEnviar() {
        return BEnviar;
    }

    public void setBEnviar(JButton BEnviar) {
        this.BEnviar = BEnviar;
    }

    public JTextArea getTAMensaje() {
        return TAMensaje;
    }

    public void setTAMensaje(JTextArea TAMensaje) {
        this.TAMensaje = TAMensaje;
    }

    public JButton getBEnviarArchivo() {
        return BEnviarArchivo;
    }

    public void setBEnviarArchivo(JButton BEnviarArchivo) {
        this.BEnviarArchivo = BEnviarArchivo;
    }

    public JTextField getTFMensaje() {
        return TFMensaje;
    }

    public void setTFMensaje(JTextField TFMensaje) {
        this.TFMensaje = TFMensaje;
    }

    public JPanel getjPanel1() {
        return PMensajes;
    }

    public void setjPanel1(JPanel jPanel1) {
        this.PMensajes = jPanel1;
    }

    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public void setjScrollPane1(JScrollPane jScrollPane1) {
        this.jScrollPane1 = jScrollPane1;
    }



    

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
            java.util.logging.Logger.getLogger(FCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BEnviar;
    private javax.swing.JButton BEnviarArchivo;
    private javax.swing.JButton BLimpiar;
    private javax.swing.JButton BNombre;
    private javax.swing.JButton BVerRecibidos;
    private javax.swing.JCheckBox ChkBFondo;
    private javax.swing.JLabel LNombre;
    private javax.swing.JPanel PFotoPerfil;
    private javax.swing.JPanel PInterfaz;
    private javax.swing.JPanel PMensajes;
    private javax.swing.JTextArea TAMensaje;
    private javax.swing.JTextField TFMensaje;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables
}