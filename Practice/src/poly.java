
public class poly {
	public static void main(String[] args) {
		A c = new C();
		A a = new C();
		a.m2();
		//c.m1();
		
	}

}
class A{
	int a=23;{
		System.out.println(a+"---4");
	}
	{
		System.out.println("Instance block of class A----5");
	}
	static{
		System.out.println("inside static block of A----1");
	}
	
	void m1() {
		System.out.println("inside m1 of class A");
	}
	static void m2() {
		System.out.println("inside m2 of class A Static block");
	}
	void m3() {
		System.out.println("inside m3 of class A");
	}
	public A() {
		System.out.println("constructor of class A----6");
	}
	
	
	
}
class B extends A{
	void m1() {
		System.out.println("inside m1 of class B");
	}
	 static void m2() {
		System.out.println("inside m2 of class B Static block");
	}
	 static{
			System.out.println("inside static block of B---2");
		}
	 public B() {
			System.out.println("constructor of class B---8");
		}
	 {
	 System.out.println("Instance block of class B----7");
	 }
	
	
}
class C extends B{
	void m1() {
		System.out.println("inside m1 of class C-----11");
	}
	static void m2() {
		System.out.println("inside m2 of class C Static block");
	}
	static{
		System.out.println("inside static block of C--3");
	}
	public C() {
		System.out.println("constructor of class C----10");
	}
	{
		System.out.println("Instance block of class C----9");
	}
	
	
}