public class UnitTestGym {

	public static void main(String[] args) {
	
	int[] someArray = {1, 3, 2, 10, 6, 5};
	
	int topAthlete = findTopAthlete(someArray);
	
	System.out.println("The Top Athelete is Athelete " + topAthlete);
	}

	
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
	} // end of method
}
