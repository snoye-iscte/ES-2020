
public class Defeito { //classe feita para guardar defeitos/aramzenar
	
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
	
	public Defeito() {
		toString();
	}
	
	

	public int getMethod_ID() {
		return method_ID;
	}
	public void setMethod_ID(int method_ID) {
		this.method_ID = method_ID;
	}
	public String getPackage_name() {
		return package_name;
	}
	public void setPackage_name(String package_name) {
		this.package_name = package_name;
	}
	public String getClass_name() {
		return class_name;
	}
	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}
	public String getMethod_name() {
		return method_name;
	}
	public void setMethod_name(String method_name) {
		this.method_name = method_name;
	}
	public int getLOC() {
		return LOC;
	}
	public void setLOC(int lOC) {
		LOC = lOC;
	}
	public int getCYCLO() {
		return CYCLO;
	}
	public void setCYCLO(int cYCLO) {
		CYCLO = cYCLO;
	}
	public int getATFD() {
		return ATFD;
	}
	public void setATFD(int aTFD) {
		ATFD = aTFD;
	}
	public double getLAA() {
		return LAA;
	}
	public void setLAA(double lAA) {
		LAA = lAA;
	}
	public boolean isIs_long_method() {
		return is_long_method;
	}
	public void setIs_long_method(boolean is_long_method) {
		this.is_long_method = is_long_method;
	}
	public boolean isiPlasma() {
		return iPlasma;
	}
	public void setiPlasma(boolean iPlasma) {
		this.iPlasma = iPlasma;
	}
	public boolean isPMD() {
		return PMD;
	}
	public void setPMD(boolean pMD) {
		PMD = pMD;
	}
	public boolean isIs_feature_envy() {
		return is_feature_envy;
	}
	public void setIs_feature_envy(boolean is_feature_envy) {
		this.is_feature_envy = is_feature_envy;
	}

	
	public String toString() {
		return "Defeito [method_ID=" + method_ID + ", package_name=" + package_name + ", class_name=" + class_name
				+ ", method_name=" + method_name + ", LOC=" + LOC + ", CYCLO=" + CYCLO + ", ATFD=" + ATFD + ", LAA="
				+ LAA + ", is_long_method=" + is_long_method + ", iPlasma=" + iPlasma + ", PMD=" + PMD
				+ ", is_feature_envy=" + is_feature_envy + "]";
	}


	
}

