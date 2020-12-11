import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.runner.RunWith;
import org.junit.runner.Runner;

import junit.framework.Assert;

public class EnumTest{


	@BeforeAll
	static void inicitialize() throws Exception {
	
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
	void testMetrics1() {
		Metric metric1 =  Metric.LOC;
		Metric metric2 =  Metric.CYCLO;
		Metric metric3 =  Metric.ATFD;
		Metric metric4 =  Metric.LAA;
		
		assertEquals(Metric.valueOf("LOC"), metric1);
		assertEquals(Metric.valueOf("CYCLO"), metric2);
		assertEquals(Metric.valueOf("ATFD"), metric3);
		assertEquals(Metric.valueOf("LAA"), metric4);

		

	}



}
