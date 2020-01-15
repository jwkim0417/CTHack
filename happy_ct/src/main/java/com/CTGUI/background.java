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
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

/**
 *
 * @author kimsj0302
 */
public class background extends JPanel {
    private BufferedImage image;
    Integer x,y;
    public background(){
        Border blackline = BorderFactory.createLineBorder(Color.black);
        setBorder(blackline);
        setBackground(new Color(0,0,0,0));
    }
    @Override
    protected void paintComponent(Graphics g) {
        
        try {
          image = ImageIO.read(new File("src/main/java/images/bg.png"));
       } catch (IOException ex) {
           return;
       }

        super.paintComponent(g);
        g.drawImage(image, 0, 0, null);
    }
    
}
