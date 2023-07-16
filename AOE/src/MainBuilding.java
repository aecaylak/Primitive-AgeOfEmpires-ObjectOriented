public class MainBuilding extends Building{

    private int lifePoints = 100;
    private String Symbol = "M";
    Player player;

    private int x;
    private int y;

    MainBuilding(){

    }
    MainBuilding(Player player){
        this.player = player;
        player.mainBuilding = this;
    }


    public void death() {
        System.out.println(this.x + " / " + this.y);
        player.lose();
        //player.map.map[this.x][this.y].building = null; KAYBETTIN!
    }


    @Override
    public String getSymbol() {
        return Symbol;
    }

    @Override
    public int getLifePoints() {
        return lifePoints;
    }

    public void setLifePoints(int lifePoint) {
        this.lifePoints = lifePoint;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public void setX(int x) {
        this.x = x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public void setY(int y) {
        this.y = y;
    }
}
