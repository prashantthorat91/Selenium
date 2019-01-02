import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.Vector;

public class collection {
	
	public static void main(String[] args) {
		Emp e1 = new Emp(1,"A");
		Emp e2 = new Emp(2,"B");
		Emp e3 = new Emp(1,"C");
		Emp e4 = new Emp(1,"A");
		
		
		
		HashMap<Emp,Integer> mapOfEmp = new HashMap<>();
		System.out.println(mapOfEmp.get(e1));
		
		ArrayList<Integer> list = new ArrayList<>();
		list.add(1111);
		list.add(5555);
		list.add(null);

		Set<Object> set = new HashSet<>();
		set.add(40);
		set.add(55);
		set.add(55);
		set.add(75);
		set.add(e1);
		
		System.out.println(set);
	}

}
class Emp{
	private int empId;
	private String empName;
	public int getEmpId() {
		return empId;		
	}
	public Emp(int empId, String empName) {
		super();
		this.empId = empId;
		this.empName = empName;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + empId;
		result = prime * result + ((empName == null) ? 0 : empName.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Emp other = (Emp) obj;
		if (empId != other.empId)
			return false;
		if (empName == null) {
			if (other.empName != null)
				return false;
		} else if (!empName.equals(other.empName))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Emp [empId=" + empId + ", empName=" + empName + "]";
	}
	
}
