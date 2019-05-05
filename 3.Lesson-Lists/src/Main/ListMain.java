package Main;

import java.util.ArrayList;
import java.util.List;

import setExample.Student;

public class ListMain {

	public static void main(String[] args) {
		List<Object> obj = new ArrayList<>();
		
		String s = new String();
		s ="1";
		Integer i = new Integer(0);
		
		
		obj.add(i);
		obj.add(s);
//		
//		Student stu = new Student();
		MyType<Student> stuType = new MyType<>();
		
		
		
	}
}
