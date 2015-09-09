package core;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.Collection;
import java.util.Arrays;

import org.junit.BeforeClass;
import org.junit.ComparisonFailure;

import org.junit.Test;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;


@RunWith(Parameterized.class)

public class SeleniumTest {

	@BeforeClass
	public static void BeforeClass01() throws Exception
	{
		
	}
		// Test data generator
		@Parameters(name = "Iteration # {index} : exp: {1}; act: {2}")
		public static Collection <String[]> data() throws IOException {
			core.Selenium selen = new core.Selenium();
			return Arrays.asList(selen.b2d());
		}
		// Parameter for Field injection instead of Constructor
		@Parameter(value = 0)
		public String test_id;
		
		@Parameter(value = 1)
		public String exp_result;
		
		@Parameter(value = 2)
		public String act_result;
		
		@Test
		public void test_Title_Validation() throws ComparisonFailure {
		System.out.println("Test Case:" + test_id + "Expected Result:" + exp_result + "Actual Result:" + act_result);
		assertEquals("FAILED", exp_result, act_result);
	}
	

}
