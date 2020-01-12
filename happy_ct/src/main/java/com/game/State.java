package com.game;

public class State {
    /* Cooperate = true, Betrayal = false */
    boolean Action;
    int C_arc;
    int B_arc;

    public State(boolean action, int c_arc, int b_arc){
        this.Action = action;
        this.C_arc = c_arc;
        this.B_arc = b_arc;
    }
}
