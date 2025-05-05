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
	File athletes1File = new File("gym1.txt");
	File athletes2File = new File("gym2.txt");

	final int MAX_GYM_MEMBERS = 3;
	
	Gym gym1 = new Gym("Elite Fitness", MAX_GYM_MEMBERS);

	try
	{
		readGymAthletesInfoFromFile("gym1.txt", gym1);
		gym1.displayAthleteSummary();
		gym1.saveReportToFile(athletes1File);
		
	} catch (FileNotFoundException e)
	{
		System.out.println("Error: File not found.");
	}
	
	Gym gym2 = new Gym("Work in Progress", MAX_GYM_MEMBERS);

	try
	{
		readGymAthletesInfoFromFile("gym2.txt", gym2);
		gym2.displayAthleteSummary();
		gym2.saveReportToFile(athletes2File);
		
	} catch (FileNotFoundException e)
	{
		System.out.println("Error: File not found.");
	}
		
	
	
	
	}//End of Main Method
	
	public static void readGymAthletesInfoFromFile(String filename, Gym currentGym) throws FileNotFoundException
	{
		Scanner fileScanner = null;
		try
		{

			fileScanner = new Scanner(new File(filename));
	         

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
	
	public static void gymSetUp(Gym gym, String filename) throws FileNotFoundException
	{
		Scanner fileScanner = null;
		try
		{
			fileScanner = new Scanner(new File(filename));
			while (fileScanner.hasNextLine())
			{
				double [] dailyCaloriesBurned = new double[7];
				String firstName = fileScanner.next().trim();
				String lastName = fileScanner.next().trim();
				double height = fileScanner.nextDouble();
				double weight = fileScanner.nextDouble();
				int age = fileScanner.nextInt();
				for(int i = 0; i < dailyCaloriesBurned.length; i++)
				{
					dailyCaloriesBurned[i] = fileScanner.nextDouble();
				}
				Athlete currentAthlete = new Athlete(firstName, lastName, weight, height, age, dailyCaloriesBurned);
				gym.addAthlete(currentAthlete);
			}
		} finally
		{
			if (fileScanner != null)
			{
				fileScanner.close();
			}
		}
	}
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
	}// End of Athlete Constructor
	
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
	

}// End of Athlete Class


class Gym
{
private String name;
private Athlete[] athletes;
private int maxNumAthletes;
private int currentNumAthletes;


	public Gym(String name, int maxNumAthletes)
	{
		this.name = name;
		this.athletes = new Athlete[maxNumAthletes];
		this.currentNumAthletes = 0;
	}// End of Gym Constructor

	public void addAthlete(Athlete athlete)
	{
		if (maxNumAthletes < athletes.length)
		{
			athletes[maxNumAthletes] = athlete;
			currentNumAthletes++;
		} else
		
			System.out.println("Gym is full. Couldn't add : " + athlete.getFirstName() + " " + athlete.getLastName());
		
	
	}// End of addAthlete Method

	public void displayAthleteSummary()
	{
		System.out.println("***** Gym Weekly Fitness Summary *****");
		System.out.println("Gym: " + name);

		for(int i = 0; i < athletes.length; i++)
		{
			System.out.println("Athlete: "+ athletes[i].getFirstName() + " " + athletes[i].getLastName() + "\n" + "	Max Heart Rate: "+ athletes[i].calculateMaxHeartRate() + "\n"
							   + "	Average Daily Calories Burned: " + athletes[i].getAverageCaloriesBurned() + "\n");
			System.out.printf("	BMI: %.1f",  athletes[i].calculateBMI());
			System.out.println("	Category: " + athletes[i].getBMICategory());
		}
		
		System.out.println("Top Athlete (Most Average Daily Calories Burned): " + (findTopAthlete() + 1));
	
		System.out.println("\nUnderweight athletes: ");
		displayUnderweightAthletes();
		
		int counter = 0;
		for (int i = 0; i < athletes.length; i++)
		{
		if( athletes[i].calculateBMI() < 18.5)
		{
			counter++;
		}
		
		}
		if(counter == 0)
		{
			System.out.println("No underweight athletes");
		}
		
	}// End of displayAthleteSummary Method

	public void saveReportToFile(File testFile)
	{
	
		String absoluteFilePath = testFile.getAbsolutePath();
		System.out.println("\nReport Saved to: " + absoluteFilePath);
		
	}// End of saveReportToFile Method

	public int findTopAthlete()
	{
		int largestIndex = 0;
		
		for (int i = 1; i < athletes.length; i++)
		{
			if (athletes[i].getAverageCaloriesBurned() > athletes[largestIndex].getAverageCaloriesBurned()) 
			{
				largestIndex = i;
			}
		}
			return largestIndex;
	}// End of findTopAthlete

	public void displayUnderweightAthletes()
	{
		for(int i = 1; i < athletes.length; i++)
		{
			if (athletes[i].calculateBMI() < 18.5)
			{
				System.out.println("Athlete " + (i + 1));
			}
		}
	}// End of displayUnderweightAthletes Method
	


}// End of Gym Class



