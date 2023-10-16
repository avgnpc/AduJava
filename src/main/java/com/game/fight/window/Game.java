package com.game.fight.window;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import com.game.fight.hero.Hero;
import com.game.fight.utils.EnemyKeyInput;
import com.game.fight.utils.KeyInput;
import com.game.fight.utils.Position;
import com.game.fight.utils.Velocity;

public class Game extends Canvas implements Runnable {

	private static final long serialVersionUID = 1L;
	
	private Thread thread;
	private boolean running = false;
	
	private static int screenWidth;
	private static int screenHeight;
	
	private Hero player;
	private Hero enemy;
	

	
    
    public Game() {
    	
    	new Window(800, 600, "Fight", this);
	    
	    player = new Hero(new Position(0, 20.0), new Velocity(0.0, 0.0), Color.blue);
	    enemy = new Hero(new Position(500, 20.0), new Velocity(0.0, 0.0), Color.red);
	    //mob = new Hero(new Position(0, 20.0), new Velocity(0.0, 0.0));
	    
	    KeyInput keyInput = new KeyInput(player); // Pass the player instance
	    this.addKeyListener(keyInput);
	    
	 // Create an instance of EnemyKeyInput for the enemy character
        EnemyKeyInput enemyKeyInput = new EnemyKeyInput(enemy);
        this.addKeyListener(enemyKeyInput);
    	

        // Set focus and request focus as before
        setFocusable(true);
        requestFocus();
    }
	
	public static void setScreenDimensions(int width, int height) {
        setScreenWidth(width);
        setScreenHeight(height);
    }
	
	public synchronized void start() {
		if (running)
			return;
		
		running = true;
		
		thread = new Thread(this);
		thread.start();
	}
	
	public void stop() {
		
	}

	public void run() {
		System.out.println("running");
		
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int updates = 0;
		int frames = 0;
		while(running){
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while(delta >= 1){
				tick();
				updates++;
				delta--;
			}
			render();
			frames++;
					
			if(System.currentTimeMillis() - timer > 1000){
				timer += 1000;
				System.out.println("FPS: " + frames + " TICKS: " + updates);
				frames = 0;
				updates = 0;
			}
		}
	}
	
	
	
	private void tick() {
		// TODO Auto-generated method stub
		
		
	    //mob.update(); // Call the update method of the Hero class to update its position
		
		player.update();
		enemy.update();
		
		
	}

	private void render() {
		
		BufferStrategy bs = this.getBufferStrategy();
		
		if (bs== null) {
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		
		///////////////////////////////////
		
		///// Draw Here /////////
		
		g.setColor(Color.black);
		g.fillRect(0, 0, getWidth(), getHeight());
		
		player.draw(g);
		enemy.draw(g);
		//mob.draw(g);
		
		///////////////////////////////////
		
		g.dispose();
		bs.show();
		
	}

	public static void main(String args[]) {
		//new Window(800, 600, "Fight", new Game());
		
		//Window win = new Window(8, 6 , "w", new Game());
		
		//player = new Sprite(0, 0);
		//enemy = new Sprite(400,100);
		
		Game game = new Game();
	    
	}

	public static int getScreenWidth() {
		return screenWidth;
	}

	public static void setScreenWidth(int screenWidth) {
		Game.screenWidth = screenWidth;
	}

	public static int getScreenHeight() {
		return screenHeight;
	}

	public static void setScreenHeight(int screenHeight) {
		Game.screenHeight = screenHeight;
	}

}
