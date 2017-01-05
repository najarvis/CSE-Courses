import static org.junit.Assert.*;

import org.junit.Test;

public class PointUnitTester {

	@Test
	public void defaultConstructorTest() {
		Point pt = new Point();
		assertEquals(pt.getX(), 0, 0.001);
		assertEquals(pt.getY(), 0, 0.001);
	}
	
	@Test
	public void parseTest() {
		Point pt = Point.parse("(10.5,-12.9)");
		assertEquals(pt.getX(), 10.5, 0.001);
		assertEquals(pt.getY(), -12.9, 0.001);
	}

}