package com.CTGUI;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.CTGUI.Controller;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author kimsj0302
 */
public class Ct_Frame extends javax.swing.JFrame {

    /**
     * Creates new form Ct_Frame
     */
    public Ct_Frame() {
        initComponents();
        cont = new Controller();
        cont.init_game();
        jButton2.setEnabled(false);
        jButton3.setEnabled(false);
        count = 0;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        fSMGraph1 = new com.CTGUI.FSMGraph();
        scoreBoard2 = new com.CTGUI.ScoreBoard();
        resultBoard2 = new com.CTGUI.ResultBoard();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        fSMGraph2 = new com.CTGUI.FSMGraph();
        left_bg1 = new com.CTGUI.left_bg();
        left_player1 = new com.CTGUI.left_player();
        fSMGraph3 = new com.CTGUI.FSMGraph();
        right_bg1 = new com.CTGUI.right_bg();
        right_player1 = new com.CTGUI.right_player();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1920, 1440));

        resultBoard2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jButton1.setText("Setup");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Play 1 turn");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Export Result");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout left_player1Layout = new javax.swing.GroupLayout(left_player1);
        left_player1.setLayout(left_player1Layout);
        left_player1Layout.setHorizontalGroup(
            left_player1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 202, Short.MAX_VALUE)
        );
        left_player1Layout.setVerticalGroup(
            left_player1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout left_bg1Layout = new javax.swing.GroupLayout(left_bg1);
        left_bg1.setLayout(left_bg1Layout);
        left_bg1Layout.setHorizontalGroup(
            left_bg1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, left_bg1Layout.createSequentialGroup()
                .addGap(0, 499, Short.MAX_VALUE)
                .addComponent(left_player1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        left_bg1Layout.setVerticalGroup(
            left_bg1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(left_player1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout right_player1Layout = new javax.swing.GroupLayout(right_player1);
        right_player1.setLayout(right_player1Layout);
        right_player1Layout.setHorizontalGroup(
            right_player1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );
        right_player1Layout.setVerticalGroup(
            right_player1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout right_bg1Layout = new javax.swing.GroupLayout(right_bg1);
        right_bg1.setLayout(right_bg1Layout);
        right_bg1Layout.setHorizontalGroup(
            right_bg1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(right_bg1Layout.createSequentialGroup()
                .addComponent(right_player1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 501, Short.MAX_VALUE))
        );
        right_bg1Layout.setVerticalGroup(
            right_bg1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(right_player1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(fSMGraph2, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(left_bg1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(right_bg1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fSMGraph3, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fSMGraph2, javax.swing.GroupLayout.DEFAULT_SIZE, 433, Short.MAX_VALUE)
            .addComponent(left_bg1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(fSMGraph3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(right_bg1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(scoreBoard2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1)
                            .addComponent(jButton2)
                            .addComponent(jButton3)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(resultBoard2, javax.swing.GroupLayout.PREFERRED_SIZE, 1385, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scoreBoard2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 152, Short.MAX_VALUE)
                .addComponent(resultBoard2, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /* Play One Turn */
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if(cont.check())
            return;
        try {
            /* FSM Graph */
            fSMGraph2.setCurrent(cont.game.getPlayer().getCurrentID() + 1, false);
            fSMGraph3.setCurrent(cont.game.getBoss().getCurrentID() + 1, false);
            fSMGraph2.repaint();
            fSMGraph3.repaint();
            fSMGraph2.revalidate();
            fSMGraph3.revalidate();

            /*
            Result board, setTurn. Record *BEFORE* play(), since game does not memorize previous states & outputs
                and play() makes the game steps forward.
             */
            resultBoard2.RecordResult(cont.game.getOngoingTurn(), cont.game.getPlayer().getAction(), cont.game.getBoss().getAction());
            System.out.println(cont.game.getPlayer().getAction());
            System.out.println(cont.game.getBoss().getAction());
            cont.command(cont.game.getPlayer().getAction(), cont.game.getBoss().getAction());
            cont.game.play();
            /* Score Board */
            scoreBoard2.setTurn(cont.game.getPreviousTurn());
            scoreBoard2.setPlayerScore(cont.game.getPlayer().getScore());
            scoreBoard2.setBossScore(cont.game.getBoss().getScore());

            if(++count == cont.game.getMAXTurn()) {
                jButton2.setEnabled(false);
                jButton3.setEnabled(true);
            }

        } catch (Exception ex) {
            Logger.getLogger(Ct_Frame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    //SETUP
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

        /* Result Board */
        resultBoard2.ResetBoard();

        cont.game.resetGame();

        /* Score Board */
        scoreBoard2.setPlayerName(cont.game.getPlayer().getName());
        scoreBoard2.setTurn(0);
        scoreBoard2.setPlayerScore(cont.game.getPlayer().getScore());
        scoreBoard2.setBossScore(cont.game.getBoss().getScore());

        /* FSM Graph */
        fSMGraph2.setGraph("src/main/java/files/player.txt");
        fSMGraph3.setGraph("src/main/java/files/boss1.txt");
        fSMGraph2.repaint();
        fSMGraph3.repaint();
        fSMGraph2.revalidate();
        fSMGraph3.revalidate();
        jButton2.setEnabled(true);
        count = 0;
        //fSMGraph3.setGraph(null);
        left_player1.init();
        right_player1.init();
        
        cont.set_lb(left_bg1);
        cont.set_rb(right_bg1);
        cont.set_lp(left_player1);
        cont.set_rp(right_player1);
        cont.set_movement();

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        try{
            cont.game.EndGame();
            jButton3.setEnabled(false);
        } catch(Exception e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Ct_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ct_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ct_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ct_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ct_Frame().setVisible(true);
            }
        });
    }
    private Controller cont;
    private int count;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.CTGUI.FSMGraph fSMGraph1;
    private com.CTGUI.FSMGraph fSMGraph2;
    private com.CTGUI.FSMGraph fSMGraph3;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private com.CTGUI.left_bg left_bg1;
    private com.CTGUI.left_player left_player1;
    private com.CTGUI.ResultBoard resultBoard2;
    private com.CTGUI.right_bg right_bg1;
    private com.CTGUI.right_player right_player1;
    private com.CTGUI.ScoreBoard scoreBoard2;
    // End of variables declaration//GEN-END:variables
}
