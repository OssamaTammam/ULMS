/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package frontend;

/**
 *
 * @author Ossama
 */
public class ChoiceWindow extends javax.swing.JFrame implements Node {

    /**
     * Creates new form ChoiceWindow
     */
    AdminLogin admin = null;
    LibrarianLogin librarian = null;

    public ChoiceWindow() {
        initComponents();
        setTitle("Library System");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonAdminRole = new javax.swing.JButton();
        buttonLibrarianRole = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        buttonAdminRole.setBackground(new java.awt.Color(0, 0, 0));
        buttonAdminRole.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        buttonAdminRole.setForeground(new java.awt.Color(255, 255, 255));
        buttonAdminRole.setText("Admin Role");
        buttonAdminRole.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAdminRoleActionPerformed(evt);
            }
        });

        buttonLibrarianRole.setBackground(new java.awt.Color(0, 0, 0));
        buttonLibrarianRole.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        buttonLibrarianRole.setForeground(new java.awt.Color(255, 255, 255));
        buttonLibrarianRole.setText("Librarian Role");
        buttonLibrarianRole.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonLibrarianRoleActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(buttonLibrarianRole, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
                    .addComponent(buttonAdminRole, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(69, 69, 69))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(buttonAdminRole, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonLibrarianRole, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                .addGap(45, 45, 45))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonAdminRoleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAdminRoleActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        if (admin == null) {
            admin = new AdminLogin();
            admin.setTitle("Admin Login");
        }
        admin.setParentNode(this);
        admin.setVisible(true);

    }//GEN-LAST:event_buttonAdminRoleActionPerformed

    private void buttonLibrarianRoleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonLibrarianRoleActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        if (librarian == null) {
            librarian = new LibrarianLogin();
            librarian.setTitle("Librarian Login");
        }
        librarian.setParentNode(this);
        librarian.setVisible(true);
    }//GEN-LAST:event_buttonLibrarianRoleActionPerformed

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
            java.util.logging.Logger.getLogger(ChoiceWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChoiceWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChoiceWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChoiceWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChoiceWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAdminRole;
    private javax.swing.JButton buttonLibrarianRole;
    // End of variables declaration//GEN-END:variables

    @Override
    public void setParentNode(Node parent) {
    }

    @Override
    public Node getParentNode() {
        return null;
    }
}
