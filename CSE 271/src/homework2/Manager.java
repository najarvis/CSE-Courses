package homework2;

public class Manager extends Employee {
	
	String department;
	
	public Manager(String name, int salary, String department) {
		super(name, salary);
		this.department = department;
	}
	
	@Override
	public String toString() {
		return "Manager: name = " + name + ", salary = $" + salary + ", department = " + department;
	}
}
