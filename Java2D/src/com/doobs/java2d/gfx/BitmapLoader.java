package com.doobs.java2d.gfx;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class BitmapLoader {
	private int[] ignoredColors;
	
	public BitmapLoader() {
		
	}
	public BitmapLoader(int... ignoredColors) {
		this.ignoredColors = ignoredColors;
	}
	
	public Bitmap loadBitmap(String URL) {
		try {
			return loadBitmap(ImageIO.read(new File(URL)));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		return null;
	}
	
	public Bitmap loadBitmap(BufferedImage image) {
		int width = image.getWidth();
		int height = image.getHeight();
		Bitmap result = new Bitmap(width, height);
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				int col = image.getRGB(x, y);
				if(ignoredColors != null) {
					boolean writePixel = true;
					for(int i = 0; i < ignoredColors.length; i++) {
						if((col & 0xFFFFFF) == ignoredColors[i]) {
							writePixel = false;
						}
					}
					if(writePixel)
						result.pixels[x + y * width] = image.getRGB(x, y);
				} else {
					result.pixels[x + y * width] = image.getRGB(x, y);
				}
			}
		}
		return result;
	}
	
	public Bitmap[] load1DTileSheet(String URL, int tilesX) {
		try {
			return load1DTileSheet(ImageIO.read(new File(URL)), tilesX);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public Bitmap[] load1DTileSheet(BufferedImage image, int tilesX) {
		int width = image.getWidth();
		int tileWidth = width / tilesX;
		Bitmap[] result = new Bitmap[tilesX];

		for (int x = 0; x < tilesX; x++) {
				result[x] = new Bitmap(tileWidth, image.getHeight());
				for (int yy = 0; yy < image.getHeight(); yy++) {
					for (int xx = 0; xx < tileWidth; xx++) {
						int xxx = xx + x * tileWidth;
						
						int col = image.getRGB(xxx, yy);
						if(ignoredColors != null) {
							boolean writePixel = true;
							for(int i = 0; i < ignoredColors.length; i++) {
								if((col & 0xFFFFFF) == ignoredColors[i]) {
									writePixel = false;
								}
							}
							if(writePixel)
								result[x].pixels[xx + yy * tileWidth] = image.getRGB(xxx, yy);
						} else {
							result[x].pixels[xx + yy * tileWidth] = image.getRGB(xxx, yy);
						}
					}
				}
			}
		return result;
	}
	
	public Bitmap[][] load2DTileSheet(String URL, int tilesX, int tilesY) {
		try {
			return load2DTileSheet(ImageIO.read(new File(URL)), tilesX, tilesY);
		} catch(IOException e) {
			e.printStackTrace();
		} 
		
		return null;
	}
	
	public Bitmap[][] load2DTileSheet(BufferedImage image, int tilesX, int tilesY) {
		int width = image.getWidth();
		int height = image.getHeight();
		int tileWidth = width / tilesX;
		int tileHeight = height / tilesY;
		Bitmap[][] result = new Bitmap[tilesX][tilesY];

		for (int x = 0; x < tilesX; x++) {
			for (int y = 0; y < tilesY; y++) {
				result[x][y] = new Bitmap(tileWidth, tileHeight);
				for (int yy = 0; yy < tileHeight; yy++) {
					for (int xx = 0; xx < tileWidth; xx++) {
						int xxx = xx + x * tileWidth;
						int yyy = yy + y * tileHeight;
						
						int col = image.getRGB(xxx, yyy);
						if(ignoredColors != null) {
							boolean writePixel = true;
							for(int i = 0; i < ignoredColors.length; i++) {
								if((col & 0xFFFFFF) == ignoredColors[i]) {
									writePixel = false;
								}
							}
							if(writePixel)
								result[x][y].pixels[xx + yy * tileWidth] = image.getRGB(xxx, yyy);
						} else {
							result[x][y].pixels[xx + yy * tileWidth] = image.getRGB(xxx, yyy);
						}
					}
				}
			}
		}
		return result;
	}
	
	public int[] getIgnoredColors() {
		return ignoredColors;
	}
	public void setIgnoredColors(int... ignoredColors) {
		this.ignoredColors = ignoredColors;
	}
}
