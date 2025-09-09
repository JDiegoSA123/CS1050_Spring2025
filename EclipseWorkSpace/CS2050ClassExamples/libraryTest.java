public class libraryTest 
{
	public static void main(String[] args) 
	{
		
	Book book1 = new Book("Book A ", "Diego ", 1997);
	
	System.out.print(book1.getName());
	System.out.print(book1.getAuthor());
	System.out.print(book1.getYear());
	} // End of Main Method
	
} // End of libraryTest Class	

class Book
{
	private String name;
	private String author;
	private int year;
	
	public Book(String name, String author, int year)
	{
		this.name = name;
		this.author = author;
		this.year = year;
	} // End of Book Constructor
	public String getName()
	{
		return name;
	}
	public String getAuthor()
	{
		return author;
	}
	public int getYear()
	{
		return year;
	}
} // End of Book Class

class Library
{
	private String name;
	private int numberOfShelves;
	private int shelfCapacity;
	private int totalBookCapacity;
	private int bookShelf[][];
	
	
	
	
	
	
}