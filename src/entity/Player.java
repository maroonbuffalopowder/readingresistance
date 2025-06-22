package entity;

import java.awt.Color;
// Allows Colour Usage
import java.awt.Graphics2D;
// Allows Graphic Usage

import main.GamePanel;
// Imports Game Panel
import main.KeyHandler;
// Imports Key Handler

public class Player extends Entity{
	
	GamePanel gp;
	// Creates GamePanel Instance
	KeyHandler keyH;
	// Creates Key Handler Instance
	
	public Player(GamePanel gp, KeyHandler keyH) {
		// Constructor Class
		this.gp = gp;
		// Makes gp Accessible
		this.keyH = keyH;
		// Makes keyH Accessible
		setDefaultValues();
		// Sets Default Values
	}
	
	public void setDefaultValues() {
		// Sets Player Position
		x = 100;
		// Sets Player Position On X Coord
		y = 100;
		// Sets Player Position On Y Coord
		speed = 4;
		// Sets Player Speed
	}
	
	public void update() {
		// Updates Info
		if(keyH.upPressed == true){
			//If Up Pressed
			y -= speed;
			// Player Moves Up
		}else if(keyH.downPressed == true) {
			//If Down Pressed
			y += speed;
			// Player Moves Down
		}else if(keyH.leftPressed == true) {
			//If Left Pressed
			x -= speed;
			// Player Moves Right
		}else if(keyH.rightPressed == true) {
			//If Left Pressed
			x += speed;
			// Player Moves Left
		}
	}
	public void draw(Graphics2D g2) {
		// Shows The Players Position
		g2.setColor(Color.white);
		//Makes Colour White
		g2.fillRect(x,y,gp.tileSize,gp.tileSize);
		// Fills Section
	}
}
