package com.clc.inheritance;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TestMapping {
	public static void main(String[] args) {
		Address1 ad1 = new Address1(1,"Pune2","MH");
		Emp1 e1 = new Emp1(1,"AAAAA",19828.2);
		ad1.setEmp(e1);
		
		Configuration configuraton = new Configuration();
		configuraton.addAnnotatedClass(Emp.class).addAnnotatedClass(Address1.class);
		SessionFactory sfactory = configuraton.configure("mysql-hibernate.cfg.xml").buildSessionFactory();
		Session session = sfactory.openSession();
		Transaction tr = session.beginTransaction();
		session.save(ad1);
		//session.save(ad1); //P
		session.flush();
		tr.commit();
					
	}
}


@Entity
@Table(name="emp_map_info")
class Emp1{
@Id
private int empId;
private String empName;

private double empSalary;
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
public double getEmpSalary() {
	return empSalary;
}
public void setEmpSalary(double empSalary) {
	this.empSalary = empSalary;
}
@Override
public String toString() {
	return "Emp [empId=" + empId + ", empName=" + empName + ", empAddress="
			 + ", empSalary=" + empSalary + "]";
}
public Emp1(int empId, String empName, double empSalary) {
	super();
	this.empId = empId;
	this.empName = empName;
	this.empSalary = empSalary;
}
public Emp1() {
	super();
	// TODO Auto-generated constructor stub
}



}

@Entity
@Table(name="address_map_info")
class Address1{
@Id
private int addressId;
private String city;
private String state;


@JoinTable(
        name = "Emp_Address",
        inverseJoinColumns = @JoinColumn(
                name = "eid",
                referencedColumnName = "empId"
        ),
        joinColumns = @JoinColumn(
                name = "aid",
                referencedColumnName = "addressId"
        )
)
@OneToOne(cascade=CascadeType.ALL)
@JoinColumn(name="empId")
private Emp1 emp;


public Emp1 getEmp() {
	return emp;
}
public void setEmp(Emp1 emp) {
	this.emp = emp;
}
public Address1(int addressId, String city, String state) {
	super();
	this.addressId = addressId;
	this.city = city;
	this.state = state;
}
public Address1() {
	super();
	// TODO Auto-generated constructor stub
}
@Override
public String toString() {
	return "Address [addressId=" + addressId + ", city=" + city
			+ ", state=" + state + ", emp=" + emp + "]";
}
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
public String getState() {
	return state;
}
public void setState(String state) {
	this.state = state;
}



}
