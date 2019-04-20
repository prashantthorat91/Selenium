package com.exception;
class Student
{
	
  int add()
  {
	  int d=10;
	  String ss=null;
	  try
	  {
	  System.out.println("1");
	  int a=10/0;
	  }
	  catch (Exception e)
	  {
		  System.out.println("2");

		int a=20/0;
	}
	  finally
	  {
		  String s=null;
		  System.out.println("3");

		  //System.out.println(s.length());
		 // return 30;

	  }
	 System.out.println(ss.length());
	  return 20;
  }



}
public class TestData 
{
	public static void main(String[] args) 
	{
		Student s=new Student();
		int a=s.add();
		System.out.println(a);
	}

}
