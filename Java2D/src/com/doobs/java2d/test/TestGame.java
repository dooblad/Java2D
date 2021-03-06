package com.doobs.java2d.test;

import java.awt.event.KeyEvent;

import com.doobs.java2d.Game2D;
import com.doobs.java2d.GameLoop;
import com.doobs.java2d.gfx.Screen;
import com.doobs.java2d.input.InputHandler;

public class TestGame extends GameLoop{
	public static final int DEFAULT_SCALE = 2;
	
	private static final int WIDTH = 360, HEIGHT = 240;
	private static final String TITLE = "Test Game";
	private static final boolean RENDER_FPS = true;
	private static final boolean VSYNC = false;
	
	private MoveCube cube;
	private boolean test;
	
	
	public TestGame() {
		game = new Game2D(WIDTH, HEIGHT, DEFAULT_SCALE, TITLE, this);
		Bitmaps.init(game.getBitmapLoader());
		cube = new MoveCube(game);
		game.setRenderFPS(RENDER_FPS);
		game.setVSync(VSYNC);
		game.start();
		test = false;
	}
	
	public void tick(InputHandler input) {
		cube.tick(input);
		if(input.isKeyPressed(KeyEvent.VK_G)) {
			test = !test;
			game.setScreenSize(test ? 320 : 400, test ? 240 : 300);
		}
			
	}
	
	public void render(Screen screen) {
		screen.fill(0xFF00FF00);
		screen.drawFlipped(Bitmaps.cube, 0, 0, (byte) 0x00);
		cube.render(screen);
	}
	
	public static void main(String[] args) {
		new TestGame();
	}
}
