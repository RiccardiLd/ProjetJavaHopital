/*  Created by riccardild on Apr 22, 2018 12:10:06 PM
*  (C) Copyright Gianni Riccardi.
*/
package controller;

import java.sql.SQLException;

/**
 *
 * @author riccardild
 */
public class QueryGenerator {
    private final Controller controleur;
    /**
     * Constructeur
     * @param controleur le controleur principal du projet
     */
    public QueryGenerator(Controller controleur) {
        this.controleur = controleur;
    }
    public boolean isValidTable() throws SQLException {
        String table = controleur.maConnexion.rsetMeta.getTableName(1);
        int nbColonnes = controleur.maConnexion.rsetMeta.getColumnCount();
        return (table.equals("service") || table.equals("chambre") ||
                table.equals("employe") || table.equals("docteur") ||
                table.equals("infirmier") || table.equals("malade") ||
                table.equals("hospitalisation") || table.equals("soigne"))
                &&
                !(nbColonnes > 6);
    }
    /**
     * Reçoit le String récupéré dans l'arbre et le traduit en nom de la table correspondante.
     * @param path le path récupéré après la sélection d'un node de l'arbre
     * @return le nom de la table correspondante dans la base de données
     */
    public String pathTranslator(String path) {
        String table = "";
        if (path.contains("Service")) {
            table = "service";
        }
        else if (path.contains("Chambre")) {
            table = "chambre";
        }
        else if (path.contains("Employé")) {
            table = "employe";
        }
        else if (path.contains("Docteur")) {
            table = "docteur";
        }
        else if (path.contains("Infirmier")) {
            table = "infirmier";
        }
        else if (path.contains("Malade")) {
            table = "malade";
        }
        else if (path.contains("Hospitalisation")) {
            table = "hospitalisation";
        }
        else if (path.contains("Soigne")) {
            table = "soigne";
        }
        return table;
    }
    
    public String createAddQuery(int nbColonnes, javax.swing.JTextField[] texte)
            throws SQLException
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
                    requete += "'";
                    requete += texte[i].getText().trim();
                    requete += "'";
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
    
    public String createDeleteQuery(int nbColonnes, javax.swing.JTextField[] texte)
            throws SQLException
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
                    requete += controleur.maConnexion.rsetMeta.getColumnName(i+1);
                    requete += " = '";
                    requete += texte[i].getText().trim();
                    requete += "'";
                    j+=1;
                    
