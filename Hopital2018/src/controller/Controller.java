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
    
    
    public MyModel model;
 
    public Controller(String nameDatabase, String loginDatabase, String passwordDatabase) throws SQLException, ClassNotFoundException {
        Connexion maConnexion;
        //maConnexion = new Connexion("hopital","root","root");
        maConnexion = new Connexion(nameDatabase, loginDatabase, passwordDatabase);
        init(maConnexion);
    }
    
    private void init(Connexion maConnexion) throws SQLException {
        model = new MyModel();
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

        private Map<Integer, Object> values = new HashMap<Integer, Object>();

        public Object getValueForCol(int columnIndex) {
            if(values.containsKey(columnIndex)){
                return values.get(columnIndex);
            }
            return "";
        }

        public void setValueForCol(Object aValue, int columnIndex) {
            values.put(columnIndex, aValue);
        }

    }

    public class MyModel extends AbstractTableModel{

        int colIndex=0;
        private List<Integer> cols = new ArrayList<Integer>();
        private List<RowData> rows = new ArrayList<RowData>();

        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return true;
        }

        @Override
        public String getColumnName(int column) {
            return cols.get(column).toString();
        }

        @Override
        public int getRowCount() {
            return rows.size();
        }

        public void addRow() {
            rows.add(new RowData());
            fireTableRowsInserted(rows.size(), rows.size());
        }


       /* public void removeRow(int selectedRow) {
            rows.remove(selectedRow);
            fireTableRowsDeleted(selectedRow, selectedRow);
        }*/

       /* public void removeColumn(int selectedColumn) {
            cols.remove(table.convertColumnIndexToModel(selectedColumn));
            fireTableStructureChanged();
        }*/

        public void addColumn() {
            cols.add(++colIndex);
            fireTableStructureChanged();
        }

        @Override
        public int getColumnCount() {
            return cols.size();
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            RowData rowData = rows.get(rowIndex);
            return rowData.getValueForCol(cols.get(columnIndex));
        }

        @Override
        public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
            RowData rowData = rows.get(rowIndex);
            rowData.setValueForCol(aValue,cols.get(columnIndex));
            fireTableCellUpdated(rowIndex, columnIndex);
        }

    }
    
}
