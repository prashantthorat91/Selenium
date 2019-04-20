package com.clc.inheritance;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.clc.util.AppConstants.MyDB;
import com.clc.util.FactoryUtil;

public class HibernateMappings {
	public static void main(String[] args) {

		Address address1 = new Address(101,"Pune1");
		Address address2 = new Address(102,"Pune2");
		Address address3 = new Address(103,"Pune3");
		
		Employee e1 = new Employee(1,"AAA", address1);
		Employee e2= new Employee(2,"BBB", address2);
		Employee e3 = new Employee(3,"CCC", address3);
		
		SessionFactory mysqlFactory = FactoryUtil.getSessionFactory(MyDB.MYSQL);
		Session session = mysqlFactory.openSession();
		Transaction tr = session.beginTransaction();
		session.save(e1);
		session.save(e2);
		session.save(e3);
		
		session.flush();
		tr.commit();
	
		
		
	}
}


@Entity
@Table(name="emp_info_tab")
class Employee{
	@Id
	private int empId;
	private String empName;
	
	@OneToOne(cascade=CascadeType.ALL)
	private Address address;

	public Employee(int empId, String empName, Address address) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.address = address;
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName
				+ ", address=" + address + "]";
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

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	
	
}

@Entity
@Table(name="emp_Address")
class Address{
	@Id
	private int addressId;
	private String city;
	public int getAddressId() {
		return addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Address(int addressId, String city) {
		super();
		this.addressId = addressId;
		this.city = city;
	}
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", city=" + city + "]";
	}
	
	
}
