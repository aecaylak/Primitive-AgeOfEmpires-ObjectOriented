import java.util.ArrayList;

public class Game implements GameInterface {
    Map map = new Map();

    ArrayList<Player> player = new ArrayList<>();
    int numberOfPlayer;


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

    }
}
