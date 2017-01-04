package homework2;

public class Person {
	String name;
	int birthYear;
	
	public Person(String name, int birthYear){
		this.name = name;
		this.birthYear = birthYear;
	}
	
	@Override
	public String toString(){
		return ("Person: name = " + name + ", birthYear = " + birthYear);
	}
}
