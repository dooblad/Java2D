package com.doobs.java2d.test;

import com.doobs.java2d.Game2D;
import com.doobs.java2d.gfx.Screen;
import com.doobs.java2d.input.InputHandler;

public class MoveCube {
	private Game2D game;
	private float x, y;
	
	public MoveCube() {
		this(0, 0, null);
	}
	
	public MoveCube(float x, float y) {
		this(x, y, null);
	}
	
	public MoveCube(Game2D game) {
		this(0, 0, game);
	}
	
	public MoveCube(float x, float y, Game2D game) {
		this.x = x;
		this.y = y;
		this.game = game;
	}
	
	public void tick(InputHandler input) {
		// Divide by scale of game
		x = input.getMouseX() / game.getScale()  - Bitmaps.cube.getWidth() / 2;
		y = input.getMouseY() / game.getScale() - Bitmaps.cube.getHeight() / 2;
	}
	
	public void render(Screen screen) {
		screen.drawCW(Bitmaps.cube, (int) x - Bitmaps.cube.getHeight() - 4, (int) y);
		screen.draw(Bitmaps.cube, (int) x, (int) y);
		screen.drawCCW(Bitmaps.cube, (int) x + Bitmaps.cube.getWidth() + 4, (int) y);
	}
}
