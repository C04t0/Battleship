package Battleship;


public class Board {
    public static void main (String[]args) {
         int numRows = 10;
         int numCols = 10;
        char [][] field = new char[numRows][numCols];
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                field[i][j] = Board.EMPTY;
                System.out.print(field[i][j]);
            }
            System.out.println();


        }

    }
    private static final char EMPTY = '.';
}