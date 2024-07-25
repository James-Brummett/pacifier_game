/*
* File: Handler.java
* Created by: James Brummett
* Created on: 2024-07-21
* Updated on: 2024-07-21
*
* Purpose: This file is the Handler class for the Pacifier game.
*/

package com.pacifier.game.util;

// imports
import java.awt.*;
import java.util.LinkedList;

// class for handling game objects
public class Handler {
    public LinkedList<GameObject> object = new LinkedList<>();

    public void tick() {
        // end for
        for (int i = 0; i < object.size(); i++) {
            GameObject tempObject = object.get(i);
            tempObject.tick();
        }
    } // end tick

    public void render(Graphics g) {
        for (GameObject tempObject : object) {
            tempObject.render(g);
        } // end for
    } // end render

    public void addObject(GameObject object) {
        this.object.add(object);
    } // end addObject

    public void removeObject(GameObject object) {
        this.object.remove(object);
    } // end removeObject

    public void clearEnemies() {
        for (int i = object.size()-1; i > 0; i--) {
            GameObject tempObject = object.get(i);
            if (tempObject.getId() != ID.Player) {
                removeObject(tempObject);
            } // end if
        } // end for
    } // end clearEnemies

} // end Handler
