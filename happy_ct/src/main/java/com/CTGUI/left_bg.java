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

    public left_bg(){
        Border blackline = BorderFactory.createLineBorder(Color.black);
        setBorder(blackline);
    }
    @Override
    protected void paintComponent(Graphics g) {

        try {
          image = ImageIO.read(new File("src/main/java/images/bg.jpg"));
       } catch (IOException ex) {
           return;
       }
        BufferedImage bi = new BufferedImage(2 * image.getWidth(null),
                                             2 * image.getHeight(null),
                                             BufferedImage.TYPE_INT_ARGB);

        Graphics2D grph = (Graphics2D) bi.getGraphics();
        grph.scale(2, 2);
        super.paintComponent(g);
        g.drawImage(image, -180, -200, null);
    }
}