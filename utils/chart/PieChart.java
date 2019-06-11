/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package utils.chart;

import java.util.Map;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

/**
 * Cette classe permet de générer des camembert (Secteur)
 * @author CHAABANA Yanis
 * 
 * Source : 
 *  - http://www.jfree.org/jfreechart/
 *  - https://www.tutorialspoint.com/jfreechart/
 *  - https://www.tutorialspoint.com/jfreechart/jfreechart_pie_chart.htm
 */
public class PieChart {
    private PieChart(){
    }
    
    public static JFreeChart createChart(String chartTitle, Map<String, Double> mapData ) {
        DefaultPieDataset dataset = new DefaultPieDataset( );
        
        for (String key : mapData.keySet()){
            dataset.setValue( key, mapData.get(key) );
        }
        
        return createChart(chartTitle, dataset);
    }
    
    public static JFreeChart createChart(String chartTitle, PieDataset dataset ) {
      JFreeChart chart = ChartFactory.createPieChart(      
         chartTitle,   // chart title 
         dataset,      // data    
         true,         // include legend   
         true, 
         false);

      return chart;
   }
    
    public static JFreeChart createChart3D(String chartTitle, Map<String, Double> mapData ) {
        DefaultPieDataset dataset = new DefaultPieDataset( );
        
        for (String key : mapData.keySet()){
            dataset.setValue( key, mapData.get(key) );
        }
        
        return createChart3D(chartTitle, dataset);
    }
    
    public static JFreeChart createChart3D(String chartTitle, PieDataset dataset ) {
      JFreeChart chart = ChartFactory.createPieChart3D(      
         chartTitle,   // chart title 
         dataset,      // data    
         true,         // include legend   
         true, 
         false);

      return chart;
   }
}
