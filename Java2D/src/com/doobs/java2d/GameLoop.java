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
		int startX = game.getWidth() / 2;
		int startY = game.getHeight() / 2;
		int width = 50;
		int height = 50;

		for(int x = 0; x < width; x++) {
			for(int y = 0; y < height; y++) {
				if((x + y) % 2 == 0) 
					screen.drawPoint(0xFFFFFFFF, startX + x, startY + y);
			}
		}
	}
	
	public void printFPS() {
		System.out.println("FPS: " + game.getFPS());
	}
	
	// Getters and setters
	public void setGame(Game2D game) {
		this.game = game;
	}
}
