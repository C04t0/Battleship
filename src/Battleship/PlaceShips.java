package Battleship;

import java.util.Arrays;
import java.util.Scanner;

public class PlaceShips {
    public static char ship = '\u26f4';
    private static String [][] positionShips(String[][] startField, String ship) {
        System.out.println("Enter your startcoordinate and ship orientation: ");
        System.out.println("For example: b2, h");
        Scanner shipInput = new Scanner(System.in);
        String shipPos = shipInput.nextLine();
        String[] splittedShipPos= shipPos.split(" ");
        System.out.println(Arrays.toString(splittedShipPos));

        return startField;
    }
    String [][] startField = positionShips(startField, ship);


}
