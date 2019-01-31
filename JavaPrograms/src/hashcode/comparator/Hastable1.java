package hashcode.comparator;

import java.util.Hashtable;

public class Hastable1 {

	
	public static void main(String[] args) {
		Hashtable h=new Hashtable();
		h.put(101, "abc");
		h.put(102, "xyz");
		h.put(101, "pqr");
		h.put(101, "axx");
		System.out.println(h);
		
		

	}

}
