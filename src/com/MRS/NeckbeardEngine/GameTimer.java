/* 
 * PROJECT:LodeStar
 * Source can be found at www.github.com/michaelvu97/LodeStar
 * Authors: Safwan Qazi (Project Manager), Roy Liu, Michael Vu
 * Date: 9/17/14
 * 
 * This class is simply a timertask that executes the specific Game process.
 */

package com.MRS.NeckbeardEngine;

import java.util.TimerTask;

public class GameTimer extends TimerTask {
     
     Game game;
     
     //Constructor
     public GameTimer (Game g1) {
          game = g1;
     }
     
     @Override
     public void run() {
          //Runs on Timer completion
          game.step();
     } 
}
