/**
 * 
 */

import java.util.Scanner;

/**
 * 
 */
public class ProjectIteration02 
{

	public static void main(String[] args) 
	{
	int[] athlete1Calories = {100, 200, 300, 400, 500, 600, 700};
	Athlete[] athlete1 = new Athlete ["Diego", "Sanchez", 150, 68, 21, athlete1Calories];
		
		
		
		
	}//End of Main Method
	
	
	
	
	
	
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
					+ "	BMI:" +  bmis[i] + "	Category " + getBMICategory(bmis));
		}
		
		System.out.println("Top Athlete (Most Average Daily Calories Burned): " + "Athlete " + findTopAthleteIndex(averageCalories));
		
		System.out.println(" Underweight athletes: ");
		findUnderweightAthlete(bmis);
		for (int i = 0; i < bmis.length; i++)
		{
			if(bmis[i] > 18.5)
			{
			System.out.println("Underweight Athletes: No underweight athletes");
			}
		}
	} // End of displayAtheletsSummary
}// End of Class

class Athlete
{
	private String firstName;
	private String lastName;
	private double height;
	private double weight;
	private int age;
	private double[] dailyCaloriesBurned;

	public Athlete(String firstName, String lastName, double weight,
		double height, int age, double[] dailyCaloriesBurned)
	{
	this.firstName = firstName;
	this.lastName = lastName;
	this.height = height;
	this.weight = weight;
	this.age = age;
	this.dailyCaloriesBurned = dailyCaloriesBurned;
	}// End of Athlete Method
	
	public String getFirstName() 
	{
		return firstName;
	}
	
	public String getLastName()
	{
		return lastName;
	}
	
	public double calculateBMI()
	{
		bmi = weight * 703 / (height * height);
		return bmi;
	}
	
	public int calculateMaxHeartRate()
	{
		int maxHeartRate = 220 - age;
		return maxHeartRate;
	}
	
	public String getBMICategory()
	{
		String category;
		int i = 0;
		
		if (BMI >= 30.1) 
		{
			category = "Obese";
		}
		else if (BMI >= 25.1 && BMI <= 30) 
		{
			category = "Overweight";
		}
		else if (BMI >= 18.5 && BMI <= 25) 
		{
			category = "Normal";
		}
		else  
			category = "Underweight";
		
		return category;
	}
	
	public double getAverageCaloriesBurned()
	{
		
	}// End of getAverageCaloriesBurned
}// End of Athlete Class











