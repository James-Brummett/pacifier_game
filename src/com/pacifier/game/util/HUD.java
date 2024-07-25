/*
* File: HUD.java
* Created by: James Brummett
* Created on: 2024-07-22
* Updated on: 2024-07-22
*
* Purpose: This file is the HUD class for the Pacifier game.
*/

package com.pacifier.game.util;

// imports
import com.pacifier.game.Game;
import java.awt.*;

// HUD class
public class HUD {
    public static int HEALTH = 100;
    private int greenValue = 255;
    private int score = 0;
    private int level = 1;

    public void tick() {
        HEALTH = Game.clamp(HEALTH, 0, 100);
        greenValue = Game.clamp(greenValue, 0, 255);
        greenValue = HEALTH * 2;
        score++;
    } // end tick

    public void render(Graphics g) {
        g.setColor(Color.gray);
        g.fillRect(15, 15, 200, 32);
        g.setColor(new Color(75, greenValue, 0));
        g.fillRect(15, 15, HEALTH * 2, 32);
        g.setColor(Color.white);
        g.drawRect(15, 15, 200, 32);

        g.drawString("Score: " + score, 15, 64);
        g.drawString("Level: " + level, 15, 80);
    } // end render

    public int getScore() {
        return score;
    } // end getScore

    public void setScore(int score) {
        this.score = score;
    } // end setScore

    public int getLevel() {
        return level;
    } // end getLevel

    public void setLevel(int level) {
        this.level = level;
    } // end setLevel

} // end HUD
