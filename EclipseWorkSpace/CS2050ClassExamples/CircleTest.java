public class CircleTest
{
	public static void main(String[] args)
	{
		CircleA circle1 = new CircleA(3);
		System.out.println("\n" + "Circle 1 Radius is " + circle1.getRadius());
		int newRadius = 5;
		updatePassedCircle(circle1, newRadius);
		System.out.println("\n" + "Circle 1 Radius is " + circle1.getRadius());
		CircleA circle2 = new CircleA();
		System.out.println("\n" + "Circle2 Radius is " + circle2.getRadius());
		newRadius = 100;
		updatePassedCircle(circle2, newRadius);
		System.out.println("\n" + "Circle2 Radius is " + circle2.getRadius());
	}
	public static void updatePassedCircle(CircleA currentCircle, int radius)
	{
		currentCircle.setRadius(radius);
	}
}
class CircleA
{
	private double radius = 1;
	private static int numberOfObjects = 0;
	public CircleA()
	{
		numberOfObjects++;
	}
	public CircleA(double radius)
	{
		setRadius(radius);
		numberOfObjects++;
	}
	public double getRadius()
	{
		return radius;
	}
	public void setRadius(double radius)
	{
		if (radius >= 0)
		{
			this.radius = radius;
		}
	}
	public static int getNumberOfObjects()
	{
		return numberOfObjects;
	}
	public double getArea()
	{
		return radius * radius * Math.PI;
	}
}