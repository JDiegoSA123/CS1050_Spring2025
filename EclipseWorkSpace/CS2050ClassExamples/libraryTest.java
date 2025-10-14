import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class libraryTest 
{
	public static void main(String[] args) 
	{
		// --- unit test checks for Book ---
		//Book nullBook = null;
		//System.out.println(nullBook.getName());
		
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the year");
		int year = input.nextInt();
		
		
		
		/*System.out.println("Unit Test Book Class");
		Book unitTestBook = new EBook("Unmasking AI", "Joy Buolamwini", 2023);
		System.out.println("getTitle():   " + unitTestBook.getName());
		System.out.println("getAuthor():  " + unitTestBook.getAuthor());
		System.out.println("getYear():    " + unitTestBook.getYear());
		System.out.println("stringOfBookDetails():   " + unitTestBook.toString());
		System.out.println();
		System.out.println("Setting up Test Library");    */
		int numberOfShelves = 3;
		int shelfCapacity = 4;
		
		
		
		Library library = new Library("Test Library", numberOfShelves, shelfCapacity);
		System.out.println("Loading books from file: library_books.csv");
		LibraryLoader.loadFromCsv(library, "library_books.csv");
	/*	library.displayCountPerShelf();
		library.printAllBooks();
		library.displayOldest();
		System.out.println("Shelves (rows): " + numberOfShelves);
		System.out.println("Slots per shelf (columns): " + shelfCapacity);
		System.out.println("Total capacity: " + (numberOfShelves * shelfCapacity));
		System.out.println();
		Library library = new Library("Test Library", numberOfShelves, shelfCapacity);
		library.displayCountPerShelf();
		library.printAllBooks();
		library.displayOldest();
		// Row 0
		library.addBook(null);
		library.addBook(new PrintBook("Unmasking AI", " Joy Buolamwini ", 2023));
		library.addBook(new PrintBook("Hello World", " Hannah Fry ", 2018));
		library.addBook(new EBook("Race After Technology", " Ruha Benjamin ", 2019));
		library.addBook(new EBook("Deep Learning", " Ian Goodfellow ", 2016));
		library.displayCountPerShelf();
		library.printAllBooks();
		library.displayOldest();
		// Row 1
		library.addBook(new EBook("Algorithms to Live By", " Brian Christian ", 2016));
		library.addBook(new EBook("Weapons of Math Destruction", " Cathy O'Neil ", 2016));
		library.addBook(new PrintBook("The Mythical Man-Month", " Fred Brooks ", 1975));
		library.addBook(new PrintBook("Refactoring", " Martin Fowler ", 1999));
		// Row 2
		library.addBook(new PrintBook("The Pragmatic Programmer", " Andrew Hunt & David Thomas ", 1999));
		library.addBook(new PrintBook("Peopleware", " Tom DeMarco & Tim Lister ", 1987));
		library.addBook(new EBook("Computer Lib / Dream Machines", " Ted Nelson ", 1975));
		library.addBook(new EBook("Book of Lies", " Diego Sanchez ", 1980));
		library.displayCountPerShelf();
		library.printAllBooks();
		library.displayOldest();
		System.out.println();
		System.out.println("Test add more books than capacity...");
		library.addBook(new EBook("Extra Title", "Extra Author", 2024)); // should trigger "full" message
		library.displayCountPerShelf();
		library.printAllBooks();
		library.displayOldest();   */
		
		input.close();
	} // End of Main Method
	
} // End of libraryTest Class	

abstract class Book
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
	public String toString()
	{
		return name + author + year;
	}
	/** Calculates the late fee based on subclass policy. */
	public final double calculateLateFee(int daysLate){
		double lateFee = 0;
		if (daysLate > 0){
			lateFee = daysLate * getDailyLateFee();
		}
		return lateFee;
	}

	public abstract int getLoanDays();
	
	public abstract double getDailyLateFee();
	
} // End of Book Class
class PrintBook extends Book 
{
	public PrintBook(String name, String author, int year)
	{
		super(name,author, year);
	}
	public String toString()
	{
		return getName() + getAuthor() + getYear();
	}
	public int getLoanDays()
	{
		return 21;
	}
	public double getDailyLateFee()
	{
		return .25;
	}
} // End of PrintBook Subclass
class EBook extends Book
{
	public EBook(String name, String author, int year)
	{
		super(name,author,year);
	}
	public String toString()
	{
		return getName() + getAuthor() + getYear();
	}
	public int getLoanDays()
	{
		return 14;
	}
	public double getDailyLateFee()
	{
		return .10;
	}
}
class Library
{
	private String name;
	private int numberOfShelves;
	private int shelfCapacity;
	private int totalBookCapacity;
	private Book bookShelf[][];
	private int currentTotalBooks;
	private int currentShelf;
	private int currentSlot;
	private boolean isFull;
	
