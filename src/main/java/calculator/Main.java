package calculator;

import java.io.FileNotFoundException;
import java.io.IOException;



public class Main {
	
	public static void main(String[] args) throws FileNotFoundException, IOException
	{
		String path = new String("/home/uladzimir/workspace/1/equations.txt");
		String[] stringArray = Explorer.read(path);
		Parser parser = new Parser();
		
		for(int i = 0; i < stringArray.length; ++i){
			System.out.println(stringArray[i]);
			System.out.println(parser.equalsSolution(stringArray[i]));
			stringArray[i] = stringArray[i] +
					" = " + reduce(parser.equalsSolution(stringArray[i]));
		}
		
		Explorer.write(stringArray);
		System.out.println(Math.log(100));
		
	}
	
	static public String reduce(String string)
	{
		int index = string.indexOf('.') + 3;
		if(index < string.length())	string = string.substring(0, index + 1);		
		return string;		
	}

}
