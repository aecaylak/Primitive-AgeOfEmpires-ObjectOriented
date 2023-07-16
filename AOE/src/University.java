public class University extends Building implements UniversityInterface {

    private int lifePoints = 30;
    private int x;
    private int y;
    private String symbol = "U";

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
                player.soldiers.get(i).setLifePoints(player.soldiers.get(i).getLifePoints() - player.infantryBoost);
                player.soldiers.get(i).setDamage(1);
            }
        }for (int i = 0; i < player.getSoldierCount(); i++) {
            if (player.soldiers.get(i).getClass() == Cavalry.class) {
                player.soldiers.get(i).setLifePoints(player.soldiers.get(i).getLifePoints() - player.cavalryBoost);
                player.soldiers.get(i).setDamage(1);
            }
        }for (int i = 0; i < player.getSoldierCount(); i++) {
            if (player.soldiers.get(i).getClass() == Catapult.class) {
                player.soldiers.get(i).setLifePoints(player.soldiers.get(i).getLifePoints() -  player.catapultBoost);
                player.soldiers.get(i).setDamage(1);

            }
        }

        player.infantryBoost = 0;
        player.cavalryBoost = 0;
        player.catapultBoost = 0;

        player.map.map[this.x][this.y].building = null;
    }

    @Override
    public void trainInfantry() {
        try {
            if (player.turnController() && player.getGold() >= 50) {
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
            if (player.turnController() && player.getGold() >= 50) {
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
            if (player.turnController() && player.getGold() >= 50) {
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
