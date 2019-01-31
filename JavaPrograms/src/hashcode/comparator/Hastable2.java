package hashcode.comparator;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

public class Hastable2 {

	public static void main(String[] args) {
		Product4 p1=new Product4(101,"santosh");
		Product4 p2=new Product4(101,"satish");
		Hashtable h=new Hashtable();
		h.put(p1, 222);
		h.put(p2, 666);
		System.out.println(h);
		Iterator<Product4> itr=h.keySet().iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}

	}

}
