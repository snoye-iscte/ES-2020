import java.util.List;

public class App 
{
    public static void main( String[] args )
    {

    	
    	GetExcel excel = new GetExcel();
    	List<Defeito> defeitos = excel.getListaDefeitos();
		Regra regra = new Regra(defeitos);
    	QualityIndicators qIndicators = new QualityIndicators(defeitos);
    	QualityIndicatorsChart QIChart = new QualityIndicatorsChart(qIndicators);
	 	
    	Gui gui = new Gui(excel);
		gui.start();
		gui.manage_gui(regra);
		gui.addChart(QIChart);
    }
}
