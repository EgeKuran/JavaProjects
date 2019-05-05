package question2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Set;
import java.util.TreeMap;

public class MainClass {
	public static void main(String[] args) {
	try (	BufferedReader reader = new BufferedReader(new FileReader("D:\\Eclipse\\AdvancedJava\\MidtermGiven.zip_expanded\\MidtermGiven\\src\\question2\\creditcards.txt"));)
			{
		TreeMap<String, Integer> treeMap = new TreeMap<>();
		
		String line = "";
		
		while((line = reader.readLine()) != null) 
		{
			String [] numbers = line.split("\n");
			for (String number : numbers) {
				number = number.replaceAll("[^a-zA-Z0-9]", "");
				if(treeMap.containsKey(number)) 
				{
					treeMap.put(number, treeMap.get(number)+1);					
				}
				else 
				{
					treeMap.put(number, 1);
				}
			}
		}
	Set<String> keySet = treeMap.keySet();
	for (String key : keySet) {
		if(treeMap.get(key)!=1)
		{
		System.out.println(("Key: " + key.substring(0,4) +" " 
		+key.substring(4,8) +" "
		+key.substring(8,12) +" "
		+key.substring(12,16) +" "
		+key.substring(16,18) +"/"
		+key.substring(18,20) +" "+ "\tValue: " + treeMap.get(key) + "\n" ));
		
		}
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
