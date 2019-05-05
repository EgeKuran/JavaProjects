package SwingTest;

public  class Student implements Comparable<Student> {

	private String name;
	private int id;
	private String department;
	private int birth;

	public Student(String name, int id, String department, int birth) {
		super();
		this.name = name;
		this.id = id;
		this.department = department;
		this.birth = birth;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public int getBirth() {
		return birth;
	}
	public void setBirth(int birth) {
		this.birth = birth;
	}
	public Student() {
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
	
		return "Student [ id = " + id +  ", name= " + name  + ", department= " + department + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		return new Integer(id).equals(((Student) obj).getId());
	}
//	@Override
//	public int compareTo(Student student) {
//		if(this.id>student.getId()) { return 1;}
//		else if (this.id< student.getId()) {
//			return -1;}
//			else 
//			{return 0;}	
//		
//	}
	@Override
	public int compareTo(Student o) {
		return new Integer(this.getId()).compareTo(o.getId());
	}
	
	
}
