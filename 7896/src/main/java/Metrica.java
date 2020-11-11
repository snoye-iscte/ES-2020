import java.awt.List;
import java.util.ArrayList;

public class Metrica {
	
	private getExcel getExcel;
	private String metricName;
	private int metricIntegerValue;
	private boolean metricBooleanValue;
	private Defeito defeito;
	
	public Metrica(ArrayList<Defeito> listaDefeitos) {
		for(Defeito defeito: listaDefeitos) {
			switch (defeito.getClass_name()) {
			case "LOC":
				
				break;

			default:
				break;
			}
		}
//		this.metricName = metricName;
//		this.metricIntegerValue = metricIntegerValue;
//		this.metricBooleanValue = metricBooleanValue;
	}
	
	
}
 