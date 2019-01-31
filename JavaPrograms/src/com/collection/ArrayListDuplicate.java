package com.collection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class ArrayListDuplicate {

	public static void main(String[] args) {
	/*	ArrayList al = new ArrayList();
		al.add("Aniket");
		al.add("KK");
		al.add("DC");
		al.add("SU");
		al.add("KD");
		al.add("Aniket");
		Object[] ar = al.toArray();
		HashSet hs = new HashSet();
		boolean isDuplicate = false;
		for (int i = 0; i < al.size(); i++) {
			if (hs.add(ar[i])) {
				System.out.println(ar[i] + " : Added to hs");
			}else{
				System.out.println(ar[i] + " : is duplicate so not added to hs");
			}
		}*/
		ArrayListDuplicate.duplicate();
	}
	public static void duplicate() {
		ArrayList al = new ArrayList();
		al.add("Aniket");
		al.add("KK");
		al.add("DC");
		al.add("SU");
		al.add("KD");
		al.add("Aniket");
		HashSet set = new HashSet();
		Iterator itr = al.listIterator();
		while(itr.hasNext()) {
			String str = (String) itr.next();
			if(set.contains(str)) {
				System.out.println(str+" found duplicate");
			}else {
				set.add(str);
			}
		}
		System.out.println(set);
	}
}

