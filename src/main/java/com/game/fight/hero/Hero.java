package com.game.fight.hero;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

import com.game.fight.utils.Position;
import com.game.fight.utils.Velocity;
import com.game.fight.window.Game;

public class Hero {
    private double posX;
    private double posY;
    private double velX;
    private double velY;
    private final int GRAVITY = 2;
    private final int HEROWIDTH = 50;
    private final int HEROHEIGHT = 150;
    private boolean isMovingLeft = false;
    private boolean isMovingRight = false;
    private int lastKey = 0;
    private boolean isJumping = false;
    private int jumpHeight = 35; // Adjust this value as needed for the jump height
    private Color color;
    
   
    public Hero(Position position, Velocity velocity, Color color) {
        this.posX = position.getX();
        this.posY = position.getY();
        this.velX = velocity.getX();
        this.velY = velocity.getY();
        this.color = color;
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect((int) posX, (int) posY, HEROWIDTH, HEROHEIGHT);
        
    }

    public void update() {
        // Update the velocity to simulate gravity
        velY += GRAVITY;

        // Update the position based on the velocity
        posX += velX;
        posY += velY;
        
     // Handle jump
        if (isJumping  && posY >= Game.getScreenHeight() - HEROHEIGHT) {
            // Apply gravity while jumping
            velY = -jumpHeight;
        }

        // Handle left movement
        if (isMovingLeft && lastKey == KeyEvent.VK_LEFT) {
            velX = -5; // You can adjust the speed as needed
        }
        // Handle right movement
        else if (isMovingRight && lastKey == KeyEvent.VK_RIGHT) {
            velX = 5; // You can adjust the speed as needed
        }
        // If neither left nor right movement is active, stop moving horizontally
        else {
            velX = 0;
        }

        // Ensure the hero stays within the screen boundaries
        if (posX < 0) {
            posX = 0;
        } else if (posX + HEROWIDTH > Game.getScreenWidth()) {
            posX = Game.getScreenWidth() - HEROWIDTH;
        }

        if (posY < 0) {
            posY = 0;
        } else if (posY + HEROHEIGHT > Game.getScreenHeight()) {
            posY = Game.getScreenHeight() - HEROHEIGHT;
        }
    }

    public void setMovingLeft(boolean movingLeft) {
        isMovingLeft = movingLeft;
        if (movingLeft) {
            lastKey = KeyEvent.VK_LEFT;
        }
    }

    public void setMovingRight(boolean movingRight) {
        isMovingRight = movingRight;
        if (movingRight) {
            lastKey = KeyEvent.VK_RIGHT;
        }
    }
    
    public void setJumping(boolean jumping) {
        isJumping = jumping;
    }
    
    

}
