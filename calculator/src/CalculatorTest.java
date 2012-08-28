import static org.junit.Assert.*;

import org.junit.Test;


public class CalculatorTest {

	@Test
	public void onePlusOneMustEqualTwo() {
		assertEquals(2, Calculator.calculate("1 1 +"));
	}

	@Test
	public void onePlusOneMustEqualThree() {
		assertEquals(3, Calculator.calculate("1 1 +"));
	}
}
