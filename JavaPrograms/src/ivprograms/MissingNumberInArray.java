package ivprograms;

public class MissingNumberInArray {

	public static void main(String[] args) {
		int [] a= {1,2,3,4,5,6,10};
		int sum=0;
		for(int i=0;i<a.length;i++) {
			sum=sum+a[i];
			//System.out.println(sum);
		}
		int sum2=0;
		for(int j=0;j<=10;j++) {
			sum2=sum2 +j;
			//System.out.println(sum2);
		}
		System.out.println("missing number is:: "+(sum2-sum));

	}

}
