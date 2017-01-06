package PolynomialHomework;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Polynomial class
 * @author Nick Jarvis
 *
 */
public class Polynomial {
	
	public ArrayList<Term> terms;
	
	/**
	 * Default constructor for Polynomial. Initializes with no terms.
	 */
	public Polynomial(){
		this(new int[0], new int[0]);
	}
	
	/**
	 * Constructor for Polynomial that accepts matching arrays for the terms 
	 * @param coefs Integer array of the coefficients of each term
	 * @param exps Integer array of the exponents of each term
	 */
	public Polynomial(int[] coefs, int[] exps){
		terms = new ArrayList<Term>();
		
		// Assuming the length of coefs and exps is equal
		for (int i = 0; i < coefs.length; i++){
			terms.add(new Term(coefs[i], exps[i]));
		}

		Collections.sort(terms);
	}
	
	/**
	 * Deep copy constructor
	 * @param p The Polynomial to copy
	 */
	public Polynomial(Polynomial p){
		terms = new ArrayList<Term>();
		for (int i = 0; i < p.terms.size(); i++){
			terms.add(new Term(p.terms.get(i).getCoef(), p.terms.get(i).getExp()));
		}
	}
	
	/**
	 * returns a String version of the Polynomial. This is also the format that is used for parsing.
	 */
	@Override
	public String toString(){
		String toReturn = "";
		Collections.sort(terms);
		
		for (int i = 0; i < terms.size(); i++){
			if (terms.get(i).getCoef() < 0 && i == terms.size() - 1)
				toReturn +=terms.get(i).toString();
			
			else if (i == terms.size() - 1)
				toReturn += "+" + terms.get(i).toString();
			
			else if (terms.get(i).getCoef() < 0)
				toReturn += terms.get(i).toString();
			
			else if (i != 0)
				toReturn += "+"+terms.get(i).toString();
			
			else
				toReturn += terms.get(i).toString();
		}
		
		return toReturn;
	}
	
	/**
	 * Evaluates the polynomial at a given value, x
	 * @param x The at which to evaluate the polynomial
	 * @return The value of the evaluated Polynomial
	 */
	public double evaluate(double x){
		double sum = 0;
		for (int i = 0; i < terms.size(); i++){
			sum += terms.get(i).evaluate(x);
		}
		
		return sum;
	}
	
	// Other polynomial functions below
	
	/**
	 * Negates the Polynomial (inverts all of the coefficients of the terms)
	 * @return The negated Polynomial
	 */
	public Polynomial negate(){
		Polynomial toReturn = new Polynomial(this);
		for (Term t : toReturn.terms){
			t.setCoef(-t.getCoef());
		}
		return toReturn;
	}
	
	/**
	 * Adds two Polynomials together
	 * @param p The other Polynomial to add
	 * @return A new Polynomial equal to the addition of the two
	 */
	public Polynomial add(Polynomial p){
		Polynomial toReturn = new Polynomial(this);
		for (int i = 0; i < p.terms.size(); i++){
			boolean combined = false;
			for (int j = 0; j < toReturn.terms.size(); j++){
				if (p.terms.get(i).combinable(toReturn.terms.get(j))){
					toReturn.terms.set(j, p.terms.get(i).add(toReturn.terms.get(j)));
					combined = true;
					break;
				}
			}
			if (!combined) toReturn.terms.add(p.terms.get(i));
		}
		
		return toReturn;
	}
	
	/**
	 * Subtracts two Polynomials together
	 * @param p The other Polynomial to Subtract
	 * @return A new Polynomial equal to the difference of the two
	 */
	public Polynomial subtract(Polynomial p){
		return add(p.negate());
	}
	
	/**
	 * Multiplies two Polynomials together and returns a new Polynomial
	 * @param p The other Polynomial to Multiply
	 * @return A new Polynomial equal to the difference of the two
	 */
	public Polynomial multiply(Polynomial p){
		Polynomial toReturn = new Polynomial();
		for (int i = 0; i < terms.size(); i++){
			for (int j = 0; j < p.terms.size(); j++){
				int[] tmpCoef = new int[] {terms.get(i).getCoef() * p.terms.get(j).getCoef()};
				int[] tmpExp = new int[] {terms.get(i).getExp() + p.terms.get(j).getExp()};
				Polynomial toAdd = new Polynomial(tmpCoef, tmpExp);
				toReturn = toReturn.add(toAdd);
			}
		}
		
		return toReturn;
	}
	
	/**
	 * Checks if two Polynomials are equivalent
	 * @param p The other Polynomial to check for equivalence with
	 * @return True if the two Polynomials are equal, false if not
	 */
	public boolean equals(Polynomial p){
		return toString().equals(p.toString());
	}
	
	/**
	 * Parse a string and output a new Polynomial
	 * @param str The String to parse
	 * @return A new Polynomial equal to the parsed String
	 */
	public static Polynomial parse(String str){
		Polynomial toReturn = new Polynomial();
		str = str.replaceAll("(?<!\\^)\\-", "+-");
		for (String s : str.split("(?<!\\^)\\+")){
			toReturn.terms.add(Term.parse(s));
		}
		return toReturn;
		
	}
	
	public static void main(String[] args){
		Polynomial defaultCubic = new Polynomial(new int[] {1, 1, 1}, new int[] {3, 2, 1});
		Polynomial defaultCubic2 = new Polynomial(new int[] {1, 3, 1}, new int[] {2, 3, 1});

		
		//System.out.println("at x = 3 evaluates to " + defaultCubic.evaluate(3));
		System.out.println(defaultCubic);
		System.out.println(defaultCubic2);
		System.out.println(defaultCubic.add(defaultCubic2));
		System.out.println(defaultCubic.add(defaultCubic2).negate());
		
		System.out.println();
		
		System.out.println(Term.parse("-3x^4").toString());
		
		System.out.println();
		System.out.println(defaultCubic.multiply(defaultCubic));
		
		System.out.println(parse("3x^6-2x^5+32x^4-2x^3+1x^-2").toString());
		
		
		
	}
}
