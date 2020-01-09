/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.CTGUI;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
/**
 *
 * @author kimsj0302
 */
public class bg_layer extends JPanel {
     private BufferedImage image;

    public bg_layer(){
    }
    @Override
    protected void paintComponent(Graphics g) {

        try {
          image = ImageIO.read(new File("src/main/java/images/bg.jpg"));
       } catch (IOException ex) {
           return;
       }
        super.paintComponent(g);
        g.drawImage(image, 0, 0, null);
    }
}
