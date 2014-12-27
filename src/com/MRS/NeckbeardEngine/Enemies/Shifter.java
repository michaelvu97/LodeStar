package com.MRS.NeckbeardEngine.Enemies;

import com.MRS.NeckbeardEngine.*;

import java.awt.*;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Shifter extends Enemy {
     
     public static int DEFAULT_HITBOX_WIDTH = 60;
     public static int DEFAULT_HITBOX_HEIGHT = 60;
     private String version;
     public static int MAXSHOTCOOLDOWN = 60;
     public static int SHIFT_COOLDOWN = 120;
     private Player target;
     private int shootPos;
     private int shiftTimer;
     
     public Shifter (State state, int x, int y, double xVelocity, double yVelocity, String projectileType, PowerUpPickup heldPowerUp, long timeLine, String version, Player target, int shootPos) {
          super(state, x, y, xVelocity, yVelocity, projectileType, heldPowerUp, timeLine);
          health = 1;          
          hitBox = new HitBox (x, y, DEFAULT_HITBOX_WIDTH, DEFAULT_HITBOX_HEIGHT);
          this.version = version;
          shotCoolDown = MAXSHOTCOOLDOWN;
          this.target = target;
          this.shootPos = shootPos;
          shiftTimer = SHIFT_COOLDOWN;
     }
     
     //@Override
     public void animate () {
          //Todo: add shooting to animate.
          //When creating "stay" Shifters, yVelocity = 0 and xVelocity magnitude = 3
          if(version.equalsIgnoreCase("stay")){
               if(x < target.getX() - 10){
                    xVelocity = xSpeed;
                    //yVelocity -= (yVelocity/20);        
               }
               else if(x > target.getX() + 10){
                    xVelocity = -1 * xSpeed;
                    //yVelocity -= (yVelocity/20);        
               }
               else
                    xVelocity = 0;
          }
          if(version.equalsIgnoreCase("leave")){
               if(xVelocity > 0){
                    xVelocity = xSpeed;
                    yVelocity -= (yVelocity/20);        
               }
               else if(xVelocity < 0){
                    xVelocity = -1 * xSpeed;
                    yVelocity -= (yVelocity/20);        
               }
          }
          
          //Diagonal move downward formation. 4 Velocity magnitude
          if(version.equalsIgnoreCase("form1")) {
               if (xVelocity > 0) {
                    xVelocity = xSpeed;
                    yVelocity = ySpeed;
               }
               else if (xVelocity < 0) {
                    xVelocity = -1 * xSpeed;
                    yVelocity = ySpeed;
               }
          }
          
          //Diagonal move upward formation. 4 Velocity magnitude
          if(version.equalsIgnoreCase("form2")) {
               if (xVelocity > 0) {
                    xVelocity = xSpeed;
                    yVelocity = -1 * ySpeed;
               }
               else if (xVelocity < 0) {
                    xVelocity = -1 * xSpeed;
                    yVelocity = -1 * ySpeed;
               }
          }
          
          //V-shaped move formation, fires a bottom point of V. 3 xVelocity, 4 yVelocity
          if(version.equalsIgnoreCase("form3")) {
               if (xVelocity > 0) {
                    if (x < Main.WIDTH/4) {
                         xVelocity = xSpeed;
                         yVelocity = ySpeed;
                    }
                    else {
                         xVelocity = xSpeed;
                         yVelocity = -1 * ySpeed;
                    }
               }
               else if (xVelocity < 0) {
                    if (x > (Main.WIDTH - Main.WIDTH/4)) {
                         xVelocity = -1 * xSpeed;
                         yVelocity = ySpeed;
                    }
                    else {
                         xVelocity = xSpeed * -1;
                         yVelocity = ySpeed * -1;
                    }
               }
          }
          
          //Changes Shifter state when cooldown is done and resets cooldown timer
          shiftTimer--;
          if (shiftTimer == 0) {
               if (state == State.RED)
                    state = State.BLUE;
               else
                    state = State.RED;
               shiftTimer = SHIFT_COOLDOWN;
          }
     }
     
     public void move () {
          animate();
          x += xVelocity;
          y += yVelocity;
          hitBox.setX(x);
          hitBox.setY(y);
     }
     
     public boolean onScreen(){
          return (x > 0 - DEFAULT_HITBOX_WIDTH - 100 && x < Main.WIDTH + 100 && y > 0 - DEFAULT_HITBOX_HEIGHT - 100 && y < Main.HEIGHT + 100);
     }
     public boolean canShoot() {
          if(version.equalsIgnoreCase("stay") && shotCoolDown <= 0 && xVelocity == 0) 
               return true;
          else if((version.equalsIgnoreCase("leave") || version.equalsIgnoreCase("form1") || version.equalsIgnoreCase("form2") || version .equalsIgnoreCase("form3")) && (x == shootPos))
               return true;
          else
               return false;
     }
     public void resetShotCoolDown() {
          shotCoolDown = MAXSHOTCOOLDOWN;
     }
     
     @Override
     public void paint (Graphics2D g) {
          BufferedImage img = null;
          
          String workingDir = System.getProperty("user.dir");
          String path = "";
          
          if (state == State.RED) {
               path = workingDir + FileStore.SHIFTER_RED;
          } else if (state == State.BLUE) {
               path = workingDir + FileStore.SHIFTER_BLUE;
          }
          
          try {
               img = ImageIO.read(new File(path));
          } catch (IOException e) {
               e.printStackTrace();
          }
          
          g.drawImage(img, x, y, null);
     }
}
