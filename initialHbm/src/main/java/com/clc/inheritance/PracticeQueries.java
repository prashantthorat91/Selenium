package com.clc.inheritance;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import org.hibernate.cfg.Configuration;



public class PracticeQueries {
	
	public static void main(String[] args) {
		
	
	stud st1 = new stud(1, "prashant", 2500, 15);
	stud st2 = new stud(2, "pratik", 4500, 55);
	stud st3 = new stud(3, "vivek", 1500, 25);
	stud st4 = new stud(4, "santosh", 9500, 35);
	
	SessionFactory factory = new Configuration().configure("mysql-hibernate.cfg.xml").addAnnotatedClass(stud.class).buildSessionFactory();
	Session s= factory.openSession();
	Transaction tr = s.beginTransaction();
	s.save(st1);
	s.save(st2);
	s.save(st3);
	s.save(st4);
	s.flush();
	tr.commit();
	
	

	stud st = s.get(stud.class, 1);
	System.out.println(st);
	stud s1 = s.load(stud.class, 2);
	System.out.println(s1);
	List<stud> list = s.createCriteria(stud.class).list();
	System.out.println(list);
	
	SQLQuery squery = s.createSQLQuery("select * from emp_info where empName = 'prashant'");
	List<stud> lis = squery.addEntity(stud.class).list();
	System.out.println(lis);
	Query query = s.createQuery("from stud");
	List<stud> lis1 = query.list();
	System.out.println(lis1);
	
	Query query1 = s.getNamedQuery("info");
	List<stud> lis2 = query1.list();
	System.out.println(lis2);
	
	Query query2 = s.getNamedQuery("named_info");
	List<stud> list3 = query2.setString("aa", "prashant").list();
	System.out.println(list3);

	}
}

@NamedNativeQueries({
	@NamedNativeQuery(name="info",query= "select * from emp_info", resultClass= stud.class)
})
@NamedQueries({
	@NamedQuery(name="named_info",query="from stud where empName =:aa")
})

@Entity
@Table(name="emp_info")
class stud{
	@Id
	@Column(name="emp_ID")
	private int empId;
	private String empName;
	private double empSalary;
	private int empAge;
	public int getEmpId() {
		return empId;
	}
	
	public stud() {
		super();
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
	public int getEmpAge() {
		return empAge;
	}
	public void setEmpAge(int empAge) {
		this.empAge = empAge;
	}
	public stud(int empId, String empName, double empSalary, int empAge) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empSalary = empSalary;
		this.empAge = empAge;
	}
	@Override
	public String toString() {
		return "Student [empId=" + empId + ", empName=" + empName + ", empSalary=" + empSalary + ", empAge=" + empAge
				+ "]";
	}
	
}