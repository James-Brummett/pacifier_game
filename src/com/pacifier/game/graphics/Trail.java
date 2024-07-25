/*
* File: Trail.java
* Author: James Brummett
* Date Created: 7/22/2024
* Date Updated: 7/22/2024
*
* Purpose: This file is the Trail class for the Pacifier game.
*/

package com.pacifier.game.graphics;

// imports
import com.pacifier.game.util.GameObject;
import com.pacifier.game.util.Handler;
import com.pacifier.game.util.ID;
import java.awt.*;

// Trail class
public class Trail extends GameObject {
    private float alpha = 1;
    private float life;
    private Handler handler;
    private Color color;
    private int width, height;

    // constructor
    public Trail(int x, int y, ID id, Color color, int width, int height, float life, Handler handler) {
        super(x, y, id);
        this.color = color;
        this.width = width;
        this.height = height;
        this.life = life;
        this.handler = handler;
    } // end Trail

    @Override
    public void tick() {
        if (alpha > life) {
            alpha -= life - 0.0001f;
        } else {
            handler.removeObject(this);
        } // end if
    } // end tick

    @Override
    public void render(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setComposite(makeTransparent(alpha));
        g.setColor(color);
        g.fillRect(x, y, width, height);
        g2d.setComposite(makeTransparent(1));
    } // end render

    public AlphaComposite makeTransparent(float alpha) {
        int type = AlphaComposite.SRC_OVER;
        return AlphaComposite.getInstance(type, alpha);
    } // end makeTransparent

    @Override
    public Rectangle getBounds() {
        return null;
    } // end getBounds
} // end Trail
