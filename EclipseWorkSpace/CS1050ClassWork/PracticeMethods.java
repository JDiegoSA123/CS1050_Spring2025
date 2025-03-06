public class PracticeMethods 
{

	public static void main(String[] args) 
	{
	final int MAX = 5;
	int maxsum = sum(MAX);
	
	System.out.println("the sum is " + maxsum);
	}// End of Main Method
	
	public static int sum(int MAX) 
	{
		int total = 0;
		for (int i = 0; MAX >= i; i++) 
		{
			total = total + i;
		}
		return total;
	}// End of sum Method 
	
	

}// End of Class


