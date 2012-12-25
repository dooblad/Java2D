package com.doobs.java2d.test;

import com.doobs.java2d.Game2D;
import com.doobs.java2d.GameLoop;
import com.doobs.java2d.gfx.Screen;
import com.doobs.java2d.input.InputHandler;

public class TestGame extends GameLoop{
	private static final int WIDTH = 320, HEIGHT = 240;
	private static final int SCALE = 2;
	private static final String TITLE = "TEST";
	private static final boolean VSYNC = false;
	
	private Game2D game;
	
	private Bitmaps bitmaps;
	
	public TestGame() {
		game = new Game2D(WIDTH, HEIGHT, SCALE, TITLE, this);
		bitmaps = new Bitmaps(game.getBitmapLoader());
		game.setVSync(VSYNC);
		game.start();
	}
	
	public void tick(InputHandler input) {
		
	}

	public void render(Screen screen) {
		screen.fill(0xFFFF0000);
		screen.draw(bitmaps.swirl, 200, 200);
	}
	
	public void printFPS() {
		System.out.println("FPS: " + game.getFps());
	}
	
	public static void main(String[] args) {
		new TestGame();
	}
}
