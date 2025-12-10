import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
public class Iteration1ProjPlaylist 
{

	public static void main(String[] args) 
	{
				final int MENU_END = 9;
				final String[] menuItems =
				{ "Load Songs from CSV", // 1
						"Display Playlist", // 2
						"Play Song by Index", // 3
						"Add Song to Up-Next Queue", // 4
						"Show Up-Next Queue", // 5
						"Play Next Song in Up-Next Queue", // 6
						"Search Songs (by ID or Artist)", // 7
						"View Playlist Sorted", // 8
						"Exit" // 9
				};
				final String menuPrompt = "Enter your choice (1–" + MENU_END + "): ";
				Scanner keyboardScanner = new Scanner(System.in);
				PlaylistManager manager = new PlaylistManager();
				int choice;
				do
				{
					System.out.println("\n=== Music Playlist Menu ===");
					for (int i = 0; i < menuItems.length; i++)
					{
						System.out.println((i + 1) + ". " + menuItems[i]);
					}
					choice = getValidInt(keyboardScanner, menuPrompt, 1, MENU_END);
					switch (choice)
					{
					case 1:
					{
						// User Story 1 — Load my music
						System.out.print("Enter CSV filename: "); // songs_Sanchez.csv
						String filename = keyboardScanner.next();
						boolean loaded = manager.loadFromCsv(filename);
						if (!loaded)
						{
							System.out.println("No songs were loaded.");
							System.out.println("Working directory: " + java.nio.file.Paths.get("").toAbsolutePath());
						} else
						{
							manager.buildByIdMap();
						}
						break;
					}
					case 2:
					{
						// User Story 2 — See what’s in the playlist
						manager.displayPlaylist();
						break;
					}
					case 3:
					{
						// User Story 3 — Play a specific song now
						if (manager.size() == 0)
						{
							System.out.println("Playlist is empty.");
						} else
						{
							int index = getValidInt(keyboardScanner, "Enter index to play: ", 0, manager.size() - 1);
							Song song = manager.get(index);
							if (song == null)
							{
								System.out.println("Invalid index.");
							} else
							{
								System.out.println("Now playing: " + song);
							}
						}
						break;
					}
					case 4:
					{
						// User Story 4 — Add songs to the Up-Next linked list queue
						if (manager.size() == 0)
						{
							System.out.println("Playlist is empty.");
						} else
						{
							int addIdx = getValidInt(keyboardScanner, "Enter song number to add to Up-Next Queue: ", 0,
									manager.size() - 1);
							boolean ok = manager.enqueue(addIdx);
							if (ok)
							{
								System.out.println("Song added to Up-Next Queue.");
							} else
							{
								System.out.println("Invalid index. Nothing added.");
							}
						}
						break;
					}
					case 5:
					{
						// User Story 5 — See what’s coming up in Up-Next queue
						manager.showUpNext();
						break;
					}
					case 6:
					{
						// User Story 6 — Play the next song in Up-Next queue
						Song next = manager.playNext();
						if (next == null)
						{
							System.out.println("Up-Next Queue is empty (head is null).");
						} else
						{
							System.out.println("Now playing: " + next);
						}
						break;
					}
					case 7:
					{
						// User Story 8 — Unique Song IDs & Fast Lookup
						System.out.println("\nSearch Options");
						System.out.println("1. Find song by ID");
						System.out.println("2. List songs by artist");
						int searchChoice = getValidInt(keyboardScanner, "Enter search choice: ", 1, 2);
						if (searchChoice == 1)
						{
							System.out.print("Enter song ID (e.g., S1000): ");
							String id = keyboardScanner.next();
							manager.playSongById(id);
						} else
						{
							System.out.print("Enter artist name: ");
							String artist = keyboardScanner.next();
							manager.displaySongsByArtist(artist);
							
						}
						break;
					}
					case 8:
					{
						// User Story 9 — Sort the Playlist
						System.out.println("\nSort Options");
						System.out.println("1. Sort by title A–Z");
						System.out.println("2. Sort by duration longest first");
						int sortChoice = getValidInt(keyboardScanner, "Enter sort choice: ", 1, 2);
						if (sortChoice == 1)
						{
							manager.displayPlaylistSortedByTitle();
						} else
						{
							manager.displayPlaylistSortedByDuration();
						}
						break;
					}
					case 9:
					{
						System.out.println("Goodbye!");
						break;
					}
					}
				} while (choice != MENU_END);
				keyboardScanner.close();	} // End of Main Method


