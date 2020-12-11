import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RegraTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() {
		Regra rule = new Regra();
		
		assertEquals(80  , rule.threshold1);
		assertEquals(Defect.isLongMethod,rule.defect);
		assertEquals(10  , rule.threshold2);
		assertEquals(Operation.AND, rule.operation);
		
		fail("Not yet implemented");
	}

//	}
		

}
