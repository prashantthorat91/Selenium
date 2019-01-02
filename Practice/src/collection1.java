import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

public class collection1 {
	public static void main(String[] args) throws IOException {
		HashMap<String,Integer> map= new HashMap<>();
		map.put("prashant", 10);
		map.put("pratik", 15);
		map.put("prashant", 14);
		map.putIfAbsent("karad", 50);
		Collection<Integer> values = map.values();
		ArrayList<Integer> list = new ArrayList<>(values);
		for(Integer val: list) {
			System.out.println(val);
		}
		Set<Entry<String, Integer>> list1 = map.entrySet();
		ArrayList<Entry<String, Integer>> ArryL = new ArrayList<>(list1);
		for(Entry<String, Integer> lst: ArryL) {
			System.out.println(lst.getKey()+"...."+lst.getValue());
		}
		
		for(int i=0;i<map.size();i++)
		{
			System.out.println(ArryL.get(i).getKey()+"::"+ArryL.get(i).getValue());
		}
		System.out.println(Collections.max(values));

		
	}

}
