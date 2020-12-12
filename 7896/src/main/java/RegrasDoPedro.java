import java.rmi.server.Operation;

public class RegrasDoPedro implements RegraInterface {
	DefectEnum defectEnum;
	MetricEnum metric1;
	int threshold1;
	OperationEnum operation;
	MetricEnum metric2;
	int threshold2;
	QualityIndicatorsInterface i;
	
	public RegrasDoPedro() {
		defectEnum = DefectEnum.isLongMethod;
		metric1 = MetricEnum.LOC;
		threshold1 = 80;
		operation = OperationEnum.AND;
		metric2 = MetricEnum.CYCLO;
		threshold2 = 10;
		i = null;
	}
	
	public RegrasDoPedro(DefectEnum defectEnum, MetricEnum metric1, int threshold1, MetricEnum metric2, int threshold2) {
		this.defectEnum = defectEnum;
		this.metric1 = metric1;
		this.threshold1 = threshold1;
		this.metric2 = metric2;
		this.threshold2 = threshold2;
	}
	/**
	 * 
	 * All combinations of metrics  a user can edit in Gui Combo boxes
	 * This method will validate each combination
	 * @author Eduardo and Pedro
	 * @param line
	 * @return the value of metric when it is greater than the threshold by omission
	 */
	public boolean valid(Defeito line) {
		double firstMetric;
		double secondMetric;
		if(metric1 == MetricEnum.LOC) {
			firstMetric = line.getLOC();
		} else if(metric1 == MetricEnum.CYCLO) {
			firstMetric = line.getCYCLO();
		} else if(metric1 == MetricEnum.ATFD) {
			firstMetric = line.getATFD();
		} else {
			firstMetric = line.getLAA();
		}
		if(metric2 == MetricEnum.LOC) {
			secondMetric = line.getLOC();
		} else if(metric2 == MetricEnum.CYCLO) {
			secondMetric = line.getCYCLO();
		} else if(metric2 == MetricEnum.ATFD) {
			secondMetric = line.getATFD();
		} else {
			secondMetric = line.getLAA();
		}
		
		if(operation == OperationEnum.AND) {
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
	public void update(DefectEnum defectEnum, MetricEnum metric1, int threshold1, OperationEnum operation, MetricEnum metric2, int threshold2) {
		this.defectEnum = defectEnum;
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
