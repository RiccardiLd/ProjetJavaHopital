/*  Created by riccardild on Apr 20, 2018 11:36:04 AM
*  (C) Copyright Gianni Riccardi.
*/
package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.table.AbstractTableModel;
import model.*;

/**
 *
 * @author riccardild
 */
public class Controller {
    
    
    public MyTableModel model;
    public Connexion maConnexion;
    
    public Controller(String nameDatabase, String loginDatabase, String passwordDatabase, String host)
            throws SQLException, ClassNotFoundException {
        maConnexion = new Connexion(nameDatabase, loginDatabase, passwordDatabase, host);
        model = new MyTableModel();
    }
    
    public void findAll(String table) throws SQLException{
        maConnexion.findAll(table);
    }
    
    public void query(String query) throws SQLException {
        maConnexion.query(query);
        
        updateModel(); ///A VERIFIER
    }
    public void queryUpdate(String query) throws SQLException {
        maConnexion.queryUpdate(query);
    }
    
    public void updateModel() throws SQLException {
        model = new MyTableModel();
        model.addRow();
        
        System.out.println("\n**********************************");
        
        for(int i = 1; i <= maConnexion.rsetMeta.getColumnCount(); i++)
        {
            model.addColumn();
            System.out.print("\t" + maConnexion.rsetMeta.getColumnName(i).toUpperCase() + "\t *");
            model.setValueAt(maConnexion.rsetMeta.getColumnName(i).toUpperCase(), 0, i-1);
        }
        
        System.out.println("\n**********************************");
        int j = 1;
        while(maConnexion.rset.next()){
            model.addRow();
            
            for(int i = 1; i <= maConnexion.rsetMeta.getColumnCount(); i++)
            {
                System.out.print("\t" + maConnexion.rset.getObject(i).toString() + "\t |");
                model.setValueAt(maConnexion.rset.getObject(i).toString(),j,i-1);
            }
            
            System.out.println("\n---------------------------------");
            j++;
        }
    }
    
    private class RowData{
        
        private Map<Integer, Object> valeurs = new HashMap<Integer, Object>();
        
        public Object getColValue(int indexColonne) {
            if(valeurs.containsKey(indexColonne)){
                return valeurs.get(indexColonne);
            }
            return "";
        }
        
        public void setColValue(Object uneValeur, int indexColonne) {
            valeurs.put(indexColonne, uneValeur);
        }
        
    }
    
    public class MyTableModel extends AbstractTableModel{
        
        int indexColonnes=0;
        private List<Integer> colonnes = new ArrayList<Integer>();
        private List<RowData> lignes = new ArrayList<RowData>();
        
        @Override
        public boolean isCellEditable(int indexLigne, int indexColonne) {
            return true;
        }
        
        @Override
        public String getColumnName(int colonne) {
            return colonnes.get(colonne).toString();
        }
        
        @Override
        public int getRowCount() {
            return lignes.size();
        }
        
        @Override
        public int getColumnCount() {
            return colonnes.size();
        }
        
        @Override
        public Object getValueAt(int indexLigne, int indexColonne) {
            RowData data = lignes.get(indexLigne);
            return data.getColValue(colonnes.get(indexColonne));
        }
        
        @Override
        public void setValueAt(Object uneValeur, int indexLigne, int indexColonne) {
            RowData data = lignes.get(indexLigne);
            data.setColValue(uneValeur,colonnes.get(indexColonne));
            fireTableCellUpdated(indexLigne, indexColonne);
        }
        
        public void addRow() {
            lignes.add(new RowData());
            fireTableRowsInserted(lignes.size(), lignes.size());
        }
        
        public void addColumn() {
            colonnes.add(++indexColonnes);
            fireTableStructureChanged();
        }
        
    }
    
}
