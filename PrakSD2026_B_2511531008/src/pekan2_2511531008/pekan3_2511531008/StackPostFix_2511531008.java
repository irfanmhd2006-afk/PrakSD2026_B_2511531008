package pekan3_2511531008;
import java.util.*;
import java.util.Scanner;

public class StackPostFix_2511531008 {
	public static int postfixEvaluate_2511531008(String expression) {
		Stack<Integer> s_2511531008 = new Stack<Integer>();
		Scanner input = new Scanner(expression);
		while (input.hasNext()) {
			if(input.hasNextInt()) { //an operand (integer)
				s_2511531008.push(input.nextInt());
			}else {
				String operator = input.next();
				int operand2 = s_2511531008.pop();
				int operand1 = s_2511531008.pop();
				if(operator.equals("+")) {
					s_2511531008.push(operand1 + operand2);
				} else if (operator.equals("-")) {
					s_2511531008.push(operand1 - operand2);
				} else if (operator.equals("*")) {
					s_2511531008.push(operand1 * operand2);
				} else {
					s_2511531008.push(operand1 / operand2);
				}
			}
			
		}
		input.close();
		return s_2511531008.pop();
	}
	public static void main(String[] args) {
		System.out.println("Hasil postfix= "+postfixEvaluate_2511531008("5 2 4 * + 7 -"));

	}

}
