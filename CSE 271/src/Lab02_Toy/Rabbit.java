package Lab02_Toy;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;


public class Rabbit extends ClownToy {

	// Variables
	private int lookDirection;
	private Color color;
	
	
	// Constructors
	public Rabbit(int x, int y, boolean playState, boolean popped, String name, Color fillColor, Color color, int lookDirection) {
		super(x, y, playState, popped, fillColor, Color.WHITE);
		setName(name);
		setFillColor(fillColor);
		setColor(color);
		setLookDirection(lookDirection);
	}
	
	public Rabbit(Color color, int lookDirection) {
		this(250, 250, true, false, "Rabbit", Color.WHITE, color, lookDirection);
	}
	
	// Methods
	public void draw(Graphics g){
		int hatWidth = (int) (width * 1.5);
		int eyeSize   = 10;
		
		// Draw Hat
		// Setting the color of the box for the jack in the box to dark gray
		g.setColor(Color.RED);
		g.fillRect(x, y, width, height);
		g.setColor(Color.BLACK);
		g.drawRect(x, y, width, height);
		
		g.setColor(Color.RED);
		g.fillRect(x - ((hatWidth - width) / 2), y - 5, hatWidth, 5);
		g.setColor(Color.BLACK);
		g.drawRect(x - ((hatWidth - width) / 2), y - 5, hatWidth, 5);
		
		if (isPopped()){
			// Draw the rabbit
			int size = 80;
			int posX = x + (width - size) / 2;
			int posY = y - (size + ((width - size) / 2));
			
			// Left ear
			g.setColor(getColor());
			g.fillOval(posX, posY - (size - 20), 20, size);
			g.setColor(Color.BLACK);
			g.drawOval(posX, posY - (size - 20), 20, size);
			
			// Right ear
			g.setColor(getColor());
			g.fillOval(posX + (size - 20), posY - (size - 20), 20, size);
			g.setColor(Color.BLACK);
			g.drawOval(posX + (size - 20), posY - (size - 20), 20, size);
			
			// Head
			g.setColor(getColor());
			g.fillOval(posX, posY, size, size);
			g.setColor(Color.BLACK);
			g.drawOval(posX, posY, size, size);
			
			if (lookDirection == -1){
				
				int leftEyePosX = x + (width - size) / 2 + (int) (size * 0.1);
				int leftEyePosY = y - (size + ((width - size) / 2)) + (int) (size * 0.25);
				
				int rightEyePosX = x + (width - size) / 2 + (int) (size * 0.3);
				int rightEyePosY = y - (size + ((width - size) / 2)) + (int) (size * 0.25);
		
				g.setColor(getEyeColor());
				g.fillOval(leftEyePosX, leftEyePosY, eyeSize, eyeSize);
				g.setColor(Color.BLACK);
				g.drawOval(leftEyePosX, leftEyePosY, eyeSize, eyeSize);
				
				g.setColor(getEyeColor());
				g.fillOval(rightEyePosX, rightEyePosY, eyeSize, eyeSize);
				g.setColor(Color.BLACK);
				g.drawOval(rightEyePosX, rightEyePosY, eyeSize, eyeSize);
				
			} else if (lookDirection == 0) {
				int leftEyePosX = x + (width - size) / 2 + (int) (size * 0.25);
				int leftEyePosY = y - (size + ((width - size) / 2)) + (int) (size * 0.25);
				
				int rightEyePosX = x + (width - size) / 2 + (int) (size * 0.75 - eyeSize);
				int rightEyePosY = y - (size + ((width - size) / 2)) + (int) (size * 0.25);
				
				g.setColor(getEyeColor());
				g.fillOval(leftEyePosX, leftEyePosY, eyeSize, eyeSize);
				g.setColor(Color.BLACK);
				g.drawOval(leftEyePosX, leftEyePosY, eyeSize, eyeSize);
				
				g.setColor(getEyeColor());
				g.fillOval(rightEyePosX, rightEyePosY, eyeSize, eyeSize);
				g.setColor(Color.BLACK);
				g.drawOval(rightEyePosX, rightEyePosY, eyeSize, eyeSize);
				
				// Mouth
				int mouthPosX = x + (width - size) / 2 + size / 2 - eyeSize;
				int mouthPosY = y - (size + ((width - size) / 2)) + (int) (size * 0.75) - eyeSize;
				
				g.setColor(Color.RED);
				g.fillRect(mouthPosX, mouthPosY, eyeSize * 2, eyeSize);
				g.setColor(Color.BLACK);
				g.drawRect(mouthPosX, mouthPosY, eyeSize * 2, eyeSize);
				
			} else {
				int leftEyePosX = x + (width - size) / 2 + (int) (size * 0.7 - eyeSize);
				int leftEyePosY = y - (size + ((width - size) / 2)) + (int) (size * 0.25);
				
				int rightEyePosX = x + (width - size) / 2 + (int) (size * 0.9 - eyeSize);
				int rightEyePosY = y - (size + ((width - size) / 2)) + (int) (size * 0.25);
				
				g.setColor(getEyeColor());
				g.fillOval(leftEyePosX, leftEyePosY, eyeSize, eyeSize);
				g.setColor(Color.BLACK);
				g.drawOval(leftEyePosX, leftEyePosY, eyeSize, eyeSize);
				
				g.setColor(getEyeColor());
				g.fillOval(rightEyePosX, rightEyePosY, eyeSize, eyeSize);
				g.setColor(Color.BLACK);
				g.drawOval(rightEyePosX, rightEyePosY, eyeSize, eyeSize);
			}

		}
		
		
		
	}
	
//	public void changePopState(boolean newState){
//		setPopped(!isPopped());
//	}

	public void randomize(){
		Random random = new Random();
		changePopState();
		setLookDirection(random.nextInt(3)-1);
	}
	
	// Getters and Setters
	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}	
	
	public int getLookDirection() {
		return lookDirection;
	}

	public void setLookDirection(int lookDirection) {
		if (lookDirection < -1) {
			lookDirection = -1;
			
		} else if (lookDirection > 1) {
			lookDirection = 1;
		
		}	
		
		this.lookDirection = lookDirection;
	}
	
	
}
