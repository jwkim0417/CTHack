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
    Game game = null;

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

    public void init_game() {
        try {
            game = new Game("src/main/java/files/boss1.txt", "src/main/java/files/player.txt", "src/main/java/files/result.txt", 10);
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public void command(boolean coop1, boolean coop2) throws InterruptedException{
        if(coop1 && coop2){
            waiting wait=new waiting();
            wait.start();
        }
    }
    
    public class waiting extends Thread {

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
