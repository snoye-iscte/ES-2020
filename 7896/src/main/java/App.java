import java.util.List;

public class App 
{
    public static void main( String[] args )
    {
    	//* A classe GUI deve receber a classe Excel, uma classe de interação (alterar os thresholds) e
   	 // a classe QualityIndicators.
    	
    	GetExcel excel = new GetExcel();
    	List<Defeito2> defeitos = excel.getDefts();
		RegraUI regra = new RegraUI(defeitos);
    	QualityIndicators qIndicators = new QualityIndicators(defeitos);
    	QualityIndicatorsChart QIChart = new QualityIndicatorsChart(qIndicators);
	 	
    	Gui gui = new Gui(excel);
		gui.start();
		gui.addPanelRegra(regra);
		gui.addChart(QIChart);
		gui.pack();
    }
}
