package Q2;

import java.util.List;
import java.util.stream.Collectors;


public class Main {

public static void main(String[] args) {
	List<Student> stus = Student.getStudentList();
System.out.println( stus.stream().filter(t->t.getDepartment().getName().equals("Social Sciences")).mapToDouble(t->t.getGPA()).average().getAsDouble());	
	
double gpa = stus.stream().filter(t->t.getDepartment().getName().equals("Natural Sciences")).mapToDouble(Student::getGPA).max().getAsDouble();
System.out.println(stus.stream().filter(t->t.getGPA()==gpa).map(Student::getName).collect(Collectors.toList()));
int age =stus.stream().mapToInt(Student:: getBirthYear).min().getAsInt();
System.out.println(stus.stream().filter(t->t.getBirthYear()==age).map(Student::getName).collect(Collectors.toList()));
}
}
