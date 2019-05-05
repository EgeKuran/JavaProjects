package q3;

import java.awt.Graphics;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class MainClass extends MyFrame{
	
public static void main(String[] args) {
	 Graphics g = null;
	
	 String content = null;
	 File file = new File("points.txt");
	
	    try (   FileReader reader = new FileReader(file);)
	    {
	        char[] chars = new char[(int) file.length()];
	        reader.read(chars);
	        content = new String(chars);
	        
	    } catch (IOException e) {
	        e.printStackTrace();
	    } 
	    
	   MyFrame frame= new MyFrame();
	   frame.setVisible(true);
	   frame.paint(g, 20, 10, 120, 10);
	   
}
}
