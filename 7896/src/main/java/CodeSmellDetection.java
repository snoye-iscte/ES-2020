import javax.swing.JPanel;

public class CodeSmellDetection extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CodeSmellDetection() {
		// TODO Auto-generated constructor stub
	}

	public boolean isFeatureEnvy(int atfdTheshold, int laaThreshold, Defeito2 defect) {
		return (defect.ATFD > 4 && defect.LAA < 0.428571) ;
	
	}

	public boolean isLongMethod(int loc_threshold, int cyclo_threshold, Defeito2 defect) {
		return (defect.LOC> loc_threshold && defect.CYCLO > cyclo_threshold);
		
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
