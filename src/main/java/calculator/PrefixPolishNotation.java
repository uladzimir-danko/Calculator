package calculator;

import java.util.LinkedList;

// решение выражения при помощи обратной польской записи
public class PrefixPolishNotation {
	
	static boolean isDelim(char c) {
		return c == ' ';
	}
  
	static boolean isOperator(char c) {
		return c == '+' || c == '-' || c == '*' || c == '/';
	}
  
	static int priority(char operators) {
		switch (operators) {
		case '+':
		case '-':
			return 1;
		case '*':
		case '/':
			return 2;
		default:
			return -1;
		}
	}
  
	static void processOperator(LinkedList<Double> numbers, char operators) {
		double r = numbers.removeLast();
		double l = numbers.removeLast();
		switch (operators) {
		case '+':
			numbers.add(l + r);
			break;
		case '-':
			numbers.add(l - r);
			break;
		case '*':
			numbers.add(l * r);
			break;
		case '/':
			numbers.add(l / r);
			break;
		}
	}
	
    public static double eval(String string) {
    	LinkedList<Double> numbers = new LinkedList<Double>();
    	LinkedList<Character> operators = new LinkedList<Character>();
    	for (int i = 0; i < string.length(); i++) {
    		char c = string.charAt(i);
    		if (isDelim(c))
    			continue;
    		if (c == '(')
    			operators.add('(');
    		else if (c == ')') {
    			while (operators.getLast() != '(')
    				processOperator(numbers,operators.removeLast());       
    			operators.removeLast();     
    		} else if (isOperator(c)) {
    			while (!operators.isEmpty() && priority(operators.getLast()) >= priority(c))
    				processOperator(numbers, operators.removeLast());
    			operators.add(c);      
    		} else {
    			String operand = "";
    			while (i < string.length() && (Character.isDigit(string.charAt(i))
    							|| string.charAt(i) == '.'))
    				operand += string.charAt(i++);        
    			--i;        
    			numbers.add(Double.parseDouble(operand));
    		}
    	}    
    	while (!operators.isEmpty())
    		processOperator(numbers, operators.removeLast());
    	return numbers.get(0);
    }
}