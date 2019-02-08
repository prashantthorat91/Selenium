
public class SuperAndThis {

	public static void main(String[] args) {
		//Aa a = new Bb();
		Bb b = new Bb();

	}
	

}
class Aa{
	int i= 12;
	Aa(){
		System.out.println("constructor of A");
	}
	Aa(int f){
		
	}
	
}
class Bb extends Aa{
	int b =  super.i;
	Bb(){
		this(12);
		System.out.println("constructor of B");
	}
	Bb(int a){
		super(22);
		System.out.println("patamiterised constructor");
	}
	
}
