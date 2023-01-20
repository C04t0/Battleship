package Battleship;

import java.util.Scanner;

public class OliField {
    System.out.println("Hoe groot wordt het veld? ");
    Scanner input = new Scanner(System.in);
    int size = input.nextInt();

    String[] letters = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J" };
    String[][] playerOneField = new String[size][size];

    for(int i = 0; i < playerOneField.length; i++) {
        for (int j = 0; j < playerOneField.length; j++) {
            playerOne[i][j] = letters[i] + (j + 1);
        }
    }

    printField(playerOneField);


    public static void printField(String[][] playerOne) {
        for (String[] row : playerOne) {
            for (String coordinate : row) {
                System.out.print(coordinate + " ");
            }
            System.out.println();
        }
    }

}