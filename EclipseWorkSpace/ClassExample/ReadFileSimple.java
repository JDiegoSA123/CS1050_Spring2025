import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFileSimple {
    public static void main(String[] args) {
        final String FILENAME = "test.txt"; 

        try {
            // Create a Scanner to read from the file
        	File testFile = new File(FILENAME);
            Scanner fileScanner = new Scanner(testFile);

            System.out.println("Reading file contents:");

            // Read and print each line in the file
            //iterate while the file has a next line
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine(); // Read the full line
                System.out.println(line);             // Display it to the console
            }

            // Always close the file when done
            fileScanner.close();

        } catch (FileNotFoundException e) {
            // Handle the case where the file does not exist
            System.out.println("Error: Could not open file: " + e.getMessage());
        }
    }
}
