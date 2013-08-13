package com.doobs.java2d.input;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import com.doobs.java2d.Game2D;

public class WindowHandler implements WindowListener {
	private Game2D game;
	
	private boolean closeRequested;
	
	public WindowHandler() {
		this(null);
	}
	
	public WindowHandler(Game2D game) {
		this.game = game;
		game.getFrame().addWindowListener(this);
		closeRequested = false;
	}
	
	@Override
	public void windowActivated(WindowEvent e) {
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		closeRequested = true;
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		
	}
	
	// Getters and Setters
	public Game2D getGame() {
		return game;
	}
	
	public void setGame(Game2D game) {
		this.game = game;
	}
	
	public boolean getCloseRequested() {
		return closeRequested;
	}
}
