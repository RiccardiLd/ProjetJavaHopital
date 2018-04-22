package view;

/*  Created by riccardild on Apr 19, 2018 11:04:07 AM
*  (C) Copyright Gianni Riccardi.
*/

import controller.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author riccardild
 */
public class HopitalUI extends javax.swing.JFrame {
    
    /**
     * Creates new form HopitalUI
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     */
    public HopitalUI() throws SQLException, ClassNotFoundException {
        initComponents();
        //controleur = new Controller("hopital","root","root", ":8889");
        controleur = new Controller("hopital", loginDatabase, passwordDatabase, socket);
        generator = new QueryGenerator(controleur);
        controleur.findAll("service");
        controleur.updateModel();
        jTable1.setModel(controleur.model);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenuTree = new javax.swing.JPopupMenu();
        jScrollPane3 = new javax.swing.JScrollPane();
        hopitalTree = new javax.swing.JTree();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButtonAdd = new javax.swing.JButton();
        jButtonDelete = new javax.swing.JButton();
        jButtonFind = new javax.swing.JButton();
        jButtonUpdate = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuOptions = new javax.swing.JMenu();
        jMenuItemAdvSearch = new javax.swing.JMenuItem();
        jMenuChart = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuEdit = new javax.swing.JMenu();
        jMenuItemAdd = new javax.swing.JMenuItem();
        jMenuItemDelete = new javax.swing.JMenuItem();
        jMenuItemFind = new javax.swing.JMenuItem();
        jMenuItemUpdateModel = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("Hôpital");
        javax.swing.tree.DefaultMutableTreeNode treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Service");
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Chambre");
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Employé");
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Docteur");
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Infirmier");
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Malade");
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Hospitalisation");
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Soigne");
        treeNode1.add(treeNode2);
        hopitalTree.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        hopitalTree.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                hopitalTreeMouseReleased(evt);
            }
        });
        jScrollPane3.setViewportView(hopitalTree);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 465, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        jButtonAdd.setText("Add");
        jButtonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddActionPerformed(evt);
            }
        });

        jButtonDelete.setText("Delete");
        jButtonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteActionPerformed(evt);
            }
        });

        jButtonFind.setText("Find");
        jButtonFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFindActionPerformed(evt);
            }
        });

        jButtonUpdate.setText("Update");
        jButtonUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUpdateActionPerformed(evt);
            }
        });

        jMenuOptions.setText("Options");

        jMenuItemAdvSearch.setText("New advanced search...");
        jMenuItemAdvSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAdvSearchActionPerformed(evt);
            }
        });
        jMenuOptions.add(jMenuItemAdvSearch);

        jMenuChart.setText("New chart...");

        jMenuItem1.setText("Chart 1");
        jMenuChart.add(jMenuItem1);

        jMenuItem2.setText("Chart 2");
        jMenuChart.add(jMenuItem2);

        jMenuItem3.setText("Chart 3");
        jMenuChart.add(jMenuItem3);

        jMenuOptions.add(jMenuChart);

        jMenuBar1.add(jMenuOptions);

        jMenuEdit.setText("Edit");

        jMenuItemAdd.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemAdd.setText("Add");
        jMenuItemAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAddActionPerformed(evt);
            }
        });
        jMenuEdit.add(jMenuItemAdd);

        jMenuItemDelete.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemDelete.setText("Delete");
        jMenuItemDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemDeleteActionPerformed(evt);
            }
        });
        jMenuEdit.add(jMenuItemDelete);

        jMenuItemFind.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemFind.setText("Find");
        jMenuItemFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemFindActionPerformed(evt);
            }
        });
        jMenuEdit.add(jMenuItemFind);

        jMenuItemUpdateModel.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemUpdateModel.setText("Update table model");
        jMenuItemUpdateModel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemUpdateModelActionPerformed(evt);
            }
        });
        jMenuEdit.add(jMenuItemUpdateModel);

        jMenuBar1.add(jMenuEdit);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonFind, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButtonDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonAdd)
                            .addComponent(jButtonDelete))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonFind)
                            .addComponent(jButtonUpdate))
                        .addGap(0, 85, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void hopitalTreeMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hopitalTreeMouseReleased
        String path = hopitalTree.getClosestPathForLocation(evt.getX(), evt.getY()).toString();
        if (evt.getButton() == java.awt.event.MouseEvent.BUTTON1) {
            String table = generator.pathTranslator(path);
            if (!table.equals("")) {
                try {
                    controleur.findAll(table);
                    controleur.updateModel();
                    jTable1.setModel(controleur.model);
                } catch (SQLException ex) {
                    Logger.getLogger(HopitalUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        if (evt.getButton() == java.awt.event.MouseEvent.BUTTON3) {
            jPopupMenuTree.removeAll();
            javax.swing.JMenuItem item1 = new javax.swing.JMenuItem("Find by... ");
            jPopupMenuTree.add(item1);
            jPopupMenuTree.show(hopitalTree.getComponentAt(evt.getX(), evt.getY()), evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_hopitalTreeMouseReleased
    
    private void jButtonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddActionPerformed
        try {
            new SecondFrame(controleur, "Add");
            
        } catch (SQLException ex) {
            Logger.getLogger(HopitalUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonAddActionPerformed

    private void jButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteActionPerformed
        try {
            new SecondFrame(controleur, "Delete");
            
        } catch (SQLException ex) {
            Logger.getLogger(HopitalUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonDeleteActionPerformed

    private void jButtonFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFindActionPerformed
        try {
            new SecondFrame(controleur, "Find");
            controleur.updateModel();
            jTable1.setModel(controleur.model);
            
        } catch (SQLException ex) {
            Logger.getLogger(HopitalUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonFindActionPerformed

    private void jMenuItemUpdateModelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemUpdateModelActionPerformed
        jTable1.setModel(controleur.model);
    }//GEN-LAST:event_jMenuItemUpdateModelActionPerformed

    private void jButtonUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUpdateActionPerformed
        try {
            new SecondFrame(controleur, "Update");
            controleur.updateModel();
            jTable1.setModel(controleur.model);
            
        } catch (SQLException ex) {
            Logger.getLogger(HopitalUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonUpdateActionPerformed

    private void jMenuItemAdvSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAdvSearchActionPerformed
        try {
            new SecondFrame(controleur, "Advanced");
            controleur.updateModel();
            jTable1.setModel(controleur.model);
            
        } catch (SQLException ex) {
            Logger.getLogger(HopitalUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItemAdvSearchActionPerformed

    private void jMenuItemAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAddActionPerformed
        try {
            new SecondFrame(controleur, "Add");
            
        } catch (SQLException ex) {
            Logger.getLogger(HopitalUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItemAddActionPerformed

    private void jMenuItemDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemDeleteActionPerformed
        try {
            new SecondFrame(controleur, "Delete");
            
        } catch (SQLException ex) {
            Logger.getLogger(HopitalUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItemDeleteActionPerformed

    private void jMenuItemFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemFindActionPerformed
        try {
            new SecondFrame(controleur, "Find");
            controleur.updateModel();
            jTable1.setModel(controleur.model);
            
        } catch (SQLException ex) {
            Logger.getLogger(HopitalUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItemFindActionPerformed
    
    /**
     * Code static qui se declenchera automatiquement avant le main à chaque fois.
     * Demande à l'utilisateur de rentrer ses informations pour accéder à la base.
     */
    // <editor-fold defaultstate="collapsed" desc="Static login screen"> 
    static
    {
        javax.swing.Icon icon = new javax.swing.ImageIcon("Img/Hospital_Icon.png");
        javax.swing.JTextField username = new javax.swing.JTextField();
        javax.swing.JTextField password = new javax.swing.JPasswordField();
        username.setColumns(20);
        password.setColumns(20);
        
        Object[] message = {
            "Username:", username,
            "Password:", password
        };
        String[] operationalSystem = { "MacOS", "Windows" };
        
        String OSChoix = (String) javax.swing.JOptionPane.showInputDialog(null,
                "Système operationnel :",
                "Choix de l'OS",
                javax.swing.JOptionPane.QUESTION_MESSAGE,
                null,
                operationalSystem,
                operationalSystem[0]);
        if (OSChoix == null)
            System.exit(0);
        else if (OSChoix.equals("MacOS")) 
            socket = ":8889";
        else if (OSChoix.equals("Windows"))
            socket = "";
        
        int option = javax.swing.JOptionPane.showConfirmDialog(null,
                message, 
                "Login - Hôpital", 
                javax.swing.JOptionPane.OK_CANCEL_OPTION,
                javax.swing.JOptionPane.QUESTION_MESSAGE,
                icon);
        
        if (option == javax.swing.JOptionPane.OK_OPTION) {
            loginDatabase = username.getText();
            passwordDatabase = password.getText();
        }
        else System.exit(0);
    }// </editor-fold>
        
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
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
                java.util.logging.Logger.getLogger(HopitalUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
            //</editor-fold>
            
            /* Create and display the form */
            java.awt.EventQueue.invokeLater(() -> {
                try {
                    new HopitalUI().setVisible(true);
                } catch (SQLException | ClassNotFoundException ex) {
                    Logger.getLogger(HopitalUI.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(null,
                        "Wrong username and/or password - access denied.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
                    System.exit(1);
                }
            });
        }
    
    private static String passwordDatabase;
    private static String loginDatabase;
    private static String socket;
    private final Controller controleur;
    private final QueryGenerator generator;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTree hopitalTree;
    private javax.swing.JButton jButtonAdd;
    private javax.swing.JButton jButtonDelete;
    private javax.swing.JButton jButtonFind;
    private javax.swing.JButton jButtonUpdate;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuChart;
    private javax.swing.JMenu jMenuEdit;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItemAdd;
    private javax.swing.JMenuItem jMenuItemAdvSearch;
    private javax.swing.JMenuItem jMenuItemDelete;
    private javax.swing.JMenuItem jMenuItemFind;
    private javax.swing.JMenuItem jMenuItemUpdateModel;
    private javax.swing.JMenu jMenuOptions;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenuTree;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
