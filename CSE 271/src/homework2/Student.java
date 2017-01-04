package homework2;

public class Student extends Person {

	String major;
	
	public Student(String name, int birthYear, String major){
		super(name, birthYear);
		this.major = major;
	}
	
	@Override
	public String toString(){
		return "Student: name = " + name + ", birthYear = " + birthYear + ", major = " + major;
	}
}
