/*
* File: KeyInput.java
* Created by: James Brummett
* Created on: 2024-07-21
* Updated on: 2024-07-24
*
* Purpose: This file is the KeyInput class for the Pacifier game.
*/

package com.pacifier.game.util;
// imports
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

// KeyInput class
public class KeyInput extends KeyAdapter {

    Handler handler;
    private boolean[] keyDown = new boolean[4];

    public KeyInput(Handler handler) {
        this.handler = handler;
        keyDown[0] = false; // W
        keyDown[1] = false; // S
        keyDown[2] = false; // A
        keyDown[3] = false; // D
    } // end KeyInput

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        //System.out.println(key);
        for (int i = 0; i < handler.object.size(); i++) {
            GameObject tempObject = handler.object.get(i);
            if (tempObject.getId() == ID.Player) {
                // key events for player 1
                if (key == KeyEvent.VK_W) {
                    tempObject.setVelY(-5);
                    keyDown[0] = true;
                }
                if (key == KeyEvent.VK_S) {
                    tempObject.setVelY(5);
                    keyDown[1] = true;
                }
                if (key == KeyEvent.VK_A) {
                    tempObject.setVelX(-5);
                    keyDown[2] = true;
                }
                if (key == KeyEvent.VK_D) {
                    tempObject.setVelX(5);
                    keyDown[3] = true;
                }
            } // end if
        } // end for
        // exit game
        if(key == KeyEvent.VK_ESCAPE) System.exit(1);
    } // end keyPressed

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        for (int i = 0; i < handler.object.size(); i++) {
            GameObject tempObject = handler.object.get(i);
            if (tempObject.getId() == ID.Player) {
                // movement keys are released, stop moving
                if (key == KeyEvent.VK_W) keyDown[0] = false;
                if (key == KeyEvent.VK_S) keyDown[1] = false;
                if (key == KeyEvent.VK_A) keyDown[2] = false;
                if (key == KeyEvent.VK_D) keyDown[3] = false;

                // vertical movement
                if (!keyDown[0] && !keyDown[1]) tempObject.setVelY(0);
                // horizontal movement
                if (!keyDown[2] && !keyDown[3]) tempObject.setVelX(0);
            } // end if
        } // end for
    } // end keyReleased

} // end KeyInput
