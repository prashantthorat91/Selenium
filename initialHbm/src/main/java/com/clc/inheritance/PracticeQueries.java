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
	
	SessionFactory factory = new Configuration().configure("mysql-hibernate.cfg.xml").buildSessionFactory();
	Session s= factory.openSession();
	Transaction tr = s.beginTransaction();
	s.save(st1);
	s.save(st2);
	s.save(st3);
	s.save(st4);
	s.flush();
	tr.commit();
	
	stud std1 = s.get(stud.class, 1);
	System.out.println(std1);
	stud std2 = s.load(stud.class, 2);
	System.out.println(std2);
	List<stud> list = s.createCriteria(stud.class).list();
	System.out.println( list);
	
	SQLQuery query = s.createSQLQuery("select * from emp_info");
	List<stud> list2 = query.addEntity(stud.class).list();
	System.out.println(list2);
	
	Query query1 = s.createQuery("from stud where empId = 1");
	List<stud> hbmquery = query1.list();
	System.out.println(hbmquery);
	Query query2 = s.getNamedQuery("sql_all_emp"); 
	List<stud> list1 = query2.list();
	System.out.println(list1);
	
	query2 = s.getNamedQuery("select_all_emp_HQL");
	List<stud> list3 = query2.setString("aa", "4").list();
	System.out.println(list3);
	
	

	}
}

@NamedNativeQueries({
	@NamedNativeQuery(name="sql_all_emp",query="select*from emp_info" , resultClass= stud.class)
})
@NamedQueries({
	@NamedQuery(name = "select_all_emp_HQL", query = "from stud where empId =:aa")
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