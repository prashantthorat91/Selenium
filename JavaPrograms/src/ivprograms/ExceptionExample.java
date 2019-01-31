package ivprograms;

public class ExceptionExample {

	public static void main(String[] args) throws CustomException {
		System.out.println("----------");
		int ab=	Add.addition(0, -5);
		System.out.println(ab);
		
	}
	

}
class CustomException extends Exception{
	
}
class Add{
	
	static public int addition(int a, int b) throws CustomException {
		if(a<0||b<0) {
			System.out.println("cought exception");
				throw new CustomException();
			
		}
		return a+b;
	}
}
