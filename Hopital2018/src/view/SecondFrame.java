/*  Created by riccardild on Apr 20, 2018 3:54:55 PM
 *  (C) Copyright Gianni Riccardi.
 */
package view;

import javax.swing.JFrame;
import controller.Controller;
import java.sql.SQLException;
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
        javax.swing.JTextField[] texte = new javax.swing.JTextField[nbColonnes];
        /*for(int i = 1; i <= nbColonnes; i++)
      {
          texte[i] = new javax.swing.JTextField(controleur.maConnexion.rsetMeta.getColumnName(i).toUpperCase());
          this.add(texte[i]);
      }*/
        this.setVisible(true);
    }
    
}
