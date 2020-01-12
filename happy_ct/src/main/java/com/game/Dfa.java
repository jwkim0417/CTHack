package com.game;

import java.util.ArrayList;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Dfa{
    ArrayList<State> states;

    /* constructor */
    public Dfa(String src){
        this.states = new ArrayList<State>();

        try{
            setDfa(src);
        } catch(Exception e){
            e.getStackTrace();
        }
    }

    /* DFA initialization */
    public void setDfa(String src) throws IOException{
        BufferedReader br = null;
        
        br = new BufferedReader(new FileReader(src));
        while(true){
            String line = br.readLine();
            if(line==null) break;

            /*create a state*/
            State state = null;
            int C_arc = Integer.valueOf(line.substring(2, 3));
            int B_arc = Integer.valueOf(line.substring(4, 5));

            if(line.charAt(0) == 'C'){
                state = new State(true, C_arc, B_arc);
            }else if(line.charAt(0) == 'B'){
                state = new State(false, C_arc, B_arc);
            }
            this.states.add(state);
        }
        br.close();
    }

    public boolean getAction(int stateID) {
        return this.states.get(stateID).Action;
    }

    public int getNextState(int currentID, boolean action){
        if(action){
            return this.states.get(currentID).C_arc;
        }else{
            return this.states.get(currentID).B_arc;
        }
    }
    public void printAll(){
        for(int i=0; i < this.states.size(); i++){
            System.out.print(states.get(i).Action);
            System.out.print(states.get(i).C_arc);
            System.out.print(states.get(i).B_arc);
            System.out.print("\n");
        }
    }
}

