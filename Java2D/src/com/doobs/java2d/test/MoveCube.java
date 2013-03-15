package com.doobs.java2d.test;

import com.doobs.java2d.gfx.Screen;
import com.doobs.java2d.input.InputHandler;

public class MoveCube {
	private float x, y;
	
	public MoveCube() {
		this(0, 0);
	}
	public MoveCube(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	public void tick(InputHandler input) {
		// Divide by scale of game
		x = input.getMouseX() / 4 - Bitmaps.cube.getWidth() / 2;
		y = input.getMouseY() / 4 - Bitmaps.cube.getHeight() / 2;
	}
	
	public void render(Screen screen) {
		screen.draw(Bitmaps.cube, (int) x, (int) y);
	}
}
