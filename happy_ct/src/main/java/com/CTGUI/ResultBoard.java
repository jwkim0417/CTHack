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


/**

/**
 *
 * @author hsy4462
 */
public class ResultBoard extends JPanel {
   
    JTable Board;
    JScrollPane jscroll;
    
    String[] headings = {" ", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
    String[][] data = {
        {"Player 1", "", "", "", "", "", "", "", "", "", ""}, 
        {"Boss", "", "", "", "", "", "", "", "", "", ""}, 
    };
    
    /* constructor */
    public ResultBoard(){
        this.Board = new JTable(data, headings);
        
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
