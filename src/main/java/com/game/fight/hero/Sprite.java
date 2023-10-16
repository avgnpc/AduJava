package com.game.fight.hero;

import java.awt.Color;
import java.awt.Graphics;

public class Sprite {
	
	protected int x;
	protected int y;
	
	public Sprite(int x, int y) {
		
		this.x = x;
		this.y = y;
	}
	
	public void draw(Graphics g) {

		g.setColor(Color.red);
		g.fillRect(x, y, 50, 150);

/*
		// draw score
		int sx; // x position of the string
		int padding = 25; // space between dotted line and score
		String scoreText = Integer.toString(score);
		Font font = new Font("Roboto", Font.PLAIN, 50);

		if (left) {
			int strWidth = g.getFontMetrics(font).stringWidth(scoreText); // we need the width of the string so we can
																			// center it properly (for perfectionists)
			sx = Game.WIDTH / 2 - padding - strWidth;
		} else {
			sx = Game.WIDTH / 2 + padding;
		}

		g.setFont(font);
		g.drawString(scoreText, sx, 50);
*/
	}

	
	//public abstract void tick(LinkedList<Sprite> object);
	//public abstract void render(Graphics g);
}