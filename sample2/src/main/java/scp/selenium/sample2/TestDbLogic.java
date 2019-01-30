package scp.selenium.sample2;

public class TestDbLogic {
	public static void main(String[] args) {
		Datbase.getConnection();
		//Datbase.createTable();
		Datbase.insertRecordInDb(10);
		//Datbase.DeleteRecord();
		//Datbase.insertRecordInStudent(5);
		//Datbase.fetchAllDataFromDB();
	}

}
class Emp{
	private int empId;
	private String empName;
	private String empAddress;
	
	@Override
	public String toString() {
		return "\nEmp [empId=" + empId + ", empName=" + empName + ", empAddress="
				+ empAddress + "]";
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpAddress() {
		return empAddress;
	}
	public void setEmpAddress(String empAddress) {
		this.empAddress = empAddress;
	}
	
}
