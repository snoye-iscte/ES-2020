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
	
	public QualityIndicators(List<Defeito2> lines) {
		
		// Inicializar variáveis a zero
		iPlasma = 0;
		PMD = 0;
		DCI = 0;
		DII = 0;
		ADCI = 0;
		ADII = 0;
		
		// Gerar indicadores de qualidade
		
		Iterator<Defeito2> linesIterator = lines.iterator();
		while(linesIterator.hasNext()) {
			Defeito2 line = (Defeito2) linesIterator.next();

			
			iPlasma += line.iPlasma ? 1 : 0;
			PMD += line.PMD ? 1 : 0;
			DCI += (line.PMD || line.iPlasma) && line.is_long_method ? 1 : 0;
			DII += (line.PMD || line.iPlasma) && !line.is_long_method ? 1 : 0;
			ADCI += (!line.PMD || !line.iPlasma) && !line.is_long_method ? 1 : 0;
			ADII += (!line.PMD || !line.iPlasma) && line.is_long_method ? 1 : 0;
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
