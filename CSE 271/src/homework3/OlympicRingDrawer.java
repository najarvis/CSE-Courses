package homework3;


import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

public class OlympicRingDrawer extends JComponent{

	private int x, y;
	private int width, height;
	
	public OlympicRingDrawer(int x, int y, int width, int height) {
		setX(x); // Why does this influence where it goes? I don't want it to.
		setY(y);
		setWidth(width);
		setHeight(height);
		
		repaint();
	}

	public void drawRing(Graphics g, int posX, int posY, int size, Color color) {
		
		g.setColor(color);
		g.drawOval(posX, posY, size, size);
	}
	
	@Override
	public void paintComponent(Graphics g){
		int ringDiameter = getWidth() / 3;
		drawRing(g, 0, 0, ringDiameter, Color.blue);
		drawRing(g, ringDiameter, 0, ringDiameter, Color.yellow);
		drawRing(g, ringDiameter * 2, 0, ringDiameter, Color.black);
		drawRing(g, (int) (ringDiameter * 0.5), (int) (ringDiameter * 0.5), ringDiameter, Color.green);
		drawRing(g, (int) (ringDiameter * 1.5), (int) (ringDiameter * 0.5), ringDiameter, Color.red);
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

}

