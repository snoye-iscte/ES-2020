import javax.swing.JPanel;

public class CodeSmellDetection extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Defeito defeito = new Defeito();
	public CodeSmellDetection() {
		// TODO Auto-generated constructor stub
	}

	public boolean isFeatureEnvy(int atfdThreshold, int laaThreshold, Defeito defect) {
		boolean is_feature_envy = false;
		if(defect.getATFD() > atfdThreshold && defect.getLAA() < laaThreshold) 
			is_feature_envy = true;
		return is_feature_envy;
	}

	public boolean isFeatureEnvy() {
		boolean is_feature_envy = false;
		if(defeito.getATFD() > 4 && defeito.getLAA() < 0.428571) 
			is_feature_envy = true;
		return is_feature_envy;
	}
	
	public boolean isLongMethod(int loc_threshold, int cyclo_threshold, Defeito defect) {
		boolean is_long_method = false;
		if(defect.getLOC() > loc_threshold && defect.getCYCLO() > cyclo_threshold)
			is_long_method = true;
		return is_long_method;
	}
	
	public boolean isLongMethod() {
		boolean is_long_method = false;
		if(defeito.getLOC() > 80 && defeito.getCYCLO() > 10)
			is_long_method = true;
		return is_long_method;
	}
	
	public boolean isPMD() {
		return isLongMethod();
	}
	
	public boolean isIPlasma() {
		return isLongMethod();
	}

	/*Em classe defeitos adicionar as métricas como parametro no metodo dos defeitos
	public boolean isIs_long_method(int LOC, int CYCLO) {
		super(LOC, CYCLO)
		return is_long_method;
	}*/


}
