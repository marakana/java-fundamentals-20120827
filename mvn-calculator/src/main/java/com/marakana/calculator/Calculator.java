package com.marakana.calculator;

import static com.marakana.calculator.Operator.ADD;
import static com.marakana.calculator.Operator.DIVIDE;
import static com.marakana.calculator.Operator.MULTIPLY;
import static com.marakana.calculator.Operator.SUBTRACT;

import java.util.Stack;

import com.marakana.calculator.expressions.Expression;
import com.marakana.calculator.expressions.NumberExpression;
import com.marakana.calculator.expressions.OperationExpression;


public class Calculator {

	public static boolean handleNumber(String token, Stack<Expression> stack) {
		try {
			int number = Integer.parseInt(token);
			stack.push(new NumberExpression(number));
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	public static boolean handleOperator(String token, Stack<Expression> stack) {
		if (token.length() != 1) {
			return false;
		}

		Operator op;
		switch (token.charAt(0)) {
		case '+':
			op = ADD;
			break;
		case '-':
			op = SUBTRACT;
			break;
		case '*':
			op = MULTIPLY;
			break;
		case '/':
			op = DIVIDE;
			break;
		default:
			return false;
		}

		if (stack.size() < 2) {
			throw new IllegalArgumentException("not enough operands");
		}
		Expression rhs = stack.pop(), lhs = stack.pop();
		stack.push(new OperationExpression(op, lhs, rhs));
		return true;
	}

	public static Expression parse(String expression) {
		if (expression.isEmpty()) {
			throw new IllegalArgumentException("empty expression");
		}

		// initialize an empty stack
		Stack<Expression> stack = new Stack<Expression>();

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
				throw new IllegalArgumentException(
						"Usage: Calculator <expression>");
			}
			System.out.println(parse(args[0]));
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

}
