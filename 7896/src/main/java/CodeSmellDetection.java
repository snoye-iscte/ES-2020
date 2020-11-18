import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JPanel;

public class CodeSmellDetection extends JPanel{

	private List<String> metricas = new ArrayList<String>();
	private List<String> defeitos = new ArrayList<String>();

	private int method_ID;
	private String package_name;
	private String class_name;
	private String method_name;
	private int LOC;
	private int CYCLO;
	private int ATFD;
	private double LAA;
	private boolean is_long_method;
	private boolean iPlasma;
	private boolean PMD;
	private boolean is_feature_envy;

	public CodeSmellDetection() {
		// TODO Auto-generated constructor stub
	}
	
	public boolean isLongMethod() {
		metricas.addAll(Arrays.asList("LOC", "CYCLO", "ATFD", "LAA"));
		defeitos.addAll(Arrays.asList("is_long_method", "iPlasma", "PMDD", "is_feature_envy"));

		boolean is_long_method = false;

		for(String defeito: defeitos) {
			if(defeito.equals("is_long_method")) {
				if(LOC >80 && CYCLO > 10)
					is_long_method = true;
			}
		}
		return is_long_method;
	}
	
	public boolean isFeatureEnvy() {
		metricas.addAll(Arrays.asList("LOC", "CYCLO", "ATFD", "LAA"));
		defeitos.addAll(Arrays.asList("is_long_method", "iPlasma", "PMDD", "is_feature_envy"));

		boolean is_feature_envy = false;

		for(String defeito: defeitos) {
			if(defeito.equals("is_feature_envy")) {
				if(ATFD > 4 && LAA < 0.428571)
					is_feature_envy = true;
			}
		}
		return is_feature_envy;
	}
	
		public void detectionResult() {

	}


}
