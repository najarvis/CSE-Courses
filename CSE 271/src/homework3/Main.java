package homework3;

import java.awt.Button;
import java.awt.Dimension;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main {

	private static final int WIDTH = 500;
	private static final int HEIGHT = 500;
	
	public Main() {
		JFrame frame = new JFrame();
		frame.setSize(WIDTH + 2, HEIGHT + 250 + frame.getInsets().top);
		frame.setTitle("Homework 3 - Nick Jarvis");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		
		frame.setVisible(true);
		
		P10_1(frame);
		P10_26(frame);
		
	}
	
	public static void P10_1(JFrame frame) {
		// Create a square frame filled with 100 buttons labeled 1 to 100
		JPanel contentCenter = new JPanel(new GridBagLayout());
		for (int i = 0; i < 10; i++){
			for (int j = 0; j < 10; j++) {
				// Create a button with the proper name. 10's place + 1's place + 1 (so it doesn't start at 0).
				Button button = new Button(Integer.toString((j * 10) + i + 1));
				
				// Set its position
				button.setLocation(i * (WIDTH / 10) + 1, j * (HEIGHT / 10));
				
				button.setMinimumSize(new Dimension(WIDTH / 10, HEIGHT / 10));
				button.setMaximumSize(new Dimension(WIDTH / 10, HEIGHT / 10));
				button.setSize(new Dimension(WIDTH / 10, HEIGHT / 10));
				
				// Set its preferred size
				button.setPreferredSize(new Dimension(WIDTH / 10, HEIGHT / 10));
				
				// Set its borders
				button.setBounds(i * (WIDTH / 10) + frame.getInsets().left, j * (HEIGHT / 10), WIDTH / 10, HEIGHT / 10 );
				
				// Add it to the frame
				contentCenter.add(button);
				
				// This is not working and I have NO IDEA why not.
			}
		}
		
		frame.setContentPane(contentCenter);

	}
	
	public static void P10_26(JFrame frame) {
		// Make the Olympic Logo. Provide a method draw ring that draws a ring of a given position and color.
		// (from left to right they are blue, yellow, black, green, red).
		
		frame.add(new OlympicRingDrawer(0, HEIGHT, WIDTH, 250));
		
	}
	
	public static void main(String[] args) {
		new Main();	

	}

}
