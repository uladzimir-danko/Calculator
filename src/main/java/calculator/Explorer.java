package calculator;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

// чтение-запись файла
public class Explorer  {
	
	public static String[] read(String path) throws FileNotFoundException, IOException
	{
		BufferedReader reader = new BufferedReader(new FileReader(path));
        String line;
        List<String> lines = new ArrayList<String>();
        
        while ((line = reader.readLine()) != null) {
            lines.add(line);
        }
        reader.close();
        
        String [] linesAsArray = lines.toArray(new String[lines.size()]);
		
		return linesAsArray;
		
	}
	
	public static void write(String [] stringArray) 
			throws FileNotFoundException, IOException
	{
		String path = new String("/home/uladzimir/workspace/1/solutions.txt");
		
		FileOutputStream fileOutputStream = new FileOutputStream(path);
		BufferedWriter bufferedWriter = new BufferedWriter(
				new OutputStreamWriter(fileOutputStream, "UTF-8"));
		
		for(int i = 0; i < stringArray.length; ++i)
		{
			bufferedWriter.append(stringArray[i]);
			bufferedWriter.newLine();
		}
		bufferedWriter.close();
		fileOutputStream.close();
	}

}
