package q2;

import java.util.ArrayList;
import java.util.List;

public abstract class Printer {

	private List<PrintDocument> docs = new ArrayList<>();
	

	public abstract void printOut(PrintDocument printDocument);
	
	public void printAllDocuments()
	{
		for (PrintDocument printDocument : docs) {
			printOut(printDocument);
		}
		
		
	}
	public void addDocument(PrintDocument printDocument) 
	{
		docs.add(printDocument);
		
	}
}