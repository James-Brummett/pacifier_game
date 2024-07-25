/*
 * File: GameObject.java
 * Created by: James Brummett
 * Created on: 2024-07-21
 * Updated on: 2024-07-21
 *
 * Purpose: This file is the GameObject class for the Pacifier game.
 */

package com.pacifier.game.util;

import java.awt.*;

public abstract class GameObject {

    protected int x, y;
    protected ID id;
    protected int velX, velY;

    // constructor
    public GameObject(int x, int y, ID id) {
        this.x = x;
        this.y = y;
        this.id = id;
    } // end GameObject

    public abstract void tick();
    public abstract void render(Graphics g);
    public abstract Rectangle getBounds();

    // getters and setters
    public int getX() {
        return x;
    } // end getX

    public void setX(int x) {
        this.x = x;
    } // end setX

    public int getY() {
        return y;
    } // end getY

    public void setY(int y) {
        this.y = y;
    } // end setY

    public ID getId() {
        return id;
    } // end getId

    public void setId(ID id) {
        this.id = id;
    } // end setId

    public int getVelX() {
        return velX;
    } // end getVelX

    public void setVelX(int velX) {
        this.velX = velX;
    } // end setVelX

    public int getVelY() {
        return velY;
    } // end getVelY

    public void setVelY(int velY) {
        this.velY = velY;
    } // end setVelY

} // end GameObject
