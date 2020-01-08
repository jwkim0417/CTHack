/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.CTGUI;

import java.awt.Dimension;

import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.*;

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
   
    JTable Board;
    JScrollPane jscroll;
    
    /* constructor */
    public ResultBoard(){
        Image image;
        try{
            // File path Problem??
            // ref1: https://pkss.tistory.com/entry/JTable%EC%97%90-%EC%9D%B4%EB%AF%B8%EC%A7%80-%EB%84%A3%EA%B8%B0
            // ref2: https://stackoverflow.com/questions/25378231/cant-add-image-using-imageicon-to-jtable-cell
            image = ImageIO.read(new File("src/main/java/images/bg.jpg"));
        } catch(IOException e){
            return;
        }
        ImageIcon test = new ImageIcon(image);

        String[] headings = {" ", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        Object[][] data = {
            {"Player 1", test, "", "", "", "", "", "", "", "", ""}, 
            {"Boss", "", "", "", "", "", "", "", "", "", ""}, 
        };
        DefaultTableModel model = new DefaultTableModel(data, headings)
        {
            @Override
            public Class getColumnClass(int column){
                switch(column){
                    case 0:
                    case 1: return Integer.class;
                    case 2: return ImageIcon.class;
                    default: return Object.class;
                }
            }
        };
        this.Board = new JTable(model);

        /* JTable header & entry center-alignment */
        DefaultTableCellRenderer celAlignCenter = new DefaultTableCellRenderer();
        celAlignCenter.setHorizontalAlignment(SwingConstants.CENTER);
        Board.getTableHeader().setDefaultRenderer(celAlignCenter);
        TableColumnModel tcm = Board.getColumnModel();
        
        for(int i=0; i < tcm.getColumnCount(); i++){
            tcm.getColumn(i).setCellRenderer(celAlignCenter);
        }
        
        this.jscroll = new JScrollPane(Board);
        this.jscroll.setPreferredSize(new Dimension(1000, 200));
        this.setPreferredSize(new Dimension(1500, 300));

        this.add(this.jscroll);     // add to JPanel;
    }
    
    /* Record the B/C result in the Board Table */
    public void RecordResult(int Turn, String result1, String result2){
        this.Board.setValueAt(result1, 0, Turn);
        this.Board.setValueAt(result2, 1, Turn);
    }
}
