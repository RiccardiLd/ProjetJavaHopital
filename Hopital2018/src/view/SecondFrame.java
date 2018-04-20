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
    
    
    public SecondFrame(Controller controleur) throws SQLException {
        this.controleur = controleur;
        nbColonnes = controleur.maConnexion.rsetMeta.getColumnCount();
        init();
    }
    
    private void init() throws SQLException {
        JPanel pane = new JPanel();
        
        javax.swing.JTextField[] texte = new javax.swing.JTextField[nbColonnes];
        System.out.println(nbColonnes); 
         for(int i = 1; i <= nbColonnes; i++)
      {
          texte[i-1] = new javax.swing.JTextField(controleur.maConnexion.rsetMeta.getColumnName(i).toUpperCase());
        System.out.println(texte[i-1].getText());  
         pane.add(texte[i-1]);
      }
         pane.setLayout(new BoxLayout(pane, BoxLayout.PAGE_AXIS));
         getContentPane().add(pane);
         
        this.setVisible(true);
    }
    
}
