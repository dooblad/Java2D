package com.doobs.java2d.input;

import java.awt.Component;
import java.awt.event.*;

public class InputHandler implements KeyListener, MouseListener, MouseMotionListener {
	private boolean[] keys = new boolean[128];
	private int oldMouseX, oldMouseY;
	private int mouseX, mouseY;
	private boolean mousePressed = false;
	
	public InputHandler(Component component) {
		component.addKeyListener(this);
		component.addMouseListener(this);
		component.addMouseMotionListener(this);
		oldMouseX = 0;
		oldMouseY = 0;
		mouseX = 0;
		mouseY = 0;
	}
	
	// KeyListener Events
	public void keyPressed(KeyEvent e) {
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
		oldMouseX = mouseX;
		oldMouseY = mouseY;
		mouseX = e.getX();
		mouseY = e.getY();
		mousePressed = true;
	}
	
	public void mouseReleased(MouseEvent e) {
		mousePressed = false;
	}
	
	public void mouseDragged(MouseEvent e) {
		
	}

	// MouseMotionListener Events
	public void mouseMoved(MouseEvent e) {
		mouseX = e.getX();
		mouseY = e.getY();
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

	public boolean isMousePressed() {
		return mousePressed;
	}
}
