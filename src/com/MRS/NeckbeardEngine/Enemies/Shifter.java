package com.MRS.NeckbeardEngine.Enemies;

import com.MRS.NeckbeardEngine.Enemy;
import com.MRS.NeckbeardEngine.HitBox;
import com.MRS.NeckbeardEngine.PowerUpPickup;
import com.MRS.NeckbeardEngine.Projectile;
import com.MRS.NeckbeardEngine.State;

public class Shifter extends Enemy {
 
    public static int DEFAULT_HITBOX_WIDTH = 15;
    public static int DEFAULT_HITBOX_HEIGHT = 15;
    
     public Shifter (State state, int x, int y, double xVelocity, double yVelocity, String projectileType, PowerUpPickup heldPowerUp, long timeLine, boolean canShoot) {
          super(state, x, y, xVelocity, yVelocity, projectileType, heldPowerUp, timeLine, canShoot);
          health = 1;
          hitBox = new HitBox (x, y, DEFAULT_HITBOX_WIDTH, DEFAULT_HITBOX_HEIGHT);
     }
     
     public void animate () {
      
          //Swag
          
     }
}
