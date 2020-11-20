public class Defeito2 {
	public int method_ID;
	public String package_name;
	public String class_name;
	public String method_name;
	public int LOC;
	public int CYCLO;
	public int ATFD;
	public double LAA;
	public boolean is_long_method;
	public boolean iPlasma;
	public boolean PMD;
	public boolean is_feature_envy;
	
	public Defeito2(int method_ID, String package_name, String class_name, String method_name, int LOC, int CYCLO, int ATFD, double LAA, boolean is_long_method, boolean iPlasma, boolean PMD, boolean is_feature_envy) {
		this.method_ID = method_ID;
		this.package_name = package_name;
		this.class_name = class_name;
		this.method_name = method_name;
		this.LOC = LOC;
		this.CYCLO = CYCLO;
		this.ATFD = ATFD;
		this.LAA = LAA;
		this.is_long_method = is_long_method;
		this.iPlasma = iPlasma;
		this.PMD = PMD;
		this.is_feature_envy = is_feature_envy;
	}
	
	public String [] toArray() {
		return new String []{
			method_ID + "",
			package_name + "",
			class_name + "",
			method_name + "",
			LOC + "",
			CYCLO + "",
			ATFD + "",
			LAA + "",
			is_long_method + "",
			iPlasma + "",
			PMD + "",
			is_feature_envy + ""
		};
	}
	
	public String toString() {
		return "Defeito [method_ID=" + method_ID + ", package_name=" + package_name + ", class_name=" + class_name
				+ ", method_name=" + method_name + ", LOC=" + LOC + ", CYCLO=" + CYCLO + ", ATFD=" + ATFD + ", LAA="
				+ LAA + ", is_long_method=" + is_long_method + ", iPlasma=" + iPlasma + ", PMD=" + PMD
				+ ", is_feature_envy=" + is_feature_envy + "]";
	}
}

