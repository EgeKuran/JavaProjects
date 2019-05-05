import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Set;
import java.util.TreeMap;

public class WordFrequency {
	public static void main(String[] args) {
		try (	BufferedReader reader = new BufferedReader(new FileReader("text_to_count.txt"));
				BufferedWriter writer = new BufferedWriter(new FileWriter("counted_text.txt"));){
			TreeMap<String, Integer> treeMap = new TreeMap<>();
			
			String line = "";
			
			while((line = reader.readLine()) != null) 
			{
				String [] words = line.split(" ");
				for (String word : words) {
					word = word.replaceAll("[^a-zA-Z]", "");
					if(treeMap.containsKey(word)) 
					{
						treeMap.put(word, treeMap.get(word)+1);					
					}
					else 
					{
						treeMap.put(word, 1);
					}
				}
			}
		Set<String> keySet = treeMap.keySet();
		for (String key : keySet) {
			writer.write("Key: " + key + "\tValue: " + treeMap.get(key) + "\n" );
		}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}

}
