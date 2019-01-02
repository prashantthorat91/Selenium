import java.util.Scanner;

public class Overriding {
	public static void main(String [] args) {
	Scanner sc =new Scanner(System.in);
	System.out.println("enter string");
	String str1 = sc.nextLine();
	System.out.println("enter character");
	char ch = sc.nextLine().charAt(0);
	int count=0;
	for(int i=0;i<str1.length();i++) {
		if(ch==str1.charAt(i))
			count++;
	}
	System.out.println(count);



	}
	

	

}


