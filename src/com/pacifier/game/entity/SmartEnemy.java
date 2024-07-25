/*
* File: SmartEnemy.java
* Created by: James Brummett
* Created on: 2024-07-24
* Updated on: 2024-07-25
*
* Purpose: This file is the SmartEnemy class for the Pacifier game.
*/
package com.pacifier.game.entity;

// imports

import com.pacifier.game.Game;
import com.pacifier.game.graphics.Trail;
import com.pacifier.game.util.GameObject;
import com.pacifier.game.util.Handler;
import com.pacifier.game.util.ID;

import java.awt.*;

// SmartEnemy class
public class SmartEnemy extends GameObject {

    private Handler handler;
    private GameObject player;

    // constructor
    public SmartEnemy(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;

        for (int i = 0; i < handler.object.size(); i++) {
            if (handler.object.get(i).getId() == ID.Player) player = handler.object.get(i);
        } // end for

    } // end SmartEnemy

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x, y, 16, 16);
    } // end getBounds

    @Override
    public void tick() {
        x += velX;
        y += velY;

        double diffX = x - player.getX() - 8;
        double diffY = y - player.getY() - 8;
        double distance = Math.sqrt(diffX*diffX+diffY*diffY);
        velX = (int) ((-1.5 / distance) * diffX);
        velY = (int) ((-1.5 / distance) * diffY);

        if(y <= 0 || y >= Game.HEIGHT - 40) velY *= -1;
        if(x <= 0 || x >= Game.WIDTH - 16) velX *= -1;
        handler.addObject(new Trail(x, y, ID.Trail, Color.cyan, 16, 16, 0.03f, handler));
    } // end tick

    @Override
    public void render(Graphics g) {
        g.setColor(Color.cyan);
        g.fillRect(x, y, 16, 16);
    } // end render
} // end SmartEnemy

