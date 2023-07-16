import java.io.Serializable;

public class Item implements ItemInterface, Serializable {

    Player player;

    public Player getPlayer() {
        return player;
    }

    int x;
    int y;
    Human human;
    Building building;
    int lifePoints;
    String symbol;



    public void setLifePoints(int lifePoints) {
        this.lifePoints = lifePoints;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public int getLifePoints() {
        return lifePoints;
    }

    @Override
    public String getSymbol() {
        return symbol;
    }
}
