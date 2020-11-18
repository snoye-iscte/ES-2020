import javax.swing.JPanel;

public class CodeSmellDetection extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CodeSmellDetection() {
		// TODO Auto-generated constructor stub
	}

	public boolean isFeatureEnvy(int atfdTheshold, int laaThreshold, Defeito defect) {
		boolean is_feature_envy = false;
		if(defect.getATFD() > 4 && defect.getLAA() < 0.428571) 
			is_feature_envy = true;
		return is_feature_envy;
	}

	public boolean isLongMethod(int loc_threshold, int cyclo_threshold, Defeito defeito) {
		boolean is_long_method = false;
		if(defeito.getLOC() > loc_threshold && defeito.getCYCLO() > cyclo_threshold)
			is_long_method = true;
		return is_long_method;
	}

	//	public boolean isFeatureEnvy() {
	//	metricas.addAll(Arrays.asList("LOC", "CYCLO", "ATFD", "LAA"));
	//	defeitos.addAll(Arrays.asList("is_long_method", "iPlasma", "PMDD", "is_feature_envy"));
	//
	//	boolean is_feature_envy = false;
	//
	//	for(String defeito: defeitos) {
	//		if(defeito.equals("is_feature_envy")) {
	//			if(ATFD > 4 && LAA < 0.428571)
	//				is_feature_envy = true;
	//		}
	//	}
	//	return is_feature_envy;
	//}

	public void detectionResult() {

	}


}
