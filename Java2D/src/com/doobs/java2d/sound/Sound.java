package com.doobs.java2d.sound;

import java.io.IOException;

import org.newdawn.easyogg.OggClip;

/**
 * This class only supports the OGG format due to its 
 * usefulness in games for its small file size
 */
public class Sound {
	private OggClip clip;

	public Sound(String URL) {
		try {
			clip = new OggClip(URL);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void play() {
		clip.play();
	}
	
	public void loop() {
		clip.loop();
	}
	
	public void resume() {
		clip.resume();
	}
	
	public void stop() {
		clip.stop();
	}
}