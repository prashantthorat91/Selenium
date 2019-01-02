import java.util.Scanner;

public class pst {
	public static void main(String [] args) {
		int radius = 0;
		Scanner in = new Scanner(System.in);
		System.out.println("Please enter radious");
		radius = in.nextInt();
		double d = 3.14*radius*radius;
		System.out.println("area of circle="+d);
		evenOdd ev = new evenOdd();
		ev.evenOdd();
	}
}
class evenOdd{
	public void evenOdd() {
		/*int n;
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter number");
		n = sc.nextInt();*/
		for(int a = 1; a<=10; a++) {
		if(a%2==0) {
			System.out.println(a+" is even number");
		}
		else {
			System.out.println(a+" is odd number");

		}
	}}
}