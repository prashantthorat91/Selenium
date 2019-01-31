package com.collection;

public class Employee implements Comparable<Employee> {
	String empName;
	int empID;
	String empAddress;

	public Employee(String empName, int empID, String empAddress) {
		super();
		this.empName = empName;
		this.empID = empID;
		this.empAddress = empAddress;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public int getEmpID() {
		return empID;
	}
	public void setEmpID(int empID) {
		this.empID = empID;
	}
	public String getEmpAddress() {
		return empAddress;
	}
	public void setEmpAddress(String empAddress) {
		this.empAddress = empAddress;
	}
	@Override
	public String toString() {
		return "\nEmployee [empName=" + empName + ", empID=" + empID + ", empAddress=" + empAddress + "]";
	}
	@Override
	public int compareTo(Employee o) {
	
		return -(this.getEmpName().compareTo(o.getEmpName()));
	}
	

}
class SortByID implements Comparable<Employee>{

	@Override
	public int compareTo(Employee o) {
		return 0;
	}
	
}
