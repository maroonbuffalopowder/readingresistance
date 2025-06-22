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

public class GamePanel extends JPanel implements Runnable{
	// Extends JPanel

	// <SCREEN SETINGS START
	final int originalTileSize = 16; //16x16 tile
	final int scale=3; // Scale Of Pixels
	
	final int tileSize = originalTileSize * scale;// 48x48 tile(MAX)
	final int maxScreenCol = 16;
	final int maxScreenRow = 12;
	final int screenWidth = tileSize * maxScreenCol; //786 pixels
	final int screenHeight = tileSize * maxScreenRow; //576 pixels
	// SCREEN SETINGS END>
	
	KeyHandler keyH = new KeyHandler();
	// Introduces Key Handler
	Thread gameThread;
	// Creates Game Thread
	
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
		// Runs Code
		while(gameThread != null) {
			// While Game Thread Exist
			System.out.println("The Game Loop Is Running");
			// Gives Check
			
			update();
			// 1
			repaint();
			// 2
		}
	}
	// GAME LOOP>
	
	public void update() {
		// Updates Info Such As Character
		
		if(keyH.upPressed == true){
			//If Up Pressed
			playerY -= playerSpeed;
			// Player Moves Up
		}
	}
	
	public void paintComponent(Graphics g) {
		// Draws The Screen With The Updated
		
		super.paintComponent(g);
		// Changes The Frame?
		
		Graphics2D g2 = (Graphics2D)g;
		// Creates graphics for entity g2
		g2.setColor(Color.white);
		//Makes Colour White
		g2.fillRect(playerX,playerY,tileSize,tileSize);
		// Fills Section
		g2.dispose();
		// Collects Upon End
	}
}