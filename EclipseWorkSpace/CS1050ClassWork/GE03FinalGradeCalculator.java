import java.util.Scanner;
public class GE03FinalGradeCalculator 
{
	
	public static void main(String[] args) 
	{
		
	 printInfo();		

	 final double MAX = 105.00;
	 final double MIN = 0.00;
	 final double CLASS_PART = .10;
	 final double GUIDE_EXP = .20;
	 final double QUIZ = .25;
	 final double PROJECT = .25;
	 final double FINAL_EXAM = .20;

	 System.out.println("Enter a grade for the Class Participation:");
	 double classPart = getValidGrade(MAX, MIN);
	 System.out.println("Enter a grade for the Guided Exploration:");
	 double guideExp = getValidGrade(MAX, MIN);
	 System.out.println("Enter a grade for the Module Quizzes:");
	 double quiz = getValidGrade(MAX, MIN);
	 System.out.println("Enter a grade for the Project Literations:");
	 double project = getValidGrade(MAX, MIN);
	 System.out.println("Enter a grade for the Final Exam:");
	 double finalExam = getValidGrade(MAX, MIN);
	 
	 double finalGrade = ((classPart * CLASS_PART) + (guideExp * GUIDE_EXP) + (quiz * QUIZ) + (project * PROJECT) + (finalExam * FINAL_EXAM));
	 
	 char finalLetterGrade = getLetterGrade(finalGrade);
	 
	 System.out.println("Your Final Grade is: " + finalGrade + " and a letter grade of: " + finalLetterGrade);
	 
	
	 
	}// End of main Method
	
	
	
	
	
	
	
	
	
	
	public static void printInfo() 
	{
		System.out.println("**********************************\r\n"
						  + "CS1050 Final Grade Calculator\r\n"
						  + "**********************************\r\n"
						  + "------------------------------\r\n"
						  + "Category:Percent\r\n"
						  + "------------------------------\r\n"
						  + "Class Participation: 10%\r\n"
						  + "Guided Exploration: 20%\r\n"
						  + "Module Quizzes: 25%\r\n"
						  + "Project Iterations: 25%\r\n"
						  + "Final Exam: 20%\r\n"
						  + "-------------------------------\r\n"
						  + "Letter Grade Range\r\n"
						  + "-------------------------------\r\n"
						  + "A: 90 to 100\r\n"
						  + "B: 80 to < 90\r\n"
						  + "C: 70 to < 80\r\n"
						  + "D: 60 to < 70\r\n"
						  + "F: < 60\r\n");
	}// End of printInfo Method
	
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
	}
	
	
	
	public static char getLetterGrade(double finalGrade) 
	{
		char letterGrade;
		
		if (finalGrade >= 90) 
		{
			letterGrade = 'A';
		}
		else if (finalGrade >= 80 && finalGrade <= 89.99) 
		{
			letterGrade = 'B';
		}
		else if (finalGrade >= 70 && finalGrade <= 79.99) 
		{
			letterGrade = 'C';
		}
		else if (finalGrade >= 60 && finalGrade <= 69.99) 
		{
			letterGrade = 'D';
		}
		else 
			letterGrade = 'F';
		
		return letterGrade;
	} // End of getLetterGrade
	

	
	
	
	

	
}// End of class