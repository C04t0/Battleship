package Battleship;

import java.util.Scanner;

public class Battleships {
    public static String blank = "  ";
    public static int numRows = 10;
    public static int numCols = 10;
    public static int playerShips;
    public static int computerShips;
    public static Scanner keyboard = new Scanner(System.in);
    public static String[][] grid = new String[numRows][numCols];
    public static int[][] missedGuess = new int[numRows][numCols];

    public static void main(String[] args) {
        printWelcome();
        createOceanMap();
        deployPlayerShips();
        deployComputerShips();

        do {
            Battle();
        } while (playerShips != 0 && computerShips != 0);
        printGameOver();
        keyboard.close();
    }

    private static void printGameOver() {
        System.out.println("Your ships: " + playerShips + " | Computer ships: " + computerShips);
        if(playerShips > 0 && computerShips <= 0) {
            System.out.println("Hooray! You won the battle.");
        } else {
            System.out.println("Sorry, you lost the battle.");
            System.out.println();
        }
    }

    private static void Battle() {
        playerTurn();
        computerTurn();

        printOceanMap();

        System.out.println();
        System.out.println("Your ships: " + playerShips + "| Computer ships: " + computerShips);
        System.out.println();
    }

    private static void computerTurn() {
        System.out.println("\nCOMPUTER'S TURN");
        int x = -1;
        int y = -1;
        do {
            x = (int) (Math.random() * 10);
            y = (int) (Math.random() * 10);

            if ((x >= 0 && x < numRows) && (y >= 0 && y < numCols)) {
                if (grid[x][y] == "@") {
                    System.out.println("The Computer sunk one of your ships!");
                    grid[x][y] = "x";
                    --playerShips;
                    ++computerShips;
                } else if (grid[x][y] == "x") {
                    System.out.println("The Computer sunk one of its own ships");
                    grid[x][y] = "!";
                } else if (grid[x][y] == ".") {
                    System.out.println("Computer missed");
                    if(missedGuess[x][y] != 1) {
                        missedGuess[x][y] = 1;

                    }
                }
            }
        } while ((x < 0 || x >= numRows) || (y < 0 || y >= numCols));
    }

    private static void playerTurn() {
        System.out.println("\nYOUR TURN");
        int x = -1;
        int y = -1;

        do {
            System.out.println("Enter X coordinate: ");
            x = keyboard.nextInt();
            System.out.println("Enter Y coordinate: ");
            y = keyboard.nextInt();

            if ((x >= 0 && x < numRows) && (y >= 0 && y < numCols)) {
                if (grid[x][y] == "x") {
                    System.out.println("BOOM! You hit the ship!");
                    grid[x][y] = "!";
                    --computerShips;
                } else if (grid[x][y] == "@") {
                    System.out.println("Oh no, you sunk your own ship..");
                    grid[x][y] = "x";
                    --playerShips;
                    ++computerShips;
                } else if (grid[x][y] == ".") {
                    System.out.println("Sorry, you missed.");
                    grid[x][y] = "-";
                }
            } else if ((x < 0 || x >= numRows) || (y < 0 || y >= numCols)) {
                System.out.println("You can't place ships outside of the grid. ");
            }

        } while ((x < 0 || x >= numRows) || (y < 0 || y >= numCols));

    }
    private static void deployComputerShips() {

        System.out.println("\nComputer is deploying ships");

        computerShips = 5;

        for (int i = 1; i <= computerShips; ) {
            int x = (int)(Math.random() * 10);
            int y = (int)(Math.random() * 10);

            if((x >= 0 && x < numRows) && (y >= 0 && y < numCols) && (grid[x][y] == "."))
            {
                grid[x][y] = "x";
                System.out.println(i + ". ship DEPLOYED");
                i++;
            }
        }
        printOceanMap();
    }
    private static void deployPlayerShips() {

        System.out.println("\nDeploy your ships: ");

        playerShips = 5;

        for (int i = 1; i <= playerShips; i++) {
            System.out.print("Enter X coordinate for your ship " + (i) + ": ");
            int x = keyboard.nextInt();
            System.out.print("Enter Y coordinate for your ship " + (i) + ": ");
            int y = keyboard.nextInt();

            if ((x >= 0 && x < numRows) && (y >= 0 && y < numCols) && (grid[x][y] == ".")) {
                grid[x][y] = "@";
            } else if ((x > 0 && x < numRows) && (y >= 0 && y < numCols && grid[x][y] == "@")) {
                System.out.println("You can't place two or more ships on the same location.");
            } else if ((x < 0 || x >= numRows) || (y < 0 || y >= numCols)) {
                System.out.println("You can't place ships outside of the grid. ");
            }
            printOceanMap();

        }
    }
    private static void createOceanMap() {

        //section 1
        System.out.print("  ");
        for(int i = 0; i < numCols; i++) {
            System.out.print(i);
        }
        System.out.println();

        //section 2
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                grid[i][j] = ".";
                if (j == 0) {
                    System.out.print(i + "|" + grid[i][j]);
                } else if (j == grid[i].length - 1) {
                    System.out.print(grid[i][j] + "|" + i);
                } else {
                    System.out.print(grid[i][j]);
                }

            } System.out.println();
        }

        //section 3
        System.out.print("  ");
        for(int i = 0; i < numCols; i++) {
            System.out.print(i);
        }
        System.out.println();
    }
    public static void printWelcome() {
        System.out.println("***Welcome to Battleships***");
        System.out.println("Right now, the sea is empty!\n");
    }
    public static void printOceanMap(){
        System.out.println();

        //section 1
        System.out.print(blank);
        for(int i = 0; i < numCols; i++) {
            System.out.print(i);
        }

        System.out.println();

        //section 2
        for(int x = 0; x < grid.length; x++) {
            System.out.print(x + "|");

            for (int y = 0; y < grid[x].length; y++){
                System.out.print(grid[x][y]);
            }

            System.out.println("|" + x);
        }

        //section 3
        System.out.print(blank);
        for(int i = 0; i < numCols; i++) {
            System.out.print(i);
        }
        System.out.println();
    }
}
