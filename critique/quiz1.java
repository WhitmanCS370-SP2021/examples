/**
 *	Called by mousePressed() when a player clicks on 
 *	the square in the specified row and column.
 */
public void doClickSquare(int row, int col) {

    String currentPlayerString;
    if (currentPlayer == BLACK)
        currentPlayerString = "Black";
    else
        currentPlayerString = "White";

    /* Check that the user clicked an empty square.  
       If not, show an error message and exit. */
       
    if ( board[row][col] != EMPTY ) {
        message.setText(currentPlayerString + 
                        ": Please click an empty square.");
        return;
    }

    /* Make the move.  Check if the board is full or 
       if the move is a winning move.  If so, the game ends.  
       If not, then it's the other user's turn. */    
       
    board[row][col] = currentPlayer;  // Make the move.
    drawPiece(currentPlayer, row, col);

    if (winner(row,col)) {  // First, check for a winner.
        gameOver(currentPlayerString + " wins the game!");
        return;
    }

    boolean emptySpace = false;     // Check if the board is full.
    for (int i = 0; i < 13; i++)
        for (int j = 0; j < 13; j++)
            if (board[i][j] == EMPTY)
                emptySpace = true;
    if (emptySpace == false) {
        gameOver(“The game ends in a draw.”);
        return;
    }

    /* Continue the game.  It's the other player's turn. */
    
    if (currentPlayer == BLACK) {
        currentPlayer = WHITE;
        message.setText(“WHITE:  Make your move.”);
    } else {  
        currentPlayer = BLACK;
        message.setText(“BLACK:  Make your move.”);
    }
    
}  // end doClickSquare()

