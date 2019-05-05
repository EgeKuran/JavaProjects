package q2;

import java.util.Date;

public class MainClass {

	public static void main(String[] args) {
		PrintDocument doc1 = new PrintDocument(new Date(), 
				"Final Exam", 
				"I am trying to complete the question, yeah still!");
		
		PrintDocument doc2 = new PrintDocument(new Date(), 
				"Final Exam", 
				"OK, I am done!");
		
		Printer filePrinter = new FilePrinter("output1.txt");
		filePrinter.addDocument(doc1);
		filePrinter.addDocument(doc2);
		
		Printer consolePrinter = new ConsolePrinter();
		consolePrinter.addDocument(doc1);
		consolePrinter.addDocument(doc2);
		
		filePrinter.printAllDocuments();
		filePrinter.printAllDocuments();
		consolePrinter.printAllDocuments();
	}
	
}
