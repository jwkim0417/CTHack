/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.CTGUI;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JPanel;


/**
 *
 * @author kimsj0302
 */
public class left_player extends JPanel{
    Image stop,walk,shoot,dazed,curr;
    int now;
    // 0 : stop 1: walk 2: shoot 3: dazed
    
    public void init(){
        
        now=0;
        stop = Toolkit.getDefaultToolkit().createImage("src/main/java/images/stand.jpg");  
        walk = Toolkit.getDefaultToolkit().createImage("src/main/java/images/walk.gif");  
        shoot = Toolkit.getDefaultToolkit().createImage("src/main/java/images/shoot.gif");  
        dazed = Toolkit.getDefaultToolkit().createImage("src/main/java/images/dazed.gif");  
        curr=walk;
    }
    
    public void paintComponent(Graphics g) {  
        super.paintComponent(g);  
        if (curr != null) {  
          g.drawImage(curr, 0, 0, this); 
        }  
      }

    public void  setwalk(){
        curr = walk;
    }
    public void setstop(){
        curr = stop;
    }
    public void setshoot(){
        curr = shoot;
    }
    public void setdazed(){
        curr = dazed;
    }
}
