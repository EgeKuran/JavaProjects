package q1;

import java.util.Arrays;
import java.util.List;

public class MainClass {

	
	public static void main(String[] args) {
		
		String[][] jackShoppingList = {{"Mouse","1"},{"Laptop","1"},{"Iphone 5","1"}};
		String[][] henryShoppingList = {{"TV 20 Inch","1"}};
		String[][] jenniferShoppingList = {{"Apples 1kg","2"},{"Melon 1kg","1"},{"Cake","1"}};
		String[][] susanShoppingList = {{"Apples 1kg","2"},{"Melon 1kg","2"},{"Cake","2"},{"Hair Dryer","1"},{"Samsung Tablet","1"}};
		
		ShoppingListCalculator calc = new ShoppingListCalculator();
		System.out.println("Jack : \n" +
										"Net : " + (calc.calculateTotalAmountPayable(jackShoppingList))[0] + "\n" +
										"Tax : " + (calc.calculateTotalAmountPayable(jackShoppingList))[1] +  "\n" +
										"Total: " +  ((calc.calculateTotalAmountPayable(jackShoppingList))[0] + (calc.calculateTotalAmountPayable(jackShoppingList))[1]) + "\n" 
										+ "---------------------"
										
				);
		
		System.out.println("Henry : \n" +
				"Net : " + (calc.calculateTotalAmountPayable(henryShoppingList))[0] + "\n" +
				"Tax : " + (calc.calculateTotalAmountPayable(henryShoppingList))[1] +  "\n" +
				"Total: " +  ((calc.calculateTotalAmountPayable(henryShoppingList))[0] + (calc.calculateTotalAmountPayable(henryShoppingList))[1]) + "\n" 
				+ "---------------------"
				
);
		
		System.out.println("Jennifer : \n" +
				"Net : " + (calc.calculateTotalAmountPayable(jenniferShoppingList))[0] + "\n" +
				"Tax : " + (calc.calculateTotalAmountPayable(jenniferShoppingList))[1] +  "\n" +
				"Total: " +  ((calc.calculateTotalAmountPayable(jenniferShoppingList))[0] + (calc.calculateTotalAmountPayable(jenniferShoppingList))[1]) + "\n" 
				+ "---------------------"
				
);
		
		System.out.println("Susan : \n" +
				"Net : " + (calc.calculateTotalAmountPayable(susanShoppingList))[0] + "\n" +
				"Tax : " + (calc.calculateTotalAmountPayable(susanShoppingList))[1] +  "\n" +
				"Total: " +  ((calc.calculateTotalAmountPayable(susanShoppingList))[0] + (calc.calculateTotalAmountPayable(susanShoppingList))[1]) + "\n" 
				+ "---------------------"
				
);
	}
	
	
}
