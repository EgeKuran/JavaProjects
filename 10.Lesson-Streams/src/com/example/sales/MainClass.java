package com.example.sales;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MainClass {

	public static void main(String[] args) {
		List<SalesTxn> data = SalesTxn.createTxnList();
		Map<String, List<SalesTxn>> data2 = data.stream().collect(Collectors.groupingBy(SalesTxn::getSalesPerson));
		
//		for (String key : data2.keySet()) {
//			List<SalesTxn> innerList = data2.get(key);
//			for(SalesTxn salesTxn : innerList){
//				salesTxn.printSummary();
//				
//			}			
//		}
//		
		
		
		data2.keySet().stream().flatMap(t->data2.get(t).stream()).forEach(SalesTxn::printSummary);
		
		
		
		
		
	}
}
