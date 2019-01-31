package hashcode.comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;



public class Test2 {



	public static void main(String[] args) {
	Product1 p1=new Product1(1, "A", 1000);
	Product1 p2=new Product1(4, "M", 1400);
	Product1 p3=new Product1(8, "F", 1200);
	Product1 p4=new Product1(1, "A", 1800);
	List<Product1> l= new ArrayList<Product1>();
	l.add(p1);
	l.add(p2);
	l.add(p3);
	l.add(p4);
	//Collections.sort(l, new sortProductIDNamePrice());
	//Collections.sort(l, new sortProductIdName());
	//Collections.sort(l, new sortProductId());
	Collections.sort(l, new sortProductPrice());
		System.out.println(l);

	}
}
	class sortProductIDNamePrice implements Comparator<Product1>{

		@Override
		public int compare(Product1 o1, Product1 o2) {
			
			int temp= o1.getProductid()-o2.getProductid();
				if(temp==0) {
					temp=o1.getProductName().compareTo(o2.getProductName());
					if(temp==0) {
						temp=(int) (o1.getPrice()-o2.getPrice());
						
					}
				}
				return temp;
		}
		
	}
	class sortProductIdName implements Comparator<Product1>{

		@Override
		public int compare(Product1 o1, Product1 o2) {
			
			int temp= o1.getProductid()-o2.getProductid();
			if(temp==0) {
				temp=o1.getProductName().compareTo(o2.getProductName());
			}
			return temp;
		}
		
	}
	class sortProductId implements Comparator<Product1>{

		@Override
		public int compare(Product1 o1, Product1 o2) {
			
			return o1.getProductid()-o2.getProductid();
			
			
		}
		
	}
	class sortProductPrice implements Comparator<Product1>{

		@Override
		public int compare(Product1 o1, Product1 o2) {
			
			return (int) (o1.getPrice()-o2.getPrice());
			
			
		}
		
	}

