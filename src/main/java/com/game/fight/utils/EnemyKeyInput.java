package com.game.fight.utils;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import com.game.fight.hero.Hero;

public class EnemyKeyInput extends KeyAdapter {
    private Hero enemy;

    public EnemyKeyInput(Hero enemy) {
        this.enemy = enemy;
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_A) {
            enemy.setMovingLeft(true);
        }
        if (key == KeyEvent.VK_D) {
            enemy.setMovingRight(true);
        }
        if (key == KeyEvent.VK_W) {
            enemy.setJumping(true);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_A) {
            enemy.setMovingLeft(false);
        }
        if (key == KeyEvent.VK_D) {
            enemy.setMovingRight(false);
        }
        if (key == KeyEvent.VK_W) {
            enemy.setJumping(false);
        }
    }
}
