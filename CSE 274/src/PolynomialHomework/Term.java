package PolynomialHomework;

public class Term implements Comparable<Term>{

	private int coef;
	private int exp;
	
	public Term(int coef, int exp){
		this.coef = coef;
		this.exp = exp;
	}
	
	public Term(){
		this(0, 0);
	}
	
	public boolean combinable(Term otherTerm){
		return this.exp == otherTerm.exp;
	}
	
	public Term add(Term otherTerm) {
		if (!combinable(otherTerm)) return null;
		return new Term(this.coef + otherTerm.coef, this.exp);
	}
	
	public Term multiply(Term otherTerm){
		return new Term(this.coef * otherTerm.coef, this.exp + otherTerm.exp);
	}
	
	public Term multiplyScalar(int scalar){
		return new Term(this.coef * scalar, this.exp);
	}

	// Terms are sorted by their coefficients
	@Override
	public int compareTo(Term otherTerm) {
		if (!(otherTerm instanceof Term)) return 0;
		return ((Term)otherTerm).exp - this.exp;
	}
	
	public String toString(){
		return "" + this.coef + "x^" + this.exp;
	}
	
	public double evaluate(double val){
		return coef * Math.pow(val, exp);
	}
	
	public int getCoef(){
		return this.coef;
	}
	
	public int getExp(){
		return this.exp;
	}
}
