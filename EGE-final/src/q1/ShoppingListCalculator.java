package q1;

import java.util.ArrayList;
import java.util.List;

public class ShoppingListCalculator {


public ShoppingListCalculator() {
	// TODO Auto-generated constructor stub
}
	
	public static double[] calculateTotalAmountPayable(String[][] shoppingListItems) 
	{
		int index=-1;
		int demandAmount =0;
		double productPrice;
		double vatPrice;
		double totalNetPrice = 0.0;
		double netPrice=0.0;
		double taxedPrice =0.0;
		double totalTaxedPrice =0.0;
		List<ProductInfo> products = ProductInfo.getProducts();
		double[] shoppingListAmounts = new double[2];
		ArrayList<String> productName=new ArrayList();
		ArrayList<Integer> productDemand=new ArrayList();
		for(int i=0; i < shoppingListItems.length; i ++) 
		{
			productName.add( shoppingListItems[i][0]) ;
			productDemand.add(Integer.parseInt(shoppingListItems[i][1]));
			
		}
		for (String pName : productName) {
				index++;
			for(ProductInfo pInfo : products) 
			{
				if(pInfo.getProductName().equals(pName)) 
				{
					if(pInfo.isAvailable())
					{
						demandAmount = productDemand.get(index);
						productPrice =pInfo.getProductPrice();
						vatPrice=pInfo.getVat();
						netPrice = (double)demandAmount * productPrice;
						taxedPrice = netPrice *vatPrice;
						totalNetPrice += netPrice;
						totalTaxedPrice += taxedPrice;
					}
				}
			}
		}
		shoppingListAmounts[0] = totalNetPrice;
	
		shoppingListAmounts[1] = totalTaxedPrice;
		
		return shoppingListAmounts;
		
	}
}
