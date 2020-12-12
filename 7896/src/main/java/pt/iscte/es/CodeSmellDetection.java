package pt.iscte.es;
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

	/**
	 * Method that identifies CodeSmell taking into account the LAA and ATFD metrics entered as a parameter 
	 * 
	 * 
	 * @author Isaías
	 * @return boolean
	 * @param atfdThreshold
	 * @param laaThreshold
	 * @param defect
	 */
	public boolean isFeatureEnvy(int atfdThreshold, int laaThreshold, Defeito defect) {
		boolean is_feature_envy = false;
		if(defect.getATFD() > atfdThreshold && defect.getLAA() < laaThreshold) 
			is_feature_envy = true;
		return is_feature_envy;
	}

	/**
	 * Method that identifies CodeSmell taking into account the LAA and ATFD metrics;
	 * 
	 * 
	 * @author Isaías
	 * @return boolean
	 * 
	 */
	public boolean isFeatureEnvy() {
		boolean is_feature_envy = false;
		if(defeito.getATFD() > 4 && defeito.getLAA() < 0.428571) 
			is_feature_envy = true;
		return is_feature_envy;
	}

	/**
	 * Method that identifies CodeSmell taking into account the LOC and CYCLO metrics entered as a parameter
	 * 
	 * @author Isaías
	 * @return boolean
	 * @param loc_threshold
	 * @param cyclo_threshold
	 * @param defect
	 */
	public boolean isLongMethod(int loc_threshold, int cyclo_threshold, Defeito defect) {
		boolean is_long_method = false;
		if(defect.getLOC() > loc_threshold && defect.getCYCLO() > cyclo_threshold)
			is_long_method = true;
		return is_long_method;
	}

	/**
	 * Method that identifies CodeSmell taking into account the LOC and CYCLO metrics ;
	 * 
	 * @author Isaías
	 * @return boolean
	 * 
	 */
	public boolean isLongMethod() {
		boolean is_long_method = false;
		if(defeito.getLOC() > 80 && defeito.getCYCLO() > 10)
			is_long_method = true;
		return is_long_method;
	}

	/**
	 * Method that store in a Vector the result of quality of tool defect detection using quality indicators
	 * 
	 * 
	 * @author Isaías
	 * @param MethodID
	 * @param toolResult
	 * @param isLongMethod
	 * @return Vector
	 */
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
