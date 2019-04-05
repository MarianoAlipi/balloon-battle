package dev.marianoalipi.balloonbattle.levels;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.lang.reflect.GenericArrayType;

import dev.marianoalipi.balloonbattle.Game;
import dev.marianoalipi.balloonbattle.entities.Player;

public class Platform {

	private int x, y, width, height;
	private Rectangle hitbox;
	private BufferedImage sprite;
	private Game game;
	private Player player;
	
	public Platform() {
		this.x = 0;
		this.y = 0;
		this.width = 0;
		this.height = 0;
		this.hitbox = new Rectangle(x, y, width, height);
		this.sprite = null;
		this.game = null;
		this.player = null;
	}
	
	public Platform(int x, int y, int width, int height, Game game) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.hitbox = new Rectangle(x, y, width, height);
		this.sprite = null;
		this.game = game;
		this.player = game.getPlayer();
	}
	
	public void tick() {
		
		/*
		if (getHitbox().intersects(player.getHitbox())) {
			player.setY(getY() - player.getHeight());
			player.setGrounded(true);
		}
		*/
		
	}
	
	public void render(Graphics g) {
		//g.drawImage(getSprite(), getX(), getY(), getWidth(), getHeight(), null);

		// Placeholder renderer
		g.setColor(Color.green);
		g.fillRect(getX(), getY(), getWidth(), getHeight());
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public Rectangle getHitbox() {
		return hitbox;
	}
	
	public BufferedImage getSprite() {
		return sprite;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public void setWidth(int width) {
		this.width = width;
	}
	
	public void setHeight(int height) {
		this.height = height;
	}
	
	public void setHitbox(Rectangle hitbox) {
		this.hitbox = hitbox;
	}
	
	public void setSprite(BufferedImage sprite) {
		this.sprite = sprite;
	}
}