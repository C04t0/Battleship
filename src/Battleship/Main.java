package Battleship;

import java.util.Scanner;

public class Main {
    public static void main (String []args) {
        TryoutBoard1 board = new TryoutBoard1();
        System.out.println("Geef de grootte van het veld: ");
        board.size = board.keyboard.nextInt();
        }
    }
