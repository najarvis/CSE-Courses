package Lab02_Toy;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class Tester extends JPanel{

	private ArrayList<ClownToy> toys = new ArrayList<ClownToy>();
	
	final int WIDTH = 600;
	final int HEIGHT = 600;
	
	// Apologize in advance for the lack of comments, ran out of time.
	public Tester() {
		JFrame window = new JFrame("kanena & jarvisna - Lab 02 - Meme Machine with Jacks and Rabbits");
		window.setBounds(0, 0, WIDTH, HEIGHT);
		window.setDefaultCloseOperation(window.EXIT_ON_CLOSE);
		window.add(this);
		window.setVisible(true);
		
		buildRandomJacks(3);
		buildRandomRabbits(3);
		
		addMouseListener(new MouseListener() {
			@Override
			public void mousePressed(MouseEvent e) {
				for (ClownToy ct : toys){
					if (ct.contains(e.getPoint())){
						ct.randomize();
						repaint();
					}
				}
			}
			
			@Override public void mouseReleased(MouseEvent e) {}
			@Override public void mouseEntered(MouseEvent e) {}
			@Override public void mouseClicked(MouseEvent e) {}
			@Override public void mouseExited(MouseEvent e) {}
			
		});
		
		
	}
	
	public void buildRandomJacks(int n) {
		Random random = new Random();
		for (int i = 0; i < n; i++) {
			int randomX = random.nextInt(WIDTH - 100);
			int randomY = random.nextInt(HEIGHT - 100);
			toys.add(new JackInTheBox(randomX, randomY, true, false, "Jack", Color.BLACK, Color.BLUE, random.nextBoolean(), random.nextBoolean()));
		}
	}
	
	public void buildRandomRabbits(int n) {
		Random random = new Random();
		for (int i = 0; i < n; i++) {
			int randomX = random.nextInt(WIDTH - 100);
			int randomY = random.nextInt(HEIGHT - 100);
			toys.add(new Rabbit(randomX, randomY, true, random.nextBoolean(), "Rabbit", Color.RED, Color.GREEN, random.nextInt(3)-1));
		}		
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for(ClownToy ct : toys){
			ct.draw(g);
		}
	}
	
//	public void paint(Graphics g) {
//		for(ClownToy ct : toys){
//			ct.draw(g);
//		}
//	}
	
	public static void main(String[] args) {
		new Tester();
	}

}
