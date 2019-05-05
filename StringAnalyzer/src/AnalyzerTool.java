
public class AnalyzerTool {

	public void searchArr(String[] sources, String searchStr,StringAnalyze analyzer) {
		for (int i = 0; i < sources.length; i++) {
			if(analyzer.analyze(sources[i],searchStr)) 
			{
				System.out.println("Match: " + i);
			}
		}
		
	}
}
