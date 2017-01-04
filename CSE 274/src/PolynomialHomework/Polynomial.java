package PolynomialHomework;

import java.util.ArrayList;
import java.util.Collections;

public class Polynomial {
	
	public ArrayList<Term> terms;
	
	public Polynomial(){
		this(new int[0], new int[0]);
	}
	
	@SuppressWarnings("unchecked")
	public Polynomial(int[] coefs, int[] exps){
		terms = new ArrayList<Term>();
		
		// Assuming the length of coefs and exps is equal
		for (int i = 0; i < coefs.length; i++){
			terms.add(new Term(coefs[i], exps[i]));
		}
		
		Collections.sort(terms);
	}
	
	@Override
	public String toString(){
		String toReturn = "";
		
		for (int i = 0; i < terms.size(); i++){
			if (terms.get(i).getCoef() < 0 && i == terms.size() - 1)
				toReturn += "(" + terms.get(i).toString() + ")";
			
			else if (i == terms.size() - 1)
				toReturn += terms.get(i).toString();
			
			else if (terms.get(i).getCoef() < 0)
				toReturn += "(" + terms.get(i).toString() + ") + ";
			
			else
				toReturn += terms.get(i).toString() + " + ";
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
	
	public static void main(String[] args){
		Polynomial defaultCubic = new Polynomial(new int[] {1, -1, -1}, new int[] {3, 2, 1});
		System.out.println(defaultCubic);
		System.out.println(defaultCubic.evaluate(3));
	}
}
