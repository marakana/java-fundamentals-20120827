package com.marakana.calculator;

import static com.marakana.calculator.Calculator.calculate;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CalculatorTest {

	@Test
	public void onePlusOneMustEqualTwo() {
		assertEquals(2, calculate("1 1 +"));
	}

	@Test(expected = IllegalArgumentException.class)
	public void invalidTokenMustThrowIAE() {
		calculate("foo");
	}

	@Test(expected = IllegalArgumentException.class)
	public void emptyExpressionMustThrowIAE() {
		calculate("");
	}

	@Test(expected = IllegalArgumentException.class)
	public void invalidExpressionMustThrowIAE() {
		calculate("1 +");
	}

	@Test(expected = ArithmeticException.class)
	public void divisionByZeroMustThrowArithmeticException() {
		calculate("1 0 /");
	}
}
