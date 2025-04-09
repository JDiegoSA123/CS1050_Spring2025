import java.util.Scanner;   // Scanner class to read input

//import input/output package classes to write to a file 
import java.io.*;
/**
   This program writes data to a file using arrays. 
   It makes sure the
   specified file does not exist before opening it.
 */

public class FileWriteDemo2
{
	public static void main(String[] args) throws IOException
	{
		
		//Add comments to explain the code.
		
		//Use the debugger		
		String[] gradeCategories = {"Class Participation","Guided Exploration",
				"Quizzes","Project Percent","Final Exam"};
		double[] gradePercentWeights = {.12,.22,.22,.22,.22};
		
		// 
		Scanner readKeyboard = new Scanner(System.in);
		
		//
		System.out.print("Enter the filename with no spaces and include .txt \n");
		String file = readKeyboard.next();

		writeToFile(file, gradeCategories, gradePercentWeights);
		
		
		//
		readKeyboard.close();		
	}//end main
	
	public static void writeToFile(String filename, String[] categories, double[] percentWeights)
			throws IOException
	{
		//
		File gradeFile = new File(filename);
		
		// 
		if (gradeFile.exists())
		{			
			System.out.println("\nThe file " + filename +
					" already exists.");
			
		}else
		{

			//
			PrintWriter outputFile = new PrintWriter(gradeFile);
	
			// 		
			outputFile.println("\nCategories and percentage weights");
			
			for(int categoryColumn = 0; categoryColumn < categories.length; categoryColumn++ )
			{	
				outputFile.printf("%s Grade: %.2f\n", categories[categoryColumn], percentWeights[categoryColumn]);
			}

			String absoluteFilePath = gradeFile.getAbsolutePath();
			System.out.println("\nOpen the file located at " + absoluteFilePath);
			
			System.out.println("\nNext set a breakpoint to explore the code and what is happening in memory");
			System.out.println("\nExplore the two arrays");
			System.out.println("\nAdd comments to the code.");
			// 
			outputFile.close();
		}//end else
		
	} //end method
	
}//end FileWriteDemo2
