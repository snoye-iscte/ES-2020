import java.util.List;

public class App
{
    public static void main( String[] args )
    {
    	// Inicializações
    	getExcel excel = new getExcel();
    	List<Defeito> defeitos = excel.getListaDefeitos();
		RegraUI ruleUI = new RegraUI(defeitos);
		Regra rule = new Regra(); // Default rule
    	QualityIndicators qIndicators = new QualityIndicators(defeitos);
    	QualityIndicatorsChart QIChart = new QualityIndicatorsChart(qIndicators);
    	
    	// Listeners
		ruleUI.setListener(rule);
		rule.setListener(qIndicators);
    	qIndicators.setListener(QIChart);
		
		// GUI
    	Gui gui = new Gui(excel);
		gui.start();
		gui.addPanelRegra(ruleUI);
		gui.addChart(QIChart);
		gui.pack();
    }
}