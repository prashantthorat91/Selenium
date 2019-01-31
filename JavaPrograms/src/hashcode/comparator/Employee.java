package hashcode.comparator;

public class Employee {

	int employeeId;
	String employeeName;
	float employeeSalary;
	
	public Employee(int employeeId, String employeeName, float employeeSalary) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.employeeSalary = employeeSalary;
	}

	public String toString() {
		return employeeId+" "+ employeeName+" "+ employeeSalary;
		
	}
	
	
}
