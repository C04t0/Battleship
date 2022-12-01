package Battleship;

public class Playing_field {
    public static void main (String[]args) {
        char field[][] = new char[10][10];
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                field[i][j] = Playing_field.empty;
                System.out.print(field[i][j]);
                System.out.print(' ');
            }
            System.out.println();
        }
    }
    public static final char empty = '.';
}


