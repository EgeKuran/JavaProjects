package ByteBased;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ImageCopy {
public static void main(String[] args) {
	
	try (BufferedInputStream reader = new BufferedInputStream( new FileInputStream("D:\\Eclipse\\AdvancedJava\\1.Lesson-IO-Operations\\src\\ByteBased\\EgeKuranfoto.jpg"));
			
			BufferedOutputStream writer = new BufferedOutputStream(new FileOutputStream(new File("D:\\Eclipse\\AdvancedJava\\1.Lesson-IO-Operations\\src\\ByteBased\\new.jpg")));){
		
		int b = 0;
		
		while ((b =reader.read()) != -1) 
		{
			writer.write(b);
		}
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	catch ( IOException e2) {
		// TODO: handle exception
		e2.printStackTrace();
	}
	
	
}
}
