package Scratch;

public class Tester {

	public static void main(String[] args){
		//Get input
		String input = "      SMITH    ,    MARY jean     ";
		
		String lastName = input.split(",")[0].trim();
		lastName.toLowerCase();
		String afterComma = input.split(",")[1].trim();
		String firstName = afterComma.split(" ")[0];
		String middleName = afterComma.split(" ")[1];
		
		char middleNameInitial = middleName.toUpperCase().charAt(0);
		System.out.println( firstName + " " + middleNameInitial + ". " + lastName );
		
		
		//ppa(middleNameInitial);
		
		
	}
	
	public static void ppa(Object[] a){
		for (Object o : a){
			System.out.println(o);
		}
	}
	
	public static void ppa(Object o) {
		System.out.println(o);
	}
	
}
