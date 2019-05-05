package SwingTest;

import java.util.ArrayList;
import java.util.List;

import SwingTest.Student;
public class MainStudent {
	
	public static void main(String[] args) {
		
	
	Student stu1 = new Student("A", 1, "ýt", 1994);
	Student stu2 = new Student("b", 2, "SALES", 1995);
	Student stu3= new Student("d", 3, "ýtM", 1996);
	Student stu4= new Student("AB", 4, "ýtASD", 1997);
	Student stu5 = new Student("AD", 5, "ýtW", 1998);
	Student stu6 = new Student("AD", 6, "ýtW", 1998);
	Student stu7 = new Student("AD", 6, "ýtW", 1998);
	
	List<Student> stu = new ArrayList<>();
	stu.add(stu1);
	stu.add(stu2);

	stu.add(stu3);
	stu.add(stu4);

	stu.add(stu5);
	stu.add(stu6);
	stu.add(stu7);
	
	stu.forEach(t-> System.out.println(t.getName()));
	
	stu.stream().filter(t->t.getBirth()>1985).forEach(t->System.out.println(t));
	}
}
