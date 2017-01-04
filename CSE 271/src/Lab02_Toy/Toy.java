package Lab02_Toy;

import java.awt.Rectangle;


public class Toy extends Rectangle implements IPlayable{

	// Variables
	private String name;
	private boolean playState;
	// public final int width = 100, height = 100;

	// Constructors
	public Toy(int x, int y, String name, boolean playState) {
		super(x, y, 100, 100);
		setName(name);
		setPlayState(playState);	
	}
	
	public Toy() {
		this(250, 250, "Toy", true);
	}
	
	// Methods
	public void startPlay(){
		setPlayState(true);
	}
	
	public void stopPlay(){
		setPlayState(false);
	}
	
	// Getters and Setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isPlayState() {
		return playState;
	}

	public void setPlayState(boolean playState) {
		this.playState = playState;
	}
	
	
}
