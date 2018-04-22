/*  Created by riccardild on Apr 17, 2018 11:21:32 AM
 *  (C) Copyright Gianni Riccardi, Théo Minier, Marie-Claire Belamy.
 */
package view;

import controller.Controller;
import java.sql.SQLException;
import java.util.ArrayList;
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
 * @author theo
 * @author marie-claire
 */
public class PieChart extends JFrame {

    private static final long serialVersionUID = 1L;
    PieDataset dataset;
    ArrayList<String> titre = new ArrayList();
    ArrayList<Number> val = new ArrayList();

    /**
     * Le constructeur de PieChart
     * @param controleur le controleur principal du projet
     * @param strQuery la requête sql pour le PieChart
     * @param Tfen nom de base de la fenêtre
     * @throws SQLException 
     */
    public PieChart(Controller controleur, String strQuery, String Tfen) throws SQLException {
        super(Tfen);
        this.createPieChart(controleur, strQuery);
        dataset = createDataset();
        JFreeChart chart = createChart(dataset,"");
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(700, 370));
        setContentPane(chartPanel);
    }

    /**
     * Créé un PieChart avec la requête réalisée
     * @param controleur le controleur pricipal du projet
     * @param strQuery la requête qui instancie le PieChart
     * @throws SQLException 
     */
    public void createPieChart(Controller controleur, String strQuery) throws SQLException
    {
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
    }
    /**
     * Creates a sample dataset
     */
    private  PieDataset createDataset() {
        DefaultPieDataset result = new DefaultPieDataset();
        for (int i=0; i<titre.size();i++)
        {
           result.setValue(titre.get(i), val.get(i)); 
        }
        return result;
    }
    /**
     * Créé un Chart
     * @param dataset
     * @param title
     * @return 
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
    /**
     * Affiche le PieChart
     */
    public void affPieChart()
    {
        this.pack();
        this.setVisible(true);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
}
