/*
* File: Spawner.java
* Created by: James Brummett
* Date Created: 7/22/2024
* Date Updated: 7/22/2024
*
* Purpose: This file is the Spawner class for the Pacifier game.
*/

package com.pacifier.game.util;

import com.pacifier.game.Game;
import com.pacifier.game.entity.BasicEnemy;
import com.pacifier.game.entity.BossEnemy;
import com.pacifier.game.entity.FastEnemy;
import com.pacifier.game.entity.SmartEnemy;

import java.util.Random;

public class Spawner {
    private Handler handler;
    private HUD hud;
    private int scoreKeep = 0;
    private Random r = new Random();

    public Spawner(Handler handler, HUD hud){
        this.handler = handler;
        this.hud = hud;
    } // end Spawner constructor

    public void tick(){
        scoreKeep++;
        if (scoreKeep >= 300){
            scoreKeep = 0;
            hud.setLevel(hud.getLevel() + 1);
            if (hud.getLevel() % 10 == 0) {
                handler.clearEnemies();
                handler.addObject(new BossEnemy((Game.WIDTH/2)-48, -30, ID.BossEnemy, handler));
            } else if (hud.getLevel() % 4 == 0) {
                handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH - 16), r.nextInt(Game.HEIGHT - 16) - 16, ID.SmartEnemy, handler));
            } else if (hud.getLevel() % 2 == 0) {
                handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 16), r.nextInt(Game.HEIGHT - 16), ID.BasicEnemy, handler));
            } else if (hud.getLevel() % 3 == 0) {
                handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH - 16), r.nextInt(Game.HEIGHT - 16), ID.FastEnemy, handler));
            } // end if-else-if
        } // end if
    } // end tick
} // end Spawner
