/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.CTGUI;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.Box;
import java.awt.BorderLayout;
import java.awt.Color;


import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

/**
 *
 * @author hsy4462
 */
public class ScoreBoard extends JPanel{
    JLabel PlayerName;
    JLabel Turn;
    JLabel PlayerScore;
    JLabel BossScore;
    int turn = 1;
    
    
    public ScoreBoard() {
        this.PlayerName = new JLabel("Group: ");
        this.PlayerName.setFont(new Font("Serif", Font.PLAIN, 30));
        //this.PlayerName.setHorizontalAlignment(SwingConstants.CENTER);

        this.Turn = new JLabel("Turn: ");
        this.Turn.setFont(new Font("Serif", Font.PLAIN, 30));
        
        this.PlayerScore = new JLabel("Player Score: ");
        this.PlayerScore.setFont(new Font("Serif", Font.PLAIN, 30));
        
        this.BossScore = new JLabel("Boss Score: ");
        this.BossScore.setFont(new Font("Serif", Font.PLAIN, 30));
        
        /* Layout */
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        this.add(Box.createHorizontalGlue());

        this.add(this.PlayerName);
        this.add(Box.createHorizontalGlue());

        this.add(this.Turn);
        this.add(Box.createHorizontalGlue());

        this.add(this.PlayerScore);
        this.add(Box.createHorizontalGlue());
        
        this.add(this.BossScore);
        this.add(Box.createHorizontalGlue());
        this.setBorder(new LineBorder(Color.black, 2, true));
        
        
        this.setPreferredSize(new Dimension(1000, 100));
    }
    
    public void setPlayerName(String name){
        this.PlayerName.setText("Group: " + name);
    }
    
    public void setTurn(int turn){
        this.Turn.setText("Turn: " + Integer.toString(turn));
    }
    
    public void setPlayerScore(int score){
        this.PlayerScore.setText("Player Score: " + Integer.toString(score));
    }
    
    public void setBossScore(int score){
        this.BossScore.setText("Boss Score: " + Integer.toString(score));
    }
}
