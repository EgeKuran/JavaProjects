package CharBased;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SimpleRead {
	public static void main(String[] args) {
	try {
		FileReader reader = new FileReader("");
		BufferedReader bReader = new BufferedReader(new FileReader(""));
		String line = "";
		StringBuilder buffer = new StringBuilder();
		
		while((line =bReader.readLine())!= null) 
		{
			buffer.append(line);
		}
		System.out.println(buffer);
	} catch (IOException e) {
		// TODO: handle exception
	}
}

}
