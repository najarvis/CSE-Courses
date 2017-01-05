package PolynomialHomework;

import java.util.ArrayList;
import java.util.Collections;

public class Polynomial {
	
	public ArrayList<Term> terms;
	
	public Polynomial(){
		this(new int[0], new int[0]);
	}
	
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
	 * @param p
	 */
	public Polynomial(Polynomial p){
		this.terms = new ArrayList<Term>();
		for (int i = 0; i < terms.size(); i++){
			this.terms.add(new Term(terms.get(i).getCoef(), terms.get(i).getExp()));
		}
	}
	
	@Override
	public String toString(){
		String toReturn = "";
		
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
	 * 
	 * @param other
	 * @return
	 */
	public Polynomial add(Polynomial other){
		Polynomial toReturn = new Polynomial(this);
		for (int i = 0; i < other.terms.size(); i++){
			boolean combined = false;
			for (int j = 0; j < toReturn.terms.size(); j++){
				if (other.terms.get(i).combinable(toReturn.terms.get(j))){
					toReturn.terms.set(j, other.terms.get(i).add(toReturn.terms.get(j)));
					combined = true;
				}
			}
			if (!combined) toReturn.terms.add(other.terms.get(i));
		}
		
		return toReturn;
	}
	
	public static void main(String[] args){
		Polynomial defaultCubic = new Polynomial(new int[] {1, 1, -1}, new int[] {-2, 3, 0});
		Polynomial defaultCubic2 = new Polynomial(new int[] {1, 3, 1}, new int[] {2, 3, 1});

		System.out.println(defaultCubic);
		System.out.println(defaultCubic.add(defaultCubic2));
		System.out.println("at x = 3 evaluates to " + defaultCubic.evaluate(3));
	}
}