	public static int getValidInt(Scanner scanner, String prompt, int min, int max)
	{
		int value = min - 1; // start invalid for boolean flag
		boolean valid = false;
		while (!valid)
		{
			System.out.print(prompt);
			if (scanner.hasNextInt())
			{
				value = scanner.nextInt();
				if (value >= min && value <= max)
				{
					valid = true; // exit condition
				} else
				{
					System.out.println("Please enter a number between " + min + " and " + max + ".");
				}
			} else
			{
				System.out.println("Invalid input. Please enter a whole number.");
				scanner.next(); // clear if not valid int
			}
		}
		return value;
	}


} // End of Main Class


class Song 
{
	private String title;
	private String artist;
	private int durationSeconds;
	private static int songID = 1000;
	
	public Song (String title, String artist, int durationSeconds)
	{
		this.title = title;
		this.artist = artist;
		this.durationSeconds = durationSeconds;
		songID++;
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
	public int getSongID()
	{
		return songID;
	}
	public int durationInMinutes()
	{
		int minute;
		minute = durationSeconds / 60;
		return minute;
	}
	public int remainder()
	{
		int remainder;
		remainder = durationSeconds % 60;
		return remainder;
	}
	public double duration()
	{
		return durationInMinutes() + remainder();
	}
	public String toString()
	{
		return "S" + getSongID() + " " +  title + "'' " + " by "+ artist + "(" + durationInMinutes()+ ":" + remainder() + ")";
	}
	
} // End of Song Class

class PlaylistManager
{
	private ArrayList<Song> songs;
	private SinglyLinkedList<Song> upNextQueue;
	
	public PlaylistManager()
	{
		songs = new ArrayList<Song>();
		upNextQueue = new SinglyLinkedList<Song>();
	}
	
	//Collects the loaded file and create an array list where it can be later used.
	public boolean loadFromCsv(String filename)
	{
		int lineNumber = 0;
		int added = 0;
		boolean opened = true;
		try (Scanner fileScanner = new Scanner(new File(filename)))
		{
			while (fileScanner.hasNextLine())
			{
				String csvRow = fileScanner.nextLine();
				lineNumber++;
				if (csvRow.trim().isEmpty())
				{
					System.out.println("Line " + lineNumber + " skipped: empty line.");
				} else
				{
					Song song = parseSongLine(csvRow, lineNumber);
					if (song != null)
					{
						//if valid song returned add to songLibrary
						songs.add(song);
						added++;
					}
				}
			}
		} catch (FileNotFoundException ex)
		{
			System.out.println("Could not open file: " + filename);
			opened = false;
		}
		if (opened)
		{
			System.out.println("Loaded " + added + " songs.");
		}
		return opened && (added > 0);
	}


	public static Song parseSongLine(String line, int lineNumber)
	{
		// The -1 limit keeps empty trailing columns if present.
		String[] parts = line.split(",", -1);
		if (parts.length >= 3)
		{
			String title = parts[0].trim();
			String artist = parts[1].trim();
			String durText = parts[2].trim();
			try
			{
				int dur = Integer.parseInt(durText);
				// If valid create and return the song
				if (!title.isEmpty() && !artist.isEmpty() && dur >= 0)
				{
					
					return new Song(title, artist, dur);
				} else
				{
					System.out.println("Line " + lineNumber + " skipped: invalid values.");
				}
			} catch (NumberFormatException e)
			{
				System.out.println("Line " + lineNumber + " skipped: bad number.");
			}
		} else
		{
			System.out.println("Line " + lineNumber + " skipped: not enough columns.");
		}
		return null;
	}
	
