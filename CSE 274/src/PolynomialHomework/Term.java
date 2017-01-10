package PolynomialHomework;

/**
 * Term class. Helper class for Polynomial.
 * @author Nick Jarvis
 *
 */
public class Term implements Comparable<Term>{

	private int coef;
	private int exp;
	
	/**
	 * Constructor for Term. Accepts input for both coefficient and exponent
	 * @param coef The coefficient for the new Term
	 * @param exp The exponent for the new Term
	 */
	public Term(int coef, int exp){
		this.coef = coef;
		this.exp = exp;
	}
	
	/**
	 * Default constructor for Term. Sets coefficient and exponent to zero.
	 */
	public Term(){
		this(0, 0);
	}
	
	/**
	 * Parses a string and returns a Term instance from it.
	 * @param str The String to parse
	 * @return A new Term based on the inputed String
	 */
	public static Term parse(String str){
		int i = str.indexOf("x");
		return new Term(Integer.parseInt(str.substring(0, i)), Integer.parseInt(str.substring(i + 2)));
	}
	
	/**
	 * A helper method to see if two Terms are combinable
	 * @param otherTerm The other term to test
	 * @return True if the exponents of the terms are equal
	 */
	public boolean combinable(Term otherTerm){
		return this.exp == otherTerm.exp;
	}
	
	/**
	 * Adds two Terms together
	 * @param otherTerm The other Term to add
	 * @return a new Term based on the addition of the two, or null if they cannot be added.
	 */
	public Term add(Term otherTerm) {
		if (!combinable(otherTerm)) return null;
		return new Term(this.coef + otherTerm.coef, this.exp);
	}
	
	/**
	 * Multiplies two Terms together
	 * @param otherTerm The other Term to multiply
	 * @return a new Term based on the product of the other two Terms
	 */
	public Term multiply(Term otherTerm){
		return new Term(this.coef * otherTerm.coef, this.exp + otherTerm.exp);
	}
	
	/**
	 * Multiplies a Term by a scalar.
	 * @param scalar The scalar by which to multiply the Term
	 * @return A new Term equal to the old Term multiplied by the scalar
	 */
	public Term multiplyScalar(int scalar){
		return new Term(this.coef * scalar, this.exp);
	}

	/**
	 * compareTo function for Terms. Terms are sorted by their exponents
	 */
	@Override
	public int compareTo(Term otherTerm) {
		if (!(otherTerm instanceof Term)) return 0;
		return ((Term)otherTerm).exp - this.exp;
	}
	
	/**
	 * ToString method for the Terms.
	 */
	@Override
	public String toString(){
		return "" + this.coef + "x^" + this.exp;
	}
	
	/**
	 * Evaluates the Term at a given input (for the X)
	 * @param val The value at which to evaluate the term
	 * @return The value of the Term evaluated a value of val
	 */
	public double evaluate(double val){
		return coef * Math.pow(val, exp);
	}
	
	/**
	 * Getter for Coefficient
	 * @return The coefficient
	 */
	public int getCoef(){
		return this.coef;
	}
	
	/**
	 * Setter for Coefficient
	 * @param coef The new coefficient
	 */
	public void setCoef(int coef){
		this.coef = coef;
	}
	
	/**
	 * Getter for Exponent
	 * @return The Exponent
	 */
	public int getExp(){
		return this.exp;
	}
	
	/**
	 * Setter for Exponent
	 * @param exp The new Exponent
	 */
	public void setExp(int exp){
		this.exp = exp;
	}
}
