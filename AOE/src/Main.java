public class Main {
    public static void main(String[] args) throws AgeOfEmpiresException {

        try{
            Game g = new Game(2);
            //Game g = new Game("saveBinary.txt", true);


            g.getPlayer(0).purchase(new Archer());
            g.getPlayer(1).purchase(new Cavalry());

            g.getPlayer(0).getSoldier(0).move(2, 2);
            g.getPlayer(1).getSoldier(0).move(95, 50);
            g.getPlayer(0).getSoldier(0).move(3, 2);
            g.getPlayer(1).getSoldier(0).move(90, 50);
            g.getPlayer(0).getSoldier(0).move(3, 3);

            g.getMap().print();
        } catch (AgeOfEmpiresException e) {
            throw new RuntimeException(e);
        }

//        g.getPlayer(0).getSoldier(0).move(7, 4);
//        g.getPlayer(1).getSoldier(0).move(94, 47);
//        g.getPlayer(0).getSoldier(0).move(13, 7);
//        g.getPlayer(1).getSoldier(0).move(88, 44);
//        g.getPlayer(0).getSoldier(0).move(19, 10);
//        g.getPlayer(1).getSoldier(0).move(82, 41);
//
//        g.getPlayer(0).getSoldier(0).move(25, 13);
//        g.getPlayer(1).getSoldier(0).move(76, 38);
//        g.getPlayer(0).getSoldier(0).move(31, 16);
//        g.getPlayer(1).getSoldier(0).move(70, 35);
//
//        g.getPlayer(0).getSoldier(0).move(37, 19);
//        g.getPlayer(1).getSoldier(0).move(64, 32);
//        g.getPlayer(0).getSoldier(0).move(43, 21);
//        g.getPlayer(1).getSoldier(0).move(58, 29);
//
//        g.getPlayer(0).getSoldier(0).move(49, 24);
//        g.getPlayer(1).getSoldier(0).move(52, 26);
//        g.getPlayer(0).getSoldier(0).move(51, 26);
//        g.getPlayer(1).pass();
//
//        g.getPlayer(0).getWorker(0).move(2, 2);
//        g.getPlayer(1).getWorker(0).move(99, 49);
//
//        g.getPlayer(0).getWorker(0).build(new University());
//        g.getPlayer(1).getWorker(0).build(new University());
//        g.getPlayer(0).getWorker(0).move(3, 3);
//        g.getPlayer(1).pass();
//        g.getPlayer(0).getUniversity().trainCavalry();
//        g.getPlayer(1).pass();
//
//        g.getPlayer(0).pass();
//
//        g.getPlayer(1).purchase(new Cavalry());
//        g.getPlayer(0).getSoldier(0).move(57, 29);
//        g.getPlayer(1).getSoldier(1).move(97, 50);
//        g.getPlayer(0).getSoldier(0).move(63, 32);
//        g.getPlayer(1).purchase(new Archer());
//        g.getPlayer(0).getSoldier(0).move(69, 35);
//        g.getPlayer(1).getSoldier(2).move(98, 50);
//        g.getPlayer(0).getSoldier(0).move(75, 38);
//        g.getPlayer(1).getSoldier(0).move(52, 17);
//        g.getPlayer(0).getSoldier(0).move(81, 41);
//        g.getPlayer(1).getSoldier(0).move(51, 9);
//        g.getPlayer(0).getSoldier(0).move(87, 44);
//        g.getPlayer(1).getSoldier(0).move(51, 1);
//        g.getPlayer(0).getSoldier(0).move(93, 44);
//        g.getPlayer(1).getSoldier(0).move(42, 1);
//        g.getPlayer(0).getSoldier(0).move(99, 44);
//        g.getPlayer(1).getSoldier(0).move(33, 1);
//        g.getPlayer(0).getSoldier(0).move(99, 50);
//        g.getPlayer(1).getSoldier(0).move(24, 1);
//        g.getPlayer(0).getSoldier(0).attack(100, 50);
//        g.getPlayer(1).getSoldier(0).move(15, 1);
//        g.getPlayer(1).getSoldier(0).move(6, 1);
//        for (int i = 0; i < 1; i++) {
//            g.getPlayer(0).getSoldier(0).attack(100, 50);
//            g.getPlayer(1).pass();
//        }
//        g.getPlayer(0).getSoldier(0).move(85,50);
//        g.getPlayer(1).pass();
//        g.getPlayer(0).getSoldier(0).move(96,50);








//        g.getPlayer(1).getSoldier(0).move(2,1);
//        g.getPlayer(0).getSoldier(0).attack(100,50);
//
//        g.getPlayer(1).getSoldier(0).attack(2,2);
//
//        g.getPlayer(0).getSoldier(0).attack(100,50);
//
//        g.getPlayer(1).getSoldier(0).attack(2,2);
//
//        g.getPlayer(0).getSoldier(0).attack(100,50);
//
//        g.getPlayer(1).getSoldier(0).attack(2,2);
//
//        g.getPlayer(0).getSoldier(0).attack(100,50);
//
//        g.getPlayer(1).getSoldier(0).attack(2,2);
//
//        g.getPlayer(0).getSoldier(0).attack(100,50);
//
//        g.getPlayer(1).getSoldier(0).attack(2,2);
//
//        g.getPlayer(0).getUniversity().trainCavalry();
//
//        g.getPlayer(1).getSoldier(0).attack(2,2); //UNI PATLATMA
//
//
//
//        g.getPlayer(0).getSoldier(0).attack(100,50);
//        g.getPlayer(1).getUniversity().trainCavalry();
//        g.getPlayer(0).getSoldier(0).attack(100,50);
//        g.getPlayer(1).getUniversity().trainCavalry();
//        g.getPlayer(0).getSoldier(0).attack(100,50);
//        g.getPlayer(1).pass();
//        g.getPlayer(0).getSoldier(0).attack(100,50);
////TOWER DENEME   ***LOSING DENEME***
//        g.getPlayer(1).getSoldier(0).move(3,2);
//        g.getPlayer(0).getWorker(0).build(new Tower());
//        g.getPlayer(1).getSoldier(0).attack(3,3);
//        g.getPlayer(0).getWorker(0).move(4,4);
//        g.getPlayer(1).getSoldier(0).attack(3,3);
//        g.getPlayer(0).pass();
//        g.getPlayer(1).getSoldier(0).attack(3,3);
//        g.getPlayer(0).getSoldier(0).attack(100,50);
//        g.getPlayer(1).getSoldier(0).attack(3,3);
//        g.getPlayer(0).getSoldier(0).attack(100,50);
//        g.getPlayer(1).getSoldier(0).attack(3,3);
//        g.getPlayer(0).getSoldier(0).attack(100,50);
//        g.getPlayer(1).getSoldier(0).attack(3,3);
//        g.getPlayer(0).getSoldier(0).attack(100,50);
//        g.getPlayer(1).getSoldier(0).attack(3,3);
//        g.getPlayer(0).getSoldier(0).attack(100,50);
//        g.getPlayer(1).getSoldier(0).attack(3,3);
//        g.getPlayer(0).getSoldier(0).attack(100,50);
//        g.getPlayer(1).getWorker(0).move(98,48);
        //g.getPlayer(0).getSoldier(0).attack(100,50);

//
//        System.out.println("\n GOLD: " + g.getPlayer(1).getGold());
//        System.out.println("\n WOOD: " + g.getPlayer(1).getWood());
//        System.out.println("\n STONE: " + g.getPlayer(1).getStone());

        //g.save_binary("saveBinary.txt");


    }
}
