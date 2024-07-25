/*
* File: Bullet.java
* Created by: James Brummett
* Created on: 2024-07-25
* Updated on: 2024-07-25
*
* Purpose: This file is the Bullet class for the Pacifier game.
*/
package com.pacifier.game.entity;

// imports

import com.pacifier.game.Game;
import com.pacifier.game.graphics.Trail;
import com.pacifier.game.util.GameObject;
import com.pacifier.game.util.Handler;
import com.pacifier.game.util.ID;

import java.awt.*;
import java.util.Random;

// BasicEnemy class
public class Bullet extends GameObject {

    private Handler handler;
    private Random r = new Random();

    // constructor
    public Bullet(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;
        velX = r.nextInt(5 + 5) -5;
        velY = 5;
    } // end Bullet

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x, y, 16, 16);
    } // end getBounds

    @Override
    public void tick() {
        x += velX;
        y += velY;
        if (y >= Game.HEIGHT) handler.removeObject(this);
        handler.addObject(new Trail(x, y, ID.Trail, Color.green, 16, 16, 0.03f, handler));
    } // end tick

    @Override
    public void render(Graphics g) {
        g.setColor(Color.green);
        g.fillRect(x, y, 16, 16);
    } // end render
} // end Bullet class
