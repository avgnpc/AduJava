package com.game.fight.utils;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import com.game.fight.hero.Hero;

public class KeyInput extends KeyAdapter {
    private Hero player;

    public KeyInput(Hero player) {
        this.player = player;
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            player.setMovingLeft(true);
        }
        if (key == KeyEvent.VK_RIGHT) {
            player.setMovingRight(true);
        }
        if (key == KeyEvent.VK_UP) {
            player.setJumping(true);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            player.setMovingLeft(false);
        }
        if (key == KeyEvent.VK_RIGHT) {
            player.setMovingRight(false);
        }
        if (key == KeyEvent.VK_UP) {
            player.setJumping(false);
        }
    }
}
