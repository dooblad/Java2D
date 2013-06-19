package com.doobs.java2d.input;

import java.awt.event.*;

import com.doobs.java2d.Game2D;

public class InputHandler implements KeyListener, MouseListener, MouseMotionListener {
	public boolean[] keys = new boolean[128];
	private int oldMouseX, oldMouseY;
	private int mouseX, mouseY;
	private boolean leftMousePressed, middleMousePressed, rightMousePressed;
	
	private Game2D game;
	
	public InputHandler(Game2D game) {
		this.game = game;
		game.addKeyListener(this);
		game.addMouseListener(this);
		game.addMouseMotionListener(this);
		oldMouseX = 0;
		oldMouseY = 0;
		mouseX = 0;
		mouseY = 0;
		leftMousePressed = false;
		middleMousePressed = false;
		rightMousePressed = false;
	}
	
	// KeyListener Events
	public void keyPressed(KeyEvent e) {
		if(!game.getInputStopped())
			keys[e.getKeyCode()] = true;
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
				leftMousePressed = true;
			else if(button == MouseEvent.BUTTON2)
				middleMousePressed = true;
			else if(button == MouseEvent.BUTTON3)
				rightMousePressed = true;
		}
	}
	
	public void mouseReleased(MouseEvent e) {
		int button = e.getButton();
		if(button == MouseEvent.BUTTON1)
			leftMousePressed = false;
		else if(button == MouseEvent.BUTTON2)
			middleMousePressed = false;
		else if(button == MouseEvent.BUTTON3)
			rightMousePressed = false;
	}
	
	public void mouseDragged(MouseEvent e) {
		
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
		return leftMousePressed;
	}
	
	public boolean isMiddleMousePressed() {
		return middleMousePressed;
	}
	
	public boolean isRightMousePressed() {
		return rightMousePressed;
	}
}
