package ivprograms;

public class SwapingTwoStrings {
	public static void main(String[] args) {
		String str1 = "string1";
		String str2 = "string2";
		System.out.println("values before swaping are : "+str1+str2);
		str1 = str1+str2;
		str2 = str1.substring(0,str1.length()-str2.length());
		str1 = str1.substring(str2.length());
		System.out.println("values after swaping are : "+str1+str2);
		swapString();
		swapNumber();
		
	}
	public static void swapString() {
		int a=10;
		int b=20;
		String str1= "aaaaaaaaa";
		String str2= "mmmmmmmmmmmm";
		str1 = a+b+str1+str2;
		//str2 = str1.substring(0,str1.length()-str2.length());
		//str1 = str1.substring(str2.length());
		System.out.println(""+str1);
	}
	public static void swapNumber() {
	System.out.println("Befaore swaping");
		int a =10;
		int b =30;
		 a = a+b;
		 b = a-b;
		 a = a-b;
		 System.out.println("a="+a);
		 System.out.println("b="+b);
		 System.out.println(+a+b);

		 
	}
	

}


