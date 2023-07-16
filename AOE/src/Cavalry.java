public class Cavalry extends Soldier {
    int lifePoints = 20;
    int x;
    int y;
    Map map;
    String symbol = "A";
    int attackX;
    int attackY;
    int damage = 1;
    Player player;

    Cavalry() {

    }

    Cavalry(Map map, int x, int y, int boost, Player player) {
        this.player = player;
        this.damage += boost;
        this.lifePoints += boost;
        this.map = map;
        this.map.map[x][y].human = this;
        this.x = x;
        this.y = y;
    }

    public void death() {
        player.soldiers.remove(this);
        player.map.map[this.x][this.y].human = null;
    }

    @Override
    public void move(int y, int x) {
        int oldX = this.x;
        int oldY = this.y;
        this.x = x - 1;
        this.y = y - 1;
        try {
            if (player.turnController() && map.map[this.x][this.y].human == null && map.map[this.x][this.y].building == null) {
                if (this.x <= oldX + 9 & this.x >= oldX - 9 & this.y == oldY) {
                    map.map[this.x][this.y].human = this;
                    map.map[oldX][oldY].human = null;
                } else if ((this.x >= oldX - 8 && this.x <= oldX + 8) && (this.y == oldY + 1 || this.y == oldY - 1)) {
                    map.map[this.x][this.y].human = this;
                    map.map[oldX][oldY].human = null;
                } else if ((this.x >= oldX - 7 && this.x <= oldX + 7) && (this.y == oldY + 2 || this.y == oldY - 2)) {
                    map.map[this.x][this.y].human = this;
                    map.map[oldX][oldY].human = null;
                } else if ((this.x >= oldX - 6 && this.x <= oldX + 6) && (this.y == oldY + 3 || this.y == oldY - 3)) {
                    map.map[this.x][this.y].human = this;
                    map.map[oldX][oldY].human = null;
                } else if ((this.x >= oldX - 5 && this.x <= oldX + 5) && (this.y == oldY + 4 || this.y == oldY - 4)) {
                    map.map[this.x][this.y].human = this;
                    map.map[oldX][oldY].human = null;
                } else if ((this.x >= oldX - 4 && this.x <= oldX + 4) && (this.y == oldY + 5 || this.y == oldY - 5)) {
                    map.map[this.x][this.y].human = this;
                    map.map[oldX][oldY].human = null;
                } else if ((this.x >= oldX - 3 && this.x <= oldX + 3) && (this.y == oldY + 6 || this.y == oldY - 6)) {
                    map.map[this.x][this.y].human = this;
                    map.map[oldX][oldY].human = null;
                } else if ((this.x >= oldX - 2 && this.x <= oldX + 2) && (this.y == oldY + 7 || this.y == oldY - 7)) {
                    map.map[this.x][this.y].human = this;
                    map.map[oldX][oldY].human = null;
                } else if ((this.x >= oldX - 1 && this.x <= oldX + 1) && (this.y == oldY + 8 || this.y == oldY - 8)) {
                    map.map[this.x][this.y].human = this;
                    map.map[oldX][oldY].human = null;
                } else if ((this.x == oldX) && (this.y == oldY + 9 || this.y == oldY - 9)) {
                    map.map[this.x][this.y].human = this;
                    map.map[oldX][oldY].human = null;
                } else {
                    throw new AgeOfEmpiresException();
                }
            } else {
                throw new AgeOfEmpiresException();
            }
        } catch (AgeOfEmpiresException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void attack(int y, int x) {
        this.attackX = (x - 1);
        this.attackY = (y - 1);//kod parametreli oldu
        try {
            if (player.turnController() && (this.x >= attackX - 1 && this.x <= attackX + 1) && (this.y <= attackY + 1 && this.y >= attackY - 1)) {
                if (map.map[attackX][attackY].building != null && map.map[attackX][attackY].building.getPlayer() != this.player) { //Tower Atack yazınca!

                    System.out.println("bos degil: " + map.map[attackX][attackY].building.getClass() + " / " + map.map[attackX][attackY].building.getLifePoints());

                    map.map[attackX][attackY].building.setLifePoints(map.map[attackX][attackY].building.getLifePoints() - (damage + 4));

                    System.out.println("bos degil: " + map.map[attackX][attackY].building.getClass() + " / " + map.map[attackX][attackY].building.getLifePoints());

                    if (map.map[attackX][attackY].building.getLifePoints() <= 0) {
                        map.map[attackX][attackY].building.death();

                    } else {
                        map.map[attackX][attackY].building.reattack(this.y + 1, this.x + 1);
                    }

                } else if (map.map[attackX][attackY].human != null && map.map[attackX][attackY].human.getClass() == Spearman.class && map.map[attackX][attackY].human.getPlayer() != this.player) {

                    map.map[attackX][attackY].human.attack2(this.y + 1, this.x + 1);

                } else if (map.map[attackX][attackY].human != null && map.map[attackX][attackY].human.getClass() == Cavalry.class && map.map[attackX][attackY].human.getPlayer() != this.player) {

                    System.out.println("bos degil: " + map.map[attackX][attackY].human.getClass() + " / " + map.map[attackX][attackY].human.getLifePoints());
                    map.map[attackX][attackY].human.setLifePoints(map.map[attackX][attackY].human.getLifePoints() - (damage + 4));
                    System.out.println("bos degil: " + map.map[attackX][attackY].human.getClass() + " / " + map.map[attackX][attackY].human.getLifePoints());
                    if (map.map[attackX][attackY].human.getLifePoints() <= 0) {
                        map.map[attackX][attackY].human.death();

                    } else {
                        map.map[attackX][attackY].human.reattack(this.y + 1, this.x + 1);
                    }

                } else if (map.map[attackX][attackY].human != null && map.map[attackX][attackY].human.getPlayer() != this.player) {

                    System.out.println("bos degil: " + map.map[attackX][attackY].human.getClass() + " / " + map.map[attackX][attackY].human.getLifePoints());
                    map.map[attackX][attackY].human.setLifePoints(map.map[attackX][attackY].human.getLifePoints() - (damage + 9));
                    System.out.println("bos degil: " + map.map[attackX][attackY].human.getClass() + " / " + map.map[attackX][attackY].human.getLifePoints());
                    if (map.map[attackX][attackY].human.getLifePoints() <= 0) {
                        map.map[attackX][attackY].human.death();

                    } else {
                        map.map[attackX][attackY].human.reattack(this.y + 1, this.x + 1);
                    }

                } else {
                    System.out.println("bos");
                    throw new AgeOfEmpiresException();
                }
            } else {
                System.out.println("bos");
                throw new AgeOfEmpiresException();
            }


        } catch (AgeOfEmpiresException e) {
            throw new RuntimeException(e);
        }

    }

    public void reattack(int y, int x) {
        this.attackX = (x - 1);
        this.attackY = (y - 1);//kod parametreli oldu

        if ((this.x >= attackX - 1 && this.x <= attackX + 1) && (this.y <= attackY + 1 && this.y >= attackY - 1)) {
            if (map.map[attackX][attackY].building != null) { //Tower Atack yazınca!

                System.out.println("bos degil: " + map.map[attackX][attackY].building.getClass() + " / " + map.map[attackX][attackY].building.getLifePoints());

                map.map[attackX][attackY].building.setLifePoints(map.map[attackX][attackY].building.getLifePoints() - (damage + 4));

                System.out.println("bos degil: " + map.map[attackX][attackY].building.getClass() + " / " + map.map[attackX][attackY].building.getLifePoints());

                if (map.map[attackX][attackY].building.getLifePoints() <= 0) {
                    map.map[attackX][attackY].building.death();

                }

            } else if (map.map[attackX][attackY].human != null && map.map[attackX][attackY].human.getClass() == Cavalry.class) {

                System.out.println("bos degil: " + map.map[attackX][attackY].human.getClass() + " / " + map.map[attackX][attackY].human.getLifePoints());
                map.map[attackX][attackY].human.setLifePoints(map.map[attackX][attackY].human.getLifePoints() - (damage + 4));
                System.out.println("bos degil: " + map.map[attackX][attackY].human.getClass() + " / " + map.map[attackX][attackY].human.getLifePoints());
                if (map.map[attackX][attackY].human.getLifePoints() <= 0) {
                    map.map[attackX][attackY].human.death();

                }

            } else if (map.map[attackX][attackY].human != null) {

                System.out.println("bos degil: " + map.map[attackX][attackY].human.getClass() + " / " + map.map[attackX][attackY].human.getLifePoints());
                map.map[attackX][attackY].human.setLifePoints(map.map[attackX][attackY].human.getLifePoints() - (damage + 9));
                System.out.println("bos degil: " + map.map[attackX][attackY].human.getClass() + " / " + map.map[attackX][attackY].human.getLifePoints());
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
    public void setLifePoints(int lifePoints) {
        this.lifePoints = lifePoints;
    }

    public Player getPlayer() {
        return player;
    }

    @Override
    public int getLifePoints() {
        return lifePoints;
    }

    @Override
    public String getSymbol() {
        return symbol;
    }

    @Override
    public int getDamage() {
        return damage;
    }

    @Override
    public void setDamage(int damage) {
        this.damage = damage;
    }
}
