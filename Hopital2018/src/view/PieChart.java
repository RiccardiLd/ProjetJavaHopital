/*  Created by riccardild on Apr 17, 2018 11:21:32 AM
 *  (C) Copyright Gianni Riccardi.
 */
package view;

import controller.Controller;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.util.Rotation;

/**
 *
 * @author riccardild
 */
public class PieChart extends JFrame {

    private static final long serialVersionUID = 1L;
    PieDataset dataset;
    ArrayList<String> titre= new ArrayList();
    ArrayList val= new ArrayList();

    
    
    public PieChart(Controller controleur, String strQuery, String Tfen) throws SQLException {
        super(Tfen);
        this.PieChambre(controleur, strQuery);
        dataset = createDataset();
        JFreeChart chart = createChart(dataset,"");
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(700, 370));
        setContentPane(chartPanel);

    }

    public void PieChambre(Controller controleur, String strQuery) throws SQLException
    {
        //controleur.maConnexion.query("SELECT nb_lits, COUNT(no_chambre) FROM `chambre` GROUP BY nb_lits");
        controleur.maConnexion.query(strQuery);
      
        int j = 1;
        while(controleur.maConnexion.rset.next()){
            for(int i = 1; i <= controleur.maConnexion.rsetMeta.getColumnCount(); i++)
            {
                if (i%2!=0)
                titre.add(controleur.maConnexion.rset.getObject(i).toString());
                else 
                val.add( Integer.parseInt(controleur.maConnexion.rset.getObject(i).toString()));
            }
            j++;
        }
        
        /*for(int k = 0; k < titre.size()-1; k++)
        {   System.out.print("\t Le nb de lit: " + titre.get(k) + "\t |");
            System.out.print("\t Le nb de chambre: " + val.get(k) + "\t |");
        }  */
    }
    
   
    /**
     * Creates a sample dataset
     */
    private  PieDataset createDataset() {
        DefaultPieDataset result = new DefaultPieDataset();
        //result.setValue(titre.get(0), (Number) val.get(0));
        for (int i=0; i<titre.size();i++)
        {
           result.setValue(titre.get(i), (Number) val.get(i)); 
        }
        return result;

    }

    /**
     * Creates a chart
     */
    private JFreeChart createChart(PieDataset dataset, String title) {

        JFreeChart chart = ChartFactory.createPieChart3D(
            title,                  // chart title
            dataset,                // data
            true,                   // include legend
            true,
            false
        );

        PiePlot3D plot = (PiePlot3D) chart.getPlot();
        plot.setStartAngle(290);
        plot.setDirection(Rotation.CLOCKWISE);
        plot.setForegroundAlpha(0.5f);
        return chart;

    }
    
    public void affPieChart()
    {
        this.pack();
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
