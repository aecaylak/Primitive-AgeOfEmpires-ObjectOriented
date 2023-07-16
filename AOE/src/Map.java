import java.io.Serializable;
import java.util.ArrayList;

public class Map implements MapInterface, Serializable {

    Item[][] map; //oyun map'i burda tutuluyor


    public void MakeMap(int NumberOfPlayers, ArrayList<Player> players){

        Item[][] tempMap = new Item[50][100]; //temp Mapte

        for(int i =0;i<50;i++){
            for (int j=0;j<100;j++){
                tempMap[i][j] = new Item();
            }
        }

        int CountMainBuilding = NumberOfPlayers;
        MainBuilding tempMB;


        for (int i =0;i<CountMainBuilding;i++){

            if(i==0){
                tempMap[0][0].building = new MainBuilding(players.get(0));
                players.get(i).mainBuilding.setX(0);
                players.get(i).mainBuilding.setY(0);



            }else if (i==1){
                tempMap[49][99].building = new MainBuilding(players.get(i));
                players.get(i).mainBuilding.setX(49);
                players.get(i).mainBuilding.setY(99);


            } else if (i==2) {
                tempMap[49][0].building =new MainBuilding(players.get(i));
                players.get(i).mainBuilding.setX(49);
                players.get(i).mainBuilding.setY(0);


            } else if (i==3) {
                tempMap[0][99].building =new MainBuilding(players.get(i));
                players.get(i).mainBuilding.setX(0);
                players.get(i).mainBuilding.setY(99);


            }
        }
        map=tempMap;

    }


    @Override
    public void print() {
        System.out.print("\n" + status());

    }

    @Override
    public String status() {
        String s = "";

        for(int i =0;i<50;i++){
            for (int j =0;j<100;j++){
                if(map[i][j].building == null){

                    if(map[i][j].human == null){
                        s += "_ ";
                    }else if (map[i][j].human.getClass() == Worker.class) {
                        s+= "W ";
                    }else if (map[i][j].human.getClass() == Swordman.class) {
                        s+= "K ";
                    }else if (map[i][j].human.getClass() == Archer.class) {
                        s+= "O ";
                    }else if (map[i][j].human.getClass() == Spearman.class) {
                        s+= "S ";
                    }else if (map[i][j].human.getClass() == Cavalry.class) {
                        s+= "A ";
                    }else if (map[i][j].human.getClass() == Catapult.class) {
                        s+= "C ";
                    }

                }else if(map[i][j].building.getClass() == MainBuilding.class ){
                    s += "M ";
                }else if(map[i][j].building.getClass() == Tower.class ){
                    s += "T ";
                }else if(map[i][j].building.getClass() == University.class ){
                    s += "U ";
                }

/*
                else if (map[i][j].human.getClass() == Worker.class) {
                    s+= "W ";
                }else if (map[i][j].human.getClass() == Swordman.class) {
                    s+= "K ";
                }else if (map[i][j].human.getClass() == Archer.class) {
                    s+= "O ";
                }else if (map[i][j].human.getClass() == Spearman.class) {
                    s+= "S ";
                }else if (map[i][j].human.getClass() == Cavalry.class) {
                    s+= "A ";
                }else if (map[i][j].human.getClass() == Catapult.class) {
                    s+= "C ";
                }*/
            }
            s+= "\n";
        }
        return s;
    }
}
