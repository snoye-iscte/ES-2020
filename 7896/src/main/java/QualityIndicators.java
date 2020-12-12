  
import java.util.Iterator;
import java.util.List;

import org.jfree.data.category.DefaultCategoryDataset;

public class QualityIndicators extends DefaultCategoryDataset implements QualityIndicatorsInterface {
	List<Defeito> lines;
	RegrasDoPedro rule;
	private int iPlasma;
	private int PMD;
	private int DCI;
	private int DII;
	private int ADCI;
	private int ADII;
	QualityIndicatorsChartInterface i;
	
	/**
	 * ...
	 * Quality Indicators Class. It while iterate across Excel cells and add some of the indicated values. 
	 * @author Pedro
	 * @param defect,  ArrayList of the attributes we want to select and count. 
	 */
	public QualityIndicators(List<Defeito> lines) {
		this.lines = lines;
		
		// Inicializar variáveis a zero
		rule = new RegrasDoPedro();
		iPlasma = 0;
		PMD = 0;
		DCI = 0;
		DII = 0;
		ADCI = 0;
		ADII = 0;
		
		// Gerar indicadores de qualidade
		generate();
		
		// Create dataset
		createDataset();
	}
	
	public void setListener(QualityIndicatorsChart i) {
		this.i = i;
	}
	
	/**
	 * while it iterates over all defects tools as PMD e iPlasma, the graph will increments when they are true.
	 *  The bar Chart will increment or decrement as well, when the user defines a new rule.  
	 */
	private void generate() {
		Iterator<Defeito> linesIterator = lines.iterator();
		while(linesIterator.hasNext()) {
			Defeito line = (Defeito) linesIterator.next();
			iPlasma += line.isiPlasma() ? 1 :0;
			PMD += line.isPMD() ? 1 :0;
			DCI += (line.isPMD() || line.isiPlasma()) && rule.valid(line) ? 1 : 0;
			DII += (line.isPMD() || line.isiPlasma()) && !rule.valid(line) ? 1 : 0;
			ADCI += (!line.isPMD() || !line.isiPlasma()) && !rule.valid(line) ? 1 : 0;
			ADII += (!line.isPMD() || !line.isiPlasma()) && rule.valid(line) ? 1 : 0;
		}
	}
	
	
	/**
	 * Put names on each axes
	 */
	private void createDataset() {
        setValue(iPlasma, "Numero", "iPlasma");
        setValue(PMD, "Numero", "PMD");
        setValue(DCI, "Numero", "DCI");
        setValue(DII, "Numero", "DII");
        setValue(ADCI, "Numero", "ADCI");
        setValue(ADII, "Numero", "ADII");
	}

	
	@Override
	public void update(RegrasDoPedro rule) {
		this.rule = rule;
		generate();
		createDataset();
		// Atualizar Quality Indicators Chart
		if(i != null)
			i.update(this);
	}
}