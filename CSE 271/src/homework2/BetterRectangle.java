package homework2;

import java.awt.Rectangle;

@SuppressWarnings("serial")
public class BetterRectangle extends Rectangle {

	public BetterRectangle(int x, int y, int width, int height) {
		super(x, y, width, height);
	}
	
	public int getPerimeter() {
		return 2 * width + 2 * height;
	}
	
	public int getArea() {
		return width * height;
	}
	
}
