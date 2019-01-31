package ivprograms;

public class RemovSpecialCharacter {

	public static void main(String[] args) {
		String s = "prashant!!$%#thorat@123&*(";
		// Regular expression [A-Z a-z 0-9]
		s=s.replaceAll("[^a-zA-Z0-9]", "");
		System.out.println(s);
		String str= "prashant aeiou thorat";
		str=str.replaceAll("[aeiou]", "");
		System.out.println(str);
		s=s.replaceAll("[#%$]", "");
		System.out.println(s);
	}

}
