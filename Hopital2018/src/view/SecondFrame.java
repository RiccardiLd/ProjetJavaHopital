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
    
    
    public SecondFrame(Controller controleur) throws SQLException {
        this.controleur = controleur;
        nbColonnes = controleur.maConnexion.rsetMeta.getColumnCount();
        init();
    }
    
    private void init() throws SQLException {
        JPanel pane = new JPanel();
        JPanel buttonPane = new JPanel();
        JPanel fieldPane = new JPanel();
        
        javax.swing.JButton jButtonOk = new javax.swing.JButton("Ok");
        javax.swing.JButton jButtonCancel = new javax.swing.JButton("Cancel");
        
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
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
    
}
