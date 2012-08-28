import java.util.Stack;

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

		// BROKEN: DON'T POP BEFORE WE HAVE AN OP
		if (stack.size() < 2) {
			throw new IllegalArgumentException("not enough operands");
		}
		int rhs = stack.pop(), lhs = stack.pop();
		char op = token.charAt(0);
		switch (op) {
		case '+':
			stack.push(lhs + rhs);
			return true;
		case '-':
			stack.push(lhs - rhs);
			return true;
		case '*':
			stack.push(lhs * rhs);
			return true;
		case '/':
			stack.push(lhs / rhs);
			return true;
		default:
			return false;
		}
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
			// BROKEN: CAN'T HANDLE OPERATOR BEFORE NUMBER!
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
