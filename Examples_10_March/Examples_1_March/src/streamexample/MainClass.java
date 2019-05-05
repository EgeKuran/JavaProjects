package streamexample;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.example.sales.SalesTxn;

public class MainClass {

	
	public static void main(String[] args) {
		
		List<SalesTxn> data = SalesTxn.createTxnList();
		
		Map<String, Long> dataMapped= data.stream().collect(
				Collectors.groupingBy(
						SalesTxn::getSalesPerson,Collectors.counting()
						)
				);
		
		
		dataMapped.entrySet().forEach(t->System.out.println(t));
		
		Map<String, Long> dataMapped2= data.stream().collect(
				Collectors.groupingBy(
						SalesTxn::getProduct,Collectors.counting()
						)
				);
	
		dataMapped2.entrySet().forEach(t->System.out.println(t));
		
		
		
		
	}
	
	
}
