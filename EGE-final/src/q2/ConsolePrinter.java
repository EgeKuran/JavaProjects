package q2;

public class ConsolePrinter extends Printer {

	@Override
	public void printOut(PrintDocument printDocument) {
	System.out.println(printDocument.getContent());
		
	}
	

}
