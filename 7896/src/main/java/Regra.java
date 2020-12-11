import java.util.List;

public class Regra implements RegraInterface {
	Defect defect;
	Metric metric1;
	int threshold1;
	Operation operation;
	Metric metric2;
	int threshold2;
	QualityIndicatorsInterface i;
	
	public Regra() {
		defect = Defect.isLongMethod;
		metric1 = Metric.LOC;
		threshold1 = 80;
		operation = Operation.AND;
		metric2 = Metric.CYCLO;
		threshold2 = 10;
		i = null;
	}
	
	public Regra(Defect defect, Metric metric1, int threshold1, Metric metric2, int threshold2) {
		this.defect = defect;
		this.metric1 = metric1;
		this.threshold1 = threshold1;
		this.metric2 = metric2;
		this.threshold2 = threshold2;
	}
	/**
	 * 
	 * All combinations of metrics  a user can edit in Gui Combo boxes
	 * This method will validate each combination
	 * @author pedro
	 * @param line
	 * @return the value of metric when it is greater than the threshold by omission
	 */
	public boolean valid(Defeito line) {
		double firstMetric;
		double secondMetric;
		if(metric1 == Metric.LOC) {
			firstMetric = line.getLOC();
		} else if(metric1 == Metric.CYCLO) {
			firstMetric = line.getCYCLO();
		} else if(metric1 == Metric.ATFD) {
			firstMetric = line.getATFD();
		} else {
			firstMetric = line.getLAA();
		}
		if(metric2 == Metric.LOC) {
			secondMetric = line.getLOC();
		} else if(metric2 == Metric.CYCLO) {
			secondMetric = line.getCYCLO();
		} else if(metric2 == Metric.ATFD) {
			secondMetric = line.getATFD();
		} else {
			secondMetric = line.getLAA();
		}
		
		if(operation == Operation.AND) {
			return firstMetric > threshold1 && secondMetric > threshold2;
		}
		return firstMetric > threshold1 || secondMetric > threshold2;
	}
	/*
	 * 
	 * Updates Regra in GUI 
	 * all the this @param appear in Gui inside  boxes , in which a user can edit
	 * @author pedro
	 * @param defect
	 * @param metric1
	 * @param threshold1
	 * @param operation
	 * @param metric2
	 * @param threshold2
	 */
	@Override
	public void update(Defect defect, Metric metric1, int threshold1, Operation operation, Metric metric2, int threshold2) {
		this.defect = defect;
		this.metric1 = metric1;
		this.threshold1 = threshold1;
		this.operation = operation;
		this.metric2 = metric2;
		this.threshold2 = threshold2;
		// Update Quality Indicators
		if(i != null) {
			i.update(this);
		}
	}

	public void setListener(QualityIndicatorsInterface i) {
		this.i = i;
	}
}
