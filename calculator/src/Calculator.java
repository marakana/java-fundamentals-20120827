import java.util.Stack;

public class Calculator {

	public static void main(String[] args) {
		if (args.length != 1) {
			System.err.println("Usage: Calculator <expression>");
			System.exit(1);
		}

		// initialize an empty stack
		Stack<Integer> stack = new Stack<Integer>();

		// split expression string into tokens
		String expression = args[0];
		String[] tokens = expression.split(" ");

		// for each token ...
		for (String token : tokens) {
			try {
				// if number, push onto stack
				int number = Integer.parseInt(token);
				stack.push(number);
			} catch (NumberFormatException e) {
				// check if operator ...
				if (token.length() != 1) {
					System.err.println("Error: invalid token");
					System.exit(1);
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
					System.err.println("Error: invalid token");
					System.exit(1);
				}
			}
		}
		System.out.println(stack.pop());
	}

}
