public class Worker extends Human implements WorkerInterface {
    int lifePoints = 2;
    int x;
    int y;

    int damage1 = 1;

    int attackX;
    int attackY;
    Map map;
    String symbol = "W";
    Player player;
    int towerCount = 0;

    Building building;

    Worker() {

    }

    Worker(Map map, int x, int y, Player player) {
        this.player = player;
        this.map = map;
        this.map.map[x][y].human = this;
        this.x = x;
        this.y = y;

    }


    @Override
    public void attack(int y, int x) throws AgeOfEmpiresException {
        this.attackX = (x - 1);
        this.attackY = (y - 1);

            if ((this.x >= attackX - 1 & this.x <= attackX + 1) & (this.y <= attackY + 1 & this.y >= attackY - 1) & player.turnController() ) {
                if (map.map[attackX][attackY].building != null && map.map[attackX][attackY].building.getPlayer() != this.player) {

                    map.map[attackX][attackY].building.setLifePoints(map.map[attackX][attackY].building.getLifePoints() - damage1);

                    if (map.map[attackX][attackY].building.getLifePoints() <= 0) {
                        map.map[attackX][attackY].building.death();

                    } else {
                        map.map[attackX][attackY].building.reattack(this.y + 1, this.x + 1);
                    }

                } else if (map.map[attackX][attackY].human != null && map.map[attackX][attackY].human.getClass() == Spearman.class && map.map[attackX][attackY].human.getPlayer() != this.player) {

                    map.map[attackX][attackY].human.attack2(this.y + 1, this.x + 1);

                } else if (map.map[attackX][attackY].human != null && map.map[attackX][attackY].human.getPlayer() != this.player) {

                    map.map[attackX][attackY].human.setLifePoints(map.map[attackX][attackY].human.getLifePoints() - damage1);
                    if (map.map[attackX][attackY].human.getLifePoints() <= 0) {
                        map.map[attackX][attackY].human.death();

                    } else {
                        map.map[attackX][attackY].human.reattack(this.y + 1, this.x + 1);
                    }


                } else {
                    throw new AgeOfEmpiresException();
                }
            } else {
                throw new AgeOfEmpiresException();
            }

    }

    public void reattack(int y, int x) {
        this.attackX = (x - 1);
        this.attackY = (y - 1);

        if ((this.x >= attackX - 1 & this.x <= attackX + 1) & (this.y <= attackY + 1 & this.y >= attackY - 1)) {

            if (map.map[attackX][attackY].building != null) {


                map.map[attackX][attackY].building.setLifePoints(map.map[attackX][attackY].building.getLifePoints() - damage1);


            } else if (map.map[attackX][attackY].human != null) {

                map.map[attackX][attackY].human.setLifePoints(map.map[attackX][attackY].human.getLifePoints() - damage1);

            }

        }


    }


    @Override
    public void move(int y, int x) throws AgeOfEmpiresException {
        int oldX = this.x;
        int oldY = this.y;
        this.x = (x - 1);
        this.y = (y - 1);

            if(player.turnController()){
                if (map.map[this.x][this.y].human == null & map.map[this.x][this.y].building == null) { //kod p
                    if (this.x <= oldX + 3 & this.x >= oldX - 3 & this.y == oldY) {
                        map.map[this.x][this.y].human = this;
                        map.map[oldX][oldY].human = null;
                    } else if ((this.x >= oldX - 2 & this.x <= oldX + 2) & (this.y == oldY + 1 || this.y == oldY - 1)) {
                        map.map[this.x][this.y].human = this;
                        map.map[oldX][oldY].human = null;
                    } else if ((this.x >= oldX - 1 & this.x <= oldX + 1) & (this.y == oldY + 2 || this.y == oldY - 2)) {
                        map.map[this.x][this.y].human = this;
                        map.map[oldX][oldY].human = null;
                    } else if ((this.x == oldX) & (this.y == oldY + 3 || this.y == oldY - 3)) {
                        map.map[this.x][this.y].human = this;
                        map.map[oldX][oldY].human = null;
                    } else {
                        throw new AgeOfEmpiresException();
                    }
                } else {
                    throw new AgeOfEmpiresException();
                }
            }else {
                throw new AgeOfEmpiresException();
            }
    }

    @Override
    public void build(Building b) throws AgeOfEmpiresException {
        if(player.turnController()){
            this.building = b;

                if (building.getClass() == University.class && this.player.getGold() - 50 >= 0 && this.player.getWood() - 30 >= 0 && this.player.getStone() - 5 >= 0) {
                    this.map.map[this.x][this.y].building = new University(this.player);
                    this.map.map[this.x][this.y].building.setX(this.x);
                    this.map.map[this.x][this.y].building.setY(this.y);
                    this.player.setGold(this.player.getGold() - 50);
                    this.player.setWood(this.player.getWood() - 30);
                    this.player.setStone(this.player.getStone() - 5);

                } else if (building.getClass() == Tower.class && this.player.getGold() - 5 >= 0 && this.player.getWood() - 10 >= 0 && this.player.getStone() - 40 >= 0) {
                    player.towers.add(new Tower(player, this.x, this.y));
                    this.player.getTower(towerCount).setX(this.x);
                    this.player.getTower(towerCount).setY(this.y);
                    this.player.setTowerCount(towerCount++); //1


                    this.player.setGold(this.player.getGold() - 5);
                    this.player.setWood(this.player.getWood() - 10);
                    this.player.setStone(this.player.getStone() - 40);
                } else {
                    throw new AgeOfEmpiresException();
                }

        }
    }


    public void death(){
        player.workers.remove(this);
        player.map.map[this.x][this.y].human = null;
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

    public void setLifePoints(int lifePoints) {
        this.lifePoints = lifePoints;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Player getPlayer() {
        return player;
    }
}
