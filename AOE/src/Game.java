public class Game implements GameInterface {
    Map map = new Map();

    Player[] players;
    int numberOfPlayer;


    public Game(int NumberOfPlayers) {
        this.numberOfPlayer = NumberOfPlayers;
        try {

            if (NumberOfPlayers <= 4 && NumberOfPlayers >= 2) {
                players = new Player[NumberOfPlayers];

                for (int i = 0; i < NumberOfPlayers; i++) {  //templi mi yapmalıydım bilgim yok MUSTI'ye sor
                    players[i] = new Player(map, i, this);
                }

                map.MakeMap(NumberOfPlayers, players);

                for (int i = 0; i < NumberOfPlayers; i++) {  //templi mi yapmalıydım bilgim yok MUSTI'ye sor
                    players[i].firstWorker();
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

        return players[x];
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
