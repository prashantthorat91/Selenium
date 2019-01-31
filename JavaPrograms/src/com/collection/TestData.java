package com.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class TestData 
{
   public static void main(String[] args)
   {
	   Student s2=new Student(1, "A", 50);
	   Student s1=new Student(1, "A", 10);
	   

	   Student s3=new Student(2, "C", 20);

	   Student s4=new Student(3, "D", 60);
	   

	  ArrayList<Student> alist=new ArrayList<>();
	  alist.add(s1);
	  alist.add(s2);
	  alist.add(s3);
	  alist.add(s4);
	  //System.out.println(alist);
	  //System.out.println(alist.size());
	  Collections.sort(alist);
	  System.out.println(alist);
	  
	  System.out.println("Useing comparator");
	  Collections.sort(alist, new ByMark());
	  //Collections.sort(alist, Comparator.naturalOrder());
	  System.out.println(alist);
	  
	  Comparator<Student> c=new Comparator<Student>() 
	  {

		@Override
		public int compare(Student o1, Student o2) {
			// TODO Auto-generated method stub
			return -(o1.getId()-o2.getId());
		}
	};
	
	System.out.println("Useing annonymous");
	Collections.sort(alist, c);
	System.out.println(alist);

	  
}
}
