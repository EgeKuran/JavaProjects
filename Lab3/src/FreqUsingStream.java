import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FreqUsingStream {


	public static void main(String[] args) {

		try ( Stream<String> streams = Files.lines(Paths.get("text_to_count.txt"));){
			 
		        // map each word to its total number of occurrences
		        Map<String, Long> wordCount = streams.map(w -> w.split(" "))
		                // return Stream<String[]>
		                .flatMap(Arrays::stream)
		                // flatten to Stream<String>
		                .map(s -> s.replaceAll("[^A-Za-z0-9]","").toLowerCase())
		                // strip non-alphanumerics and uppercase all
		                .filter(s -> s.matches("[a-zA-Z0-9]+")&& s.length() > 0)
		                .collect(
		                        Collectors.groupingBy(Function.identity(),
		                                Collectors.counting())); // map word strings to
		                                                            // count
		 
//		        // total number of words in list
//		        Long wordTotal = wordCount.values().stream()
//		                .reduce(0L, (a, b) -> a + b);
		 
		        // convert total occurrences of total words
		        Map<String, Integer> wordFreq = wordCount.entrySet().stream().collect(Collectors.toMap(e -> e.getKey(),e -> e.getValue().intValue()));
		 
		        List<Map.Entry<String, Integer>> sorted = wordFreq.entrySet().stream()
		                .sorted(Map.Entry.comparingByKey())
		                .collect(Collectors.toList());
		 
		        Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
		        sorted.forEach(e -> sortedMap.put(e.getKey(), e.getValue()));
		        BufferedWriter wr = new BufferedWriter(new FileWriter("counted_text.txt"));
		        sortedMap.entrySet().stream().forEach(w ->{
					try {
						wr.write("Word: " +w.getKey() +"Count: " + w.getValue()+ "\n" );
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				});
//		        
//	 
//			Map<Entry<String, Integer>, Long> wordsCount =Files.lines(Paths.get("text_to_count.txt"))
//		     .flatMap(line -> Stream.of(line.split("\\s+")))
//		     .map(w->w.replaceAll("[^a-zA-Z0-9]", "").toLowerCase())
//		     .collect(Collectors.toMap(word -> word, word -> 1, Integer::sum))
//		     .entrySet().stream()
//		     .sorted((a, b) -> a.getValue() == b.getValue() ? a.getKey().compareTo(b.getKey()) : b.getValue() - a.getValue())
//		     .collect((Collectors.groupingBy(Function.identity(),Collectors.counting())));
//			SortedSet<String> keys = new TreeSet(wordsCount.keySet());
//			keys.forEach(t->System.out.println("Key: " + t + " Value: " + wordsCount.get(t)));
			
//			Map<String, Long> wordsCount = Files.lines(Paths.get("text_to_count.txt"))
//				    .flatMap(str->Stream.of(str.split(" "))).map(word -> word.replaceAll("[^a-zA-Z]", "").trim())
//				    .filter(s->s.length()>0 ).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
//				
//			SortedSet<String> keys = new TreeSet(wordsCount.keySet());
//			keys.forEach(t->System.out.println("Key: " + t + " Value: " + wordsCount.get(t)));
//			
//			List<String> list = Files.lines(Paths.get("text_to_count.txt")).flatMap(str->Stream.of(str.split(" "))).map(w -> w.split("\\s+")).flatMap(Arrays::stream)
//		            .collect(Collectors.toList());
//		 
//		        Map <String, Integer > wordCounter = list.stream()
//		            .collect(Collectors.toMap(w -> w.toLowerCase(), w -> 1, Integer::sum));
//		        SortedSet<String> keys = new TreeSet<>(wordCounter.keySet());
//				keys.forEach(t->System.out.println("Key: " + t + " Value: " + wordCounter.get(t)));
//		     
//		
//			 Path path = Paths.get("text_to_count.txt");
//			    Map<String, Long> wordCount = Files.lines(path).flatMap(line -> Arrays.stream(line.trim().split(" ")))
//			            .map(word -> word.replaceAll("[^a-zA-Z0-9]", "").toLowerCase())
//			            .filter(word -> word.length() > 0)
//			            .map(word -> new SimpleEntry<>(word,1))
//			            .collect(Collectors.groupingBy(SimpleEntry::getKey, Collectors.counting()));
//			    SortedSet<String> keys = new TreeSet<>(wordCount.keySet());
//				keys.forEach(t->System.out.println("Key: " + t + " Value: " + wordCount.get(t)));

	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
