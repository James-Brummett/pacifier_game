/*
* File: Player.java
* Created by: James Brummett
* Created on: 2024-07-21
* Updated on: 2024-07-21
*
* Purpose: This file is the Player class for the Pacifier game.
*/

package com.pacifier.game.entity;

import com.pacifier.game.Game;
import com.pacifier.game.util.GameObject;
import com.pacifier.game.util.HUD;
import com.pacifier.game.util.Handler;
import com.pacifier.game.util.ID;
import java.awt.*;

public class Player extends GameObject {

    Handler handler;

    public Player(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;
    } // end Player

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x, y, 32, 32);
    } // end getBounds

    @Override
    public void tick() {
        x += velX;
        y += velY;
        x = Game.clamp(x, 0, Game.WIDTH - 37);
        y = Game.clamp(y, 0, Game.HEIGHT - 64);

        collision();
    } // end tick

    public void collision() {
        for (int i = 0; i < handler.object.size(); i++) {
            GameObject tempObject = handler.object.get(i);
            if (tempObject.getId() == ID.BasicEnemy || tempObject.getId() == ID.FastEnemy || tempObject.getId() ==
                    ID.SmartEnemy || tempObject.getId() == ID.BossEnemy){
                if (getBounds().intersects(tempObject.getBounds())) {
                    // collision code
                    HUD.HEALTH -= 2;
                } // end if
            } // end if
        } // end for
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(x, y, 32, 32);

    } // end render

} // end Player
