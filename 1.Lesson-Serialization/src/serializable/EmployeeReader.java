package serializable;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;


public class EmployeeReader {
	
	
	public static void main(String[] args) {
		
	try(ObjectInputStream reader = new ObjectInputStream(new FileInputStream("C:\\Users\\MSÝ\\Desktop\\emp1.dat"));) 
	{
		Employee emp = (Employee) reader.readObject();
		
		System.out.println(emp.getID());
		System.out.println(emp.getName());
	} 
	catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
	catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}
}
