package com.game;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*******************/
// #run
// java Game player.txt boss.txt result.txt 10
// 

/*******************/

public class Game {
    int ongoingTurn = 1;
    int MAXTurn;

    String resetBoss;
    String resetPlayer;

    Player player;
    Player boss;

    BufferedOutputStream bs;

    /* Constructor */
    public Game(String player, String boss, String output, int NumOfTurn) throws IOException {
        resetBoss = boss;
        resetPlayer = player;

        this.player = new Player(resetPlayer);
        this.boss = new Player(resetBoss);

        this.bs = new BufferedOutputStream(new FileOutputStream(output));

        this.MAXTurn = NumOfTurn;
    }

    public void resetGame() {
        System.out.println("reset!!");
        this.ongoingTurn = 1;
        this.boss = new Player(resetBoss);
        this.player = new Player(resetPlayer);
    }

    /* Play one turn */
    public void play() throws Exception {
        /* Reach the Last Turn */
        if (this.ongoingTurn > this.MAXTurn) {
            return;
        }

        boolean current_boss = this.boss.getAction();
        boolean current_player = this.player.getAction();

        String result = CompareAction(current_player, current_boss);
        /* Move Next State */
        this.player.moveNextState(current_boss);
        this.boss.moveNextState(current_player);
        this.ongoingTurn++;

        /* File Write */
        this.bs.write(result.getBytes());
    }

    /* Compare with each player Action & Add Score */
    public String CompareAction(boolean PlayerAction, boolean BossAction) {
        String Result = this.ongoingTurn + " ";
        Result += (PlayerAction ? "C " : "B ");
        Result += (BossAction ? "C\n" : "B\n");

        /*
        usage: reward = rewardTable[ whether you cooperate ][ whether opponent cooperate ]
        true is 1, false is 0.
         */
        int[][] rewardTable = {{1, 3},
                {0, 2}};

        int playerActionInt = (PlayerAction ? 1 : 0);
        int bossActionInt = (BossAction ? 1 : 0);

        this.player.addScore(rewardTable[playerActionInt][bossActionInt]);
        this.boss.addScore(rewardTable[bossActionInt][playerActionInt]);

        System.out.println(this.ongoingTurn + " Turn... ");
        System.out.println(Result);
        return Result;
    }

    public void EndGame() throws Exception {
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

    public int getMAXTurn() {
        return this.MAXTurn;
    }

    public int getOngoingTurn() {
        return this.ongoingTurn;
    }

    public int getPreviousTurn() {
        return this.ongoingTurn - 1;
    }

    public void printCurrentID() {
        System.out.println(this.player.getCurrentID());
        System.out.println(this.boss.getCurrentID());
    }
}