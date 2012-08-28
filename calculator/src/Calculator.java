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
		return false; // TODO
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
			if (!handleNumber(token, stack)) {
				// check if operator ...
				if (token.length() != 1) {
					throw new IllegalArgumentException("invalid token: " + token);
				}

				if (stack.size() < 2) {
					throw new IllegalArgumentException("not enough operands");
				}
				int rhs = stack.pop(), lhs = stack.pop();
				char op = token.charAt(0);
				switch (op) {
				case '+':
					stack.push(lhs + rhs);
					break;
				case '-':
					stack.push(lhs - rhs);
					break;
				case '*':
					stack.push(lhs * rhs);
					break;
				case '/':
					stack.push(lhs / rhs);
					break;
				default:
					throw new IllegalArgumentException("invalid token: " + token);
				}
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
