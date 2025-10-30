import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.Arrays;

public class Iteration1ProjPlaylist 
{

	public static void main(String[] args) 
	{
	
	Scanner input = new Scanner(System.in);	
	boolean loop = false;
	int option;
	
	while (loop == false)
	{
	 print();
	option = getValidInput(1, 7, input);
	switch (option) 
	{
	case 1:
		System.out.println("Enter CVS filename:");
		break;
	case 2:
		
	case 3:
		System.out.println("Enter index to play:");
		break;
	case 4:
		System.out.println("Enter song number to add to Up-Next List (queue):");
		break;
	case 5:
		
		break;
	case 6:
		
		break;
	case 7:
		loop = true;
		break;
	default:
		System.out.println("Please enter a valid Option:");
	} // End of first Switch
	
	}
	
	System.out.print("Exiting Music Playlsit!");
	
	} // End of Main Method

	public static int getValidInput(int MIN, int MAX, Scanner inputKeyboard) 
	{
		int input;	
		input = inputKeyboard.nextInt();
		while (input < MIN || input > MAX) 
		{
			System.out.println("Please enter a valid Option:");
			input = inputKeyboard.nextInt();
		}
		return input;
	}
	
	public static void print()
	{
	System.out.println("Displays Menu\r\n"
			+ "=== Music Playlist Menu ===\r\n"
			+ "1. Load Songs from CSV\r\n"
			+ "2. Display Playlist\r\n"
			+ "3. Play a Song by Index\r\n"
			+ "4. Add Song to Up-Next Queue\r\n"
			+ "5. Show Up-Next Queue\r\n"
			+ "6. Play Next from Queue\r\n"
			+ "7. Exit\r\n"
			+ "");
	}

} // End of Main Class




class Song 
{
	private String title;
	private String artist;
	private int durationSeconds;
	
	public Song (String title, String artist, int durationSeconds)
	{
		this.title = title;
		this.artist = artist;
		this.durationSeconds = durationSeconds;

	}
	
	public String getTitle()
	{
		return title;
	}
	
	public String getArtist()
	{
		return artist;
	}
	
	public int getDurationSeconds()
	{
		return durationSeconds;
	}
	
} // End of Song Class

class Playlist 
{
	
} // End of Playlist Class


class PlaylistLoader
{
public static void loadFromCsv(Library library, String filename)
{
    try (Scanner fileScan = new Scanner(new File(filename))){
	int lineNumber = 0;
	while (fileScan.hasNextLine()){
		String line = fileScan.nextLine();
		lineNumber++;
		Song parsed = parseSongLine(line, lineNumber);
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
private static Song parseSongLine(String line, int lineNumber){
	if (line == null){
		System.out.println("Line " + lineNumber + ": empty line.");
		return null; // early return
	}
	String[] parts = line.split(",");
	if (parts.length != 3){
	      System.out.println("Line " + lineNumber + ": wrong number of fields → " + line);
	      return null; // early return
	}
	String title = parts[0].trim();
	String artist = parts[1].trim();
	String durationSecocndsText = parts[2].trim();
	int year;
	try{
		year = Integer.parseInt(durationSecocndsText);
	} catch (NumberFormatException ex){
	     System.out.println("Line " + lineNumber + ": invalid year \"" + durationSecocndsText + "\" → skipping line.");
	     return null; // early return
	}
	if (type.equalsIgnoreCase("P")){
		return new PrintBook(title, artist, year);
	} else if (type.equalsIgnoreCase("E")){
		return new EBook(title, artist, year);
	} else{
	     System.out.println("Line " + lineNumber + ": invalid type \"" + type + "\" (use P or E).");
	     return null; // early return
	}
}
}