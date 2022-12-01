package Battleship;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main (String []args) {
        ArrayList<String> board = new ArrayList<>();
        char[] letters = {'a', 'b', 'c', 'd', 'e'};
        String[] numbers = {"1", "2" , "3" , "4", "5"};

        for (int i=0; i< letters.length; i++) {
            for (int j=0; j< letters.length; j++) {
                board.add(letters[i] + numbers[j]);
            }
        }
        System.out.println(board);

        }
    }
