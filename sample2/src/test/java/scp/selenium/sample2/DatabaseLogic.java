package scp.selenium.sample2;

import java.util.List;

public class DatabaseLogic {

	public static void main(String[] args) {
		Database.getConnection();
		//Database.insertRecordInTable(10);
		/*List<Emp1> listOfemps = Database.fetchAllDataFromDatabase();
		System.out.println("Here is the data :"+listOfemps);*/
		//Database.DeleteRecords();
		List<List<Object>> listOfemps = Database.fetchAllDataFromDatabase1();
		System.out.println("Here is the data :"+listOfemps);
		
		
		//Datbase.DeleteRecord();

	}

}
class Emp1{
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

