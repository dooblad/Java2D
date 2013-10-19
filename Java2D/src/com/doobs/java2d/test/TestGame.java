package com.doobs.java2d.test;

import com.doobs.java2d.Game2D;
import com.doobs.java2d.GameLoop;
import com.doobs.java2d.gfx.Screen;
import com.doobs.java2d.input.InputHandler;

public class TestGame extends GameLoop{
	public static final int SCALE = 2;
	
	private static final int WIDTH = 360, HEIGHT = 240;
	private static final String TITLE = "Test Game";
	private static final boolean RENDER_FPS = true;
	private static final boolean VSYNC = false;
	
	private MoveCube cube;
	
	public TestGame() {
		game = new Game2D(WIDTH, HEIGHT, SCALE, TITLE, this);
		Bitmaps.init(game.getBitmapLoader());
		cube = new MoveCube();
		game.setRenderFPS(RENDER_FPS);
		game.setVSync(VSYNC);
		game.start();
	}
	
	public void tick(InputHandler input, boolean paused) {
		cube.tick(input);
	}
	
	public void render(Screen screen, boolean paused) {
		screen.fill(0xFF00FF00);
		cube.render(screen);
	}
	
	public static void main(String[] args) {
		new TestGame();
	}
}
