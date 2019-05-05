package main;

import java.util.ArrayList;
import java.util.List;

public class MainBox {
	
	public static void main(String[] args) {
		Box<Integer,Object> myBox = new Box<>();
		
		myBox.setMyType(2);
		myBox.setMySecondType(new Object());
		
		List<Dog> dogs= new ArrayList<>();
		feedAnimals(dogs);
		myGenericMethod(new Object(), new String());
		
	}
	public static void feedAnimals(List<? extends Animal> animals) 
	{
		for (Animal animal : animals) {
			System.out.println(animal);
			
		}
	}
	
	public static <U,H> void myGenericMethod(U var1, H var2) 
	{
		System.out.println(var1.getClass());
		System.out.println(var2.getClass());
	}
	
}
