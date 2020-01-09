/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.CTGUI;

import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import javax.swing.Box;



/* insert Image */
import java.awt.*;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;
import javax.swing.ImageIcon;


/**

/**
 *
 * @author hsy4462
 */
public class ResultBoard extends JPanel {
   
    JLabel[] PlayerBoard = new JLabel[10];
    JLabel[] BossBoard = new JLabel[10];
    JPanel Player;
    JPanel Boss;
    
    /* constructor */
    public ResultBoard(){
        /* Initialization */
        try{
            this.PlayerBoard[0] = new JLabel(new ImageIcon("src/main/java/images/ResultBoard/player_txt.png"));
            this.BossBoard[0] = new JLabel(new ImageIcon("src/main/java/images/ResultBoard/boss_txt.png"));

            for(int i=1; i<10; i++){
                this.PlayerBoard[i] = new JLabel(new ImageIcon("src/main/java/images/ResultBoard/empty_entry.png"));
                this.BossBoard[i] = new JLabel(new ImageIcon("src/main/java/images/ResultBoard/empty_entry.png"));
            }
        }catch(Exception e){
           return;
        }
        
        /* Layout */
        this.Player = new JPanel();
        this.Player.setLayout(new BoxLayout(this.Player, BoxLayout.X_AXIS));
        
        this.Boss = new JPanel();
        this.Boss.setLayout(new BoxLayout(this.Boss, BoxLayout.X_AXIS));
        
        for(int i=0; i<10; i++){
            this.Player.add(this.PlayerBoard[i]);
            this.Player.add(Box.createHorizontalStrut(5));
            this.Boss.add(this.BossBoard[i]);
            this.Boss.add(Box.createHorizontalStrut(5));

        }

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(this.Player);
        this.add(this.Boss);
        
        this.setPreferredSize(new Dimension(1000, 150));
        RecordResult(5, true, false);
      
    }
    
    /* Record the B/C result in the Board Table */
    public void RecordResult(int Turn, Boolean result1, Boolean result2){
        if(result1){
            this.PlayerBoard[Turn] = new JLabel(new ImageIcon("src/main/java/images/ResultBoard/C_entry.png"));
            this.Player.add(PlayerBoard[Turn], Turn);
        }else{
            this.PlayerBoard[Turn] = new JLabel(new ImageIcon("src/main/java/images/ResultBoard/B_entry.png"));
            this.Player.add(PlayerBoard[Turn], Turn);
        }
        
        if(result2){
            this.BossBoard[Turn] = new JLabel(new ImageIcon("src/main/java/images/ResultBoard/C_entry.png"));
            this.Boss.add(BossBoard[Turn], Turn);
        }else{
            this.BossBoard[Turn] = new JLabel(new ImageIcon("src/main/java/images/ResultBoard/B_entry.png"));
            this.Boss.add(BossBoard[Turn], Turn);
        }
        
    }
}
