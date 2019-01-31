package ivprograms;

import java.util.Scanner;

public class inputIsNumberOrNot {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter string");
		String str = sc.nextLine();
		try {
			Integer.parseInt(str);
			System.out.println("enterd string is number");
		}
		catch(NumberFormatException e) {
			System.out.println("enterd string is not number");
		}
		/*if(Utility.numberOrNot(str)) {
			System.out.println("enterd string is number");
		}else {
			System.out.println("enterd string is not number");
		}*/
	}
}
class Utility
{
    static boolean numberOrNot(String input)
    {
        try
        {
            Integer.parseInt(input);
        }
        catch(NumberFormatException ex)
        {
            return false;
        }
        return true;
    }
}
