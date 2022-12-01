package Battleship;

import java.util.ArrayList;

public class PlaceShips {

    public static void main (String[]args) {
        int i;
        ArrayList<String> ships = new ArrayList<>();
        for(i = 0; i< 8; i++) {
            ships.add("a a a a");
        }
        System.out.println(ships);

    }
}
