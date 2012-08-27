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
			//   - if number, push onto stack
			//   - if operator:
			//       pop two numbers off stack,
			//       compute result,
			//       push result onto stack
		}
		// result is on the stack
	}

}
