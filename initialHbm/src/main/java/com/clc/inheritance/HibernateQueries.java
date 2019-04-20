package com.clc.inheritance;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;




public class HibernateQueries {

	public static void main(String[] args) {

		Student st1 = new Student(101,"AABBAA",20933.432,29);
		Student st2 = new Student(102,"bbaBBAA",40933.432,59);
		Student st3 = new Student(103,"aaBBAA",25933.432,26);
		Student st4 = new Student(104,"3094vBBAA",60933.432,79);
		Student st5 = new Student(105,"AABBAA",20933.432,39);
		
		
		Configuration configuraton = new Configuration();
		//configuraton.addAnnotatedClass(Student.class);
		SessionFactory sfactory = configuraton.configure("mysql-hibernate.cfg.xml").buildSessionFactory();
		Session session = sfactory.openSession();
		
		Transaction tr = session.beginTransaction();
		session.save(st1);session.save(st2);session.save(st3);
		session.save(st4);session.save(st5);
		session.flush();
		tr.commit();
		
		
		Student st11  = (Student) session.get(Student.class, 101);
		//Student s = session.get(Student.class, 121);
		Student st22  = (Student) session.load(Student.class, 102);
		List<Student> studs  = session.createCriteria(Student.class).list();
		//database specific -- jdbc
		//inline 
		SQLQuery query1 = session.createSQLQuery("select * from stud_info_hbm where studId=101");//native
		List<Student> listOfStudsUsingSQL = query1.addEntity(Student.class).list();
		//database independent 
		//inline
		Query query = session.createQuery("from Student where empId=101"); //hql
		List<Student> listOfStudsHQL = query.list();

		query  = session.getNamedQuery("sql_all_studs");
		List<Student> nmntSqlQuery = query.list();
		
		query  = session.getNamedQuery("sql_age_gk_26");
		List<Student> nmntSqlQuery26 = query.list();
		
		query = session.getNamedQuery("hql_all_studs");
		List<Student> nmquery = query.setString("aaa", "3094vBBAA").list();
		
		
		System.out.println("Using get"+st11);
		System.out.println("-------------------------------\n");
		System.out.println("Using load"+st22);
		System.out.println("-------------------------------\n");
		System.out.println("Using criteria"+studs);
		System.out.println("-------------------------------\n");
		System.out.println("Using sqlquery"+listOfStudsUsingSQL);
		System.out.println("-------------------------------\n");
		System.out.println("Using hqlquery"+listOfStudsHQL);
		System.out.println("-------------------------------\n");
		
		System.out.println("NativeQueries....");
		
		System.out.println("Using SQL"+nmntSqlQuery);
		System.out.println("-------------------------------\n");
		
		
		System.out.println("Using SQL26"+nmntSqlQuery);
		System.out.println("-------------------------------\n"+nmntSqlQuery26);
		
		System.out.println("Using HQL"+nmntSqlQuery);
		System.out.println("-------------------------------\n"+nmquery);
		
		
		
		if(true)
			return;
		
		/*Student st1 = new Student(101,"AABBAA",20933.432,29);
		Student st2 = new Student(102,"bbaBBAA",40933.432,59);
		Student st3 = new Student(103,"aaBBAA",25933.432,26);
		Student st4 = new Student(104,"3094vBBAA",60933.432,79);
		Student st5 = new Student(105,"AABBAA",20933.432,39);
		
		Configuration configuraton = new Configuration();
		configuraton.addAnnotatedClass(Student.class);
		SessionFactory sfactory = configuraton.configure("/mysql-hibernate.cfg.xml").buildSessionFactory();
		Session session = sfactory.openSession();
		Transaction tr = session.beginTransaction();
		session.save(st1);session.save(st2);session.save(st3);
		session.save(st4);session.save(st5);
		session.flush();
		tr.commit();*/
		
	}
	
}



//precompied
@NamedNativeQueries({
    @NamedNativeQuery(name = "sql_all_studs", query = "select * from stud_info_hbm",resultClass=Student.class),
    @NamedNativeQuery(name = "sql_age_gk_26", query = "select * from stud_info_hbm where empAge>26",resultClass=Student.class)
})

@NamedQueries({  
	   @NamedQuery(name = "hql_all_studs",query = "from Student  where empName = :aaa"  
	        )  
	    }  
	)  
@Entity
@Table(name="stud_info_hbm")
class Student{
	@Id
	@Column(name="studId")
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
	@Override
	public String toString() {
		return "Student [empId=" + empId + ", empName=" + empName
				+ ", empSalary=" + empSalary + ", empAge=" + empAge + "]";
	}
	public Student(int empId, String empName, double empSalary, int empAge) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empSalary = empSalary;
		this.empAge = empAge;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}