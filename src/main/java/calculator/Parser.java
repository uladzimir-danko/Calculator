package calculator;

//разбираем текст и попутно вычисляем значения функций
public class Parser implements Calculator {	
	private String [] expressions  = {"sqrt", "pow", "sin", "cos", "tg", "log"};
	
	public String equalsSolution(String equals)
	{
		return expressionFind(equals);
	}
	
	// сначала считаем значения функций
	private String expressionFind(String equation) {
			
		int indexBeginn = 0, indexEnd = 0, count = 0, capaCounter = 1;
			
		 // цикл исчет функции и передает их вместе с аргументом в expressionSolution
		 // для подсчета
		for(count = 0; count < 6; ++count)
		{
			if(equation.indexOf(expressions[count]) < 0)	{}
			else
			{
				capaCounter = 1;
				indexBeginn = equation.indexOf(expressions[count]);
				indexEnd = indexBeginn + 1;
				
				while(equation.charAt(indexEnd) != '(')
				{
					++indexEnd;
				}			
				while(capaCounter != 0)
				{
					++indexEnd;
					if(equation.charAt(indexEnd) == ')')
					{
						capaCounter--;
					}
					else
						if(equation.charAt(indexEnd) == '(')
						{
							capaCounter++;
						}				
				}
				indexEnd++;
				
				equation = equation.replace(equation.substring(indexBeginn, indexEnd),
						expressionSolution(equation.substring(indexBeginn, indexEnd)));
				
				--count;					
			}
		}
			
		// для подсчета числового выражения воспользуемся обратной польской записью
		equation = Double.toString(PrefixPolishNotation.eval(equation));
		return equation;
	}
	
	// вычисляем значение функции, если аргумент число
	private String expressionSolution(String expression)
	{
		int i = 0;	
		String function, argument;
		String regex = new String("\\d+");
		function = expression.substring(0, expression.indexOf('('));
		argument = expression.substring(
				expression.indexOf('(') + 1, expression.length() - 1);
		
		while(!this.expressions[i].equals(function))
		{
			++i;
		}
		
		//если аргумент необходимо посчитать - считаем и 
		 // идем дальше искать значение функции
		if( (!argument.matches(regex)) && (i != 1) )
		{
			argument = expressionFind(argument);
		} 		
			
		return Double.toString(functionDefine(argument, i));
	}	
	
	private double functionDefine(String argument, int number) {
		
		switch (number)
		{
		case 0:
			return Math.sqrt(Double.parseDouble(argument));
		case 1:
			return power(argument);
		case 2:
			return Math.sin(Math.toRadians(Double.parseDouble(argument)));
		case 3:
			return Math.cos(Math.toRadians(Double.parseDouble(argument)));
		case 4:
			return Math.tan(Math.toRadians(Double.parseDouble(argument)));
		case 5:
			return Math.log(Double.parseDouble(argument));	
		default:
			return 0;
		}		
	}
	
	private double power(String argument) {
		
		return Math.pow(
				Double.parseDouble( expressionFind
						( argument.substring( 0, argument.indexOf(',') )) ), 
				Double.parseDouble( argument.substring(argument.indexOf(',') + 1,
						argument.length()) )
				);
	}
}
