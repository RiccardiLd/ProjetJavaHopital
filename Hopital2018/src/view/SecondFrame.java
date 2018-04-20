/*  Created by riccardild on Apr 20, 2018 3:54:55 PM
*  (C) Copyright Gianni Riccardi.
*/
package view;

import javax.swing.JFrame;
import controller.Controller;
import java.awt.Dimension;
import java.sql.SQLException;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

/**
 *
 * @author riccardild
 */
public class SecondFrame extends JFrame{
    
    private final Controller controleur;
    int nbColonnes;
    javax.swing.JTextField[] texte;
    javax.swing.JLabel[] label;
    
    
    public SecondFrame(Controller controleur, String frameName) throws SQLException {
        super(frameName);
        this.controleur = controleur;
        nbColonnes = controleur.maConnexion.rsetMeta.getColumnCount();
        texte = new javax.swing.JTextField[nbColonnes];
        label = new javax.swing.JLabel[nbColonnes];
        init();
        //createAddRequete();
    }
    
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
    
    
    
    
    
    private String createAddQuery() throws SQLException
    {
        int j=0;
        int cpt=0;
        String requete = "INSERT INTO " + controleur.maConnexion.rsetMeta.getTableName(1) + " (";
        /*for(int i = 1; i <= nbColonnes; i++)
        {
            label[i-1] = new javax.swing.JLabel(controleur.maConnexion.rsetMeta.getColumnName(i).toUpperCase());
            texte[i-1] = new javax.swing.JTextField();
            texte[i-1].setPreferredSize(new Dimension(200,25));
            fieldPane.add(label[i-1]);
            fieldPane.add(texte[i-1]);
        }*/
        for(int i =0; i<nbColonnes; i++)
        {
            if(!texte[i].getText().trim().equals(""))
            {
                cpt++;
            }
        }
        if(cpt != 0)
        {
            for(int i =0; i<nbColonnes; i++)
            {
                if(!texte[i].getText().trim().equals(""))
                {
                    requete += controleur.maConnexion.rsetMeta.getColumnName(i+1);
                    j+=1;
                    
                    if(j!=0 && j!=cpt)
                    {
                        requete += ", ";
                    }
                }
            }
            j=0;
            requete += ") VALUES (";
            
            for(int i =0; i<nbColonnes; i++)
            {
                if(!texte[i].getText().trim().equals(""))
                {
                    requete += texte[i].getText().trim();
                    j+=1;
                    
                    if(j!=0 && j!=cpt)
                    {
                        requete += ", ";
                    }
                }
            }
            requete += ")";
            
            return requete;
        }
        return "";
    }
    
    private String createDeleteQuery() throws SQLException
    {
        
        int j=0;
        int cpt=0;
        String requete = "DELETE FROM " + controleur.maConnexion.rsetMeta.getTableName(1) + " WHERE ";
        
        for(int i =0; i<nbColonnes; i++)
        {
            if(!texte[i].getText().trim().equals(""))
            {
                cpt++;
                
            }
        }
        if(cpt != 0)
        {
            for(int i =0; i<nbColonnes; i++)
            {
                if(!texte[i].getText().trim().equals(""))
                {
                    requete += label[i].getText().trim();
                    requete += "= ";
                    requete += texte[i].getText().trim();
                    j+=1;
                    
                    if(j!=0 && j!=cpt)
                    {
                        requete += "and ";
                        
                    }
                    
                    
                }
            }
            
            //System.out.println(requete);

            return requete;
        }
        
        return "";
                
        
        
    }
    
    
    private void jButtonCancelActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        this.dispose();
    }
    private void jButtonOkActionPerformed(java.awt.event.ActionEvent evt)  {
        // TODO add your handling code here:
        try{
            String query = createAddQuery();
            if(!query.equals("")) {
                System.out.println(query);
                System.out.println("MDR");
                controleur.queryUpdate(query);
            }
            else System.out.println("\nErreur requete vide.");
            this.dispose();
        }
        catch (SQLException ex){
            
        }
    }
    
}
