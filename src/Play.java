/*
 * Author: S Mehta (Dominik)
 * Website: https://www.proDominik.me
 * Source code available at Github and Bitbucket
 * 
 * Play with computer and GUI coming soon..
 * Keep a look at the repo or subscribe to my mailing list.
*/

import java.util.Scanner;

public class Play {

    public static void main(String[] args) {
        letsgo();
    }

    private static void letsgo () {
        Scanner scan = new Scanner(System.in);
        int r = 0,c = 0;

        System.out.println("---------Tic Tac Toe-Play with Friend---------");
        System.out.println("\t      Enter Player Names");
        System.out.println("----------------------------------------------");
        System.out.print("Player 1: ");
        String p1 = scan.nextLine();
        System.out.print("Player 2: ");
        String p2 = scan.nextLine();

        System.out.println(p1 + ": o");
        System.out.println(p2 + ": x");

        // First player will be 'o'
        TicTacToe game = new TicTacToe(p1, p2);
        game.printBoard(); 
        do {
            System.out.println("Enter row & column of the box");
            try {
                r = scan.nextInt();
                c = scan.nextInt();
                --r;
                --c;
                if (r >= 3 || c >= 3) {
                    throw new IllegalArgumentException("Board only has 3 rows and columns\nPlease try again\n");
                }
                if (r < 0 || c < 0) {
                    throw new IllegalArgumentException("Ridiculous index of cell!!!");
                }
                if (!game.placeMark(r,c))
                    throw new IllegalArgumentException("Uh,Oh! This cell is occupied. Select an empty cell");
            } catch (IllegalArgumentException e) {
                System.err.println(e);
                continue;
            }


            // Lets print the board
            game.printBoard();

            // Did we have a winner?
            if (game.checkForWin()) {
                System.out.printf("Looks like %s wins! Congrats%n", game.getWinner());
                System.out.println("-----------------------------------------------");
                System.out.println("Feeling Lucky!? Wanna give it a shot again? y/n");
                char yn = scan.next().charAt(0);
                if (yn == 'y' || yn == 'Y') {
                    game = new TicTacToe(p1, p2);
                    game.printBoard();
                    continue;
                }
                else {
                    System.out.println("GoodBye :(");
                    System.exit(0);
                }
            }
            else if (game.isBoardFull()) {
                System.out.println("Seems like we have a draw!");
                System.out.println("-----------------------------------------------");
                System.out.println("Feeling Lucky!? Wanna give it a shot again? y/n");
                char yn = scan.next().charAt(0);
                if (yn == 'y' || yn == 'Y') {
                    game = new TicTacToe(p1, p2);
                    game.printBoard();
                    continue;
                }
                else {
                    System.out.println("GoodBye :(");
                    System.exit(0);
                }
            }

            // No winner or draw, other player's turn
            game.changePlayer();

        } while (true);
    }
}