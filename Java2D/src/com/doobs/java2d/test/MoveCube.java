package com.doobs.java2d.test;

import java.awt.event.KeyEvent;

import com.doobs.java2d.gfx.Screen;
import com.doobs.java2d.input.InputHandler;

public class MoveCube {
	private float x, y;
	private float xa, ya;
	
	public MoveCube() {
		this(0, 0);
	}
	public MoveCube(float x, float y) {
		this.x = x;
		this.y = y;
		this.xa = 0;
		this.ya = 0;
	}
	
	public void tick(InputHandler input) {
		if(input.keys[KeyEvent.VK_W]) {
			ya -= 0.75;
		} else if(input.keys[KeyEvent.VK_S]) {
			ya += 0.75;
		}
		
		if(input.keys[KeyEvent.VK_A]) {
			xa -= 0.75;
		} else if(input.keys[KeyEvent.VK_D]) {
			xa += 0.75;
		}
		
		x += xa;
		y += ya;
		
		xa *= 0.8f;
		ya *= 0.8f;
	}
	public void render(Screen screen) {
		screen.draw(Bitmaps.cube, (int) x, (int) y);
	}
}
