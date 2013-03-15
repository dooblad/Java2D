package com.doobs.java2d.test;

import com.doobs.java2d.gfx.Bitmap;
import com.doobs.java2d.gfx.BitmapLoader;

public class Bitmaps {
	private static BitmapLoader loader;
	
	public static Bitmap cube;
	
	public static void init(BitmapLoader bitmapLoader) {
		loader = bitmapLoader;
		init();
	}
	
	public static void init() {
		cube = loader.loadBitmap("res/cube.png");
	}
	
	public static void setBitmapLoader(BitmapLoader bitmapLoader) {
		loader = bitmapLoader;
	}
}
