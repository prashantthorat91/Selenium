package com.clc.util;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="emp_info_hbm")
public class Employee {
		@Id
		@Column(name="emp_id")
		private int empId;
		
		@Column(name="emp_name",length=30)
		private String empName;
		
		private int empAge;
		private String empAddress;
		private String empCompany;
		
		
		
		
		
		public String getEmpCompany() {
			return empCompany;
		}
		public void setEmpCompany(String empCompany) {
			this.empCompany = empCompany;
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
		public int getEmpAge() {
			return empAge;
		}
		public void setEmpAge(int empAge) {
			this.empAge = empAge;
		}
		public String getEmpAddress() {
			return empAddress;
		}
		public void setEmpAddress(String empAddress) {
			this.empAddress = empAddress;
		}
		@Override
		public String toString() {
			return "Employee [empId=" + empId + ", empName=" + empName
					+ ", empAge=" + empAge + ", empAddress=" + empAddress + "]";
		}
		public Employee(int empId, String empName, int empAge, String empAddress,String empCompany) {
			super();
			this.empId = empId;
			this.empName = empName;
			this.empAge = empAge;
			this.empAddress = empAddress;
			this.empCompany=empCompany;
		}
		public Employee() {
			super();
		}
		
		
		

}
