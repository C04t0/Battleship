package Battleship;

import java.util.Scanner;

public class TryoutBoard1 {
    Scanner keyboard = new Scanner(System.in);
    int size = keyboard.nextInt();
    String[][] field = new String[size][size];

    public void setBoard(String[][] field) {
        this.field = field;
    }

    public String[][] getBoard() {
        return field;
    }

    private static final char EMPTY = '\u25A2';
}
