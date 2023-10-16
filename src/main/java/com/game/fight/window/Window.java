package com.game.fight.window;

import java.awt.Dimension;

import javax.swing.JFrame;

public class Window {

	public Window(int w, int h, String title, Game game) {
		
		game.setPreferredSize(new Dimension(w, h));
		game.setMaximumSize(new Dimension(w, h));
		game.setMinimumSize(new Dimension(w, h));
		
		JFrame frame = new JFrame();
		frame.add(game);
		frame.pack();
		frame.setTitle(title);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(w, h);
		frame.setLocationRelativeTo(null);
	    //frame.setUndecorated(true);
		frame.setResizable(false);
		frame.setVisible(true);
		
		// Access the screen width and height
        Game.setScreenDimensions(w, h);

		
		game.start();
		
		
	}
}
