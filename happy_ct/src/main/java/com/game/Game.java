package com.game;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*******************/
// #run
// java Game player.txt boss.txt result.txt 10
// 
/*******************/

public class Game{
    int CurrentTurn;
    int MAXTurn;

    String resetBoss;
    String resetPlayer;

    Player player;
    Player boss;

    BufferedOutputStream bs = null;

    /* Constructor */
    public Game(String player, String boss, String output, int NumOfTurn) throws IOException{
        resetBoss = boss;
        resetPlayer = player;
        
        this.player = new Player(resetPlayer);
        this.boss = new Player(resetBoss);

        this.bs = new BufferedOutputStream(new FileOutputStream(output));

        this.MAXTurn = NumOfTurn;
        this.CurrentTurn = 0;
    }

    public void resetGame() {
        System.out.println("reset!!");
        this.CurrentTurn = 0;
        this.boss = new Player(resetBoss);
        this.player = new Player(resetPlayer);
    }

    /* Play one turn */
    public void play() throws Exception{
        if(this.player.getCurrentID() == -1){
            this.player.current_stateID = 0;
            this.boss.current_stateID = 0;
            
            String result = CompareAction(this.getPlayer().getAction(), this.getBoss().getAction());
            
             /* File Write */
            this.bs.write(result.getBytes());
            this.CurrentTurn++;
            
            return;
        }
        
        /* Reach the Last Turn */
        if(this.CurrentTurn > this.MAXTurn){
            return;
        }
                
        String result = CompareAction(this.getPlayer().getAction(), this.getBoss().getAction());

        /* Move Next State */
        boolean current_boss = this.boss.getAction();
        boolean current_player = this.player.getAction();

        this.player.moveNextState(current_boss);
        this.boss.moveNextState(current_player);
       
        
        /* File Write */
        this.bs.write(result.getBytes());
        this.CurrentTurn++;
    }
    
    /* Compare with each player Action & Add Score */
    public String CompareAction(boolean PlayerAction, boolean BossAction){
        String Result;
        if(PlayerAction && BossAction){ // C - C
            this.player.addScore(2);
            this.boss.addScore(2);
            Result = "C C \n";
        }
        else if(!(PlayerAction) && BossAction){
            this.player.addScore(3);
            this.boss.addScore(0);
            Result = "B C \n";
        }
        else if(PlayerAction && !(BossAction)){
            this.player.addScore(0);
            this.boss.addScore(3);
            Result = "C B \n";
        }else{
            this.player.addScore(1);
            this.boss.addScore(1);
            Result = "B B \n" ;
        }
        Result = Integer.toString(this.CurrentTurn) + " " + Result;
        
        System.out.println(this.CurrentTurn + " Turn... ");
        System.out.println(Result);
        return Result;
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

    public int getMAXTurn() { return this.MAXTurn; }
    public int getCurrentTurn() {return this.CurrentTurn; }
    public void printCurrentID() {
        System.out.println(this.player.getCurrentID());        
        System.out.println(this.boss.getCurrentID());
    }
}