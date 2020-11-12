
public class QualityIndicators {

	private int DCI;
	private int DII;
	private int ADCI;
	private int ADII;
	private int count=0;
	
	private Defeito def = new Defeito();
	private getExcel ge = new getExcel();
	
	
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
		return def;
	}
	public getExcel getGe() {
		return ge;
	}
	private boolean isDCI(){
		if((def.isPMD()||def.isiPlasma()) && def.isIs_long_method())
				return true;
		return false;
		
	}
	private boolean isDII(){
		if((def.isPMD()||def.isiPlasma()) && !def.isIs_long_method())
			return true;
		return false;
	}
	private boolean isADCI(){
		if((!def.isPMD()|| !def.isiPlasma()) && !def.isIs_long_method())
			return true;
		return false;
		
	}
	private boolean isADII(){
		if((!def.isPMD() || !def.isiPlasma()) && def.isIs_long_method())
			return true ;
		return false;
		
	}
	

	
	public int countDCI(){
		//for ( int  : iterable) {
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