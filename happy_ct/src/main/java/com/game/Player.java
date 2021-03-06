/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game;

/**
 *
 * @author Hcle
 */
public class Player {
    Dfa dfa;
    int current_stateID;
    int score;

    public Player(String dfa_path){
        this.dfa = new Dfa(dfa_path);
        this.current_stateID = 0;
        this.score = 0;
        this.dfa.printAll();
    }

    public boolean getAction(){
        return this.dfa.getAction(this.current_stateID);
    }
    public void addScore(int score){
        this.score += score;
    }
    public int getScore(){
        return this.score;
    }
    public void moveNextState(boolean action){
       this.current_stateID = this.dfa.getNextState(this.current_stateID, action);
    }
    public int getCurrentID(){
        return this.current_stateID;
    }
}
