/*  Created by riccardild on Apr 17, 2018 11:21:32 AM
 *  (C) Copyright Gianni Riccardi.
 */
package view;

import controller.Controller;
import java.sql.SQLException;
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

    public PieChart(String applicationTitle, String chartTitle) {
        super(applicationTitle);
        // This will create the dataset
        dataset = createDataset();
        // based on the dataset we create the chart
        JFreeChart chart = createChart(dataset, chartTitle);
        // we put the chart into a panel
        ChartPanel chartPanel = new ChartPanel(chart);
        // default size
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
        // add it to our application
        setContentPane(chartPanel);

    }
    
    public PieChart() throws SQLException {
        super();
        dataset = createDataset();
        JFreeChart chart = createChart(dataset,"");
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
        setContentPane(chartPanel);

    }

    public void PieChambre(Controller controleur) throws SQLException
    {
        controleur.maConnexion.query("SELECT nb_lits, COUNT(no_chambre) FROM `chambre` GROUP BY nb_lits");
        /*for(int i = 1; i <= controleur.maConnexion.rset.getFetchSize(); i++)
        {
            System.out.println(controleur.maConnexion.rset.getInt(i));
            
        }*/
        
        while(controleur.maConnexion.rset.next()){
          
            for(int i = 1; i <= controleur.maConnexion.rsetMeta.getColumnCount(); i++)
            {
                System.out.print("\t" + controleur.maConnexion.rset.getObject(i).toString() + "\t |");
            }
        }
    }
    
    
    public void modifDataset(String value, int nb)
    {
       //dataset = createDataset();
       //dataset.setValue(value, nb); 
       //dataset.setValue("Linux", 29);
    }
    /**
     * Creates a sample dataset
     */
    private  PieDataset createDataset() {
        DefaultPieDataset result = new DefaultPieDataset();
        result.setValue("Linux", 29);
        result.setValue("Mac", 21);
        //result.setValue("Windows", 49);
        //result.setValue("Other", 1);
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
