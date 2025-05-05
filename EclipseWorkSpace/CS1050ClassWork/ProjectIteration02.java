/**
 * 
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ProjectIteration02 
{
	public static void main(String[] args) 
	{
	double[] athlete1Calories = {100, 200, 300, 400, 500, 600, 700};
	Athlete athlete1 = new Athlete("Diego", "Sanchez", 150, 68, 21, athlete1Calories);
	
	final int MAX_GYM_MEMBERS = 3;
	
	Gym gym1 = new Gym("Elite Fitness", MAX_GYM_MEMBERS);

	try
	{
		readGymAthletesInfoFromFile("gym1.txt", gym1);
		gym1.displayAthleteSummaries();
		gym1.saveReportToFile();
		
	} catch (FileNotFoundException e)
	{
		System.out.println("Error: File not found.");
	}
	
	Gym gym2 = new Gym("Work in Progress", MAX_GYM_MEMBERS);

	try
	{
		readGymAthletesInfoFromFile("gym2.txt", gym2);
		gym2.displayAthleteSummaries();
		gym2.saveReportToFile();
		
	} catch (FileNotFoundException e)
	{
		System.out.println("Error: File not found.");
	}
		
	
	
	
	}//End of Main Method
	
	
}// End of Class

class Athlete
{
	private String firstName;
	private String lastName;
	private double height;
	private double weight;
	private int age;
	private double[] dailyCaloriesBurned;
	private double bmi;

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
		
		if (bmi >= 30.1) 
		{
			category = "Obese";
		}
		else if (bmi >= 25.1 && bmi <= 30) 
		{
			category = "Overweight";
		}
		else if (bmi >= 18.5 && bmi <= 25) 
		{
			category = "Normal";
		}
		else  
			category = "Underweight";
		
		return category;
	}
	
	public double getAverageCaloriesBurned()
	{
		double avgCalories = 0;
		for(int i = 0; i > dailyCaloriesBurned.length; i++)
		{
			avgCalories += dailyCaloriesBurned[i];
		}
		return avgCalories;
	}// End of getAverageCaloriesBurned
	
	public static void readGymAthletesInfoFromFile(String filename, Gym currentGym) throws FileNotFoundException
	{
		
		
		Scanner fileScanner = null;
		try
		{

			fileScanner = new Scanner(new File(filename));

			final String FILENAME = "gym1.txt"; 

	        	File testFile = new File(FILENAME);
	         

	            while (fileScanner.hasNextLine()) {
	                String line = fileScanner.nextLine();
	                System.out.println(line);
	            }

	            fileScanner.close();
	    }
		catch (FileNotFoundException e) 
			{
	            System.out.println("Error: Could not open file: " + e.getMessage());
	        }


		finally
		{
			if (fileScanner != null)
			{
				fileScanner.close();
			}
		}
	}// end add athletes



}// End of Athlete Class

class Gym
{
private String name;
private Athlete[] athletes;
private int numAthletes;

	public Gym(String name, int numAthletes)
	{
		this.name = name;
		this.numAthletes = numAthletes;
	}// End of Gym Method

	public void addAthlete(Athlete athlete)
	{
	
	}// End of addAthlete Method

	public void displayAthleteSummary()
	{
	
	}// End of displayAthleteSummary Method

	public void saveReportToFile()
	{
	
	}// End of saveReportToFile Method

	public int findTopAthlete()
	{
		int largestIndex = 0;
		
		for (int i = 1; i < athletes.length; i++)
		{
			if (athletes[i] > athletes[largestIndex]) 
			{
				largestIndex = i;
			}
		}
			return largestIndex;
	}// End of findTopAthlete

	public void displayUnderweightAthletes()
	{
		
	}// End of displayUnderweightAthletes Method
	
	public static void readGymAthletesInfoFromFile(String filename, Gym currentGym) throws FileNotFoundException
	{
		
		
		Scanner fileScanner = null;
		try
		{

			fileScanner = new Scanner(new File(filename));

			final String FILENAME = "gym1.txt"; 

	        	File testFile = new File(FILENAME);
	         

	            while (fileScanner.hasNextLine()) {
	                String line = fileScanner.nextLine();
	                System.out.println(line);
	            }

	            fileScanner.close();
	    }
		catch (FileNotFoundException e) 
			{
	            System.out.println("Error: Could not open file: " + e.getMessage());
	        }


		finally
		{
			if (fileScanner != null)
			{
				fileScanner.close();
			}
		}
	}// end add athletes

}// End of Gym Class