                    if(j!=0 && j!=cpt)
                    {
                        requete += " and ";
                        
                    }
                }
            }
            
            return requete;
        }
        
        return "";
    }
    
    public String createFindQuery(int nbColonnes, javax.swing.JTextField[] texte)
            throws SQLException
    {
        
        int j=0;
        int cpt=0;
        String requete = "SELECT * FROM " + controleur.maConnexion.rsetMeta.getTableName(1) + " WHERE ";
        
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
                    requete += " = '";
                    requete += texte[i].getText().trim();
                    requete += "'";
                    j+=1;
                    
                    if(j!=0 && j!=cpt)
                    {
                        requete += " and ";
                    }
                }
            }
            
            return requete;
        }
        
        return "";
    }
    
    public String createUpdateQuery(int nbColonnes, javax.swing.JTextField[] texte)
            throws SQLException
    {
        /*UPDATE table
        SET nom_colonne_1 = 'nouvelle valeur'
        WHERE condition*/
        int j=0;
        int cpt=0;
        String requete = "UPDATE " + controleur.maConnexion.rsetMeta.getTableName(1) + " SET ";
        System.out.println("LOL");
        for(int i =1; i<nbColonnes; i++)
        {
            if(!texte[i].getText().trim().equals(""))
            {
                cpt++;
            }
        }
        if(cpt != 0)
        {
            for(int i =1; i<nbColonnes; i++)
            {
                if(!texte[i].getText().trim().equals(""))
                {
                    requete += controleur.maConnexion.rsetMeta.getColumnName(i+1);
                    requete += " = '";
                    requete += texte[i].getText().trim();
                    requete += "'";
                    j+=1;
                    
                    if(j!=0 && j!=cpt)
                    {
                        requete += " and ";
                    }
                }
            }
            
            requete += " WHERE ";
            requete += controleur.maConnexion.rsetMeta.getColumnName(1);
            requete += " = ";
            requete += texte[0].getText().trim();
            return requete;
        }
        
        return "";
    }
    
    public String createAdvancedMaladeQuery(int nbColonnes, javax.swing.JTextField[] texte)
            throws SQLException
    {
        /**
         * INFORMATIONS D'UN MALADE
         * Préselectionner la table malades
         * Donne des infos sur malade : Chambre, Les docteurs, leurs noms etc
         */
        System.out.println("ICI");
        int j=0;
        int cpt=0;
        String requete = "SELECT * FROM malade m, soigne s, hospitalisation h, docteur d, employe e WHERE ";/*, chambre c, docteur d, employe e WHERE ";*/
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
                    requete += "m.";
                    requete += controleur.maConnexion.rsetMeta.getColumnName(i+1);
                    requete += " = '";
                    requete += texte[i].getText().trim();
                    requete += "'";
                    
                    
                    if(j!=0 && j!=cpt)
                    {
                        requete += " and ";
                        
                    }
                    j+=1;
                }
            }
            requete += "and m.numero = s.no_malade and s.no_malade = h.no_malade and s.no_docteur = d.numero and s.no_docteur = e.numero";
            System.out.println(requete);
            return requete;
        }
        
        return "";
    }
    
    public String createAdvancedChambreQuery(int nbColonnes, javax.swing.JTextField[] texte)
            throws SQLException
    {
        /**
         * INFORMATIONS D'UNE CHAMBRE
         * Préselectionner la table chambre
         * Donne des infos sur chambre : surveillants, Les malades
         */
        
        int j=0;
        int cpt=0;
        String requete = "SELECT * FROM chambre c, infirmier i, hospitalisation h, malade m, employe e WHERE ";/*, chambre c, docteur d, employe e WHERE ";*/
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
                    requete += "c.";
                    requete += controleur.maConnexion.rsetMeta.getColumnName(i+1);
                    requete += " = '";
                    requete += texte[i].getText().trim();
                    requete += "'";
                    
                    
                    if(j!=0 && j!=cpt)
                    {
                        requete += " and ";
                    }
                    j+=1;
                }
            }
            requete += "and c.no_chambre = h.no_chambre and m.numero = h.no_malade and c.surveillant = e.numero and i.numero = c.surveillant";
            System.out.println(requete);
            return requete;
        }
        
        return "";
    }
    
     public String createAdvancedServiceQuery(int nbColonnes, javax.swing.JTextField[] texte) 
            throws SQLException
    {
        /**
         * INFORMATIONS D'UNE CHAMBRE
         * Préselectionner la table service
         * Donne des infos sur chambre : les docteurs du service
         */
        
       // int j=0;
        //int cpt=0;
      //  String requete = "SELECT * FROM service s, docteur d, employe e WHERE ";/*, chambre c, docteur d, employe e WHERE ";*/
       /* for(int i =0; i<nbColonnes; i++)
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
                    requete += "c.";
                    requete += controleur.maConnexion.rsetMeta.getColumnName(i+1);
                    requete += " = '";
                    requete += texte[i].getText().trim();
                    requete += "'";
                    
                    
                    if(j!=0 && j!=cpt)
                    {
                        requete += " and ";
                    }
                    j+=1;
                }
            }
            requete += "and s.code = h.no_chambre and m.numero = h.no_malade and c.surveillant = e.numero and i.numero = c.surveillant";
            System.out.println(requete);
            return requete;
        }*/
        
        return "";
    }
    
    public String createAdvancedQuery(int nbColonnes, javax.swing.JTextField[] texte) 
            throws SQLException
    {
        /**
         * Choisis la bonne requete avancee en fonction de la table dejà selectionnée
         */
        if(controleur.maConnexion.rsetMeta.getTableName(1).equals("chambre"))
        {
            return createAdvancedChambreQuery(nbColonnes, texte);
        }
        
        
        if(controleur.maConnexion.rsetMeta.getTableName(1).equals("malade"))
        {
            return createAdvancedMaladeQuery(nbColonnes, texte);
        }
        
        
        else return "";
    }
}