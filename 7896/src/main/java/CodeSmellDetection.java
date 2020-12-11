import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

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

	public boolean isPMD(int MethodID, boolean isPmd) {
		return isPmd;
	}

	public boolean isIPlasma() {
		return isLongMethod();
	}

	public boolean isIPlasma(int MethodID, boolean isIPlasma) {
		return isIPlasma;
	}

	public Vector<Integer> qualityEvaluation(int MethodID, boolean toolResult, boolean isLongMethod ) {
		Vector<Integer> result =  new Vector<Integer>(4);
		int DCI = 0;
		int DII = 0;
		int ADCI = 0;
		int ADII = 0;
		
		if(isLongMethod == true && toolResult == true) {
			DCI++;
		}else if(isLongMethod == false && toolResult == true) {
			DII++;
		}else if(isLongMethod == false && toolResult == false) {
			ADCI++;
		}else if(isLongMethod == true && toolResult == false) {
			ADII++;
		}
		
		result.add(0, DCI);
		result.add(1,DII);
		result.add(2,ADCI);
		result.add(3,ADII);
		
		return result;
	}

	public int getVetorElement(Vector<Integer> vector, int position) {
		return vector.get(position);  
	}
	
	public Defeito getDefeito() {
		return defeito;
	}
	
	public void setDefeito(Defeito defeito) {
		this.defeito = defeito;
	}
}
