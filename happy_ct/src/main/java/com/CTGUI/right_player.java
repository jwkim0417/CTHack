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
public class right_player extends JPanel{
    Image stop,walk,shoot,dazed,curr;
    int now;
    // 0 : stop 1: walk 2: shoot 3: dazed
    
    public void init(){
        
        now=0;
        stop = Toolkit.getDefaultToolkit().createImage("src/main/java/images/b1/stand_b1.gif");  
        walk = Toolkit.getDefaultToolkit().createImage("src/main/java/images/b1/walk_b1.gif");  
        shoot = Toolkit.getDefaultToolkit().createImage("src/main/java/images/b1/shoot_b1.gif");  
        dazed = Toolkit.getDefaultToolkit().createImage("src/main/java/images/b1/dazed_b1.gif");  
        curr=stop;
    }
    
    public void paintComponent(Graphics g) { 
        super.paintComponent(g);  
        if (curr != null) {  
          g.drawImage(curr, 0, 0, this); 
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
