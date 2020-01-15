/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.CTGUI;
import com.game.Game;
import java.awt.Color;
import java.io.IOException;

import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author kimsj0302
 */
public class Controller {
    right_bg rb;
    left_bg lb;
    ScoreBoard sb;
    int boss;
    Game game = null;
    public void set_rb(right_bg bg) throws IOException{
        rb=bg;
        rb.setperson();
        rb.setboss(boss);
    }
    public void set_lb(left_bg bg) throws IOException{
        lb=bg;
        lb.setperson();
    }
    public void set_boss(int n){
        rb.setboss(n);
        System.out.println(n);
        System.out.println(n);
        System.out.println(n);
        try {
            rb.setperson();
        } catch (IOException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void init_game(int n) {
        try {
            game = new Game("src/main/java/files/player.txt", "src/main/java/files/boss"+Integer.toString(n)+".txt", "src/main/java/files/result.txt", 10);
        } catch(Exception e){
            e.printStackTrace();
        }
        
    }
    public void command(boolean coop1, boolean coop2) throws InterruptedException{
        if(coop1 && coop2){
            try {
                rb.setC();
            } catch (IOException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                lb.setC();
            } catch (IOException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
            lb.revalidate();
            rb.revalidate();
            rb.repaint();
            lb.repaint();
            lb.revalidate();
            rb.revalidate();
        }
        else if(coop1 && !coop2){
            try {
                rb.setD();
            } catch (IOException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                lb.setC();
            } catch (IOException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
            lb.revalidate();
            rb.revalidate();
            rb.repaint();
            lb.repaint();
            lb.revalidate();
            rb.revalidate();
            
        }
        else if(!coop1 && coop2){
            try {
                rb.setC();
            } catch (IOException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                lb.setD();
            } catch (IOException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
            lb.revalidate();
            rb.revalidate();
            rb.repaint();
            lb.repaint();
            lb.revalidate();
            rb.revalidate();
            
        }
        else{
            try {
                rb.setD();
            } catch (IOException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                lb.setD();
            } catch (IOException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
            lb.revalidate();
            rb.revalidate();
            rb.repaint();
            lb.repaint();
            lb.revalidate();
            rb.revalidate();
            
        }
    }
}
