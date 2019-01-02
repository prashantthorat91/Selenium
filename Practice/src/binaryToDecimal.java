import java.util.Scanner;


public class binaryToDecimal {
	public static void main(String[] args) {
		A a= new A();
		a.m1();
		try {
			System.out.println(a);
		}
		catch(Exception e) {
			System.out.println("number is non divisibal by zero");
		}
		finally{
			System.out.println("number is non divisibal by zero");
		}

	}
}
/*class A{
	public void m1() {
		System.out.println("inside m1 block");
		int a = 10/0;
		System.out.println("inside m1 block");
	}
	
}*/

