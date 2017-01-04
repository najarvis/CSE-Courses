package homework2;

import java.util.Random;

public class Homework2 {

	public static void main(String[] args) {
		// 9.8, 9.9, 9.10, 9.14
		System.out.println("P9.8");
		P9_8();
		System.out.println("\nP9.9");
		P9_9();
		System.out.println("\nP9.10");
		P9_10();
		System.out.println("\nP9.14");
		P9_14();
	}
	
	public static void P9_8(){
		// Implement a superclass Person, with subclasses Student and Instructor.
		Person randoMan = new Person("Tom", 1976);
		Student me = new Student("Nick", 1998, "Computer Science");
		Instructor teach = new Instructor("Thomas", 1912, 120000);
		
		System.out.println(randoMan);
		System.out.println(me);
		System.out.println(teach);
	}
	
	public static void P9_9(){
		// Implement a superclass Employee, subclass Manager, subclass Executive
		Employee emp1 = new Employee("Bobby", 60000);
		Manager man1 = new Manager("Rick", 85000, "HR");
		Executive exe1 = new Executive("Bill", 120000, "Operations");
		
		System.out.println(emp1);
		System.out.println(man1);
		System.out.println(exe1);
	}
	
	public static void P9_10(){
		// Make a BetterRectangle class that implements the normal Rectangle but adds
		// Methods for GetArea and GetPerimeter. 
		BetterRectangle BRect1 = new BetterRectangle(20, 50, 100, 55);
		System.out.println("The position of BRect1: (" + BRect1.getX() + ", " + BRect1.getY() + ")");
		System.out.println("The Size of BRect1: (" + BRect1.getWidth() + ", " + BRect1.getHeight() + ")");
		System.out.println("The Area of BRect1: " + BRect1.getArea());
		System.out.println("The Perimeter of BRect1: " + BRect1.getPerimeter());
	}
	
	public static void P9_14(){
		// Modify SodaCan class of Exercise 8.5. Add a measurable interface. The measure should be
		// equal to the surface area. Calculate the average surface area of an array of soda cans.
		int numCans = 123;
		Random random = new Random();
		
		double totalSurfaceArea = 0;
		
		SodaCan[] cans = new SodaCan[numCans];
		for (int i = 0; i < numCans; i++) {
			cans[i] = new SodaCan(random.nextInt(45) + 5, random.nextInt(9) + 1);
			totalSurfaceArea += cans[i].getMeasure();
		}
		
		System.out.printf("Number of cans: %d\n", numCans);
		System.out.printf("Total surface area: %.2fm^2\n", totalSurfaceArea);
		System.out.printf("Average surface area: %.2fm^2\n", totalSurfaceArea / numCans);
		
		
	}
	

}
