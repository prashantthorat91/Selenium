package com.clc.inheritance;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.clc.util.AppConstants.MyDB;
import com.clc.util.FactoryUtil;
public class TestHibernateInheritance {
	public static void main(String[] args) {
		
		Emp e1 = new Emp(101,"AAAA");
		CEmp ce1 = new CEmp(201,"BBB",22994.32);
		PEmp pe1 = new PEmp(301,"CCC",122994.32);
		
		CEmp ce12 = new CEmp(201,"BBB",22994.32);
		CEmp ce13 = new CEmp(201,"BBB",22994.32);
		CEmp ce14 = new CEmp(201,"BBB",22994.32);
		
		Emp e12 = new Emp(101,"AAAA");
		Emp e13 = new Emp(101,"AAAA");
		Emp e14 = new Emp(101,"AAAA");
		
		
		
		SessionFactory mysqlFactory = FactoryUtil.getSessionFactory(MyDB.MYSQL);
		Session session = mysqlFactory.openSession();
		Transaction tr = session.beginTransaction();
		session.save(e1);
		session.save(ce1);
		session.save(pe1);
		
		session.save(ce12);
		session.save(ce13);
		session.save(ce14);
		
		session.save(e12);
		session.save(e13);
		session.save(e14);
		
		session.flush();
		tr.commit();
		
	}
}


@Entity
@Table(name="emp_inheritance_tab")
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
class Emp{
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int empId;
	private String empName;
	
	@Override
	public String toString() {
		return "Emp [empId=" + empId + ", empName=" + empName + "]";
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
	public Emp(int empId, String empName) {
		super();
		this.empId = empId;
		this.empName = empName;
	}
	public Emp() {
		super();
	}
	
	
}
@Entity
@DiscriminatorValue(value="C")
class CEmp extends Emp{
	
	private double conSal;

	public double getConSal() {
		return conSal;
	}

	public void setConSal(double conSal) {
		this.conSal = conSal;
	}

	public CEmp(int empId, String empName, double conSal) {
		super(empId, empName);
		this.conSal = conSal;
	}

	public CEmp() {
		super();
	}

	public CEmp(int empId, String empName) {
		super(empId, empName);
	}

	@Override
	public String toString() {
		return super.toString()+"CEmp [conSal=" + conSal + "]";
	}

	
	
	
}


@Entity
@DiscriminatorValue(value="P")
class PEmp extends Emp{
	private double comSal;

	public double getComSal() {
		return comSal;
	}

	public void setComSal(double comSal) {
		this.comSal = comSal;
	}

	@Override
	public String toString() {
		return super.toString()+"PEmp [comSal=" + comSal + "]";
	}

	public PEmp(int empId, String empName, double comSal) {
		super(empId, empName);
		this.comSal = comSal;
	}

	public PEmp() {
		super();
	}

	public PEmp(int empId, String empName) {
		super(empId, empName);
	}
	
	
	
	
	
	
}