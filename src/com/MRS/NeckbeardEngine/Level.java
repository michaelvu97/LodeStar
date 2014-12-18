package com.MRS.NeckbeardEngine;

import com.MRS.NeckbeardEngine.Enemies.*;
import com.MRS.NeckbeardEngine.Projectiles.*;
public class Level {
  
  Game g;
  private int frames;
  public Level(Game g) {
    this.g = g;
    frames = 0;
    
  }
  public void check() {
    frames++;
    
    switch(frames) {
      case 600:
        g.powerUpPickups.add(new PowerUpPickup(400, 0, PowerUp.SHIELD));
        g.enemies.add(new Mook(State.RED, 0, 70, 1, 15, "Shot", null, 0, "stay", Main.WIDTH/2));
        break;
      case 1200:
        g.enemies.add(new Mook(State.BLUE, 600, 0, 1, 10, "Shot", null, 0, "leave", Main.WIDTH/2));
        break;
      case 1800:
        g.powerUpPickups.add(new PowerUpPickup(150, 150, PowerUp.FAST_SHOT));
        g.enemies.add(new Mook(State.RED, 0, 70, 1, 15, "Shot", null, 0, "stay", Main.WIDTH/2));
        break;
      case 2400:
        g.powerUpPickups.add(new PowerUpPickup(300, 0, PowerUp.BOMB));
        g.powerUpPickups.add(new PowerUpPickup(250, 0, PowerUp.SCATTER_SHOT));
        g.enemies.add(new Mook(State.BLUE, 600, 0, 1, 10, "Shot", null, 0, "leave", Main.WIDTH/2));
        break;
      case 3000:
        g.enemies.add(new Mook(State.BLUE, 600, 0, 1, 10, "Shot", null, 0, "leave", Main.WIDTH/2));
        g.enemies.add(new Mook(State.RED, 0, 70, 1, 15, "Shot", null, 0, "stay", Main.WIDTH/2));
        break;
      case 3600:
        g.enemies.add(new Mook(State.BLUE, 600, 0, 1, 10, "Shot", null, 0, "leave", Main.WIDTH/2));
        g.enemies.add(new Mook(State.RED, 0, 70, 1, 15, "Shot", null, 0, "stay", Main.WIDTH/2));
        g.powerUpPickups.add(new PowerUpPickup(450, 0, PowerUp.EXTRA_SHIP));
        g.powerUpPickups.add(new PowerUpPickup(500, 0, PowerUp.SPEED_BOOST));
        g.powerUpPickups.add(new PowerUpPickup(200, 0, PowerUp.RAPID_FIRE));
        break;
      case 3660:
          g.enemies.add(new Mook(State.BLUE, 600, 0, 1, 10, "Shot", null, 0, "leave", Main.WIDTH/2));
        break;
      case 3720:
        g.enemies.add(new Mook(State.RED, 600, 0, 1, 10, "Shot", null, 0, "leave", Main.WIDTH/2));
        break;
      case 3780:
        g.enemies.add(new Mook(State.BLUE, 600, 0, 1, 10, "Shot", null, 0, "leave", Main.WIDTH/2));
        break;
      case 3840:
        g.enemies.add(new Mook(State.RED, 600, 0, 1, 10, "Shot", null, 0, "leave", Main.WIDTH/2));
        break;
      case 840:
        g.enemies.add(new Mook(State.RED, 600, 0, 1, 10, "Shot", null, 0, "leave", Main.WIDTH/2));
        break;
      case 900:
        g.enemies.add(new Mook(State.RED, 600, 0, 1, 10, "Shot", null, 0, "leave", Main.WIDTH/2));
        break;
      case 3900:
        g.enemies.add(new Mook(State.RED, 600, 0, 1, 10, "Shot", null, 0, "leave", Main.WIDTH/2));
        break;
      default:
                
    }
      
      
//    enemies.add(new Mook(State.BLUE, 600, 0, 1, 10, "Shot", null, 0, "leave", Main.WIDTH/2));
//    enemies.add(new Mook(State.RED, 0, 70, 1, 15, "Shot", null, 0, "stay",Main.WIDTH/2));
//    powerUpPickups.add(new PowerUpPickup(150, 150, PowerUp.FAST_SHOT));
//    powerUpPickups.add(new PowerUpPickup(300, 0, PowerUp.BOMB));
//    powerUpPickups.add(new PowerUpPickup(200, 0, PowerUp.RAPID_FIRE));
//    powerUpPickups.add(new PowerUpPickup(250, 0, PowerUp.SCATTER_SHOT));
//    powerUpPickups.add(new PowerUpPickup(400, 0, PowerUp.SHIELD));
//    powerUpPickups.add(new PowerUpPickup(450, 0, PowerUp.EXTRA_SHIP));
//    powerUpPickups.add(new PowerUpPickup(500, 0, PowerUp.SPEED_BOOST));
  }
}