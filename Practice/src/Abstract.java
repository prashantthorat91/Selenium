
public class Abstract {
	public static void main(String[] args) {
		B1 b = new B1();
		b.widrowAmount();
	}

}
abstract class A1{
	abstract public void widrowAmount();
	public void DepositAmount() {
		
	}
}
class B1 extends A1{
	public String name;{
		System.out.println("Name");
	}
	@Override
	public void widrowAmount() {
		System.out.println("widrow amount");
		
	}
	
	
}
