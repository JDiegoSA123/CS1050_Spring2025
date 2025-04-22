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
	
	int numOfAthletes = 0;

	Scanner inputCalories = new Scanner(System.in);
	Scanner inputInt = new Scanner(System.in);
	Scanner inputDouble = new Scanner(System.in);


	while(numOfAthletes <= 0)
	{
		System.out.println("Enter number of Athletes: ");
		numOfAthletes = getPositiveInt(inputInt);
		if (numOfAthletes <= 0) 
		{
			System.out.println("Error: Value must be greater than 0.");
			
		}
	}
	
	double[] averageDailyCaloriesBurned = new double[numOfAthletes];
	double[] bmis = new double[numOfAthletes];
	int[] maxHeartRate = new int[numOfAthletes];
	double[] caloriesPerDay;
	
	for(int i = 0; i < numOfAthletes; i++)
	{
		System.out.println("Enter data for Athlete " + (i + 1) + ":");
		
		
		bmis[i] = calculateBMI(inputDouble);
	
		maxHeartRate[i] = calculateMaxHeartRate(inputInt);
		
		caloriesPerDay = getDailyCalories(inputCalories);
		
		averageDailyCaloriesBurned[i] = calculateAverageCaloriesBurned(caloriesPerDay);
	}
	
	displayAthleteSummary(averageDailyCaloriesBurned, bmis, maxHeartRate);
	

	
	} // End of Main Method
	
	public static int getPositiveInt(Scanner intInput)
	{
		int intvalue = 0;	
		intvalue = intInput.nextInt();
	
		return intvalue;
	}
	
	public static double getPositiveDouble(Scanner doubleInput)
	{
		double doubleValue = 0;	
		doubleValue = doubleInput.nextDouble();
		
		return doubleValue;
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
	
	public static int findTopAthleteIndex(double[] array) 
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
	
	public static double calculateBMI(Scanner inputDouble)
	{
		double bmi;
		double height = 0;
		double weight = 0;
		
		while(weight <= 0)
		{
			System.out.println("Enter athlete's weight (lbs): ");
			weight = getPositiveDouble(inputDouble);
			if(weight <= 0)
			{
				System.out.println("Error: Value must be greater than 0.");
			}
		}
		
		while(height <= 0)
		{
			System.out.println("Enter athlete's height (inches): ");
			height = getPositiveDouble(inputDouble);
			if (height <= 0) 
			{
				System.out.println("Error: Value must be greater than 0.");
				
			}
		}
		bmi = weight * 703 / (height * height);
		return bmi;
	} // End of getBMI
	
	public static int calculateMaxHeartRate(Scanner inputInt)
	{
		int age = 0;
		
		while(age <= 0)
		{
			System.out.println("Enter athlete's age: ");
			age = getPositiveInt(inputInt);
			if (age <= 0) 
			{
				System.out.println("Error: Value must be greater than 0.");
				
			}
		}
		int maxHeartRate = 220 - age;
		return maxHeartRate;
	} // End of calculateMaxHeartRate
	
	public static double[] getDailyCalories(Scanner scanKeyboard)
	{
		double[] dailyCalories = new double[7];
		
		for (int i = 0; i < dailyCalories.length; i++)
		{
			System.out.println("Enter calories burned on day " + (i + 1) + ":");
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
		for(int i = 0; i < bmis.length; i++)
		{
			System.out.println("Athlete "+ (i + 1) + "\n"
					+ "	Max Heart Rate: "+ heartRates[i] + "\n"
					+ "	Average Daily Calories Burned: " + averageCalories[i] + "\n"
					+ "	BMI: " +  bmis[i] + "	Category " + getBMICategory(bmis));
		}
		
		System.out.println("Top Athlete (Most Average Daily Calories Burned): " + "Athlete " + findTopAthleteIndex(averageCalories));
		
		
		System.out.println(" Underweight athletes: ");
		findUnderweightAthlete(bmis);
		for (int i = 0; i < bmis.length; i++)
		{
		if(bmis[i] < 18.5)
		{
			System.out.println("Underweight Athletes: No underweight athletes");
		}
		}
	} // End of displayAtheletsSummary
	
} // End of class