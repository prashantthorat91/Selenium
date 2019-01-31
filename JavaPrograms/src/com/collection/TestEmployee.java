package com.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class TestEmployee {

	public static void main(String[] args) {
		Employee emp1 = new Employee("A", 12, "x");
		Employee emp2 = new Employee("h", 43, "v");
		Employee emp3 = new Employee("V", 54, "e");
		Employee emp4 = new Employee("B", 14, "g");
		Employee emp5 = new Employee("T", 12, "h");
		
		ArrayList<Employee> list = new ArrayList<>();
		list.add(emp1);
		list.add(emp2);
		list.add(emp3);
		list.add(emp4);
		list.add(emp5);
		System.out.println("list before sort: "+list);
		Collections.sort(list);
		System.out.println("list after sort: "+list);
		Comparator<Employee> cmp = new Comparator<Employee>() {

			@Override
			public int compare(Employee o1, Employee o2) {
			
				return -(o1.getEmpID()-o2.getEmpID());
			}
		};
		System.out.println("using Annonymous");
		Collections.sort(list, cmp);
		System.out.println(list);

	}

}
