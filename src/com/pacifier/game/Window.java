/*
 * File: Window.java
 * Created by: James Brummett
 * Created on: 2024-05-20
 * Updated on: 2024-07-21
 *
 * Purpose: This file is the Window class for the Pacifier game.
 */

package com.pacifier.game;

// imports

import javax.swing.*;
import java.awt.*;
import java.io.Serial;

public class Window extends Canvas implements Runnable{

    @Serial
    private static final long serialVersionUID = 3570390790423426559L;

    public Window(int width, int height, String title, Game game){
        JFrame frame = new JFrame(title);

        frame.setPreferredSize(new Dimension(width, height));
        frame.setMaximumSize(new Dimension(width, height));
        frame.setMinimumSize(new Dimension(width, height));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.add(game);
        frame.setVisible(true);
        game.start();
    }// end Window constructor

    @Override
    public void run() {

    } // end run

}// end Window
