package ivprograms;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class removeWhiteSpace {
	public static void main(String[] args) throws IOException {
		BufferedReader buff = new BufferedReader(new FileReader("C:\\Users\\Prashant\\Desktop\\ABC.txt"));
		/*String str = buff.readLine();
		System.out.println(str.replaceAll(" ", ""));
		System.out.println("---------");*/
		String line = null;
		while((line=buff.readLine())!=null) {
			//System.out.println(line);
			String line1= line.replaceAll(" ", "");
			System.out.println(line1);
		}
	}
}

