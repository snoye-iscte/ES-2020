import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;


public class QualityIndicatorsChart extends JPanel implements QualityIndicatorsChartInterface {

    public QualityIndicatorsChart(QualityIndicators qi) {
        setChart(qi);
    }   
    /**
     * 
     * Initicialize a Chart with QI dataset and builds some caratcteristcs such as space between borders and sets a color for the background. 
     * 
     * @author Pedro
     * @param dataset
     * 
     **/
    private void setChart(QualityIndicators dataset) {
    	JFreeChart chart = createChart(dataset);
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setBorder(BorderFactory.createEmptyBorder(100,100,100,100));
        chartPanel.setBackground(Color.white);
        add(chartPanel);
        chartPanel.setVisible(true);
    }
    
	
    /**
	 * This method Creates a bar chart. The chart object returned by this method uses a CategoryPlot instance as the plot, with a CategoryAxis for the domain axis, a NumberAxis as the range axis, and a BarRenderer as the renderer.
	 * createBarChart(String title, String categoryAxisLabel, String valueAxisLabel, CategoryDataset dataset,
	 * PlotOrientation orientation, 
	 * boolean legend, boolean tooltips, boolean urls)
	 * 
	 * 
	 * @author Pedro
	 * @param dataset,  from class CategoryDataset
	 * @return barchart
	 */
    private JFreeChart createChart(CategoryDataset dataset) {
        JFreeChart barChart = ChartFactory.createBarChart(
                "Indicadores de Qualidade",
                "",
                "Número",
                dataset,
                PlotOrientation.VERTICAL,
                false, true, false);

        return barChart;
    }
    
    @Override
    public void update(QualityIndicators qi) {
		setChart(qi);
	}
	
}  
