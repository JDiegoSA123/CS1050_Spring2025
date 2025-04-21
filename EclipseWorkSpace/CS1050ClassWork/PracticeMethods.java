import java.util.Scanner;

public class PracticeMethods 
{

	public static void main(String[] args) 
	{
	int num1 = 5;
	int[][] array2D = new int [num1][num1];
	for(int row = 0; row < num1; row++)
	{
		for(int col = 0;col < num1; col++)
		{
			array2D[row][col] = (row + 1) * ( col + 1);
		}
	}
	
	final int MAX = 5;
	int maxsum = sum(MAX);
	double gradef = getValidGrade(0,105);
	
	System.out.println("the sum is " + maxsum);
	
	int sumTotal = 0;
	int i = 0;
	do {
		sumTotal = sumTotal + i;
		i++;
	} while (i < MAX );
	System.out.println("sumTotal is: " + sumTotal);
	
	
	
	
	
	
	
	
	
	
	}// End of Main Method
	
	public static int sum(int MAX) 
	{
		int total = 0;
		for (int i = 0; MAX >= i; i++) 
		{
			total = total + i;
		}
		return total;
	}// End of sum Method 
	
	public static double getValidGrade(double MIN, double MAX) 
	{
		double grade;
		Scanner input = new Scanner(System.in);
	
		grade = input.nextDouble();
		while (grade >= MIN || grade <= MAX) 
		{
			System.out.println("Please enter a valid grade:");
			grade = input.nextInt();
		}
		return grade;
	} // End of getValidGrade

}// End of Class


