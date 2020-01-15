/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.CTGUI;

import java.awt.Color;
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
        stop = Toolkit.getDefaultToolkit().createImage("src/main/java/images/player/stand.gif");  
        walk = Toolkit.getDefaultToolkit().createImage("src/main/java/images/player/walk.gif");  
        shoot = Toolkit.getDefaultToolkit().createImage("src/main/java/images/player/shoot.gif");  
        dazed = Toolkit.getDefaultToolkit().createImage("src/main/java/images/player/dazed.gif");  
        curr=stop;
    }
    
    public void paintComponent(Graphics g) {  
        super.paintComponent(g);  
        if (curr != null) {
          g.drawImage(curr, 274, 0, this); 
        }  
        setBackground(new Color(0,0,0,0));
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
