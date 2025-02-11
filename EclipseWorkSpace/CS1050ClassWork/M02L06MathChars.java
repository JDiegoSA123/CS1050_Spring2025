
import java.util.Scanner;

public class M02L06MathChars {
	 
	 
	public static void main(String[] args) {
		
	final int MIN = 1;
	final int MAX = 12;
	int randomMonth;
	
	double exponentResult =	Math.pow(10, 2);
	System.out.println("result = " + exponentResult);

	double randomDouble = Math.random();
	int randomInt = (int)randomDouble;
	randomInt = (int)(randomDouble * 10);
	randomInt = (int)(randomDouble * 10 + 1);
	randomMonth = (int)(Math.random()* (MAX-MIN + 1) + MIN);
	
	System.out.println(randomMonth);
	
	char middleInitial = '2';
	int charIntValue = 1;
	
	System.out.println(middleInitial);
	
	charIntValue = (int)middleInitial;
	
	System.out.println(charIntValue);
	
	Scanner input = new Scanner(System.in);
	
	System.out.println("enter a char");
	char someChar = input.next().charAt(0);
	
	System.out.printf("A char was entered with ascii vaule %d \n", someChar);
	
	String firstName = "Diego";
	
	
	}

}
