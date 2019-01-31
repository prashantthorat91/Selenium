package ivprograms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class commanElementBetweenArray {

	public static void main(String[] args) {
		String[] str1 = {"ABC","pqr","ABC","abc","pst"};
		String[] str2 = {"ABC","pQr","sC","abc","hh","aa"};
		HashSet<String> set = new HashSet<String>();
		List<String> list = new ArrayList<>();
		for(int i =0;i<str1.length;i++){
			for(int j=0;j<str2.length;j++) {
				 if(str1[i].equals(str2[i])) {
					 set.add(str1[i]);
					 list.add(str1[i]);
				 }
			}
		}
		System.out.println(list);
		System.out.println(set);
		
		{
	        Integer[] i1 = {1, 2, 3, 4, 5, 4};
	 
	        Integer[] i2 = {3, 4, 5, 6, 7, 4};
	 
	        HashSet<Integer> set1 = new HashSet<>(Arrays.asList(i1));
	 
	        HashSet<Integer> set2 = new HashSet<>(Arrays.asList(i2));
	 
	        set1.retainAll(set2);
	 
	        System.out.println(set1);     //Output : [3, 4, 5]
	    }
	}

}
