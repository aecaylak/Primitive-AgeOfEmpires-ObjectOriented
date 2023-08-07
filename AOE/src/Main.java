import java.lang.invoke.SwitchPoint;

public class Main {
    public static void main(String[] args) throws AgeOfEmpiresException {

        Game g = new Game(3);

        g.getPlayer(0).getWorker(0).move(4, 1);
        g.getPlayer(1).pass();
        g.getPlayer(2).pass();
        g.getPlayer(0).purchase(new Cavalry());
        g.getPlayer(1).pass();
        g.getPlayer(2).pass();
        g.getPlayer(0).getSoldier(0).move(1, 10);
        g.getPlayer(1).pass();
        g.getPlayer(2).purchase(new Archer());
        g.getPlayer(0).getSoldier(0).move(1, 19);
        g.getPlayer(1).pass();
        g.getPlayer(2).getSoldier(0).move(1, 48);
        g.getPlayer(0).getSoldier(0).move(1, 28);
        g.getPlayer(1).pass();
        g.getPlayer(2).getSoldier(0).move(1, 46);
        g.getPlayer(0).getSoldier(0).move(1, 37);
        g.getPlayer(1).pass();
        g.getPlayer(2).getSoldier(0).move(1, 44);
        g.getPlayer(0).getSoldier(0).move(1, 43);
        g.getPlayer(1).pass();
        g.getPlayer(2).getSoldier(0).move(1, 42);
        g.getPlayer(0).getSoldier(0).attack(1, 42);
        g.getPlayer(1).pass();
        g.getPlayer(2).pass();
        g.getPlayer(0).getSoldier(0).move(1, 49);
        g.getPlayer(1).pass();
        g.getPlayer(2).getWorker(0).move(3, 50);

        for (int i = 0; i < 19; i++) {
            g.getPlayer(0).getSoldier(0).attack(1, 50);
            g.getPlayer(1).pass();
            g.getPlayer(2).pass();
        }

        g.getPlayer(0).getSoldier(0).attack(1, 50);

        g.getPlayer(1).pass();

        g.getPlayer(0).getSoldier(0).move(10, 49);
        g.getPlayer(1).pass();
        g.getPlayer(0).getSoldier(0).move(19, 49);
        g.getPlayer(1).pass();
        g.getPlayer(0).getSoldier(0).move(28, 49);
        g.getPlayer(1).pass();
        g.getPlayer(0).getSoldier(0).move(37, 49);
        g.getPlayer(1).pass();
        g.getPlayer(0).getSoldier(0).move(46, 49);
        g.getPlayer(1).pass();
        g.getPlayer(0).getSoldier(0).move(55, 49);
        g.getPlayer(1).pass();
        g.getPlayer(0).getSoldier(0).move(64, 49);
        g.getPlayer(1).pass();
        g.getPlayer(0).getSoldier(0).move(73, 49);
        g.getPlayer(1).pass();
        g.getPlayer(0).getSoldier(0).move(82, 49);
        g.getPlayer(1).pass();
        g.getPlayer(0).getSoldier(0).move(91, 49);
        g.getPlayer(1).pass();
        g.getPlayer(0).getSoldier(0).move(100, 49);
        g.getPlayer(1).pass();


        g.getMap().print();


    }
}
