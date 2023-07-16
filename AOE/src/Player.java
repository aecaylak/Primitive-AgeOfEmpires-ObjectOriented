import java.io.Serializable;
import java.util.ArrayList;

public class Player implements PlayerInterface, Serializable {

    Map map;

    int infantryBoost;
    int cavalryBoost;
    int catapultBoost;
    MainBuilding mainBuilding;

    private int Wood = 100;
    private int Gold = 100;
    private int Stone = 100;
    private int TowerCount = 0;
    private int WorkerCount = 1;
    private int SoldierCount = 0;
    ArrayList<Soldier> soldiers = new ArrayList<>();
    ArrayList<Worker> workers = new ArrayList<>();
    ArrayList<Tower> towers = new ArrayList<>();


    University university;
    Game g;

    int playerSira; //1-2-3-4 diye tutulur

    Player(Map map, int i, Game game) {
        this.map = map;
        this.playerSira = i + 1;
        this.g = game;
    }

    public void firstWorker() {
        workers.add(new Worker(map, mainBuilding.getX(), mainBuilding.getY(), this));

    }

    public void lose(){
        for (int i =0; i<workers.size();i++){
            map.map[workers.get(i).getX()][workers.get(i).getY()].human=null;
        }
        for (int i =0; i<soldiers.size();i++){
            map.map[soldiers.get(i).getX()][soldiers.get(i).getY()].human=null;
        }
        for (int i =0; i<towers.size();i++){
            map.map[towers.get(i).getX()][towers.get(i).getY()].building=null;
        }
        map.map[university.getX()][university.getY()].building=null;
        map.map[mainBuilding.getX()][mainBuilding.getY()].building = null;

        if(g.player.size() == 2) {
            System.out.println("Oyun bitti");
        }
        g.player.remove(this);
    }
    @Override
    public void pass() {
        turnController();
    }

    public boolean turnController() {
        if (g.turnControl(playerSira)) {
            Gold += 2;
            Wood += 10;
            Stone += 5;
            return true;
        } else {
            Gold += 2;
            Wood += 10;
            Stone += 5;
            return true;
        }
    }

    @Override
    public void purchase(Item item) {
        try {
            if (getSoldierCount() + getWorkerCount() < 20 && turnController()) {
                if (item.getClass() == Worker.class) {
                    if (Gold - 1 >= 0) {
                        workers.add(new Worker(map, mainBuilding.getX(), mainBuilding.getY(), this));
                        Gold -= 1;
                        WorkerCount++;
                    } else {
                        throw new AgeOfEmpiresException();
                    }
                } else if (item.getClass() == Swordman.class) {
                    if (Gold - 2 >= 0 && Wood - 5 >= 0) {
                        soldiers.add(new Swordman(map, mainBuilding.getX(), mainBuilding.getY(), infantryBoost, this));
                        Gold -= 2;
                        Wood -= 5;
                        SoldierCount++;
                    } else {
                        throw new AgeOfEmpiresException();
                    }
                } else if (item.getClass() == Archer.class) {
                    if (Gold - 2 >= 0 && Wood - 5 >= 0) {
                        soldiers.add(new Archer(map, mainBuilding.getX(), mainBuilding.getY(), infantryBoost, this));
                        Gold -= 2;
                        Wood -= 5;
                        SoldierCount++;
                    } else {
                        throw new AgeOfEmpiresException();
                    }
                } else if (item.getClass() == Spearman.class) {
                    if (Gold - 3 >= 0 && Wood - 2 >= 0) {
                        soldiers.add(new Spearman(map, mainBuilding.getX(), mainBuilding.getY(), infantryBoost, this));
                        Gold -= 3;
                        Wood -= 2;
                        SoldierCount++;
                    } else {
                        throw new AgeOfEmpiresException();
                    }
                } else if (item.getClass() == Cavalry.class) {
                    if (Gold - 10 >= 0 && Wood - 3 >= 0) {
                        soldiers.add(new Cavalry(map, mainBuilding.getX(), mainBuilding.getY(), cavalryBoost, this));
                        Gold -= 10;
                        Wood -= 3;
                        SoldierCount++;
                    } else {
                        throw new AgeOfEmpiresException();
                    }
                } else if (item.getClass() == Catapult.class) {
                    if (Gold - 20 >= 0 && Wood - 30 >= 0 && Stone - 5 >= 0) {
                        soldiers.add(new Catapult(map, mainBuilding.getX(), mainBuilding.getY(), catapultBoost, this));
                        Gold -= 20;
                        Wood -= 30;
                        Stone -= 5;
                        SoldierCount++;
                    } else {
                        throw new AgeOfEmpiresException();
                    }
                } else {
                    throw new AgeOfEmpiresException();
                }
            } else {
                throw new AgeOfEmpiresException();
            }
            System.out.println("Human sayısı:  " + (getSoldierCount() + getWorkerCount()));
        } catch (AgeOfEmpiresException e) {
            throw new RuntimeException(e);
        }
    }

    public University getUniversity() {
        return this.university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }

    @Override
    public Tower getTower(int index) {
        return towers.get(index);
    }

    public void setTowerCount(int towerCount) {
        TowerCount = towerCount;
    }

    @Override
    public int getWood() {
        return Wood;
    }

    @Override
    public int getGold() {
        return Gold;
    }

    public void setWood(int wood) {
        Wood = wood;
    }

    public void setGold(int gold) {
        Gold = gold;
    }

    public void setStone(int stone) {
        Stone = stone;
    }

    @Override
    public int getStone() {
        return Stone;
    }

    @Override
    public int getTowerCount() {
        return TowerCount;
    }

    @Override
    public int getWorkerCount() {
        return WorkerCount;
    }

    @Override
    public int getSoldierCount() {
        return SoldierCount;
    }


    @Override
    public Soldier getSoldier(int index) {
        return soldiers.get(index);
    }

    @Override
    public Worker getWorker(int index) {
        return workers.get(index);
    }

}
