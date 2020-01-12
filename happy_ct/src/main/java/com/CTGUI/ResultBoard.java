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
 *
 * @author hsy4462
 */
public class ResultBoard extends JPanel {
   
    JLabel[] PlayerBoard = new JLabel[11];
    JLabel[] BossBoard = new JLabel[11];
    JPanel Player;
    JPanel Boss;
    
    /* constructor */
    public ResultBoard(){
        /* Initialization */
        ImageIcon EmptyEntry = new ImageIcon("src/main/java/images/ResultBoard/empty_entry.png");
        try{
            this.PlayerBoard[0] = new JLabel(new ImageIcon("src/main/java/images/ResultBoard/player_txt.png"));
            this.BossBoard[0] = new JLabel(new ImageIcon("src/main/java/images/ResultBoard/boss_txt.png"));

            for(int i=1; i<=10; i++){
                this.PlayerBoard[i] = new JLabel(EmptyEntry);
                this.BossBoard[i] = new JLabel(EmptyEntry);
            }
        }catch(Exception e){
           return;
        }
        
        /* Layout */
        this.Player = new JPanel();
        this.Player.setLayout(new BoxLayout(this.Player, BoxLayout.X_AXIS));
        
        this.Boss = new JPanel();
        this.Boss.setLayout(new BoxLayout(this.Boss, BoxLayout.X_AXIS));
        
        for(int i=0; i<=10; i++){
            this.Player.add(this.PlayerBoard[i]);
            this.Player.add(Box.createHorizontalStrut(20));
            this.Boss.add(this.BossBoard[i]);
            this.Boss.add(Box.createHorizontalStrut(20));

        }

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(this.Player);
        this.add(this.Boss);
        
        this.setPreferredSize(new Dimension(1000, 150));
    }
    
    /* Record the B/C result in the Board Table */
    public void RecordResult(int Turn, Boolean result1, Boolean result2){
        ImageIcon C_entry = new ImageIcon("src/main/java/images/ResultBoard/C_entry.png");
        ImageIcon B_entry = new ImageIcon("src/main/java/images/ResultBoard/B_entry.png");

        /* Player Result */
        if(result1){
            this.PlayerBoard[Turn].setIcon(C_entry);
        }else{
            this.PlayerBoard[Turn].setIcon(B_entry);
        }
        
        /* Boss Result */
        if(result2){
            this.BossBoard[Turn].setIcon(C_entry);
        }else{
            this.BossBoard[Turn].setIcon(B_entry);
        }
    }
    
    public void ResetBoard(){
        ImageIcon EmptyEntry = new ImageIcon("src/main/java/images/ResultBoard/empty_entry.png");
        
        for(int i=1; i<=10; i++){
                this.PlayerBoard[i].setIcon(EmptyEntry);
                this.BossBoard[i].setIcon(EmptyEntry);
            }
    }
}
