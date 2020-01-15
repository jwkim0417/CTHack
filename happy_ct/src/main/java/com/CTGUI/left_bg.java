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
    private BufferedImage image,player,C,D;
    public left_bg(){
        Border blackline = BorderFactory.createLineBorder(Color.black);
        setBorder(blackline);
        setOpaque(false);
    }
    
    public void setperson() throws IOException{
        image=ImageIO.read(new File("src/main/java/images/player.png"));
    }
    public void setC() throws IOException{
        image=ImageIO.read(new File("src/main/java/images/money.png"));
    }
    public void setD() throws IOException{
        image=ImageIO.read(new File("src/main/java/images/empty_l.png"));
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0,0, null);
    }
}