package com.doobs.java2d;

import com.doobs.java2d.gfx.Screen;
import com.doobs.java2d.input.InputHandler;

public class GameLoop {
	protected Game2D game;

	public GameLoop() {
		this(null);
	}
	public GameLoop(Game2D game) {
		this.game = game;
	}
	
	public void tick(InputHandler input) {
		
	}
	
	public void render(Screen screen) {
		
	}
	
	public void printFPS() {
		//System.out.println("FPS: " + game.getFPS());
	}
	
	// Getters and setters
	public void setGame(Game2D game) {
		this.game = game;
	}
}
