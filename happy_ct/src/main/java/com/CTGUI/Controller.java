/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.CTGUI;
import com.game.Game;

import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author kimsj0302
 */
public class Controller {
    right_bg rb;
    left_bg lb;
    right_player rp;
    left_player lp;
    ScoreBoard sb;
    Game game = null;
    CC cc;
    BB bb;
    CB cb;
    BC bc;
    public void set_rb(right_bg bg){
        rb=bg;
    }
    public void set_lb(left_bg bg){
        lb=bg;
    }
    public void set_rp(right_player player){
        rp=player;
    }
    public void set_lp(left_player player){
        lp=player;
    }
    public void set_movement(){
        cc = new CC();
        bb = new BB();
        cb = new CB();
        bc = new BC();
    }
    public void init_game() {
        try {
            game = new Game("src/main/java/files/player.txt", "src/main/java/files/boss1.txt", "src/main/java/files/result.txt", 10);
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    public boolean check(){
        return cc.isAlive() || cb.isAlive() || bc.isAlive() || bb.isAlive() ;
    }
    public void command(boolean coop1, boolean coop2) throws InterruptedException{
        if(coop1 && coop2){
            if(!cc.isAlive())
                cc = new CC();
            cc.start();
        }
        else if(coop1 && !coop2){
            if(!cb.isAlive())
                cb = new CB();
            cb.start();
        }
        else if(!coop1 && coop2){
            if(!bc.isAlive())
                bc = new BC();
            bc.start();
        }
        else{
            if(!bb.isAlive())
                bb = new BB();
            bb.start();
        }
    }
    
    public class CC extends Thread {

        @Override
        public void run(){
            rp.setwalk();
            lp.setwalk();
            rb.startmove();
            lb.startmove();
            try { 
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            rp.setstop();
            lp.setstop();
            rb.endmove();
            lb.endmove();
        } 
    }
    public class CB extends Thread {

        @Override
        public void run(){
            rp.setshoot();
            lp.setdazed();
            rb.startmove();
            lb.startmove();
            try { 
                Thread.sleep(300);
            } catch (InterruptedException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
            rp.setwalk();
            
            try { 
                Thread.sleep(1500);
            } catch (InterruptedException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
            rp.setstop();
            lp.setstop();
            rb.endmove();
            lb.endmove();
        } 
    }
    public class BC extends Thread {

        @Override
        public void run(){
            lp.setshoot();
            rp.setdazed();
            rb.startmove();
            lb.startmove();
            try { 
                Thread.sleep(300);
            } catch (InterruptedException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
            lp.setwalk();
            
            try { 
                Thread.sleep(1500);
            } catch (InterruptedException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
            rp.setstop();
            lp.setstop();
            rb.endmove();
            lb.endmove();
        } 
    }
    public class BB extends Thread {

        @Override
        public void run(){
            rp.setwalk();
            lp.setwalk();
            rb.startmove();
            lb.startmove();
            try { 
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            rp.setstop();
            lp.setstop();
            rb.endmove();
            lb.endmove();
        } 
    }
}
