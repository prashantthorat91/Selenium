package com.clc.util;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class EmpServiceImpl implements EmpService{

	private SessionFactory factory = null;
	public EmpServiceImpl(AppConstants.MyDB database){
		factory = FactoryUtil.getSessionFactory(database);
	}
	
	
	public boolean addEmp(Employee emp) {
		Session session =null;
		Transaction tr=null;
		try{
			session = factory.openSession();
			tr = session.beginTransaction();
			session.save(emp);
			return true;
		}catch(Exception e){
			System.out.println("Error In Add Emp" +e);
			return false;
		}finally{
			FactoryUtil.cleanUpResources(session,tr);
		}
	}

	public Employee getEmp(int empId) {
		Session session =null;
		try{
			session = factory.openSession();
			return (Employee) session.get(Employee.class, empId);
		}catch(Exception e){
			System.out.println("Error In Get Emp" +e);
			return null;
		}finally{
			FactoryUtil.cleanUpResources(session,null);
		}
	}

	public Employee updateEmp(Employee emp) {
		Session session =null;
		Transaction tr=null;
		
		Employee dbEmp = getEmp(emp.getEmpId());
		
		if(dbEmp !=null){
			try{
				session = factory.openSession();
				tr = session.beginTransaction();
				session.update(emp);
				return getEmp(emp.getEmpId());
			}catch(Exception e){
				System.out.println("Error In Add Emp" +e);
			}finally{
				FactoryUtil.cleanUpResources(session,tr);
			}
		}
		return null;
	}

	public List<Employee> deleteEmp(int empId) {
		Session session =null;
		Transaction tr=null;
		Employee dbEmp = getEmp(empId);
		if(dbEmp !=null){
			try{
				session = factory.openSession();
				tr = session.beginTransaction();
				session.delete(dbEmp);
			}catch(Exception e){
				System.out.println("Error In Add Emp" +e);
			}finally{
				FactoryUtil.cleanUpResources(session,tr);
			}
		
		}
		return getAllEmps();
	}

	public List<Employee> getAllEmps() {
		Session session =null;
		try{
			session = factory.openSession();
			return session.createCriteria(Employee.class).list();
		}catch(Exception e){
			System.out.println("Error In Add Emp" +e);
			return null;
		}finally{
			FactoryUtil.cleanUpResources(session,null);
		}
	}

}
