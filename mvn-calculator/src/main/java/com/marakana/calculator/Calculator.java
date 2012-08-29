package com.marakana.calculator;
import java.util.Stack;

import com.marakana.calculator.operators.Add;
import com.marakana.calculator.operators.Divide;
import com.marakana.calculator.operators.Multiply;
import com.marakana.calculator.operators.Operator;
import com.marakana.calculator.operators.Subtract;

public class Calculator {

	public static boolean handleNumber(String token, Stack<Integer> stack) {
		try {
			int number = Integer.parseInt(token);
			stack.push(number);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	public static boolean handleOperator(String token, Stack<Integer> stack) {
		if (token.length() != 1) {
			return false;
		}

		Operator op;
		switch (token.charAt(0)) {
		case '+':
			op = new Add();
			break;
		case '-':
			op = new Subtract();
			break;
		case '*':
			op = new Multiply();
			break;
		case '/':
			op = new Divide();
			break;
		default:
			return false;
		}

		if (stack.size() < 2) {
			throw new IllegalArgumentException("not enough operands");
		}
		int rhs = stack.pop(), lhs = stack.pop();
		stack.push(op.operate(lhs, rhs));
		return true;
	}

	public static int calculate(String expression) {
		if (expression.isEmpty()) {
			throw new IllegalArgumentException("empty expression");
		}

		// initialize an empty stack
		Stack<Integer> stack = new Stack<Integer>();

		// split expression string into tokens
		String[] tokens = expression.split(" ");

		// for each token ...
		for (String token : tokens) {
			if (!(handleOperator(token, stack) || handleNumber(token, stack))) {
				throw new IllegalArgumentException("invalid token: " + token);
			}
		}
		return stack.pop();
	}

	public static void main(String[] args) {
		try {
			if (args.length != 1) {
				throw new IllegalArgumentException("Usage: Calculator <expression>");
			}
			System.out.println(calculate(args[0]));
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

}
