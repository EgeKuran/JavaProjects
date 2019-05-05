
public class MainClass {

	public static void main(String[] args) {
		
		String[] items = {"ege","kuran","java is cool","weather is cool today", "ege kuran"};
		
		AnalyzerTool tool1 = new AnalyzerTool();
		
//			tool1.searchArr(items,"cool", new StringAnalyze() {
//				
//				@Override
//				public boolean analyze(String source, String searchStr) {
//					if(source.startsWith("i"))return true;
//					return false;
//				}
//			});
			
		//Lambda expression 
	tool1.searchArr(items,"is", (s,t)->s.contains(t));
	}
}
