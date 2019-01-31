package practice;

public class SuperThis {

	public static void main(String[] args) {
		B b = new C();

	}

}
class A{
	public int i=22;
	A(){
		System.out.println("inside A's Constructor");
		
	}
	
}
class B extends A{
	
	B(){
		System.out.println("inside B s default constructor");
	}
	B(int i){
		this();
		System.out.println(i);
		
	}
	
}
class C extends B{
	
	{
		
		System.out.println("inside instance field");
	}
	C(){
		super(4);
		System.out.println("inside C s constructor");
	}
	
}
