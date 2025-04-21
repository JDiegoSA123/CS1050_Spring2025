/*
 * 
Juan D Sanchez Acosta
CS 1050
Deb Hardling
Spring 2025
Description:

	Hello, the code's purpose is to
 
 */

import java.util.Scanner;
public class Project01 
{

	public static void main(String[] args) 
	{

	System.out.println("**************************************************\r\n"
				+ "*    Welcome to the Gym Athlete Fitness Tracker  *\r\n"
				+ "**************************************************\r\n"
				+ "");
	
	int numOfAthletes;
	Scanner input = new Scanner(System.in);
	Scanner inputCalories = new Scanner(System.in);
	Scanner inputInt = new Scanner(System.in);
	Scanner inputDouble = new Scanner(System.in);

	System.out.println("Enter number of Athletes: ");
	numOfAthletes = input.nextInt();
	while(numOfAthletes <= 0 )
	{
		System.out.println("Error: Value must be greater than 0");		
		numOfAthletes = input.nextInt();
	}
	
	double[] averageDailyCaloriesBurned = new double[numOfAthletes];
	double[] bmis = new double[numOfAthletes];
	int[] maxHeartRate = new int[numOfAthletes];
	double[] caloriesPerDay = new double [6];
	
	int[] age = new int[numOfAthletes];
	double[] height = new double[numOfAthletes];
	double[] weight = new double[numOfAthletes];

	for(int i = 0; i < numOfAthletes; i++)
	{
		System.out.println("Enter data for Athlete " + (i + 1) + ":");
		
		System.out.println("Enter athlete's weight (lbs): ");
		weight[i] = getPositiveDouble(inputDouble);
		System.out.println("Enter athlete's height (inches): ");
		height[i] = getPositiveDouble(inputDouble);
		System.out.println("Enter athlete's age: ");
		age[i] = getPositiveInt(inputInt);
		caloriesPerDay = getDailyCalories(inputCalories);
		
	}
	
	
	
	
	
	} // End of Main Method
	
	public static int getPositiveInt(Scanner intInput)
	{
		int intvalue = 0;	
		intvalue = intInput.nextInt();
		while (intvalue < 0) 
		{
			System.out.println("Please enter a valid grade:");
			intvalue = intInput.nextInt();
		}
		return intvalue;
	}
	
	public static double getPositiveDouble(Scanner doubleInput)
	{
		double doublesvalue = 0;	
		doublesvalue = doubleInput.nextDouble();
		while (doublesvalue < 0) 
		{
			System.out.println("Please enter a valid grade:");
			doublesvalue = doubleInput.nextDouble();
		}
		return doublesvalue;
	}
	
	public static void findUnderweightAthlete(double[] bmis)
	{
		for(int i = 1; i < bmis.length; i++)
		{
			if (bmis[i] < 18.5)
			{
				System.out.println("Athlete " + (i + 1));
			}
		}
	} // End of findUnderweightAthlete
	
	public static int findTopAthleteIndex(int[] array) 
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
	} // End of getBMICategory
	
	public static double calculateBMI(double height, double weight)
	{
		double bmi;
		
		bmi = weight * 703 / (height * height);
		return bmi;
	} // End of getBMI
	
	public static double calculateMaxHeartRate(int age)
	{
		double maxHeartRate = 220 - age;
		return maxHeartRate;
	} // End of calculateMaxHeartRate
	
	public static double[] getDailyCalories(Scanner scanKeyboard)
	{
		double[] dailyCalories = new double[6];
		
		for (int i = 0; i < dailyCalories.length; i++)
		{
			dailyCalories[i] = getPositiveInt(scanKeyboard);
		}
		return dailyCalories;
	} // End of getDailyCalories
	
	public static double calculateAverageCaloriesBurned(double[] currentDailyCalories)
	{
		double avgCalorie = ((currentDailyCalories[0]) + (currentDailyCalories[1]) + 
				(currentDailyCalories[2]) + (currentDailyCalories[3]) + (currentDailyCalories[4]) +
				(currentDailyCalories[5]) + (currentDailyCalories[6]) / 5.0);

		return avgCalorie;
	} // End of calculateAverageCaloriesBurned
	
	public static void displayAthleteSummary(double[] averageCalories, double[] bmis, int[] heartRates)
	{
		System.out.println("***** Gym Weekly Fitness Summary *****");
		
	} // End of displayAtheletsSummary
	
} // End of class