public class Human extends Item implements HumanInterface{

    Player player;

    public Player getPlayer() {
        return player;
    }


    public void death(){

    }
    public void attack2(int y, int x) throws AgeOfEmpiresException {

    }
    @Override
    public void attack(int x, int y) throws AgeOfEmpiresException {

    }

    public void reattack(int x, int y) {

    }

    @Override
    public void move(int x, int y) throws AgeOfEmpiresException {

    }


    @Override
    public int getX() {
        return 0;
    }

    @Override
    public int getY() {
        return 0;
    }

    @Override
    public int getLifePoints() {
        return 0;
    }

    @Override
    public String getSymbol() {
        return null;
    }
}
