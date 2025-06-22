package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
// Imports Key Receivers

public class KeyHandler implements KeyListener{
	
	public boolean upPressed, downPressed, leftPressed, rightPressed;
	// Boolean Values For WASD
	
	// Unused
	@Override
	public void keyTyped(KeyEvent e) {
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		// When Key Is Pressed
		
		int code = e.getKeyCode();
		// Gets Key Press
		
		if(code == KeyEvent.VK_W) {
			//If User Pressed W Key
			
			upPressed=true;
			// Sets Pressed Value To True
		
		}if(code == KeyEvent.VK_A) {
			//If User Pressed A Key
			
			leftPressed=true;
			// Sets Pressed Value To True
			
		}if(code == KeyEvent.VK_S) {
			//If User Pressed S Key
			
			downPressed=true;
			// Sets Pressed Value To True
			
		}if(code == KeyEvent.VK_D) {
			//If User Pressed D Key
			
			rightPressed=true;
			// Sets Pressed Value To True
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// When Key Is Released
		
		int code = e.getKeyCode();
		// Gets Key Released
		
		if(code == KeyEvent.VK_W) {
			//If User Released W Key
			
			upPressed=false;
			// Sets Released Value To False
		
		}if(code == KeyEvent.VK_A) {
			//If User Released A Key
			
			leftPressed=false;
			// Sets Released Value To False
			
		}if(code == KeyEvent.VK_S) {
			//If User Released S Key
			
			downPressed=false;
			// Sets Released Value To False
			
		}if(code == KeyEvent.VK_D) {
			//If User Released D Key
			
			rightPressed=false;
			// Sets Released Value To False
		}
	}
}
