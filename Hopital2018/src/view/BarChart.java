/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

//import controller.Controller;
import java.sql.SQLException;
import javax.swing.JFrame;
import java.lang.*;
import model.Connexion;


/*
https://www.tutorialspoint.com/jfreechart/jfreechart_bar_chart.htm
*/
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel; 
import org.jfree.chart.JFreeChart; 
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset; 
import org.jfree.data.category.DefaultCategoryDataset; 
//import org.jfree.ui.ApplicationFrame;                   si on met: extends ApplicationFrame
import org.jfree.ui.RefineryUtilities;


/**
 *
 * @author Marie
 */
public class BarChart extends JFrame{
    
    public BarChart(Connexion maConnexion) throws SQLException {
        //super(maConnexion.rsetMeta.getTableName(1));  ->plante quand j'appuie sur diagramme
        super("poney");
        JFreeChart barChart = ChartFactory.createBarChart(
         "Titre",               //chartTitle,           
         "Abscisse",            
         "Ordonnee",            
         createDataset(),          
         PlotOrientation.VERTICAL,           
         true, true, false);
         
      ChartPanel chartPanel = new ChartPanel( barChart );        
      chartPanel.setPreferredSize(new java.awt.Dimension( 560 , 367 ) );        
      setContentPane( chartPanel ); 
    }

    private CategoryDataset createDataset( ) {
      final String rouge = "Rouge";        
      final String bleu = "Bleu";        
      final String vert = "Vert";        
      final String c1 = "Colonne1";        
      final String c2 = "Colonne2";        
      final String c3 = "Colonne3";       
      final DefaultCategoryDataset dataset = new DefaultCategoryDataset( );  

      dataset.addValue( 1.0 , rouge , c1 );        
      dataset.addValue( 3.0 , rouge , c3 );        
      dataset.addValue( 5.0 , rouge , c2 );        

      dataset.addValue( 5.0 , bleu , c1 );        
      dataset.addValue( 6.0 , bleu , c3 );       
      dataset.addValue( 10.0 , bleu , c2 );      

      dataset.addValue( 4.0 , vert , c1 );        
      dataset.addValue( 2.0 , vert , c3 );        
      dataset.addValue( 3.0 , vert , c2 );  

      return dataset; 
   }
    
    public void affBarChart()
    {
        this.pack( );        
        RefineryUtilities.centerFrameOnScreen( this );        
        this.setVisible( true ); 
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
   
}
