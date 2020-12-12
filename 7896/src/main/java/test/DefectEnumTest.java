package test;

import org.junit.jupiter.api.Test;

import pt.iscte.es.MetricEnum;

import static org.junit.Assert.assertEquals;
public class DefectEnumTest{

	@Test
	void testMetrics1() {
		MetricEnum metric1 =  MetricEnum.LOC;
		MetricEnum metric2 =  MetricEnum.CYCLO;
		MetricEnum metric3 =  MetricEnum.ATFD;
		MetricEnum metric4 =  MetricEnum.LAA;
		
		assertEquals(MetricEnum.valueOf("LOC"), metric1);
		assertEquals(MetricEnum.valueOf("CYCLO"), metric2);
		assertEquals(MetricEnum.valueOf("ATFD"), metric3);
		assertEquals(MetricEnum.valueOf("LAA"), metric4);


	}



}

