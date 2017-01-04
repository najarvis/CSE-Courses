package Lab02_Toy;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;


public class JackInTheBox extends ClownToy {

	// Variables
	private Color color;
	private boolean leftEyeOpen, rightEyeOpen;
	
	
	
	// Constructors
	public JackInTheBox(int x, int y, boolean playState, boolean popped, String name, Color fillColor, Color color, boolean leftEyeOpen, boolean rightEyeOpen) {
		super(x, y, playState, popped, fillColor, Color.WHITE);
		setName(name);
		setColor(color);
		setLeftEyeOpen(leftEyeOpen);
		setRightEyeOpen(rightEyeOpen);
	}
	
	public JackInTheBox(Color color, boolean leftEyeOpen, boolean rightEyeOpen){
		this(250, 250, true, true, "Jack in the Box", Color.BLACK, color, leftEyeOpen, rightEyeOpen);
	}
	
	
	
	// Methods
	public void draw(Graphics g) {
		int lidHeight = 20;
		int eyeSize   = 10;
		
		// Draw Box
		// Setting the color of the box for the jack in the box to dark gray
		g.setColor(Color.DARK_GRAY);
		g.fillRect(x, y, width, height);
		g.setColor(Color.BLACK);
		g.drawRect(x, y, width, height);
		
		if(isPopped()){
			// Draw The jack in the box
			int size = 80;
			int posX = x + (width - size) / 2;
			int posY = y - (size + ((width - size) / 2));
			g.setColor(getColor());
			g.fillOval(posX, posY, size, size);
			g.setColor(Color.BLACK);
			g.drawOval(posX, posY, size, size);
			
			// Draw lid opened
			g.setColor(Color.DARK_GRAY);
			g.fillRect(x - (lidHeight + 5), y - width, lidHeight, width);
			g.setColor(Color.BLACK);
			g.drawRect(x - (lidHeight + 5), y - width, lidHeight, width);
			
			// Eyes
			if (isLeftEyeOpen()){
				int leftEyePosX = x + (width - size) / 2 + (int) (size * 0.25);
				int leftEyePosY = y - (size + ((width - size) / 2)) + (int) (size * 0.25);
				
				g.setColor(getEyeColor());
				g.fillOval(leftEyePosX, leftEyePosY, eyeSize, eyeSize);
				g.setColor(Color.BLACK);
				g.drawOval(leftEyePosX, leftEyePosY, eyeSize, eyeSize);
				
			} else {
				int leftEyePosX = x + (width - size) / 2 + (int) (size * 0.25);
				int leftEyePosY = y - (size + ((width - size) / 2)) + (int) (size * 0.25);
				
				g.setColor(Color.BLACK);
				g.fillRect(leftEyePosX, leftEyePosY, eyeSize, 5);
			}
			
			if (isRightEyeOpen()){
				int rightEyePosX = x + (width - size) / 2 + (int) (size * 0.75 - eyeSize);
				int rightEyePosY = y - (size + ((width - size) / 2)) + (int) (size * 0.25);
				
				g.setColor(getEyeColor());
				g.fillOval(rightEyePosX, rightEyePosY, eyeSize, eyeSize);
				g.setColor(Color.BLACK);
				g.drawOval(rightEyePosX, rightEyePosY, eyeSize, eyeSize);
			} else {
				int rightEyePosX = x + (width - size) / 2 + (int) (size * 0.75 - eyeSize);
				int rightEyePosY = y - (size + ((width - size) / 2)) + (int) (size * 0.25);
				
				g.setColor(Color.BLACK);
				g.fillRect(rightEyePosX, rightEyePosY, eyeSize, 5);
			}
			
			if (isRightEyeOpen() || isLeftEyeOpen()){
				// Mouth Open
				int mouthPosX = x + (width - size) / 2 + size / 2 - eyeSize;
				int mouthPosY = y - (size + ((width - size) / 2)) + (int) (size * 0.75) - eyeSize;
				
				g.setColor(Color.RED);
				g.fillOval(mouthPosX, mouthPosY, eyeSize * 2, eyeSize * 2);
				g.setColor(Color.BLACK);
				g.drawOval(mouthPosX, mouthPosY, eyeSize * 2, eyeSize * 2);
				
			} else {
				// Mouse closed
			}
			
			
			
		} else {
			// Draw the lid closed
			g.setColor(Color.DARK_GRAY);
			g.fillRect(x, y - (lidHeight + 5), width, lidHeight);
			g.setColor(Color.BLACK);
			g.drawRect(x, y - (lidHeight + 5), width, lidHeight);
		}
	}
	
//	public void changePopState(){
//		setPopped(!isPopped());
//	}
	
	public void randomize(){
		Random random = new Random();
		changePopState();
		setLeftEyeOpen(random.nextBoolean());
		setRightEyeOpen(random.nextBoolean());
	}	
	
	// Getter and Setters
	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public boolean isLeftEyeOpen() {
		return leftEyeOpen;
	}

	public void setLeftEyeOpen(boolean leftEyeOpen) {
		this.leftEyeOpen = leftEyeOpen;
	}

	public boolean isRightEyeOpen() {
		return rightEyeOpen;
	}

	public void setRightEyeOpen(boolean rightEyeOpen) {
		this.rightEyeOpen = rightEyeOpen;
	}
	
}
