public class Swordman extends Soldier {

    int lifePoints = 5;
    int x;
    int y;
    int attackX;
    int attackY;
    Map map;
    int damage = 1;
    String symbol = "K";
    Player player;

    Swordman() {

    }

    Swordman(Map map, int x, int y, int boost, Player player) {
        this.player = player;
        this.lifePoints += boost;
        this.damage += boost;
        this.map = map;
        this.map.map[x][y].human = this;
        this.x = x;
        this.y = y;
    }

    public void death() {
        player.soldiers.remove(this);
        player.map.map[this.x][this.y].human = null;
    }

    int toX;
    int toY;

    @Override
    public void move(int y, int x) throws AgeOfEmpiresException {
        int oldX = this.x;
        int oldY = this.y;
        this.toX = x - 1;
        this.toY = y - 1;

        if (player.turnController() & map.map[this.toX][this.toY].human == null & map.map[this.toX][this.toY].building == null) {
            if (this.toX <= oldX + 2 & this.toX >= oldX - 2 & this.toY == oldY) {
                this.x = x - 1;
                this.y = y - 1;
                map.map[this.toX][this.toY].human = this;
                map.map[oldX][oldY].human = null;
            } else if ((this.toX >= oldX - 1 & this.toX <= oldX + 1) & (this.toY == oldY + 1 || this.toY == oldY - 1)) {
                this.x = x - 1;
                this.y = y - 1;
                map.map[this.toX][this.toY].human = this;
                map.map[oldX][oldY].human = null;
            } else if ((this.toX == oldX) & (this.toY == oldY + 2 || this.toY == oldY - 2)) {
                this.x = x - 1;
                this.y = y - 1;
                map.map[this.toX][this.toY].human = this;
                map.map[oldX][oldY].human = null;
            }
            else {
                player.turn2();
                    throw new AgeOfEmpiresException();
                }
            } else {
            player.turn2();
                throw new AgeOfEmpiresException();
            }

    }

    @Override
    public void attack(int y, int x) throws AgeOfEmpiresException {
        this.attackX = (x - 1);
        this.attackY = (y - 1);

            if ((this.x >= attackX - 1 && this.x <= attackX + 1) && (this.y <= attackY + 1 && this.y >= attackY - 1) && player.turnController()) {
                if (map.map[attackX][attackY].building != null && map.map[attackX][attackY].building.getPlayer() != this.player) {


                    map.map[attackX][attackY].building.setLifePoints(map.map[attackX][attackY].building.getLifePoints() - (damage + 2));


                    if (map.map[attackX][attackY].building.getLifePoints() <= 0) {
                        map.map[attackX][attackY].building.death();

                    } else {
                        map.map[attackX][attackY].building.reattack(this.y + 1, this.x + 1);
                    }

                } else if (map.map[attackX][attackY].human != null && map.map[attackX][attackY].human.getClass() == Spearman.class && map.map[attackX][attackY].human.getPlayer() != this.player) {

                    map.map[attackX][attackY].human.attack2(this.y + 1, this.x + 1);

                } else if (map.map[attackX][attackY].human != null && map.map[attackX][attackY].human.getPlayer() != this.player) {

                    map.map[attackX][attackY].human.setLifePoints(map.map[attackX][attackY].human.getLifePoints() - (damage + 2));

                    if (map.map[attackX][attackY].human.getLifePoints() <= 0) {
                        map.map[attackX][attackY].human.death();

                    } else {
                        map.map[attackX][attackY].human.reattack(this.y + 1, this.x + 1);
                    }


                } else {
                    player.turn2();
                    throw new AgeOfEmpiresException();
                }
            } else {
                player.turn2();
                throw new AgeOfEmpiresException();
            }

    }

    public void reattack(int y, int x) {
        this.attackX = (x - 1);
        this.attackY = (y - 1);

        if ((this.x >= attackX - 1 && this.x <= attackX + 1) && (this.y <= attackY + 1 && this.y >= attackY - 1)) {

            if (map.map[attackX][attackY].building != null) {


                map.map[attackX][attackY].building.setLifePoints(map.map[attackX][attackY].building.getLifePoints() - (damage + 2));


                if (map.map[attackX][attackY].building.getLifePoints() <= 0) {
                    map.map[attackX][attackY].building.death();
                }

            } else if (map.map[attackX][attackY].human != null) {

                map.map[attackX][attackY].human.setLifePoints(map.map[attackX][attackY].human.getLifePoints() - (damage + 2));
                if (map.map[attackX][attackY].human.getLifePoints() <= 0) {
                    map.map[attackX][attackY].human.death();

                }

            }

        }


    }

    @Override
    public int getX() {
        return this.x;
    }

    @Override
    public int getY() {
        return this.y;
    }

    @Override
    public int getLifePoints() {
        return lifePoints;
    }

    @Override
    public void setLifePoints(int lifePoints) {
        this.lifePoints = lifePoints;
    }

    @Override
    public String getSymbol() {
        return symbol;
    }


    @Override
    public int getDamage() {
        return damage;
    }

    public Player getPlayer() {
        return player;
    }

    @Override
    public void setDamage(int damage) {
        this.damage = damage;
    }
}
