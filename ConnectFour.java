import java.util.Scanner;
public class ConnectFour {
    public static void printBoard(char[][] array) {
        // prints the current board
        for (int i = array.length - 1; i >= 0; --i) {
            System.out.println(array[i]);
        }
    }
    public static void initializeBoard(char[][] array) {
        // prints the initial board where all spots are blanks
        for (int i = 0; i < array.length; ++i) {
            for (int j = 0; j < array[0].length; ++j) {
                array[i][j] = '-';
            }
        }
        for (char[] items : array) {
            System.out.println(items);
        }
    }
    public static int insertChip(char[][] array, int col, char chipType) {
        // inserts the chip ('x' or 'o') down the column selected by the players
        int row = 0;
        for (int i = 0 ; i < array.length; ++i) {
            if (array[i][col] == '-') {
                array[i][col] = chipType;
                row = i;
                break;
            }
        }
        return row;
    }
    public static boolean checkIfWinner(char[][] array, int col, int row, char chipType){
        // checks the board to see whether or not there are four pieces lined up
        int count = 0;
        for (int i = 0; i < array.length; ++i) {
            if (array[i][col] == chipType) {
                count += 1;
            }
            else {
                count = 0;
            }
            if (count == 4) {
                return true;
            }
        }
        for (int i = 0; i < array[0].length; ++i) {
            if (array[row][i] == chipType) {
                count += 1;
            }
            else {
                count = 0;
            }
            if (count == 4) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // main program; this is where the game is conducted
        Scanner scnr = new Scanner(System.in);
        System.out.print("What would you like the height of the board to be? ");
        int row = scnr.nextInt();
        System.out.print("What would you like the length of the board to be? ");
        int col = scnr.nextInt();
        char[][] array = new char[row][col];
        System.out.println();
        initializeBoard(array);
        System.out.println();
        System.out.println("Player 1: x");
        System.out.println("Player 2: o");
        char player1 = 'x';
        char player2 = 'o';
        System.out.println();
        int game = 0;
        int count = 0;
        int drawCount = row*col;
        while (game == 0) {
            // the first half allows Player 1 to play
            count += 1;
            System.out.print("Player 1: Which column would you like to choose? ");
            col = scnr.nextInt();
            row = insertChip(array,col,player1);
            printBoard(array);
            System.out.println();
            //checks to see if player 1 won
            if (checkIfWinner(array,col,row,player1) == true) {
                System.out.println("Player 1 won the game!");
                break;
            }
            //checks the board to see if there are any open sports; if there's not, the game is a tie
            if (count >= drawCount) {
                System.out.println("Draw. Nobody wins.");
                break;
            }
            // the second half allows Players 2 to play
            count += 1;
            System.out.print("Player 2: Which column would you like to choose? ");
            col = scnr.nextInt();
            row = insertChip(array,col,player2);
            printBoard(array);
            System.out.println();
            //checks to see if player 2 won
            if (checkIfWinner(array,col,row,player2) == true) {
                System.out.println("Player 2 won the game!");
                break;
            }
            //checks the board to see if there are any open sports; if there's not, the game is a tie
            if (count >= drawCount) {
                System.out.println("Draw. Nobody wins.");
                break;
            }
        }
    }
}
//this is my comment necessary for Lab 6
