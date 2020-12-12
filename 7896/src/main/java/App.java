import java.util.List;

public class App 
{
    public static void main( String[] args )
    {
    	//* A classe GUI deve receber a classe Excel, uma classe de interação (alterar os thresholds) e
   	 // a classe QualityIndicators.
    	
    	getExcel excel = new getExcel();
    	List<Defeito> defeitos = excel.getListaDefeitos();
    	
    	RegraUi ruleUI = new RegraUi(defeitos);
		RegrasDoPedro rule = new RegrasDoPedro(); // Default rule
    	
		
    	QualityIndicators qIndicators = new QualityIndicators(defeitos);
    	QualityIndicatorsChart QIChart = new QualityIndicatorsChart(qIndicators);
	 	
    	ruleUI.setListener(rule);
		rule.setListener(qIndicators);
    	qIndicators.setListener(QIChart);
    	
    	Gui gui = new Gui(excel);
		gui.start();
		gui.addPanelRegra(ruleUI);
		gui.addChart(QIChart);
		gui.pack();
    }
}
