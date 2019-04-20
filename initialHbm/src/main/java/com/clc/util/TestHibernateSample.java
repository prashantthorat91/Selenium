package com.clc.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.clc.util.AppConstants.MyDB;


public class TestHibernateSample {
	public static void main(String[] args) {
		
		Employee e1 = new Employee(11,"AAA", 38, "Pune", "INfy"); //Transient
		
		SessionFactory mysql = FactoryUtil.getSessionFactory(MyDB.MYSQL);
		Session session = mysql.openSession();
		
		/*System.out.println("before get....");
		Employee dbEmp1 = (Employee) session.get(Employee.class, 1119); //eager  //persistent
		System.out.println("after get" +dbEmp1);*/
		System.out.println("before load....");
		Employee dbEmp2 = (Employee) session.load(Employee.class, 1119);//lazy
		System.out.println("after load"+dbEmp2);
		
		System.out.println("Printing info for both objects...");
		//System.out.println("EMp1" +dbEmp1);
		//System.out.println("EMp2" +dbEmp2);
		
		//System.out.println(e1.hashCode());
		//System.out.println(dbEmp1.hashCode());
		//System.err.println(dbEmp2.hashCode());
		
		/*Transaction tr = session.beginTransaction();
		session.save(e1);
		session.flush();
		tr.commit();*/
		
/*		SessionFactory mysql = FactoryUtil.getSessionFactory(MyDB.MYSQL);
		SessionFactory hsql = FactoryUtil.getSessionFactory(MyDB.HSQL);
		
		Session sesion11 = mysql.openSession();
		Session sesion12 = mysql.openSession();
		Session sesion13 = mysql.getCurrentSession();
		Session sesion14 = mysql.getCurrentSession();

		Session sesion21 = hsql.openSession();
		Session sesion22 = hsql.openSession();
		
		Session sesion23 = hsql.getCurrentSession();
		Session sesion24 = hsql.getCurrentSession();
		
		System.out.println(sesion11.hashCode());//1499840045
		System.out.println(sesion12.hashCode());//67749199
		System.out.println(sesion13.hashCode());//65488937
		System.out.println(sesion14.hashCode());//65488937
		
		System.out.println(sesion21.hashCode());//1332691311
		System.out.println(sesion22.hashCode());//999230073
		System.out.println(sesion23.hashCode());//1910936570
		System.out.println(sesion24.hashCode());//1910936570
*/
		/*		Employee e1 = new Employee(111, "AAA1",22,"Pune");
		
		EmpServiceImpl hsqlImpl = new EmpServiceImpl(MyDB.HSQL);
		EmpServiceImpl mysql = new EmpServiceImpl(MyDB.MYSQL);
		
		hsqlImpl.addEmp(e1); // hsqldb
		Employee dbEmp = hsqlImpl.getEmp(111); //get frm hsqldb
		
		dbEmp.setEmpCompany("Infy...!");
		mysql.addEmp(dbEmp);
*/		
		
	}

}