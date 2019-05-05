package streamexample;

import java.nio.MappedByteBuffer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.example.sales.SalesTxn;

public class FlatMapExample {

	public static void main(String[] args) {
		

		List<SalesTxn> data = SalesTxn.createTxnList();
		
		Map<String, List<SalesTxn>>  mappedData = 
			data.stream().collect(Collectors.groupingBy(SalesTxn::getSalesPerson)
			);
		
		/*
		for (String key : mappedData.keySet()) {
			
			List<SalesTxn> innerList = mappedData.get(key);
			
			for (SalesTxn salesTxn : innerList) {
				salesTxn.printSummary();
			}
			
			
		}
		*/
		
		mappedData.keySet().stream()
			.flatMap(key-> mappedData.get(key).stream())
			.forEach(SalesTxn::printSummary);
		
		
		
	}
	
	
}
