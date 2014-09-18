/* 
 * PROJECT:Fedora
 * Source can be found at www.github.com/michaelvu97/Fedora
 * Authors: Qazi Qazi (Project Manager), Roy Liu, Michael Vu
 * Date: 9/17/14
 * 
 * Dr. Java prefs/misc/indent level = 5
 * 
 * This project will eventually be a shoot 'em up game with the ability to switch states to gain advantages and avoid
 * certain obstacles. There will be different types of enemies, and boss fights. I don't really know what else to put
 * here, so yeah.
 */

package com.MRS.NeckbeardEngine;

import javax.swing.*;

public class Main extends JFrame {
 
     public static void main (String[] args) {
   
          SwingUtilities.invokeLater(new Runnable() {
     
               public void run() {
                    
                    Main main = new Main();
                    
                    main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    
               }
               
          });
          
     }
     
     public Main () {
          
     }
  
}