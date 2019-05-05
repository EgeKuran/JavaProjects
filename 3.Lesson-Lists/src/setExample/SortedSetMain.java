package setExample;

import java.util.TreeSet;

import setExample.Student;

public class SortedSetMain {
	public static void main(String[] args) {
		TreeSet<String> namesSet = new TreeSet<String>();
		
		namesSet.add("Mehet");
		namesSet.add("Mehmet");
		namesSet.add("Mehmmet");
		namesSet.add("Mehmmmet");
		namesSet.add("Mehmmmmet");
		namesSet.add("Mehmmmmmet");
		
		for (String name : namesSet) {
			System.out.println(name);
			
		}
//		System.out.println("-------------------------");
//		Student stu1 = new Student("A", 1, "�t", 1994);
//		Student stu2 = new Student("b", 2, "SALES", 1995);
//		Student stu3= new Student("d", 3, "�tM", 1996);
//		Student stu4= new Student("AB", 4, "�tASD", 1997);
//		Student stu5 = new Student("AD", 5, "�tW", 1998);
//		
		
		TreeSet<Student> stu = new TreeSet<>();
		
//		stu.add(stu1);
//		stu.add(stu2);
//
//		stu.add(stu3);
//		stu.add(stu4);
//
//		stu.add(stu5);
//		
		for (Student student : stu) {
			System.out.println(student);
		}
	}

}
