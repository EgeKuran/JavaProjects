package q2;

import java.io.FileWriter;
import java.io.IOException;

public class FilePrinter  extends Printer{
	
	private String fileName;
	
	
	public FilePrinter(String fileName) {
		super();
		this.fileName = fileName;
	}


	@Override
	public void printOut(PrintDocument printDocument) {
		
		try (FileWriter fr = new FileWriter(fileName);){
			
			fr.write(printDocument.getContent().toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
