/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game;

/**
 *
 * @author hsy4462
 */

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
