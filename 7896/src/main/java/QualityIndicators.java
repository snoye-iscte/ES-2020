
public class QualityIndicators {

	private int DCI;
	private int DII;
	private int ADCI;
	private int ADII;
	private int count=0;
	
	private Defeito defeito = new Defeito();
	private getExcel get_excel = new getExcel();
	
	
	public int getDCI() {
		return DCI;
	}
	public int getDII() {
		return DII;
	}
	public int getADCI() {
		return ADCI;
	}
	public int getADII() {
		return ADII;
	}
	public int getCount() {
		return count;
	}
	public Defeito getDef() {
		return defeito;
	}
	public getExcel getGe() {
		return get_excel;
	}
	private boolean isDCI(){
		if((defeito.isPMD()||defeito.isiPlasma()) && defeito.isIs_long_method())
				return true;
		return false;
		
	}
	private boolean isDII(){
		if((defeito.isPMD()||defeito.isiPlasma()) && !defeito.isIs_long_method())
			return true;
		return false;
	}
	private boolean isADCI(){
		if((!defeito.isPMD()|| !defeito.isiPlasma()) && !defeito.isIs_long_method())
			return true;
		return false;
		
	}
	private boolean isADII(){
		if((!defeito.isPMD() || !defeito.isiPlasma()) && defeito.isIs_long_method())
			return true ;
		return false;
		
	}
	

	
	public int countDCI(){
			if(isDCI())
				count++;
			return ADCI;
			
			
			
		}
	
	
	
	
	public int countDII(){
		if(isDII())
			count++;
		
		return ADCI;
		
	}

	public int countADCI(){

		if(isDCI())
			count++;
		return ADCI;
	
	}

	public int countADII(){
		if(isDCI())
			count++;
		return ADCI;
	
	}
	
}