	public Library(String name, int shelves, int shelfCapacity)
	{
		if (name == null || name.isEmpty()){
			this.name = "Library";
		} else{
			this.name = name;
		}
		if (shelves <= 0 || shelfCapacity <= 0){
			this.numberOfShelves = 1;
			this.shelfCapacity = 1;
		} else{
			this.numberOfShelves = shelves;
			this.shelfCapacity = shelfCapacity;
		}
		this.totalBookCapacity = numberOfShelves * shelfCapacity;
		this.bookShelf = new Book[numberOfShelves][shelfCapacity];
		this.currentTotalBooks = 0;
		this.currentShelf = 0;
		this.currentSlot = 0;
		this.isFull = false;
	} // End of Library Constructor
	public String getName()
	{
		return name;
	}
	public boolean addBook(Book book)
	{
			if (book == null)
			{
				System.out.println("Invalid book.");
				return false;
			}
			if (isFull)
			{
				System.out.println("Library is full. Couldn't add " + book.toString());
				return false;
			}
			bookShelf[currentShelf][currentSlot] = book;
			System.out.println("Added " + book.toString() + " at shelf " + (currentShelf + 1) + ", slot "
					+ (currentSlot + 1));
			currentTotalBooks = currentTotalBooks + 1;

			if (currentTotalBooks >= totalBookCapacity){
				isFull = true;
			} 
			else
			{
				int nextIndex = currentTotalBooks; 
				currentShelf = nextIndex / shelfCapacity;
				currentSlot = nextIndex % shelfCapacity;
			}
			return true;
		} // End of addBooks Method
	
	public void printAllBooks()
	{
		/*for (int i = 0; i < currentTotalBooks; i++)
		{
			for (int j = 0; j < )
		}*/
	}
	public void displayOldest()
	{
		int temp;
		for(int i = 1; bookShelf.length > i; i++)
		{
			//if(bookShelf[0].getYear() < bookShelf[i])
			{
				temp = i;
			}
		}
		//System.out.println(temp);
	}
	public int displayCountPerShelf()
	{
		return numberOfShelves;
	}
} // End of Library Class

class LibraryLoader
{
public static void loadFromCsv(Library library, String filename)
{
    try (Scanner fileScan = new Scanner(new File(filename))){
	int lineNumber = 0;
	while (fileScan.hasNextLine()){
		String line = fileScan.nextLine();
		lineNumber++;
		Book parsed = parseBookLine(line, lineNumber);
		if (parsed != null){
		     boolean added = library.addBook(parsed);
		     if (!added){
			System.out.println("Line " + lineNumber + ": library full or invalid book.");
			}
		}
	}
      } catch (FileNotFoundException ex){
		System.out.println("Could not open file: " + filename);
     }
}
/**
* Parses one CSV line into a Book or returns null if invalid. Expected:
* title,author,year,type (type = P or E) Keeps logic simple for lecture.
*/
private static Book parseBookLine(String line, int lineNumber)
{
	if (line == null){
		System.out.println("Line " + lineNumber + ": empty line.");
		return null; // early return
	}
	String[] parts = line.split(",");
	if (parts.length != 4){
	      System.out.println("Line " + lineNumber + ": wrong number of fields → " + line);
	      return null; // early return
	}
	String title = parts[0].trim();
	String author = parts[1].trim();
	String yearText = parts[2].trim();
	String type = parts[3].trim();
	int year;
	try{
		year = Integer.parseInt(yearText);
	} catch (NumberFormatException ex){
	     System.out.println("Line " + lineNumber + ": invalid year \"" + yearText + "\" → skipping line.");
	     return null; // early return
	}
	if (type.equalsIgnoreCase("P")){
		return new PrintBook(title, author, year);
	} else if (type.equalsIgnoreCase("E")){
		return new EBook(title, author, year);
	} else{
	     System.out.println("Line " + lineNumber + ": invalid type \"" + type + "\" (use P or E).");
	     return null; // early return
	}
}
}