	public int size()
	{
		return songs.size();
	}
	
	public Song get(int index)
	{
		if (index < 0 || index >= songs.size())
		{
			return null;
		}
		return songs.get(index);
	}
	
	public boolean enqueue(int index)
	{
		if (index < 0 || index == songs.size())
		{
			return false;
		}
		Song song = songs.get(index);
		upNextQueue.addLast(song);
		return true;
	}
	
	public void showUpNext()
	{
		upNextQueue.displayAll();
	}
	
	public Song playNext()
	{
		return upNextQueue.removeFirst();
	}
	
	public void displayPlaylist()
	{
		for(int i = 0; i < songs.size(); i++)
		{
		System.out.println("["+ i + "]" + songs.get(i));
		}
	}
	
	public void buildByIdMap()
	{
		Map<String, Song> songMapByTitle = new HashMap<>();
		 for (Song currentSong : songs)
	        {
	        	songMapByTitle.put(currentSong.getTitle(), currentSong); // key = title, value = book
	        }
	}
	
	public void playSongById(String searchTitle)
	{
		Map<String, Song> songMapByTitle = new HashMap<>();
		 for (Song currentSong : songs)
	        {
	        	songMapByTitle.put(currentSong.getTitle(), currentSong); // key = title, value = book
	        }
		if (songMapByTitle.containsKey(searchTitle))
        {
        	System.out.println("Now Playing: " + songMapByTitle.get(searchTitle));
        } else
        {
        	System.out.println("Song not found: " + searchTitle);
        }
	}
	
	public List<Song> displaySongsByArtist(String artist)
	{
		List<Song> songByArtist = new ArrayList<>();
		if (artist != null) 
		{
			System.out.println("Songs by artist :" + artist);
		}
		else 
        {
        	System.out.println("No songs found by" + artist);
        	return songByArtist;
        }
	    for (Song currentSong : songs) {
	        if (currentSong.getArtist().equalsIgnoreCase(artist)) {
	        	songByArtist.add(currentSong);
	        	System.out.println(currentSong);
	        }
	    }
	    return songByArtist;
	}
	
	public void displayPlaylistSortedByTitle()
	{
		System.out.println("Songs sorted by title:");
		songs.sort(Comparator.comparing(Song::getTitle));
		for (Song currentSong : songs)
		{
			System.out.println(currentSong);
		}

		System.out.println();
	}
	
	public void displayPlaylistSortedByDuration()
	{
		songs.sort(Comparator.comparing(Song::durationInMinutes));
		for (Song currentSong : songs)
		{
			System.out.println(currentSong);
		}
		System.out.println();
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
		
		Node(T value)
		{
			this.value = value;
			this.next = null;
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
		if (head != null)
		{
			return false;
		}
		else
		return true;
	}
	
	public void addLast(T value)
	{
		Node<T> newNode = new Node<>(value);

		if (head == null) // Case 1 : list is empty head and tail
		{
			head = newNode;
			tail = newNode;
		} else // case 2 : list is not empty - head exists
		{
			tail.next = newNode;
			tail = newNode;
		}
		count++; // updates size of queue
	}
	
	public T removeFirst()
	{
		if (head == null) // Case 1 : head does not exist
		{
			return null;
		}
		T value = head.value; // Collects the value and sets it to return a value (T)
		head = head.next;
		count--;
		if (head == null)
		{
			tail = null;
		}
		return value;
	}
	
	public void displayAll()
	{
		if (head == null) // Case 1 : head does not exist
		{
			System.out.println("Queue is empty.");
		} else 
		{
			Node <T> current = head;
			int position = 0;
			while (current != null)
			{
				System.out.println ("[" + position + "]" + current.next);
				position++;
			}
		}
	} // End of displayAll
} // End of SinglyLinkedList class