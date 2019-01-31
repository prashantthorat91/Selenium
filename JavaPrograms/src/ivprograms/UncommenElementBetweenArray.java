package ivprograms;

import java.util.ArrayList;
import java.util.List;

public class UncommenElementBetweenArray {

	public static void main(String[] args) {
		String[] str1 = {"ABC","pqr","ABC","abc","pst"};
		String[] str2 = {"ABC","pQr","sC","abc","hh","aa"};
		boolean contains = false;
		List<String> result = new ArrayList<>();
		for(int i=0;i<str1.length;i++) {
			for(int j=0;j<str2.length;j++) {
				if(str1[i].equals(str2[i])) {
					contains = true;
					break;
				}
			}
			if(!contains) {
				result.add(str1[i]);
			}else {
				contains = false;
			}
		}
		System.out.println(result);

	}

}
