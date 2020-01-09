import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*******************/
// #run
// java Game boss.txt player.txt result.txt 10
// 
/*******************/

class Player{
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


class Game{
    int NumOfTurn;

    Player player;
    Player boss;

    BufferedOutputStream bs = null;

    /* Constructor */
    public Game(String boss, String player, String output, int NumOfTurn) throws IOException{
        this.boss = new Player(boss);

        this.player = new Player(player);

        this.bs = new BufferedOutputStream(new FileOutputStream(output));

        this.NumOfTurn = NumOfTurn;
    }

    /* Play one turn */
    public void play() throws Exception{
        System.out.println(this.NumOfTurn + " turn left...");
        StringBuffer result = new StringBuffer();

        if(this.player.getAction() && this.boss.getAction()){ // C - C
            this.player.addScore(300);
            this.boss.addScore(300);
            result.append("C C ");
        }else if(!(this.player.getAction()) && this.boss.getAction()){
            this.player.addScore(400);
            this.boss.addScore(-200);
            result.append("B C ");
        }else if(this.player.getAction() && !(this.boss.getAction())){
            this.player.addScore(-200);
            this.boss.addScore(400);
            result.append("C B ");
        }else{
            this.player.addScore(-300);
            this.boss.addScore(-300);
            result.append("B B ");
        }
        System.out.print(result.toString() + Integer.toString(this.boss.getCurrentID())+"\n");

        /* Move Next State */
        this.player.moveNextState(this.boss.getAction());
        this.boss.moveNextState(this.player.getAction());
        
        /* File Write */
        this.bs.write(result.toString().getBytes());
        this.NumOfTurn--;
    }

    public void EndGame() throws Exception{
        String final_score = Integer.toString(this.player.getScore()) + " " + Integer.toString(this.boss.getScore());
        this.bs.write(final_score.getBytes());
        this.bs.close();
    }

}

/* class which has the 'main' method */
class Play{
    public static void main(String[] argv){
        Game game = null;
        try {
            game = new Game(argv[0], argv[1], argv[2], Integer.valueOf(argv[3]));
        } catch(Exception e){
            e.printStackTrace();
        }

        for(int i = 0; i < Integer.valueOf(argv[3]); i++){
            try{
                game.play();
            } catch(Exception e){
                e.printStackTrace();
            }
        }
        
        try{
            game.EndGame();
        } catch(Exception e){
            e.printStackTrace();
        }
        
        
        
    }
}