/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.CTGUI;

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
public class left_bg extends JPanel {
    private BufferedImage image;
    Boolean reset;
    Integer initx;
    Integer x,y;
    Boolean move;
    public left_bg(){
        Border blackline = BorderFactory.createLineBorder(Color.black);
        setBorder(blackline);
        x=-2522;
        y=0;
        initx=x;
        reset=false;
        move=false;
    }
    public void init(){
        System.out.println("init in bg");
        reset=true;
    }
    public void startmove(){
        move=true;
    }
    public void endmove(){
        move=false;
    }
    @Override
    protected void paintComponent(Graphics g) {

        try {
          image = ImageIO.read(new File("src/main/java/images/bg_l.jpg"));
       } catch (IOException ex) {
           return;
       }
        super.paintComponent(g);
        if(move) x+=8;
        if(reset){
            System.out.println("?!?");
            reset=false;
            x=initx;
        }
        g.drawImage(image, x, y, null);
        repaint();
        revalidate();
    }
}