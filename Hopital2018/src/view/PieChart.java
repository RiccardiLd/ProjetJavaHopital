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
import org.jfree.data.general.DefaultKeyedValuesDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.util.Rotation;

/**
 *
 * @author Marie
 */
public class PieChart extends JFrame {

    private static final long serialVersionUID = 1L;
    PieDataset dataset;
    
        ArrayList<String> titre= new ArrayList();
        ArrayList val= new ArrayList();

    public PieChart() throws SQLException {
        super();
        //dataset = createDataset();
        JFreeChart chart = createChart(dataset,"");
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
        setContentPane(chartPanel);

    }

    /**
     *
     * @param controleur
     * @throws SQLException
     */
    @SuppressWarnings("UnusedAssignment")
    public void PieChambre(Controller controleur) throws SQLException
    {
        //DefaultPieDataset dataset = new DefaultPieDataset();
        controleur.maConnexion.query("SELECT nb_lits, COUNT(no_chambre) FROM `chambre` GROUP BY nb_lits");
        int i=1;
        //ArrayList<String> titre= new ArrayList();
        //ArrayList val= new ArrayList();
        while(controleur.maConnexion.rset.next()){
        
            if (i%2!=0)
            {
            //titre=(String) controleur.maConnexion.rset.getObject(i).toString();
            //titre.add((String) controleur.maConnexion.rset.getObject(i));
                titre.add("Coucou"+i);
            }
            else
            {
            //val=(int) controleur.maConnexion.rset.getObject(i);
            //val.add((int) controleur.maConnexion.rset.getObject(i));
                val.add(i);
            }
            i++;
            }
        dataset = createDataset();
    
    }
        
    
    private PieDataset createDataset() 
    {
        DefaultPieDataset result = new DefaultPieDataset();
        int j = 0;
        while (titre.size() > j) {
		System.out.println(titre.get(j));
                result.setValue((String)titre.get(j),(int) val.get(j));
		j++;
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
        /*
        for(int i = 0; i < title.size(); i++)
        {
            System.out.print("\t Le nb de lit: " + title.get(i) + "\t |");
            System.out.print("\t Le nb de chambre: " + value.get(i) + "\t |");
        }  */
        
       
        this.pack();
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
