package main;
// Of Package Main

import javax.swing.JFrame;
// Imports Main Screen

public class Main {
	// Main Script
	public static void main(String[] args) {
		// Starts Executable Code
		JFrame window = new JFrame();
		// Creates Instance Of JFrame
		
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Lets The Game Close When The X Is Hit
		window.setResizable(false);
		// Makes Resolution Finite
		window.setTitle("Arcanis");
		// Sets Window Tile
		
		GamePanel gamePanel = new GamePanel();
		// Creates Instance Of Game Panel
		window.add(gamePanel);
		// Adds Game Panel To Window
		
		window.pack();
		// Fits To Layout
		
		window.setLocationRelativeTo(null);
		// Sets Window In Middle
		window.setVisible(true);
		// Sets Window To Visible
		
		gamePanel.startGameThread();
		// Starts Game Thread
		
	}

}
