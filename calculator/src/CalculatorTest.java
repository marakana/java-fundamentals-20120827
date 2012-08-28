import static org.junit.Assert.*;

import org.junit.Test;


public class CalculatorTest {

	@Test
	public void onePlusOneMustEqualTwo() {
		assertEquals(2, Calculator.calculate("1 1 +"));
	}

	@Test(expected = IllegalArgumentException.class)
	public void invalidTokenMustThrowIAE() {
		Calculator.calculate("foo");
	}

	@Test(expected = IllegalArgumentException.class)
	public void emptyExpressionMustThrowIAE() {
		Calculator.calculate("");
	}

	@Test(expected = IllegalArgumentException.class)
	public void invalidExpressionMustThrowIAE() {
		Calculator.calculate("1 +");
	}

	@Test(expected = ArithmeticException.class)
	public void divisionByZeroMustThrowArithmeticException() {
		Calculator.calculate("1 0 /");
	}
}
