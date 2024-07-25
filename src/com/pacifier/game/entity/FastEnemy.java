/*
* File: FastEnemy.java
* Created by: James Brummett
* Created on: 2024-07-22
* Updated on: 2024-07-25
*
* Purpose: This file is the FastEnemy class for the Pacifier game.
*/
package com.pacifier.game.entity;

// imports

import com.pacifier.game.Game;
import com.pacifier.game.graphics.Trail;
import com.pacifier.game.util.GameObject;
import com.pacifier.game.util.Handler;
import com.pacifier.game.util.ID;

import java.awt.*;

// BasicEnemy class
public class FastEnemy extends GameObject {

    private Handler handler;

    // constructor
    public FastEnemy(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;
        velX = 2;
        velY = 8;
    } // end FastEnemy constructor

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x, y, 16, 16);
    } // end getBounds

    @Override
    public void tick() {
        x += velX;
        y += velY;
        if(y <= 0 || y >= Game.HEIGHT - 40) velY *= -1;
        if(x <= 0 || x >= Game.WIDTH - 16) velX *= -1;
        handler.addObject(new Trail(x, y, ID.Trail, Color.orange, 16, 16, 0.03f, handler));
    } // end tick

    @Override
    public void render(Graphics g) {
        g.setColor(Color.orange);
        g.fillRect(x, y, 16, 16);
    } // end render
} // end FastEnemy
