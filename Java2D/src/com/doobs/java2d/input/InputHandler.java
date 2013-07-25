package com.doobs.java2d.input;

import java.awt.event.*;

import com.doobs.java2d.Game2D;

public class InputHandler implements KeyListener, MouseListener, MouseMotionListener {
	public boolean[] keys, previousKeys;
	public boolean[] mouseButtons;
	private int oldMouseX, oldMouseY;
	private int mouseX, mouseY;
	
	private Game2D game;
	
	public InputHandler(Game2D game) {
		this.game = game;
		game.addKeyListener(this);
		game.addMouseListener(this);
		game.addMouseMotionListener(this);
		keys = new boolean[512];
		previousKeys = new boolean[512];
		mouseButtons = new boolean[3];
		oldMouseX = 0;
		oldMouseY = 0;
		mouseX = 0;
		mouseY = 0;
	}
	
	public void tick() {
		for(int i = 0; i < keys.length; i++) {
			previousKeys[i] = keys[i];
		}
	}
	
	// KeyListener Events
	public void keyPressed(KeyEvent e) {
		
		if(!game.getInputStopped()) {
			keys[e.getKeyCode()] = true;
		}
	}
	
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
	}
	
	public void keyTyped(KeyEvent e) {
		
	}

	
	// MouseListener Events
	public void mouseClicked(MouseEvent e) {
		
	}
	
	public void mousePressed(MouseEvent e) {
		if(!game.getInputStopped()) {
			oldMouseX = mouseX;
			oldMouseY = mouseY;
			mouseX = e.getX();
			mouseY = e.getY();
			int button = e.getButton();
			if(button == MouseEvent.BUTTON1)
				mouseButtons[0] = true;
			else if(button == MouseEvent.BUTTON2)
				mouseButtons[1] = true;
			else if(button == MouseEvent.BUTTON3)
				mouseButtons[2] = true;
		}
	}
	
	public void mouseReleased(MouseEvent e) {
		int button = e.getButton();
		if(button == MouseEvent.BUTTON1)
			mouseButtons[0] = false;
		else if(button == MouseEvent.BUTTON2)
			mouseButtons[1] = false;
		else if(button == MouseEvent.BUTTON3)
			mouseButtons[2] = false;
	}
	
	public void mouseDragged(MouseEvent e) {
		if(!game.getInputStopped()) {
			mouseX = e.getX();
			mouseY = e.getY();
		}
	}

	// MouseMotionListener Events
	public void mouseMoved(MouseEvent e) {
		if(!game.getInputStopped()) {
			mouseX = e.getX();
			mouseY = e.getY();
		}
	}
	
	public void mouseEntered(MouseEvent e) {
		
	}
	
	public void mouseExited(MouseEvent e) {
		
	}
	
	// Utility
	public boolean isKeyPressed(int keycode) {
		return keys[keycode] && !previousKeys[keycode];
	}
	
	// Getters and setters
	public boolean[] getKeys() {
		return keys;
	}

	public int getOldMouseX() {
		return oldMouseX;
	}

	public int getOldMouseY() {
		return oldMouseY;
	}

	public int getMouseX() {
		return mouseX;
	}

	public int getMouseY() {
		return mouseY;
	}

	public boolean isLeftMousePressed() {
		return mouseButtons[0];
	}
	
	public boolean isMiddleMousePressed() {
		return mouseButtons[1];
	}
	
	public boolean isRightMousePressed() {
		return mouseButtons[2];
	}
}
