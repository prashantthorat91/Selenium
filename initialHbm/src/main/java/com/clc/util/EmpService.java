package com.clc.util;

import java.util.List;

public interface EmpService {
	
	public boolean addEmp(Employee emp);
	public Employee getEmp(int empId);
	public Employee updateEmp(Employee emp);
	public List<Employee> deleteEmp(int empId);
	public List<Employee> getAllEmps();

}
