/*
 * Explosions are a gold-platey effect
 * called generally when something is hit
 * or dies. It cycles throught multiple 
 * animation frames.
 */
package com.MRS.NeckbeardEngine;

import java.awt.*;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;

public class Explosion {
  private int x;
  private int y;
  private int animationPosition = 0;
  private boolean animationCompleted = false;
  
  ArrayList<BufferedImage> frames = new ArrayList<BufferedImage>();
  
  public static final String EXPLOSIONTYPE_HIT = "EXPLOSIONTYPE_HIT";
  public static final String EXPLOSIONTYPE_DEATHMEDIUM = "EXPLOSIONTYPE_DEATHMEDIUM";
  
  //Used to center the explosion properly
  public static final int HIT_OFFSET_X = -17;
  public static final int HIT_OFFSET_Y = -80;
  public static final int DEATHMEDIUM_OFFSET_X = 0;
  public static final int DEATHMEDIUM_OFFSET_Y = 0;
  
  public Explosion (int x, int y, String explosionType) {
    
    this.x = x;
    this.y = y;
    
    //Checking which explosion image set to use
    if (explosionType.equals(EXPLOSIONTYPE_HIT)) {
      this.x += HIT_OFFSET_X;
      this.y += HIT_OFFSET_Y;
      String workingDir = System.getProperty("user.dir"); 
      for (int i = 0; i < FileStore.HITEXPLOSIONONE.length; i++) {
        try {
          frames.add(frames.size(), ImageIO.read(new File (workingDir + FileStore.HITEXPLOSIONONE[i])));
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    } else if (explosionType.equals(EXPLOSIONTYPE_DEATHMEDIUM)) {
      this.x += DEATHMEDIUM_OFFSET_X;
      this.y += DEATHMEDIUM_OFFSET_Y;
      String workingDir = System.getProperty("user.dir"); 
      for (int i = 0; i < FileStore.DEATHEXPLOSIONMEDIUM.length; i++) {
        try {
          frames.add(frames.size(), ImageIO.read(new File (workingDir + FileStore.DEATHEXPLOSIONMEDIUM[i])));
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
  }
  
  public void paint(Graphics2D g) {
    if (animationPosition >= frames.size()) {
      animationCompleted = true;
    } else {
      g.drawImage(frames.get(animationPosition++), x, y, null);
    }
  }
  
  public boolean getCompleted() {
    //True when there are no frames left.
    return animationCompleted;
  }
}