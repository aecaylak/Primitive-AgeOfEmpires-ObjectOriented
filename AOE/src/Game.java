import java.io.*;
import java.util.ArrayList;

public class Game implements GameInterface, Serializable {
    Map map = new Map();

    ArrayList<Player> player = new ArrayList<>();
    int numberOfPlayer;

    public Game(String filename, boolean x) {
        if(x){
            try {
                ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename));
                Game game = (Game) in.readObject();
                in.close();

                this.player = game.player;
                this.numberOfPlayer = game.numberOfPlayer;
                this.map = game.map;
                this.playerTurn = game.playerTurn;
            } catch (Exception e) {
                e.printStackTrace();
            }


        }
    }

    public Game(int NumberOfPlayers) {
        this.numberOfPlayer = NumberOfPlayers;
        try {

            if (NumberOfPlayers <= 4 && NumberOfPlayers >= 2) {

                for (int i = 0; i < NumberOfPlayers; i++) {  //templi mi yapmalıydım bilgim yok MUSTI'ye sor
                    player.add(new Player(map, i, this)) /*= new Player(map, i, this)*/;
                }

                map.MakeMap(NumberOfPlayers, player);

                for (int i = 0; i < NumberOfPlayers; i++) {  //templi mi yapmalıydım bilgim yok MUSTI'ye sor
                    player.get(i).firstWorker();
                }
            } else {
                throw new AgeOfEmpiresException();
            }
        } catch (AgeOfEmpiresException e) {
            throw new RuntimeException(e);
        }
    }

    int playerTurn = 1; //1-2-3-4 diye tutulur!

    public boolean turnControl(int x) {
        try {
            if (playerTurn == x) {
                playerTurn++;
                if (playerTurn == numberOfPlayer + 1) {
                    playerTurn = 1;
                }
                return true;
            } else {
                throw new AgeOfEmpiresException();

            }
        } catch (AgeOfEmpiresException e) {
            return false;
        }
    }

    public void turn2(){
        if(playerTurn == 1){
            playerTurn= 4;
        }else{
            playerTurn--;
        }

    }

    @Override
    public Player getPlayer(int x) {

        return player.get(x);
    }

    @Override
    public Map getMap() {
        return map;
    }


    @Override
    public void save_text(String filename) {

    }

    @Override
    public void save_binary(String filename) {
        Save saveBinary = new Save(this, filename);
        saveBinary.save_binary();
    }
}
