package com.doobs.java2d.gfx;

public class Bitmap {
	private int width, height;
	public int[] pixels;

	public Bitmap(int width, int height) {
		this.width = width;
		this.height = height;
		pixels = new int[width * height];
	}

	public void draw(Bitmap bitmap, int xo, int yo) {
		for (int y = 0; y < bitmap.height; y++) {
			int yy = y + yo;
			if (yy < 0 || yy >= height)
				continue;
			for (int x = 0; x < bitmap.width; x++) {
				int xx = x + xo;
				if (xx < 0 || xx >= width)
					continue;
				int color = bitmap.pixels[x + y * bitmap.width];
				if (color < 0)
					pixels[xx + yy * width] = color;
			}
		}
	}

	public void drawReverse(Bitmap bitmap, int xo, int yo) {
		for (int y = 0; y < bitmap.height; y++) {
			int yy = y + yo;
			if (yy < 0 || yy >= height)
				continue;
			for (int x = 0; x < bitmap.width; x++) {
				int xx = bitmap.width - x + xo;
				if (xx < 0 || xx >= width)
					continue;
				int color = bitmap.pixels[x + y * bitmap.width];
				if (color < 0)
					pixels[xx + yy * width] = color;
			}
		}
	}
	
	public void drawColored(Bitmap bitmap, int color, int xo, int yo) {
		for (int y = 0; y < bitmap.height; y++) {
			int yy = y + yo;
			if (yy < 0 || yy >= height)
				continue;
			for (int x = 0; x < bitmap.width; x++) {
				int xx = x + xo;
				if (xx < 0 || xx >= width)
					continue;
				if (bitmap.pixels[x + y * bitmap.width] < 0)
					pixels[xx + yy * width] = color;
			}
		}
	}

	public void drawPoint(int color, int xo, int yo) {
		if (xo < 0 || xo >= width || yo < 0 || yo >= height)
			return;
		pixels[xo + yo * width] = color;
	}

	public void fill(int color) {
		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = color;
		}
	}
	
	public void fillRect(int color, int xo, int yo, int w, int h) {
		for(int x = 0; x < w; x++) {
			int xx = x + xo;
			if(xx < 0 || xx >= width)
				continue;
			for(int y = 0; y < h; y++) {
				int yy = y + yo;
				if(yy < 0 || yy >= height)
					continue;
				pixels[xx + yy * width] = color;
			}
		}
	}

	// Getters and setters
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
}
