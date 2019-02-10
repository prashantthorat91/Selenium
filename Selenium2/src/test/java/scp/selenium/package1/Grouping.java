package scp.selenium.package1;

import org.testng.annotations.Test;

public class Grouping {
	
	@Test(groups= {"car"})
	public void car1() {
		System.out.println("Batch car   test Alto");
	}
	@Test(groups= {"car"})
	public void car2() {
		System.out.println("Batch car   test Swift");
	}
	@Test(groups= {"scooter"})
	public void scooter1() {
		System.out.println("Batch scooter   test Pulsor");
	}
	@Test(groups= {"scooter"})
	public void scooter2() {
		System.out.println("Batch scooter   test Bullet");
	}
	@Test(groups= {"riksha"})
	public void scooter3() {
		System.out.println("Batch scooter   test riksha2t");
	}
	@Test(groups= {"scooter", "riksha"})
	public void scooterCar() {
		System.out.println("Batch riksha   test riksha");
	}
}
