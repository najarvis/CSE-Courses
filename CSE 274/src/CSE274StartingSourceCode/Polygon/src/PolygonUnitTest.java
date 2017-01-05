import static org.junit.Assert.*;
import org.junit.*;

public class PolygonUnitTest {
	public static final double EPSILON = 0.001;

	@Test
	public void ctorTest1() {
		Polygon p = new Polygon();
		assertTrue(p.numVertices() == 3);
		assertEquals(p.area(), 0.5, EPSILON);
	}
	
	@Test
	public void ctorTest2() {
		Polygon p = new Polygon();
		p.addVertice(new Point(0, 1));
		assertTrue(p.numVertices() == 4);
		assertEquals(p.area(), 1, EPSILON);
	}
	
	@Test
	public void perimeterAreaTest1() {
		for (int i=0; i<10; i++) {
			double x1 = Math.random();
			double x2 = Math.random();
			double x3 = Math.random();
			double y1 = Math.random();
			double y2 = Math.random();
			double y3 = Math.random();
			Point [] pts1 = { new Point(x1, y1), 
							new Point(x2, y2), 
							new Point(x3, y3) }; 
			Point [] pts2 = { new Point(-x1, -y1), 
					new Point(-x2, -y2), 
					new Point(-x3, -y3) }; 
			
			Polygon p1 = new Polygon(pts1);
			Polygon p2 = new Polygon(pts2);
			assertEquals(p1.area(), p2.area(), EPSILON);
		}
	}
	@Test
	public void perimeterAreaTest2() {
		for (int i=1; i<10; i++) {
			double W = Math.random() * 100;
			double H = Math.random() * 100;
			double x = Math.random() * 400 - 200;
			double y = Math.random() * 400 - 200;
			Point [] pts1 = { new Point(x, y),
							new Point(x+W, y), 
							new Point(x+W, y+H),
							new Point(x, y+H) }; 
			
			Polygon p1 = new Polygon(pts1);
			assertEquals(p1.area(), W*H, EPSILON);
		}
	}	
	@Test
	public void testThatShouldFail() {
		Polygon p = new Polygon();
		assertEquals(p.numVertices(), 100);
	}

}
