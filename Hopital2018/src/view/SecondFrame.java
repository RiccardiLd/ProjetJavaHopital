/*  Created by riccardild on Apr 20, 2018 3:54:55 PM
 *  (C) Copyright Gianni Riccardi.
 */
package view;

import javax.swing.JFrame;
import controller.Controller;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.sql.SQLException;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import model.*;

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
        

        javax.swing.JTextField[] texte = new javax.swing.JTextField[nbColonnes];
        javax.swing.JLabel[] label = new javax.swing.JLabel[nbColonnes];
                

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
    
    
    private void jButtonOkActionPerformed(java.awt.event.ActionEvent evt) { 
        // TODO add your handling code here:
    }
    

     private String createAddRequete() throws SQLException
{
    /*
INSERT INTO T_TITRE (TIT_CODE, TIT_LIBELLE)
       VALUES  ('M.'    , 'Monsieur'),
                ('Mlle.' , 'Mademoiselle'),
                ('Mme.'  , 'Madame');*/
    
       String requete = "INSERT INTO " + controleur.maConnexion.rsetMeta.getTableName(1) + " (";
       for(int i =0; i<nbColonnes; i++)
       {
          if(verifTexteExiste(label[i].getText().trim()))
           {
           requete += label[i].getText().trim();
           if(nbColonnes>i+1)
           requete += ", ";
           }
       }
       
       requete += ") VALUES ( ";
        
       for(int i =0; i<nbColonnes; i++)
       {
           if(verifTexteExiste(texte[i].getText().trim()))
           {
            requete += texte[i].getText().trim();
           if(nbColonnes>i+1)
           requete += ", ";
           }
           
       }
       requete += ")";
       
       System.out.println(requete);
    
    return requete;
}
    private boolean verifTexteExiste(String s){
        
        if(s!= null && s!= "")
            return true;
        
        
        return false;
    }
        

    private void jButtonCancelActionPerformed(java.awt.event.ActionEvent evt) { 
        // TODO add your handling code here:
        this.dispose();
    }

}
   