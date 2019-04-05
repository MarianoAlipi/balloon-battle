package dev.marianoalipi.balloonbattle.levels;

import java.awt.Graphics;
import java.util.ArrayList;

public class Level {

	private byte id;
	private ArrayList<Platform> platforms;
	
	public Level() {
		this.id = -1;
		this.platforms = new ArrayList<Platform>();
	}
	
	public Level(byte id) {
		this.id = id;
		this.platforms = new ArrayList<Platform>();
	}
	
	public void tick() {
		for (Platform platform : platforms)
			platform.tick();
	}
	
	public void render(Graphics g) {
		for (Platform platform : platforms) {
			platform.render(g);
		}
	}
	
	public byte getId() {
		return id;
	}
	
	public ArrayList<Platform> getPlatforms() {
		return platforms;
	}
	
	public void setId(byte id) {
		this.id = id;
	}
}