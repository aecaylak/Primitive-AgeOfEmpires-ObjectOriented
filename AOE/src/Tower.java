public class Tower extends Building implements TowerInterface {

    Player player;

    Tower() {

    }

    Tower(Player player, int x, int y) {
        this.player = player;
        player.towers.add(this);
        this.x = x;
        this.y = y;
        player.map.map[this.x][this.y].building = this;
    }

    public void death() {
        player.towers.remove(this);
        player.map.map[this.x][this.y].building = null;
    }

    int damage2 = 2;
    int attackX;
    int attackY;
    private int lifePoints = 50;
    private String Symbol = "T";
    private int x;
    private int y;


    @Override
    public void attack(int y, int x) throws AgeOfEmpiresException {
        this.attackX = (x - 1);
        this.attackY = (y - 1);

            if (player.turnController() && ((this.x >= attackX - 7 && this.x <= attackX + 7) && (this.y == attackY)) || ((this.x >= attackX - 6 && this.x <= attackX + 6) && (this.y == attackY + 1 || this.y == attackY - 1)) || ((this.x >= attackX - 5 && this.x <= attackX + 5) && (this.y == attackY + 2 || this.y == attackY - 2)) || ((this.x >= attackX - 4 && this.x <= attackX + 4) && (this.y == attackY + 3 || this.y == attackY - 3)) || ((this.x >= attackX - 3 && this.x <= attackX + 3) && (this.y == attackY + 4 || this.y == attackY - 4)) || ((this.x >= attackX - 2 && this.x <= attackX + 2) && (this.y == attackY + 5 || this.y == attackY - 5)) || ((this.x >= attackX - 1 && this.x <= attackX + 1) && (this.y == attackY + 6 || this.y == attackY - 6)) || (this.x == attackX && (this.y == attackY + 7 || this.y == attackY - 7))) {

                if (player.map.map[attackX][attackY].building != null && player.map.map[attackX][attackY].building.getPlayer() != this.player) { //Tower Atack yazınca!


                    player.map.map[attackX][attackY].building.setLifePoints(player.map.map[attackX][attackY].building.getLifePoints() - damage2);


                    if (player.map.map[attackX][attackY].building.getLifePoints() <= 0) {
                        player.map.map[attackX][attackY].building.death();

                    } else {
                        player.map.map[attackX][attackY].building.reattack(this.y + 1, this.x + 1);
                    }

                } else if (player.map.map[attackX][attackY].human != null && player.map.map[attackX][attackY].human.getClass() == Spearman.class && player.map.map[attackX][attackY].human.getPlayer() != this.player) { //Tower Atack yazınca!

                    player.map.map[attackX][attackY].human.reattack(this.y + 1, this.x + 1);

                } else if (player.map.map[attackX][attackY].human != null && player.map.map[attackX][attackY].human.getPlayer() != this.player) {

                    player.map.map[attackX][attackY].human.setLifePoints(player.map.map[attackX][attackY].human.getLifePoints() - damage2);
                    if (player.map.map[attackX][attackY].human.getLifePoints() <= 0) {
                        player.map.map[attackX][attackY].human.death();

                    } else {
                        player.map.map[attackX][attackY].human.reattack(this.y + 1, this.x + 1);
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

        if (((this.x >= attackX - 7 & this.x <= attackX + 7) & (this.y == attackY) & this.x != attackX) || ((this.x >= attackX - 6 & this.x <= attackX + 6) & (this.y == attackY + 1 || this.y == attackY - 1)) || ((this.x >= attackX - 5 & this.x <= attackX + 5) & (this.y == attackY + 2 || this.y == attackY - 2)) || ((this.x >= attackX - 4 & this.x <= attackX + 4) & (this.y == attackY + 3 || this.y == attackY - 3)) || ((this.x >= attackX - 3 & this.x <= attackX + 3) & (this.y == attackY + 4 || this.y == attackY - 4)) || ((this.x >= attackX - 2 & this.x <= attackX + 2) & (this.y == attackY + 5 || this.y == attackY - 5)) || ((this.x >= attackX - 1 & this.x <= attackX + 1) & (this.y == attackY + 6 || this.y == attackY - 6)) || (this.x == attackX & (this.y == attackY + 7 || this.y == attackY - 7))) {

            if (player.map.map[attackX][attackY].building != null) {


                player.map.map[attackX][attackY].building.setLifePoints(player.map.map[attackX][attackY].building.getLifePoints() - damage2);

                if (player.map.map[attackX][attackY].building.getLifePoints() <= 0) {
                    player.map.map[attackX][attackY].building.death();

                }

            } else if (player.map.map[attackX][attackY].human != null) {

                player.map.map[attackX][attackY].human.setLifePoints(player.map.map[attackX][attackY].human.getLifePoints() - damage2);
                if (player.map.map[attackX][attackY].human.getLifePoints() <= 0) {
                    player.map.map[attackX][attackY].human.death();

                }


            }
        }


    }


    @Override
    public int getLifePoints() {
        return lifePoints;
    }

    public void setLifePoints(int lifePoints) {
        this.lifePoints = lifePoints;
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

    @Override
    public String getSymbol() {
        return Symbol;
    }

}
