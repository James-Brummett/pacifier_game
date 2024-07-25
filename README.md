*Pacifier Game
  **Object Types
    ***Player:
      White square, spawns in middle of screen. Moves using W,A,S,D. Avoid enemies to survive longer. Score constantly rises. Life lost when player collides with enemies.
    ***Basic Enemy:
      Red square. Random spawn point. Bounces around the screen.
    ***Fast Enemy:
      Orange square. Randow spawn point. Faster along the y-axis (up & down) than a basic enemy.
    ***Smart Enemy:
      Cyan square. Randowm spawn point. Slower than basic enemy. Constantly moves toward the player.
    ***Boss Enemy:
      Large green square. Spawns at top of screen. Drops down into view then stops descent. Moves along the x-axis around the room. Shoots bullets in random directions.
    ****Bullet:
        Small green square. Fired by Boss enemy. Shoots in random direction, disappears when off screen.
  **Scoring
    Score constantly rises as long as player has is alive (has positive health bar).
  **Levels
    When score hits increments of 300, level increases. New basic enemy spawns on even levels. New fast enemy spawns every third level. Smart enemy spawns on levels divisible by four (in place of basic enemy).
    Boss enemy spawns every 10 levels. When boss spawns, all other enemies are removed from game.
