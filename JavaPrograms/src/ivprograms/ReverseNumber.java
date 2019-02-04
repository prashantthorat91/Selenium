package ivprograms;

public class ReverseNumber {

	public static void main(String[] args) {
		long num=778675;
		long rev=0;
		while(num!=0) {
			rev= rev*10+num%10;
			num=num/10;
		}
		System.out.println(rev);
		long num1=456852;
		System.out.println(new StringBuffer(String.valueOf(num1)).reverse());
		int numb= 1234;
		Integer n = numb;
		n.toString();
		
	}
	
	

}
