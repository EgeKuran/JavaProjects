package StudentGrade;

import java.io.Serializable;

public class Grade implements Serializable{

	private String studentName;
	private String grade;
	
	
	public Grade() {
		// TODO Auto-generated constructor stub
	}


	public Grade(String studentName, String grade) {
		super();
		this.studentName = studentName;
		this.grade = grade;
	}


	public String getStudentName() {
		return studentName;
	}


	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}


	public String getGrade() {
		return grade;
	}


	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	
}
