/*  Created by riccardild on Apr 20, 2018 3:54:55 PM
 *  (C) Copyright Gianni Riccardi.
 */
package view;

import javax.swing.JFrame;
import controller.Controller;
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
    
    
    public SecondFrame(Controller controleur) throws SQLException {
        this.controleur = controleur;
        nbColonnes = controleur.maConnexion.rsetMeta.getColumnCount();
        texte = new javax.swing.JTextField[nbColonnes];
        label = new javax.swing.JLabel[nbColonnes];
        init();
        createAddRequete();
    }
    
    private void init() throws SQLException {
        JPanel pane = new JPanel();
        
        
        
         for(int i = 1; i <= nbColonnes; i++)

        {
            label[i-1] = new javax.swing.JLabel(controleur.maConnexion.rsetMeta.getColumnName(i).toUpperCase());
            texte[i-1] = new javax.swing.JTextField();
            System.out.println(texte[i-1].getText()); 
            pane.add(label[i-1]);
            pane.add(texte[i-1]);
        }
        pane.setLayout(new BoxLayout(pane, BoxLayout.PAGE_AXIS));
        getContentPane().add(pane);
        this.setVisible(true);
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
        
}
   