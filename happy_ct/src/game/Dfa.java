import java.util.ArrayList;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class State{
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

public class Dfa{
    ArrayList<State> states;
    String src; // src file path

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
            int B_arc = Integer.valueOf(line.substring(2, 3));
            int C_arc = Integer.valueOf(line.substring(4, 5));

            if(line.charAt(0) == '1'){
                state = new State(true, B_arc, C_arc);
            }else{
                state = new State(false, B_arc, C_arc);
            }
            this.states.add(state);

            //System.out.println(line);
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

}

