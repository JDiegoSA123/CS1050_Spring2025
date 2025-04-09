/*
 * 
Juan D Sanchez Acosta
CS 1050
Deb Hardling
Spring 2025
Description:

	Hello, the code's purpose is to
 
 */
public class Project01 
{

	public static void main(String[] args) 
	{
		
	print();
	
	System.out.println("Enter number of Athletes: ");
	
	
		
	
	} // End of Main Method
	

	
	public static int findTopAthlete(int[] array) 
	{
		
	int largestIndex = 0;
	
	for (int i = 1; i < array.length; i++)
	{
		
		if (array[i] > array[largestIndex]) 
		{
			largestIndex = i;
			
		} // end of if
	} //end of loop	
	
		return largestIndex;
	} // end of findTopAthlete method
	
	public static String getBMICategory(double[] BMI) 
	{
		String category;
		int i = 0;
		
		if (BMI[i] >= 30.1) 
		{
			category = "Obese";
		}
		else if (BMI[i] >= 25.1 && BMI[i] <= 30) 
		{
			category = "Overweight";
		}
		else if (BMI[i] >= 18.5 && BMI[i] <= 25) 
		{
			category = "Normal";
		}
		else  
		
			category = "Underweight";
		
		return category;
	}
	
	public static double getBMI(double height, double weight)
	{
		double bmi;
		
		bmi = weight * 703 / (height * height);
		return bmi;
	}
	
	public static void print()
	{
		System.out.println("**************************************************\r\n"
				+ "*    Welcome to the Gym Athlete Fitness Tracker  *\r\n"
				+ "**************************************************\r\n"
				+ "");
	}
	
	
	
	
} // End of class
