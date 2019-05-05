package Q2;

import java.util.ArrayList;
import java.util.List;

public class Student {

	private int id;
	private String name;
	private Department department;
	private int birthYear;
	private double GPA;

	
	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(int id, String name, Department department, int birthYear, double GPA) {
		super();
		this.id = id;
		this.name = name;
		this.department = department;
		this.birthYear = birthYear;
		this.GPA = GPA;

	}
	
	public static List<Student> getStudentList(){
		List<Student> data = new ArrayList<>();
		
		Department nat = new Department("Natural Sciences");
		Department soc = new Department("Social Sciences");
		
		Student stu1 = new Student(5224,"Jack Ford",nat,1990,3.45);
		Student stu2 = new Student(456363,"Dana Bettis",nat,1994,4.81);
		Student stu3 = new Student(45453,"Henry Williams",soc,1987,4.6);
		Student stu4 = new Student(46456,"Turk Donnaway",soc,1990,2.7);
		Student stu5 = new Student(25245,"Pete Peterson",nat,1983,3.0);	
		Student stu6 = new Student(74456,"Gary Oldway",nat,1986,2.3);
		Student stu7 = new Student(34374,"Mark Kork",soc,1979,2.9);
		Student stu8 = new Student(25466,"Donna Summers",nat,1983,3.4);
		Student stu9 = new Student(56856,"Peter Patt",nat,1995,4.2);
		Student stu10 = new Student(2467,"Patrick Johanson",soc,1992,4.56);
		Student stu11= new Student(2435756,"Sid Barret",nat,1992,3.56);
		Student stu12 = new Student(2327,"Eric Clapton",nat,1994,3.24);
		Student stu13 = new Student(4668,"John Ross",soc,1992,2.3);
		Student stu14 = new Student(24687,"Sheldon Tukk",soc,1985,3.45);
		Student stu15 = new Student(7453,"Price Waterhouse",nat,1991,3.0);
		Student stu16 = new Student(1776,"Gale Olap",nat,1992,3.65);
		Student stu17 = new Student(85674,"Jenny Jenkins",soc,1993, 3.2);
		Student stu18 = new Student(874334,"Karl Weiss",nat,1992,2.34);
		Student stu19 = new Student(362346,"Lia Princess",nat,1995,2.45);
		Student stu20 = new Student(86242,"Luke Skywalker",soc,1992,2.87);

		data.add(stu1);
		data.add(stu2);
		data.add(stu3);
		data.add(stu4);
		data.add(stu5);
		data.add(stu6);
		data.add(stu7);
		data.add(stu8);
		data.add(stu9);
		data.add(stu10);
		data.add(stu11);
		data.add(stu12);
		data.add(stu13);
		data.add(stu14);
		data.add(stu15);
		data.add(stu16);
		data.add(stu17);
		data.add(stu18);
		data.add(stu19);
		data.add(stu20);
		
		return data;
		
	}

	public double getGPA() {
		return GPA;
	}
	public void setGPA(double gPA) {
		GPA = gPA;
	}

	
	public int getBirthYear() {
		return birthYear;
	}

	public void setBirthYear(int birthYear) {
		this.birthYear = birthYear;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	
}
