import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.EventQueue;

public class GetChart extends JPanel {
	
	QualityIndicators quality_indicator = new QualityIndicators();
	
	
	public void createChart() {
		
        initUI();
    }

    private void initUI() {

        CategoryDataset dataset = createDataset();

        JFreeChart chart = createChart(dataset);
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));
        chartPanel.setBackground(Color.white);
        add(chartPanel);

     
    }

    private CategoryDataset createDataset() {

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.setValue(quality_indicator.countDCI(), "Numero", "DCI");
        dataset.setValue(quality_indicator.countDII(), "Numero", "DII");
        dataset.setValue(quality_indicator.countADCI(), "Numero", "ADCI");
        dataset.setValue(quality_indicator.countADII(), "Numero", "ADII");

        return dataset;
    }

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