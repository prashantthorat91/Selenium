package com.collection;

import java.util.Comparator;

public class Student implements Comparable<Student>
{
   private int id;
   private String name;
   private int mark;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getMark() {
	return mark;
}
public void setMark(int mark) {
	this.mark = mark;
}
public Student(int id, String name, int mark) {
	super();
	this.id = id;
	this.name = name;
	this.mark = mark;
}
@Override
public String toString() {
	return "\nStudent [id=" + id + ", name=" + name + ", mark=" + mark + "]";
}
@Override
public int compareTo(Student o)
{
	return -(this.getName().compareTo(o.getName()));
}
}
class ByMark implements Comparator<Student>
{

	@Override
	public int compare(Student o1, Student o2) {
		// TODO Auto-generated method stub
		if (o1.getId()>o2.getId()) 
		{
			return 1;
		}
		else if(o1.getId()<o2.getId())
		{
			return -1;
		}
		else
		{
			if(o1.getName().compareTo(o2.getName())==0)
			{
				if(o1.getMark()>o2.getMark())
				{
					return 1;
				}
				else if(o1.getMark()<o2.getMark())
				{
					return -1;
				}
				else return 0;
			}
			else
			{
				return o1.getName().compareTo(o2.getName());
			}
			
		}
		//return -(o1.getMark()-o2.getMark());
	}
	


}
