package ivprograms;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Set;

public class DuplicateCharacter {

	public static void main(String[] args) throws IOException {
		BufferedReader buff = new BufferedReader(new FileReader("C:\\Users\\Prashant\\Desktop\\ABC.txt"));
		String line = null;
		int count=0;
		HashMap<Character, Integer> map = new HashMap<>();
		while((line=buff.readLine())!= null) {
			System.out.println(line);
			char[] ch = line.toCharArray();
			for(char ch1:ch) {
				if(map.containsKey(ch1)) {
					map.put(ch1, map.get(ch1)+1);
				}else {
					map.put(ch1, 1);
				}
				count++;
			}
		}
		System.out.println(map);
		System.out.println(count);
		Set<Character> set= map.keySet();
		System.out.println("------------");
		System.out.println("Duplicate character in string is:");
		for(Character ch2: set) {
			if(map.get(ch2)>1) {
				System.out.println(ch2+" : "+map.get(ch2));
			}
		}

	}
	

}
