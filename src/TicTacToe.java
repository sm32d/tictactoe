/*
 * Author: S Mehta (Dominik)
 * Website: https://www.proDominik.me
 * Source code available at Github and Bitbucket
 * 
 * Play with computer and GUI coming soon..
 * Keep a look at the repo or subscribe to my mailing list.
*/

public class TicTacToe {

    private char[][] board; 
    private char currentPlayerMark;
    private String winner;
    private String player1, player2;
			
    public TicTacToe(String p1, String p2) {
        board = new char[3][3];
        player1 = p1;
        player2 = p2;
        setBoard();
    }
	
	
    // Set an empty board
    public void setBoard() {
		currentPlayerMark = 'o';
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }
	
    public void printBoard() {
        System.out.println("-------------");
		
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }
    
    // checks if there are any empty spaces within the board
    public boolean isBoardFull() {
        boolean isFull = true;
		
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    isFull = false;
                }
            }
        }
		
        return isFull;
    }
	
    public boolean checkForWin() {
        if (checkRowsForWin() || checkColumnsForWin() || checkDiagonalsForWin()){
            if (currentPlayerMark == 'o')
                winner = player1;
            else
                winner = player2;
            return true;
        };
        return false;
    }
	
    // Loop through rows and checks for same markers (Winner)
    private boolean checkRowsForWin() {
        for (int i = 0; i < 3; i++) {
            if (checkIfSame(board[i][0], board[i][1], board[i][2])) {
                return true;
            }
        }
        return false;
    }
	
    // Loop through columns and checks for same markers (Winner)
    private boolean checkColumnsForWin() {
        for (int i = 0; i < 3; i++) {
            if (checkIfSame(board[0][i], board[1][i], board[2][i])) {
                return true;
            }
        }
        return false;
    }
	
    // Check the two diagonals for same markers (Winner)
    private boolean checkDiagonalsForWin() {
        return ((checkIfSame(board[0][0], board[1][1], board[2][2])) || (checkIfSame(board[0][2], board[1][1], board[2][0])));
    }
	
    // Check to see if all three values are the same (and not empty) indicating a win.
    private boolean checkIfSame(char c1, char c2, char c3) {
        return ((c1 != ' ') && (c1 == c2) && (c2 == c3));
    }
	
    // Change player marks (after each turn)
    public void changePlayer() {
        if (currentPlayerMark == 'x') {
            currentPlayerMark = 'o';
        }
        else {
            currentPlayerMark = 'x';
        }
    }
	
    // puts current player's mark at specified row and column
    public boolean placeMark(int row, int col) {
		
        if (board[row][col] == ' ') {
            board[row][col] = currentPlayerMark;
            return true;
        }
		
        return false;
    }

    // some methods to get basic info
    public String getWinner () {
        return winner;
    }

    public String getPlayer1() {
        return player1;
    }

    public String getPlayer2 () {
        return player2;
    }
}
