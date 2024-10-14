package sosGame449;

public class SOSGame {
    private char[][] board;
    private int boardSize;
    private boolean isPlayerOneTurn;

    public SOSGame(int boardSize) {
        if (boardSize < 3) {
            throw new IllegalArgumentException("Board size must be at least 3.");
        }
        this.boardSize = boardSize;
        this.board = new char[boardSize][boardSize];
        this.isPlayerOneTurn = false;  // red starts first
    }

    public int getBoardSize() {
        return boardSize;
    }

    public char[][] getBoard() {
        return board;
    }

    public boolean isPlayerOneTurn() {
        return isPlayerOneTurn;
    }

    public boolean placeLetter(int row, int col, char letter) {
        if (row >= 0 && row < boardSize && col >= 0 && col < boardSize && board[row][col] == '\0') {
            board[row][col] = letter;
            isPlayerOneTurn = !isPlayerOneTurn;
            return true;
        }
        return false;
    }
}


