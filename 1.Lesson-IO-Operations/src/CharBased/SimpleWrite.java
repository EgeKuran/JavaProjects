package CharBased;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class SimpleWrite {
	public static void main(String[] args) {
		try (BufferedWriter writer = 
				new BufferedWriter(new FileWriter("test.txt"));){
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
