package PolynomialHomework;

import static org.junit.Assert.*;

import org.junit.Test;

public class PolynomialTest {

	public static final double EPSILON = 0.001;
	
	@Test
	public void testEvaluate() {
		Polynomial defaultCubic = new Polynomial(new int[] {1, 1, 1}, new int[] {3, 2, 1});
		assertEquals(defaultCubic.evaluate(3), 39, EPSILON);
	}
	
	@Test
	public void testAdd(){
		Polynomial defaultCubic = new Polynomial(new int[] {1, 1, 1}, new int[] {3, 2, 1});
		assertEquals(defaultCubic.add(defaultCubic).toString(), "2x^3+2x^2+2x^1");
	}
	
	@Test
	public void testParse(){
		Polynomial Cubic = new Polynomial(new int[] {1, -1, 1}, new int[] {3, 2, 1});
		assertEquals(Cubic.multiply(Cubic).toString(), Polynomial.parse("1x^6-2x^5+3x^4-2x^3+1x^2").toString());
		
	}
	
	@Test
	public void testMultiply(){
		Polynomial defaultCubic = new Polynomial(new int[] {1, 1, 1}, new int[] {3, 2, 1});
		assertEquals(defaultCubic.multiply(defaultCubic).toString(), "1x^6+2x^5+3x^4+2x^3+1x^2");
	}
	
	@Test
	public void testNegate(){
		Polynomial defaultCubic = new Polynomial(new int[] {1, 1, 1}, new int[] {3, 2, 1});
		assertEquals(defaultCubic.negate().toString(), "-1x^3-1x^2-1x^1");
	}
	/*
	 * 	public static void main(String[] args){
		Polynomial defaultCubic = new Polynomial(new int[] {1, -1, 1}, new int[] {3, 2, 1});
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
	 */

}
