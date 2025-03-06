import java.util.Scanner;
public class GE03FinalGradeCalculator 
{
	
	public static void main(String[] args) 
	{
		
	 printInfo();		

	 final int MAX = 105;
	 final int MIN = 0;
	 
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
	
	public static double getValidGrade(int MIN, int MAX) 
	{
		double grade;
		Scanner input = new Scanner(System.in);
	
		grade = input.nextInt();
		while (MIN <= grade || grade <= MAX) 
		{
			System.out.println("Please enter a valid grade:");
			grade = input.nextInt();
		}
		return grade;
	}
	
	
	
	
	
	

	
}// End of class