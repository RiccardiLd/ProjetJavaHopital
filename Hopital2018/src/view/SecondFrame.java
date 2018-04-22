/*  Created by riccardild on Apr 20, 2018 3:54:55 PM
*  (C) Copyright Gianni Riccardi, Théo Minier, Marie-Claire Belamy.
*/
package view;

import javax.swing.JFrame;
import controller.*;
import java.awt.Dimension;
import java.sql.SQLException;
import javax.swing.BoxLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author riccardild
 * @author theo
 * @author marie-claire
 */
public class SecondFrame extends JFrame{
    
    private final Controller controleur;
    private final QueryGenerator generator;
    int nbColonnes;
    javax.swing.JTextField[] texte;
    javax.swing.JLabel[] label;
    String frameName;
    /**
     * Constructeur de la SecondFrame
     * @param controleur le controleur principal du projet
     * @param frameName le nom de la fênetre, qui décidera aussi de sa fonction
     * @throws SQLException
     */
    public SecondFrame(Controller controleur, String frameName) throws SQLException {
        super(frameName);
        this.frameName = frameName;
        this.controleur = controleur;
        generator = new QueryGenerator(controleur);
        nbColonnes = controleur.maConnexion.rsetMeta.getColumnCount();
        texte = new javax.swing.JTextField[nbColonnes];
        label = new javax.swing.JLabel[nbColonnes];
        init();
        //createAddRequete();
    }
    /**
     * Méthode appelée depuis le constructeur pour initialiser la SecondFrame
     * @throws SQLException
     */
    private void init() throws SQLException {
        JPanel pane = new JPanel();
        JPanel buttonPane = new JPanel();
        JPanel fieldPane = new JPanel();
        
        javax.swing.JButton jButtonOk = new javax.swing.JButton("Ok");
        jButtonOk.addActionListener((java.awt.event.ActionEvent evt) -> {
            jButtonOkActionPerformed(evt);
        });
        javax.swing.JButton jButtonCancel = new javax.swing.JButton("Cancel");
        jButtonCancel.addActionListener((java.awt.event.ActionEvent evt) -> {
            jButtonCancelActionPerformed(evt);
        });
        
        for(int i = 1; i <= nbColonnes; i++)
        {
            label[i-1] = new javax.swing.JLabel(controleur.maConnexion.rsetMeta.getColumnName(i).toUpperCase());
            texte[i-1] = new javax.swing.JTextField();
            texte[i-1].setPreferredSize(new Dimension(200,25));
            fieldPane.add(label[i-1]);
            fieldPane.add(texte[i-1]);
        }
        fieldPane.setLayout(new BoxLayout(fieldPane, BoxLayout.PAGE_AXIS));
        buttonPane.setLayout(new BoxLayout(buttonPane, BoxLayout.LINE_AXIS));
        buttonPane.add(jButtonOk);
        buttonPane.add(jButtonCancel);
        pane.add(fieldPane);
        pane.add(buttonPane);
        pane.setLayout(new BoxLayout(pane, BoxLayout.PAGE_AXIS));
        getContentPane().add(pane);
        pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
    /**
     * Bouton "Cancel" appuyé
     * @param evt
     */
    private void jButtonCancelActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();
    }
    /**
     * Bouton "Ok" appuyé
     * @param evt
     */
    private void jButtonOkActionPerformed(java.awt.event.ActionEvent evt)  {
        String query = "";
        try{
            switch (frameName) {
                case "Add":
                    query = generator.createAddQuery(nbColonnes, texte);
                    break;
                case "Delete":
                    query = generator.createDeleteQuery(nbColonnes, texte);
                    break;
                case "Find":
                    query = generator.createFindQuery(nbColonnes, texte);
                    break;
                case "Update":
                    query = generator.createUpdateQuery(nbColonnes, texte);
                    break;
                case "Advanced":
                    query = generator.createAdvancedQuery(nbColonnes, texte);
                    break;
                default:
                    break;
            }
            
            if((frameName.equals("Add")||frameName.equals("Delete")||frameName.equals("Update")) && !query.equals("")) {
                controleur.queryUpdate(query);
                JOptionPane.showMessageDialog(this,
                    "Requête réalisée : " + query);
            }
            else if((frameName.equals("Find")||frameName.equals("Advanced")) && !query.equals("")) {
                controleur.query(query);///Attention ICI au equals Avance
                JOptionPane.showMessageDialog(this,
                    "Requête réalisée : " + query);
            }
            else JOptionPane.showMessageDialog(this,
                    "Erreur requête vide",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        catch (SQLException ex){
            
        }
        this.dispose();
    }
}
