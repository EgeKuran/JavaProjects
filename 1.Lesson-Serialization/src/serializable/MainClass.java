package serializable;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class MainClass {
	public static void main(String[] args) {
		Employee emp = new Employee();
		
		emp.setID(1);
		emp.setName("Ahmet");
		
		try(ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(new File("C:\\Users\\MSÝ\\Desktop\\emp1.dat")));) {
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
