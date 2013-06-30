package com.doobs.java2d.test;

import java.awt.event.KeyEvent;

import com.doobs.java2d.Game2D;
import com.doobs.java2d.GameLoop;
import com.doobs.java2d.gfx.Screen;
import com.doobs.java2d.input.InputHandler;

public class TestGame extends GameLoop{
	private static final int WIDTH = 160, HEIGHT = 120;
	private static final int SCALE = 4;
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
	
	public void tick(InputHandler input) {
		if(input.keys[KeyEvent.VK_SPACE])
			game.pause();
		cube.tick(input);
	}
	
	public void tickPaused(InputHandler input) {
		if(input.keys[KeyEvent.VK_ENTER])
			game.unpause();
	}

	public void render(Screen screen) {
		screen.fill(0xFF00FF00);
		screen.fillRect(0xFFFFFFFF, 100, 5, 20, 20);
		screen.drawColoredExceptFor(Bitmaps.cube, 0xFFFF0000, 0, 0, 0xFFFFBF00, 0xFF2B9CFF);
		cube.render(screen);
	}
	
	public void renderPaused(Screen screen) {
		screen.fill(0xFFFF0000);
		cube.render(screen);
	}
	
	public static void main(String[] args) {
		new TestGame();
	}
}
