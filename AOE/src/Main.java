import java.lang.invoke.SwitchPoint;

public class Main {
    public static void main(String[] args) throws AgeOfEmpiresException {

        Game g = new Game(3);
        //Game g = new Game("saveBinary.txt", true);
        g.getPlayer(0).purchase(new Spearman());
        g.getPlayer(1).purchase(new Cavalry());
        g.getPlayer(2).getWorker(0).move(2,50);
        g.getPlayer(0).getSoldier(0).move(1, 2);
        g.getPlayer(1).getSoldier(0).move(98, 50);
        g.getPlayer(2).pass();
        g.getPlayer(0).pass();
        g.getPlayer(1).getSoldier(0).move(89, 50);
        g.getPlayer(2).pass();
        g.getPlayer(0).pass();
        g.getPlayer(1).getSoldier(0).move(80, 50);
        g.getPlayer(2).pass();
        g.getPlayer(0).pass();
        g.getPlayer(1).getSoldier(0).move(71, 50);
        g.getPlayer(2).pass();
        g.getPlayer(0).pass();
        g.getPlayer(1).getSoldier(0).move(62, 50);
        g.getPlayer(2).pass();
        g.getPlayer(0).pass();
        g.getPlayer(1).getSoldier(0).move(53, 50);
        g.getPlayer(2).pass();
        g.getPlayer(0).pass();
        g.getPlayer(1).getSoldier(0).move(44, 50);
        g.getPlayer(2).pass();
        g.getPlayer(0).pass();
        g.getPlayer(1).getSoldier(0).move(35, 50);
        g.getPlayer(2).pass();
        g.getPlayer(0).pass();
        g.getPlayer(1).getSoldier(0).move(26, 50);
        g.getPlayer(2).pass();
        g.getPlayer(0).pass();
        g.getPlayer(1).getSoldier(0).move(17, 50);
        g.getPlayer(2).pass();
        g.getPlayer(0).pass();
        g.getPlayer(1).getSoldier(0).move(8, 50);
        g.getPlayer(2).pass();
        g.getPlayer(0).pass();
        g.getPlayer(1).getSoldier(0).move(2, 49);
        g.getPlayer(2).pass();
        for(int q =0; q<19;q++){
            g.getPlayer(0).pass();
            g.getPlayer(1).getSoldier(0).attack(1, 50);
            g.getPlayer(2).pass();
        }
        g.getPlayer(0).pass();
        g.getPlayer(1).getSoldier(0).attack(1, 50);


        g.getMap().print();

        //g.save_binary("saveBinary.txt");


    }
}
