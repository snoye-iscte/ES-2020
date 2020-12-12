package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import pt.iscte.es.*;

class RegrasTest {

	@Test
	void test() {
		Regras rule = new Regras();
	
		assertEquals(80, rule.threshold1);
		assertEquals(DefectEnum.isLongMethod,rule.defectEnum);
		assertEquals(10  , rule.threshold2);
		assertEquals(OperationEnum.AND, rule.operation);
		
	}

}
