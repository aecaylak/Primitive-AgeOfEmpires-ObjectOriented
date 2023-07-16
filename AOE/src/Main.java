public class Main {
    public static void main(String[] args) {

        Game g = new Game(2);

        g.getPlayer(0).purchase(new Cavalry());
        g.getPlayer(1).purchase(new Cavalry());
        g.getPlayer(0).getSoldier(0).move(7,4);
        g.getPlayer(1).getSoldier(0).move(94,47);
        g.getPlayer(0).getSoldier(0).move(13,7);
        g.getPlayer(1).getSoldier(0).move(88,44);
        g.getPlayer(0).getSoldier(0).move(19,10);
        g.getPlayer(1).getSoldier(0).move(82,41);

        g.getPlayer(0).getSoldier(0).move(25,13);
        g.getPlayer(1).getSoldier(0).move(76,38);
        g.getPlayer(0).getSoldier(0).move(31,16);
        g.getPlayer(1).getSoldier(0).move(70,35);

        g.getPlayer(0).getSoldier(0).move(37,19);
        g.getPlayer(1).getSoldier(0).move(64,32);
        g.getPlayer(0).getSoldier(0).move(43,21);
        g.getPlayer(1).getSoldier(0).move(58,29);

        g.getPlayer(0).getSoldier(0).move(49,24);
        g.getPlayer(1).getSoldier(0).move(52,26);
        g.getPlayer(0).getSoldier(0).move(51,26);
        g.getPlayer(1).pass();

        g.getPlayer(0).getWorker(0).move(2,2);
        g.getPlayer(1).getWorker(0).move(99,49);

        g.getPlayer(0).getWorker(0).build(new University());
        g.getPlayer(1).getWorker(0).build(new University());
        g.getPlayer(0).getWorker(0).move(3,3);
        g.getPlayer(1).pass();
        g.getPlayer(0).getUniversity().trainCavalry();
        g.getPlayer(1).pass();

        g.getPlayer(0).pass();

        g.getPlayer(1).purchase(new Cavalry());
        g.getPlayer(0).getSoldier(0).move(57,29);
        g.getPlayer(1).getSoldier(1).move(97,50);
        g.getPlayer(0).getSoldier(0).move(63,32);
        g.getPlayer(1).purchase(new Archer());
        g.getPlayer(0).getSoldier(0).move(69,35);
        g.getPlayer(1).getSoldier(2).move(98,50);
        g.getPlayer(0).getSoldier(0).move(75,38);
        g.getPlayer(1).getSoldier(0).move(52,17);
        g.getPlayer(0).getSoldier(0).move(81,41);
        g.getPlayer(1).getSoldier(0).move(51,9);
        g.getPlayer(0).getSoldier(0).move(87,44);
        g.getPlayer(1).getSoldier(0).move(51,1);
        g.getPlayer(0).getSoldier(0).move(93,44);
        g.getPlayer(1).getSoldier(0).move(42,1);
        g.getPlayer(0).getSoldier(0).move(99,44);
        g.getPlayer(1).getSoldier(0).move(33,1);
        g.getPlayer(0).getSoldier(0).move(99,50);
        g.getPlayer(1).getSoldier(0).move(24,1);
        g.getPlayer(0).getSoldier(0).attack(100,50);
        g.getPlayer(1).getSoldier(0).move(15,1);
        g.getPlayer(0).getSoldier(0).attack(100,50);
        g.getPlayer(1).getSoldier(0).move(6,1);
        g.getPlayer(0).getSoldier(0).attack(100,50);
        g.getPlayer(1).getSoldier(0).move(2,1);
        g.getPlayer(0).getSoldier(0).attack(100,50);

        g.getPlayer(1).getSoldier(0).attack(2,2);

        g.getPlayer(0).getSoldier(0).attack(100,50);

        g.getPlayer(1).getSoldier(0).attack(2,2);

        g.getPlayer(0).getSoldier(0).attack(100,50);

        g.getPlayer(1).getSoldier(0).attack(2,2);

        g.getPlayer(0).getSoldier(0).attack(100,50);

        g.getPlayer(1).getSoldier(0).attack(2,2);

        g.getPlayer(0).getSoldier(0).attack(100,50);

        g.getPlayer(1).getSoldier(0).attack(2,2);

        g.getPlayer(0).getUniversity().trainCavalry();

        g.getPlayer(1).getSoldier(0).attack(2,2); //UNI PATLATMA



        g.getPlayer(0).getSoldier(0).attack(100,50);
        g.getPlayer(1).getUniversity().trainCavalry();
        g.getPlayer(0).getSoldier(0).attack(100,50);
        g.getPlayer(1).getUniversity().trainCavalry();
        g.getPlayer(0).getSoldier(0).attack(100,50);
        g.getPlayer(1).pass();
        g.getPlayer(0).getSoldier(0).attack(100,50);
//TOWER DENEME
        g.getPlayer(1).getSoldier(0).move(3,2);
        g.getPlayer(0).getWorker(0).build(new Tower());
        g.getPlayer(1).getSoldier(0).attack(3,3);
        g.getPlayer(0).getWorker(0).move(4,4);
        g.getPlayer(1).getSoldier(0).attack(3,3);
        g.getPlayer(0).pass();
        g.getPlayer(1).getSoldier(0).attack(3,3);
        g.getPlayer(0).getSoldier(0).attack(100,50);
        g.getPlayer(1).getSoldier(0).attack(3,3);
        g.getPlayer(0).getSoldier(0).attack(100,50);
        g.getPlayer(1).getSoldier(0).attack(3,3);
        g.getPlayer(0).getSoldier(0).attack(100,50);
        g.getPlayer(1).getSoldier(0).attack(3,3);
        g.getPlayer(0).getSoldier(0).attack(100,50);
        g.getPlayer(1).getSoldier(0).attack(3,3);
        g.getPlayer(0).getSoldier(0).attack(100,50);
        g.getPlayer(1).getSoldier(0).attack(3,3);
        g.getPlayer(0).getSoldier(0).attack(100,50);
        g.getPlayer(1).getWorker(0).move(98,48);
        g.getPlayer(0).getSoldier(0).attack(100,50);



        System.out.println(g.getPlayer(0).getGold());
        System.out.println(g.getPlayer(0).getWood());
        System.out.println(g.getPlayer(0).getStone());

        g.getMap().print();

    }
}
