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

    public Game(int NumberOfPlayers) throws AgeOfEmpiresException {
        this.numberOfPlayer = NumberOfPlayers;

            if (NumberOfPlayers <= 4 && NumberOfPlayers >= 2) {

                for (int i = 0; i < NumberOfPlayers; i++) {
                    player.add(new Player(map, i, this));
                }

                map.MakeMap(NumberOfPlayers, player);

                for (int i = 0; i < NumberOfPlayers; i++) {
                    player.get(i).firstWorker();
                }
            } else {
                throw new AgeOfEmpiresException();
            }

    }

    int playerTurn = 1;

    public boolean turnControl(int x) throws AgeOfEmpiresException {

            if (playerTurn == x) {
                playerTurn++;
                if (playerTurn == numberOfPlayer + 1) {
                    playerTurn = 1;
                }
                return true;
            } else {
                throw new AgeOfEmpiresException();
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
