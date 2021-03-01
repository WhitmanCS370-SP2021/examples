private static final String PLAYER_NAME[] = { "Black", "White" };
private int currentPlayer = 0;

private getPlayerName() {
    return PLAYER_NAME[currentPlayer];
}

private void makeMove(int row, int col) throws InvalidMoveException {
    if (board[row][col] != EMPTY) {
        throw InvalidMoveException;
    } else {
        board[row][col] = currentPlayer; 
        drawPiece(currentPlayer, row, col);
    }
}

private void boardIsFull() {
    boolean anyEmpty = false;     
    for (int i = 0; i < 13; i++)
        for (int j = 0; j < 13; j++)
            if (board[i][j] == EMPTY)
                emptySpace = true;
    return !anyEmpty;
}

private void changePlayer() {
    currentPlayer = (currentPlayer + 1) % 2;
    message.setText(getPlayerName + ": Make your move.");
}

/**
 *	Called by mousePressed() when a player clicks on 
 *	the square in the specified row and column.
 */
public void doClickSquare(int row, int col) {
    try {
        makeMove(row, col)
    } catch (InvalidMoveException) {
        message.setText(getPlayerName() + ": Please click an empty square.");
        return;
    }
    if (winner(row,col)) {  
        gameOver(getPlayerName() + " wins the game!");
        return;
    }
    if (boardIsFull()) {
        gameOver(“The game ends in a draw.”);
        return;
    }
    changePlayer();
}  

