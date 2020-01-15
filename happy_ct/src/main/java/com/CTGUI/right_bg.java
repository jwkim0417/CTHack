/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.CTGUI;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

import javax.swing.BorderFactory;
import javax.swing.border.Border;
/**
 *
 * @author kimsj0302
 */
public class right_bg extends JPanel {
    private BufferedImage image,boss1,boss2,C,D;
    Integer x,y,b;
    
    public right_bg(){
        Border blackline = BorderFactory.createLineBorder(Color.black);
        setBorder(blackline);
        b=0;
        setOpaque(false);
    }
    public void setboss(int n){
        b=n;
    }
    public void setperson() throws IOException{
        if(b==0){
            image=ImageIO.read(new File("src/main/java/images/boss_1.png"));
        }
        else{
            image=ImageIO.read(new File("src/main/java/images/boss_2.png"));
        }
    }
    public void setC() throws IOException{
        image=ImageIO.read(new File("src/main/java/images/jewelry.png"));
    }
    public void setD() throws IOException{
        image=ImageIO.read(new File("src/main/java/images/empty_r.png"));
    }

    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, null);
    }
}