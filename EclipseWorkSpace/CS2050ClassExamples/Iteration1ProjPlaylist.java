import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import SinglyLinkedListFix.NodeFix;

import java.util.ArrayList;

public class Iteration1ProjPlaylist 
{

	public static void main(String[] args) 
	{
	
	
		
	Scanner input = new Scanner(System.in);	
	Scanner input1 = new Scanner(System.in);	
	Scanner input2 = new Scanner(System.in);
	String fileInput;
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
		try
		{
			fileInput = input2.next();
			
			Playlist<Song> music = new Playlist<>();
			music.push(PlaylistLoader.loadFromCsv(fileInput));
			
		} catch (FileNotFoundException e)
		{
			System.out.println("Error: File not found.");
		}
		break; 
	case 2:
		if (music == null)
		{
			System.out.println("Playlist is empty");
		}
		else
		music.displayPlaylist();
	case 3:
		System.out.println("Enter index to play:");
		int index;
		index = getValidInput(1, 7, input1);
		
		while(index < music.size() || index >= 0)
		{
		System.out.println("Now playing:" + toString().music.get(index));
		}
		break;
	case 4:
		System.out.println("Enter song number to add to Up-Next List (queue):");
		SinglyLinkedList head = music.get(input1);
		break;
	case 5:
		System.out.println(music.head.newNode);
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
	public double durationInMinutes()
	{
		double minute;
		minute = durationSeconds % 60;
		return minute;
	}
	public String toString()
	{
		return "''" + title + "'' " + " by "+ artist + "(" + durationInMinutes()+ ")";
	}
	
} // End of Song Class

class Playlist<Song>
{
	private ArrayList<Song> songs;
	private int currentTotalSongs;
	
	public Playlist(int currentTotalSongs)
	{
		this.songs = new ArrayList<>();
		this.currentTotalSongs = currentTotalSongs;
	}
	
	public void push(Song song)
	{
		this.songs.add(song);
		currentTotalSongs++;
	}
	
	public void displayPlaylist()
	{
		for(int i = 0; i < songs.size(); i++)
		{
		System.out.println("["+ i + "]" + songs.get(i));
		}
	}
	
	
} // End of Playlist Class


class SinglyLinkedList<T>
{
	private Node<T> head;
	private Node<T> tail;
	private int count;
	
	private static class Node<T>
	{
		T value;
		Node<T>next;
		Node(T v)
		{
			value = v;
			next = null;
		}
	}
	public SinglyLinkedList()
	{
		head = null;
		tail = null;
		count = 0;
	}
	
	public int size()
	{
		return count;
	}
	
	public boolean isEmpty()
	{
		return true;
	}
	
	public void addLast(T value)
	{
		
	}
	
	public T removeFirst()
	{
		
	}
	
	public void displayAll()
	{
		
	}
}
class PlaylistLoader
{
public static void loadFromCsv(String filename) throws FileNotFoundException
{
    try (Scanner fileScan = new Scanner(new File(filename)))
    {
	int lineNumber = 0;
	while (fileScan.hasNextLine())
	{
		String line = fileScan.nextLine();
		lineNumber++;
		Song parsed = parseSongLine(line, lineNumber);
	}
	
	}
       catch (FileNotFoundException ex)
      {
		System.out.println("Could not open file: " + filename +"/r No songs were loaded");
      }
}

public static Song parseSongLine(String line, int lineNumber){
	if (line == null){
		System.out.println("Line " + lineNumber + "skipped" + ": empty line.");
		return null; // early return
	}
	String[] parts = line.split(",");
	if (parts.length != 3){
	      System.out.println("Line " + lineNumber + "skipped" + ": wrong number of fields → " + line);
	      return null; // early return
	}
	String title = parts[0].trim();
	String artist = parts[1].trim();
	String durationSecondsText = parts[2].trim();
	int time;
	try{
		time = Integer.parseInt(durationSecondsText);
	} catch (NumberFormatException ex){
	     System.out.println("Line " + lineNumber + "skipped" + ": bad number");
	     return null; // early return
	}
	return new Song(title,artist,time);
	}
}