package setExample;

import java.util.HashSet;
import java.util.Set;

import setExample.Student;

public class StudentMainClass {
public static void main(String[] args) {
	
	Student stu1 = new Student("A", 1, "ıt", 1994);
	Student stu2 = new Student("b", 2, "SALES", 1995);
	Student stu3= new Student("d", 3, "ıtM", 1996);
	Student stu4= new Student("AB", 4, "ıtASD", 1997);
	Student stu5 = new Student("AD", 5, "ıtW", 1998);
	Student stu6 = new Student("AD", 6, "ıtW", 1998);
	Student stu7 = new Student("AD", 6, "ıtW", 1998);
	
	Set<Student> stu= new HashSet<Student>();

	
//	stu.add(stu1);
//	stu.add(stu2);
//
//	stu.add(stu3);
//	stu.add(stu4);
//
//	stu.add(stu5);
//	stu.add(stu6);
//	stu.add(stu7);
	
	
	for (Student student : stu) {
		System.out.println(student);
	}
	

}
}
