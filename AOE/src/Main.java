public class Main {
    public static void main(String[] args) throws AgeOfEmpiresException {

        Game g = new Game(2);
        //Game g = new Game("saveBinary.txt", true);
        g.getPlayer(0).purchase(new Archer());
        g.getPlayer(1).purchase(new Archer());

        g.getPlayer(0).getSoldier(0).move(2, 2);
        g.getPlayer(1).getSoldier(0).move(98, 50);

        try{

            g.getPlayer(0).getSoldier(0).move(8, 2); //HATALI


        } catch (AgeOfEmpiresException e) {

        }
        g.getPlayer(0).getSoldier(0).move(3, 2);

        g.getPlayer(1).purchase(new Catapult());
        g.getPlayer(0).pass();

        try{
            g.getPlayer(1).getSoldier(1).move(95, 50); //HATALI

        } catch (AgeOfEmpiresException e) {

        }
        g.getPlayer(1).getSoldier(1).move(99, 50);

        //g.getPlayer(0).pass();


        g.getMap().print();

        //g.save_binary("saveBinary.txt");


    }
}
