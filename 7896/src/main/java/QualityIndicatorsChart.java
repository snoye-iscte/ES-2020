import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.ui.Size2D;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import java.awt.Color;

public class QualityIndicatorsChart extends JPanel {

    public QualityIndicatorsChart(QualityIndicators dataset) {
        JFreeChart chart = createChart(dataset);
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setBorder(BorderFactory.createEmptyBorder(100,100,100,100));
        chartPanel.setBackground(Color.white);
        add(chartPanel);
        chartPanel.setVisible(true);
    }
    
	/**
	 * 
	 * @param dataset
	 * @return barchart , 
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
   
}  