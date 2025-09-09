
public class SelectionSortTDD
{
	public static void main(String[] args)
	{
		System.out.println("Testing Selection Sort");

		int[][] testCases = { 
				{ 4, 2, 7, 1, 5 }, // Regular case
				{}, // Empty array
				{ 5 }, // Single element
				{ 1, 2, 3, 4, 5 }, // Already sorted
				{ 9, 7, 5, 3, 1 }, // Reverse sorted
				{ 4, 2, 7, 2, 5 } // Array with duplicates
		};

		for (int i = 0; i < testCases.length; i++)
		{
			System.out.println("Test Case " + (i + 1) + ": Before Sorting:");
			printArray(testCases[i]); 
			selectionSort(testCases[i]);
			System.out.println("After Sorting:");
			printArray(testCases[i]);
			System.out.println();
		}
	}



	public static void insertSort(int[] array)
	{
	    
	}

	public static void selectionSort(int[] array)
	{
	    
	}
	public static void bubbleSort(int[] array)
	{
		int arrayTest = 0;
		int largestNum;
	    while(array[array.length] > array[array.length - 1])
	    {
	    	for(int i = 0; array.length > i; i++)
	    	{
	    		if(array[i] > arrayTest)
	    		{
	    			largestNum = array[i];
	    		}
	    	largestNum = array[array.length];
	    	}
	    }
	}
	public static void printArray(int[] array)
	{
		for (int i = 0; i < array.length; i++)
		{
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}


}