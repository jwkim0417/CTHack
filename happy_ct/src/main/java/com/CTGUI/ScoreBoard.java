/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.CTGUI;

import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.JLabel;


/**
 *
 * @author hsy4462
 */

public class ScoreBoard  extends JPanel {
    JLabel PlayerName;
    JLabel PlayerScore;
    JLabel BossScore;
    JLabel Turn;
    int turn = 0;
    
    public ScoreBoard(String PlayerName) {
        
        this.PlayerName = new JLabel(PlayerName);
        this.PlayerName.setHorizontalAlignment(SwingConstants.CENTER);
        
        this.PlayerScore = new JLabel("0");
        
        this.BossScore = new JLabel("0");
        
        this.Turn = new JLabel("0");
        
        
    }
    
    public void setPlayerName(String name){
        
    }
    
    public void setPlayerScore(){
        
    }
    
    public void setBossScore(){
        
    }
    
    public void setTurn(){
        
    }
    
    
    
}
