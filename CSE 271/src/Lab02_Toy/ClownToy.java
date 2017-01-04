package Lab02_Toy;

import java.awt.Color;

public abstract class ClownToy extends Toy implements IDrawable{
	
	// Variables
	private boolean popped;
	private Color fillColor, eyeColor;
	
	
	
	// Constructors
	public ClownToy(int x, int y, boolean playState, boolean popped, Color fillColor, Color eyeColor) {
		super(x, y, "Clown Toy", playState);
		setPopped(popped);
		setFillColor(fillColor);
		setEyeColor(eyeColor);
		
		
	}

	public void changePopState(){
		setPopped(!isPopped());
	}
	
	public abstract void randomize();
	
	public ClownToy() {
		this(250, 250, true, false, Color.CYAN, Color.WHITE);
	}
	
	// Getters and Setters
	public boolean isPopped() {
		return popped;
	}

	public void setPopped(boolean popped) {
		this.popped = popped;
	}

	public Color getFillColor() {
		return fillColor;
	}

	public void setFillColor(Color fillColor) {
		this.fillColor = fillColor;
	}

	public Color getEyeColor() {
		return eyeColor;
	}

	public void setEyeColor(Color eyeColor) {
		this.eyeColor = eyeColor;
	}

}
