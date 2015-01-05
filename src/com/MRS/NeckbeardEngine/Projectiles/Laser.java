package com.MRS.NeckbeardEngine.Projectiles;

import com.MRS.NeckbeardEngine.*;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.*;

public class Laser extends Projectile {
  
  /*
   * Laser spawns from a given point: the
   * centre of the laser will be at the given
   * coordinates and will extend based on its
   * orientation
   */
  private BufferedImage imgCharge, imgActive;
  
  private boolean charging = true;
  private int chargingClock = 0;
  private Direction direction;
  
  public static int CHARGING_TIME = 120; /*or something (tune this) once tuned, 
                                           the sound clip can be created based on the time values */
  public static int ACTIVE_TIME = 180;
  
  public Laser (State state, int x, int y, double xVelocity, double yVelocity, Direction direction) {
   super(state, x, y, xVelocity, yVelocity, CHARGING_TIME + ACTIVE_TIME); 
   this.direction = direction;
   
   /* frames are converted to a time value
    * if the frame rate is ever changed,
    * this needs to be adjusted/dynamic
    */
   killTime = (CHARGING_TIME + ACTIVE_TIME) * 16.6667 + System.currentTimeMillis();
   //so it doesn't hit anything while charging
   hitBox = new HitBox(x,y,0,0);
     
   //preloading images
   imgCharge = null;
   imgActive = null;
   try {
     String workingDir = System.getProperty("user.dir");
     if (state == State.RED) {
       if (direction == Direction.DOWN || direction == Direction.UP) {
         imgCharge = ImageIO.read(new File (workingDir + FileStore.LASER_RED_VERTICAL_CHARGE));
         imgActive = ImageIO.read(new File (workingDir + FileStore.LASER_RED_VERTICAL_ACTIVE));
       } else {
         imgCharge = ImageIO.read(new File (workingDir + FileStore.LASER_RED_HORIZONTAL_CHARGE));
         imgActive = ImageIO.read(new File (workingDir + FileStore.LASER_RED_HORIZONTAL_ACTIVE));
       }
     } else {
       if (direction == Direction.DOWN || direction == Direction.UP) {
         imgCharge = ImageIO.read(new File (workingDir + FileStore.LASER_BLUE_VERTICAL_CHARGE));
         imgActive = ImageIO.read(new File (workingDir + FileStore.LASER_BLUE_VERTICAL_ACTIVE));
       } else {
         imgCharge = ImageIO.read(new File (workingDir + FileStore.LASER_BLUE_HORIZONTAL_CHARGE));
         imgActive = ImageIO.read(new File (workingDir + FileStore.LASER_BLUE_HORIZONTAL_ACTIVE)); 
       }
     }
   } catch (IOException e) {
     e.printStackTrace();
   }
  }
  
  @Override
  public void paint (Graphics2D g) {
    if (charging) {
      g.drawImage(imgCharge, x+2, y, null);
    } else {
      g.drawImage(imgActive, x, y, null);
    }
  }
  
  @Override 
  public void move () {
    super.move();
    chargingClock++;
    if (chargingClock >= CHARGING_TIME) {
      charging = false;
    }
    if(!charging){
       //orientation
   switch (direction.getValue()) {
     //The cases are the integer constants of the direction enum
     case 2:
       hitBox = new HitBox (x, y, 30, 980);
       break;
     case 4:
       hitBox = new HitBox (x, y, 980, 30);
       break;
     case 1:
       hitBox = new HitBox (x, y, 30, 980);
       break;
     case 3:
       hitBox = new HitBox (x, y, 980, 30);
       break;
   }
    }
  }
  
  public boolean getCharging() {
    return charging;
  }
  
  public int getChargingClock() {
    return chargingClock; 
  }
  
  public Direction getDirection() {
    return direction;
  }
}