package com.game;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*******************/
// #run
// java Game boss.txt player.txt result.txt 10
// 
/*******************/

public class Game{
    int NumOfTurn;
    int resetTurn;

    String resetBoss;
    String resetPlayer;

    Player player;
    Player boss;

    BufferedOutputStream bs = null;

    /* Constructor */
    public Game(String boss, String player, String output, int NumOfTurn) throws IOException{
        this.boss = new Player(boss);

        this.player = new Player(player);

        this.bs = new BufferedOutputStream(new FileOutputStream(output));

        this.NumOfTurn = NumOfTurn;
        this.resetTurn = NumOfTurn;
        resetBoss = boss;
        resetPlayer = player;
    }

    public void resetGame() {
        NumOfTurn = resetTurn;
        boss = new Player(resetBoss);
        player = new Player(resetPlayer);
    }

    /* Play one turn */
    public void play() throws Exception{
        System.out.println(this.NumOfTurn + " turn left...");
        StringBuffer result = new StringBuffer();

        if(this.player.getAction() && this.boss.getAction()){ // C - C
            this.player.addScore(300);
            this.boss.addScore(300);
            result.append("C C \n");
        }
        if(!(this.player.getAction()) && this.boss.getAction()){
            this.player.addScore(400);
            this.boss.addScore(-200);
            result.append("B C \n");
        }
        if(this.player.getAction() && !(this.boss.getAction())){
            this.player.addScore(-200);
            this.boss.addScore(400);
            result.append("C B \n");
        }
        if(!(this.player.getAction()) && !(this.boss.getAction())){
            this.player.addScore(-300);
            this.boss.addScore(-300);
            result.append("B B \n");
        }
        System.out.println(result.toString() + this.player.getCurrentID());

        /* Move Next State */
        boolean current_boss = this.boss.getAction();
        boolean current_player = this.player.getAction();

        this.player.moveNextState(current_boss);
        this.boss.moveNextState(current_player);
       
        
        /* File Write */
        this.bs.write(result.toString().getBytes());
        this.NumOfTurn--;
    }

    public void EndGame() throws Exception{
        String final_score = this.player.getScore() + " " + this.boss.getScore();
        this.bs.write(final_score.getBytes());
        this.bs.close();
    }
    
    public Player getPlayer() {
        return this.player;
    }
    
    public Player getBoss() {
        return this.boss;
    }

    public int getResetTurn() { return this.resetTurn; }
}