/*
 * File: Game.java
 * Created by: James Brummett
 * Created on: 2024-05-20
 * Updated on: 2024-07-21
 *
 * Purpose: This file is the Game class for the Pacifier game.
 */

package com.pacifier.game;

// imports

import com.pacifier.game.entity.BasicEnemy;
import com.pacifier.game.entity.Player;
import com.pacifier.game.util.*;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.io.Serial;
import java.util.Random;

public class Game extends Canvas implements Runnable{
    @Serial
    private static final long serialVersionUID = -1532166233017315972L;
    public static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9;
    private Thread thread;
    private boolean running = false;
    public Handler handler;
    private Random r;
    private HUD hud;
    private Spawner spawner;

    // constructor
    public Game(){
        handler = new Handler();

        r = new Random();

        this.addKeyListener(new KeyInput(handler));

        new Window(WIDTH, HEIGHT, "Pacifier", this);
        hud = new HUD();
        spawner = new Spawner(handler, hud);

        handler.addObject(new Player(WIDTH/2-32, HEIGHT/2-32, ID.Player, handler));
        handler.addObject(new BasicEnemy(r.nextInt(WIDTH-16), r.nextInt(HEIGHT-16
        ), ID.BasicEnemy, handler));
        
    } // end Game constructor

    public synchronized void start() {
        thread = new Thread(this);
        thread.start();
        running = true;
    } // end start

    public synchronized void stop() {
        try {
            thread.join();
            running = false;
        } catch (Exception e) {
            e.printStackTrace();
        } // end try-catch
    } // end start

    @Override
    public void run() {
        this.requestFocus();
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1) {
                tick();
                delta--;
            } // end while
            if (running) {
                render();
            } // end if
            frames++;
            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                // System.out.println("FPS: " + frames);
                frames = 0;
            } // end if
        } // end while
        stop();
    } // end run

    private void tick() {
        handler.tick();
        hud.tick();
        spawner.tick();
    } // end tick

    private void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            this.createBufferStrategy(3);
            return;
        } // end if
        Graphics g = bs.getDrawGraphics();
        g.setColor(Color.black);
        g.fillRect(0, 0, WIDTH, HEIGHT);
        handler.render(g);
        hud.render(g);
        g.dispose();
        bs.show();
    } // end render

    public static int clamp(int var, int min, int max) {
        if (var >= max) {
            return var = max;
        } else if (var <= min) {
            return var = min;
        } else {
            return var;
        } // end if
    } // end clamp

    public static void main(String[] args) {
        Game game = new Game();
    } // end main

} // end Game
