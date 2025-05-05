import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


/**
 * Main class to test dealership functionalities.
 */
public class CarDealershipTest
{
	public static void main(String[] args)
	{
		final int MAX_NUM_CARS = 5;
		// see how exception works then fix to find file
		final String DEALERSHIP1_FILE = "dealership1.txt";

		try
		{
			// Create a new dealership instance
			Dealership dealership1 = new Dealership("Deb's Dealership", MAX_NUM_CARS);
			System.out.println("Setting up " + dealership1.getName());

			// Read car data from file
			dealershipSetUp(dealership1, DEALERSHIP1_FILE);
			System.out.println("Current Number of cars in dealership: " + dealership1.getNumberCars());
			System.out.println("\nTry Adding more cars...");

			// Adding extra cars
			Car car5 = new Car("Porsche", "Spyder", 164200.00);
			Car car6 = new Car("Hyundai", "Ioniq", 29000.00);
			dealership1.addCar(car5);
			dealership1.addCar(car6);

			dealership1.displayCars();

			// Display the most expensive car
			Car mostExpensive = dealership1.findMostExpensiveCar();
			System.out.println("\nCar with highest price in dealership:");
			System.out.println("Dealership: " + dealership1.getName());
			System.out.println("Make:       " + mostExpensive.getMake());
			System.out.println("Model:      " + mostExpensive.getModel());
			System.out.println("Price:      $" + mostExpensive.getPrice());

		} catch (FileNotFoundException e)
		{
			System.out.println("Error: Can't upload dealership information\n" + e.getMessage());
		}
	}

	/**
	 * Reads car data from a file and adds them to the dealership.
	 */
	public static void dealershipSetUp(Dealership dealership, String filename) throws FileNotFoundException
	{
		Scanner fileScanner = null;
		try
		{
			fileScanner = new Scanner(new File(filename));
			while (fileScanner.hasNextLine())
			{
				String make = fileScanner.next().trim();
				String model = fileScanner.next().trim();
				double price = fileScanner.nextDouble();
				Car currentCar = new Car(make, model, price);
				dealership.addCar(currentCar);
			}
		} finally
		{
			if (fileScanner != null)
			{
				fileScanner.close();
			}
		}
	}
}



/**
 * Represents a single Car with make, model, and price attributes.
 */
class Car
{
	private String make;
	private String model;
	private double price;

	public Car(String make, String model, double price)
	{
		this.make = make;
		this.model = model;
		this.price = price;
	}

	public String getMake()
	{
		return make;
	}

	public String getModel()
	{
		return model;
	}

	public double getPrice()
	{
		return price;
	}
}

/**
 * Represents a Car Dealership that manages a list of cars.
 */
class Dealership
{
	private String name;
	private Car[] cars;
	private int currentNumberCars;

	/**
	 * Constructor 
	 */
	public Dealership(String name, int maxNumCars) 
	{
		this.name = name;
		cars = new Car[maxNumCars];
		currentNumberCars = 0;
	}



	public String getName()
	{
		return name;
	}

	public int getNumberCars()
	{
		return currentNumberCars;
	}

	/**
	 * Adds a new car to the dealership if there is space.
	 */
	public void addCar(Car carToAdd)
	{
		if (currentNumberCars < cars.length)
		{
			cars[currentNumberCars] = carToAdd;
			currentNumberCars++;
		} else
		{
			System.out.println("Dealership is full. Couldn't add car: " + carToAdd.getMake() + " " + carToAdd.getModel()
					+ " " + carToAdd.getPrice());
		}
	}

	/**
	 * Finds the car with the highest price in the dealership.
	 */
	public Car findMostExpensiveCar()
	{
		if (currentNumberCars == 0)
		{
			System.out.println("No cars in dealership.");
			return null;
		}
		double highestPrice = cars[0].getPrice();
		int highestPriceIndex = 0;
		for (int i = 1; i < currentNumberCars; i++)
		{
			if (cars[i].getPrice() > highestPrice)
			{
				highestPrice = cars[i].getPrice();
				highestPriceIndex = i;
			}
		}
		return cars[highestPriceIndex];
	}

	/**
	 * Displays all cars in the dealership.
	 */
	public void displayCars()
	{
		if (currentNumberCars == 0)
		{
			System.out.println("No cars available in " + name);
			return;
		}
		System.out.println("--------------------------------------------");
		System.out.println(name);
		System.out.println("Make \t\t Model \t\t Price ");
		System.out.println("--------------------------------------------");
		for (int i = 0; i < currentNumberCars; i++)
		{
			Car car = cars[i];
			System.out.printf("%s\t\t%s\t\t%.2f\n", car.getModel(), car.getMake(), car.getPrice());
		}
	}
}


