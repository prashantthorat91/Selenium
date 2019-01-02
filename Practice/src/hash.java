import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.Vector;

public class hash {		
	
	    public static void main(String[] args) throws IOException
	    {
	    	AA a= new AA();
	    	a.method();
	    	AA b = new BB();
	    	b.method();
	    	
	    	
 }
	    
}
class AA{
	void method() {
		System.out.println("method of AA");
	}
}
class BB extends AA{
	void method() {
	System.out.println("method of BB");
	}
}
	


