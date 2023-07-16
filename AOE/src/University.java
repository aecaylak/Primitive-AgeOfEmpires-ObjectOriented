public class University extends Building implements UniversityInterface {

    private int lifePoints = 30;
    private int x;
    private int y;
    private String symbol = "U";

    int infantryBoost = 0;
    int cavalryBoost = 0;
    int catapultBoost = 0;

    Soldier soldier;

    Player player;

    University() {

    }

    University(Player player) {
        this.player = player;
        this.player.setUniversity(this);
    }

    public void death() {

        for (int i = 0; i < player.getSoldierCount(); i++) {
            if (player.soldiers.get(i).getClass() != Cavalry.class && player.soldiers.get(i).getClass() != Catapult.class) {
                player.soldiers.get(i).setLifePoints(player.soldiers.get(i).getLifePoints() - infantryBoost);
                player.soldiers.get(i).setDamage(1);
            }
        }for (int i = 0; i < player.getSoldierCount(); i++) {
            if (player.soldiers.get(i).getClass() == Cavalry.class) {
                player.soldiers.get(i).setLifePoints(player.soldiers.get(i).getLifePoints() - cavalryBoost);
                player.soldiers.get(i).setDamage(1);
            }
        }for (int i = 0; i < player.getSoldierCount(); i++) {
            if (player.soldiers.get(i).getClass() == Catapult.class) {
                player.soldiers.get(i).setLifePoints(player.soldiers.get(i).getLifePoints() - catapultBoost);
                player.soldiers.get(i).setDamage(1);

            }
        }
        this.infantryBoost = 0;
        this.cavalryBoost = 0;
        this.catapultBoost = 0;
        System.out.println(this.x + " / " + this.y);
        player.map.map[this.x][this.y].building = null;
    }

    @Override
    public void trainInfantry() {
        try {
            if (player.turnController()) {
                this.player.setGold(this.player.getGold() - 50);
                player.infantryBoost++;
                for (int i = 0; i < player.getSoldierCount(); i++) {
                    if (player.soldiers.get(i).getClass() != Cavalry.class && player.soldiers.get(i).getClass() != Catapult.class) {
                        player.soldiers.get(i).setLifePoints(player.soldiers.get(i).getLifePoints() + 1);
                        player.soldiers.get(i).setDamage(player.soldiers.get(i).getDamage() + 1);
                    }
                }
            } else {
                throw new AgeOfEmpiresException();
            }
        } catch (AgeOfEmpiresException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void trainCavalry() {
        try {
            if (player.turnController()) {
                this.player.setGold(this.player.getGold() - 50);
                player.cavalryBoost++;
                for (int i = 0; i < player.getSoldierCount(); i++) {
                    if (player.soldiers.get(i).getClass() == Cavalry.class) {
                        player.soldiers.get(i).setLifePoints(player.soldiers.get(i).getLifePoints() + 1);
                        player.soldiers.get(i).setDamage(player.soldiers.get(i).getDamage() + 1);
                    }
                }
            } else {
                throw new AgeOfEmpiresException();
            }
        } catch (AgeOfEmpiresException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void trainCatapult() {
        try {
            if (player.turnController()) {
                this.player.setGold(this.player.getGold() - 50);
                player.catapultBoost++;
                for (int i = 0; i < player.getSoldierCount(); i++) {
                    if (player.soldiers.get(i).getClass() == Catapult.class) {
                        player.soldiers.get(i).setLifePoints(player.soldiers.get(i).getLifePoints() + 1);
                        player.soldiers.get(i).setDamage(player.soldiers.get(i).getDamage() + 1);

                    }
                }
            } else {
                throw new AgeOfEmpiresException();
            }
        } catch (AgeOfEmpiresException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public int getLifePoints() {
        return this.lifePoints;
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
        return symbol;
    }

}
