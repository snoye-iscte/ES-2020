
import java.util.Iterator;
import java.util.List;

import org.jfree.data.category.DefaultCategoryDataset;

public class QualityIndicators extends DefaultCategoryDataset {
	private int iPlasma;
	private int PMD;
	private int DCI;
	private int DII;
	private int ADCI;
	private int ADII;
	
	/**
	 * 
	 * @param defect
	 */
	//public QualityIndicators(List<ExcelLine> lines) {
	public QualityIndicators(List<Defeito> lines) {
		
		// Inicializar variáveis a zero
		iPlasma = 0;
		PMD = 0;
		DCI = 0;
		DII = 0;
		ADCI = 0;
		ADII = 0;
		
		// Gerar indicadores de qualidade
		//Iterator<ExcelLine> linesIterator = lines.iterator();
		Iterator<Defeito> linesIterator = lines.iterator();
		while(linesIterator.hasNext()) {
			Defeito line = (Defeito) linesIterator.next();

			
			iPlasma += line.isiPlasma() ? 1 :0;
			PMD += line.isPMD() ? 1 :0;
			DCI += (line.isPMD() || line.isiPlasma()) && line.isIs_long_method() ? 1 : 0;
			DII += (line.isPMD() || line.isiPlasma()) && !line.isIs_long_method() ? 1 : 0;
			ADCI += (!line.isPMD() || !line.isiPlasma()) && !line.isIs_long_method() ? 1 : 0;
			ADII += (!line.isPMD() || !line.isiPlasma()) && line.isIs_long_method() ? 1 : 0;
			
		}
		
		
		// Create dataset
        setValue(iPlasma, "Numero", "iPlasma");
        setValue(PMD, "Numero", "PMD");
        setValue(DCI, "Numero", "DCI");
        setValue(DII, "Numero", "DII");
        setValue(ADCI, "Numero", "ADCI");
        setValue(ADII, "Numero", "ADII");
	}
}
