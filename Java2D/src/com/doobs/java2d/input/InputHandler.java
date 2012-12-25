package com.doobs.java2d.input;

import java.awt.Component;
import java.awt.event.*;

public class InputHandler implements KeyListener, MouseListener, MouseMotionListener {
	public boolean[] keys = new boolean[128];
	public int oldMouseX, oldMouseY;
	public int mouseX, mouseY;
	public boolean mousePressed = false;
	
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
	public void keyTyped(KeyEvent e) {
		
	}
	public void keyReleased(KeyEvent e) {
		
	}
	public void keyPressed(KeyEvent e) {
		
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



	

	


}
