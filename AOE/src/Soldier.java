public class Soldier extends Human{
    Player player;

    int damage =1;

    public Player getPlayer() {
        return player;
    }


    public void attack2(int y, int x) throws AgeOfEmpiresException {

    }
    public void death(){
    }
    @Override
    public void attack(int x, int y) throws AgeOfEmpiresException {

    }
    @Override
    public void reattack(int x, int y) {

    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    @Override
    public void move(int y, int x) throws AgeOfEmpiresException {

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

