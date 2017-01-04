package homework2;

public class Instructor extends Person {
	
	int salary;
	
	public Instructor(String name, int birthYear, int salary){
		super(name, birthYear);
		this.salary = salary;
	}
	
	@Override
	public String toString() {
		return "Instructor: name = " + name + ", birthYear = " + birthYear + ", salary = $" + salary;
	}
}
