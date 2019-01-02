import java.util.Scanner;

public class occurance {
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the string");
		String str = sc.nextLine();
		System.out.println("enter character");
		char ch= sc.next().charAt(0);
		int count =0;
		for(int i =0;i<str.length();i++) {
			if(ch==str.charAt(i)) {
				count++;
			}
		}
		System.out.println(count);
		word w =new word();
		w.abc();
		}

}
class word{
	public void abc() {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the strings to find woard");
		String str1 = sc.nextLine();
		System.out.println("enter the word to find ");
		String word = sc.nextLine();
		String[] a = str1.split(" ");
		int count =0;
		for (int i =0;i<a.length;i++) {
			if (word.equals(a[i]))
				count++;
		}
		System.out.println(count);
		
	}
}
