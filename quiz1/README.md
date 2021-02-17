I have slightly revised code which was originally written by David Eck in 2001 
and posted at http://math.hws.edu/eck/cs124/javanotes3/c8/ex-8-6-answer.html.

The prompt was as follows:

> The game of Go Moku (also known as Pente or Five Stones) is similar to 
> Tic-Tac-Toe, except that it played on a much larger board and the object 
> is to get five squares in a row rather than three. Players take turns 
> placing pieces on a board. A piece can be placed in any empty square. 
> The first player to get five pieces in a row -- horizontally, vertically, 
> or diagonally -- wins. If all squares are filled before either player wins, 
> then the game is a draw. Write an applet that lets two players play Go Mokua
> against each other.
 
With respect to this particular method, the author wrote:

> The logic of the GoMoku game itself is mostly in the method 
> `void doClickSquare(int row, int col)`, which is called by the 
> `mousePressed()` method when the user clicks on the square ina
> row number `row` and column number `col`. 
> This method must check whether the move is legal. If so, the move is made. 
> The method then checks whether the move wins the game. If so, the game ends. 
> The game will also end if the board has become completely full. 
> Otherwise, play passes to the other player.

The current player is recorded in an instance variable named `currentPlayer`.
The value of this variable is one of the two constants `WHITE` or `BLACK`. 
The game can be ended by calling a method named `gameOver()`. 
I wrote a boolean-valued method called `winner()` to check whether a move
wins the game. 
You may also find it helpful to know that `message` is a graphical user interface component that displays text, specifically a `Label`.

