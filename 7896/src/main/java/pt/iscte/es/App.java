package pt.iscte.es;
import java.util.List;

public class App 
{
    public static void main( String[] args )
    {
    	//* A classe GUI deve receber a classe Excel, uma classe de interação (alterar os thresholds) e
   	 // a classe QualityIndicators.
    	
    	GetExcel excel = new GetExcel();
    	List<Defeito> defeitos = excel.getListaDefeitos();
    	
    	RegraUi ruleUI = new RegraUi(defeitos);
		Regras rule = new Regras(); // Default rule
    	
		
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
