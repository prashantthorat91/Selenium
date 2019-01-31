package hashcode.comparator;

public class Department {

	int studentId;
	String studentName;
	String departmentName;
	
	public Department(int studentId, String studentName, String departmentName) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.departmentName = departmentName;
	}
	public String toString() {
		return studentId+" "+ studentName+" "+ departmentName;
	}
	
	
	
}
