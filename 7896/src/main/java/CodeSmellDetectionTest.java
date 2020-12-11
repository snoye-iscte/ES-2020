import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CodeSmellDetectionTest {

	@Test
	public void checkQualityEvaluation() {
		CodeSmellDetection detection = new CodeSmellDetection();
		assertEquals(detection.getVetorElement(detection.qualityEvaluation(1, true, true), 0), 1);
		assertEquals(detection.qualityEvaluation(1, true, false).size(), 4);
	}
	
	@Test
	public void checkIsFeatureEnvy() {
		CodeSmellDetection detection = new CodeSmellDetection();
		Defeito defect = new Defeito();
		defect.setATFD(5);
		defect.setLAA(0.3);
		detection.setDefeito(defect);
		assertEquals(detection.isFeatureEnvy(), true);
	}
	
	@Test
	public void checkIsLongMethod() {
		CodeSmellDetection detection = new CodeSmellDetection();
		Defeito defect = new Defeito();
		defect.setLOC(50);
		defect.setCYCLO(12);
		detection.setDefeito(defect);
		assertEquals(detection.isLongMethod(), false);
	}

}
