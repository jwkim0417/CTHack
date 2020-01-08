/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.CTGUI;

import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.JLabel;


/**
 *
 * @author hsy4462
 */

public class ScoreBoard extends JPanel {
    JLabel PlayerName;
    JLabel PlayerScore;
    JLabel BossScore;
    JLabel Turn;
    int turn = 0;
    
    public ScoreBoard() {
        
        this.PlayerName = new JLabel("TEST PLAYER");
        this.PlayerName.setHorizontalAlignment(SwingConstants.CENTER);

        this.Turn = new JLabel("TURN!!");
        
        this.PlayerScore = new JLabel("Player Score");
        
        this.BossScore = new JLabel("Boss Score");
        
        
        JPanel WestSide = new JPanel();
        WestSide.setLayout(new BoxLayout(WestSide, BoxLayout.Y_AXIS));
        WestSide.add(this.PlayerName);
        WestSide.add(this.Turn);

        JPanel EastSide = new JPanel();
        EastSide.setLayout(new BoxLayout(EastSide, BoxLayout.Y_AXIS));
        EastSide.add(this.PlayerScore);
        EastSide.add(this.BossScore);
        
        BorderLayout fl = new BorderLayout();
        this.setLayout(fl);
        
        this.add(WestSide, BorderLayout.WEST);
        this.add(EastSide, BorderLayout.EAST);

                
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
