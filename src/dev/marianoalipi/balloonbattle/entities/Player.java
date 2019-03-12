package dev.marianoalipi.balloonbattle.entities;

import java.awt.Graphics;

import dev.marianoalipi.balloonbattle.Game;
import dev.marianoalipi.balloonbattle.InputHandler;

public class Player extends Entity {

	private InputHandler inputHandler;
	private boolean flapKeyReleased;
	
	public Player() {
		super();
	}

	public Player(int x, int y, int width, int height, Game game, InputHandler inputHandler) {
		super(x, y, width, height, game);
		this.inputHandler = inputHandler;
		this.flapKeyReleased = true;
	}

	@Override
	public void tick() {
		
		// Gravity pull
		setySpeed(getySpeed() - GRAVITY);
		
		if (inputHandler.up.down) {
			setySpeed(4);
		}
		
		// Check for a single flap (Z key = A button)
		if (inputHandler.z.down && isFlapKeyReleased()) {
			setySpeed(4);
			setFlapKeyReleased(false);
		}
		
		if (!inputHandler.z.down) {
			setFlapKeyReleased(true);
		}
		
		// Check for constant flapping (X key = B button)
		if (inputHandler.x.down) {
			setySpeed(4);
		}
		
		if (inputHandler.down.down) {
			//setySpeed(getySpeed() - 3);
		}
		
		if (inputHandler.left.down) {
			setxSpeed(-3);
		}
		
		if (inputHandler.right.down) {
			setxSpeed(3);
		}
		
		if (!inputHandler.left.down && !inputHandler.right.down) {
			setxSpeed(0);
		}
		
		// Move the player
		setX(getX() + getxSpeed());
		setY(getY() - getySpeed());
		
		// Go to the other side if the limit is crossed
		if (getX() <= -1 * getWidth() / 2) {
			setX(game.getWidth() - getWidth() / 2 - 1);
		} else if (getX() >= game.getWidth() - getWidth() / 2) {
			setX(-1 * getWidth() / 2 + 1);
		}
		
		// Prevent the player from going above or below the screen
		if (getY() < -1 * getHeight() / 2) {
			setY(-1 * getHeight() / 2);
		} else if (getY() > game.getHeight() - getHeight()) {
			setY(game.getHeight() - getHeight());
		}
	}
	
	@Override
	public void render(Graphics g) {
		if (isVisible())
			g.drawImage(getSprite(), getX(), getY(), getWidth(), getHeight(), null);
	}

	/**
	 * @return the flapKeyReleased
	 */
	public boolean isFlapKeyReleased() {
		return flapKeyReleased;
	}

	/**
	 * @param flapKeyReleased the flapKeyReleased to set
	 */
	public void setFlapKeyReleased(boolean flapKeyReleased) {
		this.flapKeyReleased = flapKeyReleased;
	}
	
}