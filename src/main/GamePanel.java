package main;
// Of Package Main

import java.awt.Color;
// Imports Colour Commands
import java.awt.Dimension;
//Imports Dimensions For Screens
import java.awt.Graphics;
// Imports Graphics
import java.awt.Graphics2D;
//Imports Graphics
import javax.swing.JPanel;
// Imports Screen Content
import entity.Player;
//Imports Player Class

public class GamePanel extends JPanel implements Runnable{
	// Extends JPanel

	// <SCREEN SETINGS START
	final int originalTileSize = 32; //16x16 tile
	final int scale=3; // Scale Of Pixels
	
	public final int tileSize = originalTileSize * scale;// 48x48 tile(MAX)
	final int maxScreenCol = 16;
	final int maxScreenRow = 12;
	final int screenWidth = tileSize * maxScreenCol; //786 pixels
	final int screenHeight = tileSize * maxScreenRow; //576 pixels
	// SCREEN SETINGS END>
	
	int FPS =60;
	//Creates FPS
	
	// <INSTANCIATIONS START
	KeyHandler keyH = new KeyHandler();
	// Introduces Key Handler
	Thread gameThread;
	// Creates Game Thread
	Player player = new Player(this,keyH);
	// INSTANCIATIONS END>
	
	// <Start Player Pos
	int playerX = 100;
	int playerY = 100;
	int playerSpeed = 4;
	// End Player Pos>
	
	public GamePanel() {
		// Constructor Class
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		// Sets The Size Of The Class
		this.setBackground(Color.black);
		// Sets Background Color
		this.setDoubleBuffered(true);
		// Improves Buffering
		this.addKeyListener(keyH);
		// Recognizes Key Input
		this.setFocusable(true);
		// Game panel can be focused to receive input
	}
	
	public void startGameThread() {
		gameThread = new Thread(this);
		// Creates gameThread Instance
		gameThread.start();
		// Starts gameThread
	}
	
	// <GAME LOOP
	@Override
	public void run() {
		double drawInterval = 1000000000/FPS;
		//Creates Drawing Interval(Nanoseconds)
		double delta = 0;
		// Creates Variable For Time Checking
		long lastTime=System.nanoTime();
		// Creates Variable For Last Time
		long currentTime;
		// Creates Variable For Current Time
		long timer = 0;
		// Creates Timer
		int drawCount = 0;
		// Creates Draw Count
		
		while(gameThread != null) {
			// While Game Thread Exist
			
			currentTime = System.nanoTime();
			// Sets Current Time
			
			delta += (currentTime - lastTime) / drawInterval;
			// Delta Calculation
			timer += (currentTime - lastTime);
			// Gets Current Time
			lastTime=currentTime;
			// Records Time
			
			if(delta >= 1) {
				// If Delta Out Of Time
				update();
				// Updates
				repaint();
				// Redraws
				delta--;
				// Sets Delta Back To Zero
				drawCount++;
				
			}
			
			if(timer >= 1000000000 ) {
				// For FPS Check
				System.out.println("FPS:" + drawCount);
				// Prints FPS Check
				drawCount = 0;
				// Resets Draw Count
				timer = 0;
				// Resets Timer
			}
		}
	}
	// GAME LOOP>
	
	public void update() {
		// Updates Info Such As Character
		player.update();
		// Updates player
	}
	
	public void paintComponent(Graphics g) {
		// Draws The Screen With The Updated
		
		super.paintComponent(g);
		// Changes The Frame?
		Graphics2D g2 = (Graphics2D)g;
		// Creates graphics for entity g2
		player.draw(g2);
		g2.dispose();
		// Collects Upon End
	}
}