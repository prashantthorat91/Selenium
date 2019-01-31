package ivprograms;

import java.util.Arrays;

public class EqualityOfTwoArray {

	public static void main(String[] args) {
		String[] str1 ={"1","2","3","4"};
		String[] str2 ={"1","3","6","4"};
		Arrays.sort(str1);
		Arrays.sort(str2);
		System.out.println(Arrays.equals(str1, str2));
	}

}
