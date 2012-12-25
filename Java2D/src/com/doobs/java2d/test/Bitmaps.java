package com.doobs.java2d.test;

import com.doobs.java2d.gfx.Bitmap;
import com.doobs.java2d.gfx.BitmapLoader;

public class Bitmaps {
	private BitmapLoader loader;
	
	public static Bitmap swirl;
	
	public Bitmaps() {
		
	}
	public Bitmaps(BitmapLoader bitmapLoader) {
		this.loader = bitmapLoader;
		init();
	}
	
	public void init() {
		swirl = loader.loadBitmap("res/swirl.png");
	}
	
	public void setBitmapLoader(BitmapLoader bitmapLoader) {
		this.loader = bitmapLoader;
	}
}
