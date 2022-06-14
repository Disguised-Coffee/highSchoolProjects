public class TicTacToe
{
   //copy over your constructor from the Tic Tac Toe Board activity in the previous lesson!
   private int turn;
   private String currentWin; //rename to recentWin
   
   private String[][] board = new String[3][3];
    
    public TicTacToe(){
        for(int row = 0; row < board.length; row++){
            for(int col = 0; col < board[row].length; col++)
                board[row][col] = "-";
        }
    }
    
    //reset board to "-" per element
    public void reset()
    {
        for(int row = 0; row < board.length; row++){
            for(int col = 0; col < board[row].length; col++)
                board[row][col] = "-";
        }
        currentWin = null;
    }
   
   //this method returns the current turn
   public int getTurn()
   {
       return turn;
   }
   
   public String getWin()
   {
       return currentWin;
   }
   
   
   /*This method prints out the board array on to the console
   */
   public void printBoard()
   {
       System.out.println("  0 1 2");
       for(int row = 0; row < board.length; row++)
       {
            System.out.print(row + " ");
            for(int col = 0; col < board[row].length; col++)
                System.out.print(board[row][col] + " ");
            System.out.println();
       }
   }
   
   //This method returns true if space row, col is a valid space
   public boolean pickLocation(int row, int col)
   {
        //Validate  3 > row > 0 && same col
        //validate is "-"
        if(((row < 3 && row >= 0) && ( col >= 0 && col < 3)) && board[row][col].equals("-"))
            return true;
        return false;
   }
   
   //This method places an X or O at location row,col based on the int turn
   public void takeTurn(int row, int col)
   {
        //Evens = X
        //Odds = O
        if(turn % 2 == 0)
            board[row][col] = "X";
        else
            board[row][col] = "O";
        turn++;
   }
   
   //This method returns a boolean that returns true if a row has three X or O's in a row
   public boolean checkRow()
   {
       //if detect all x or o in row, is true
       for(int row = 0; row < board.length; row++){
           int numX = 0;
           int numO = 0;
           for(int col = 0; col < board[row].length; col++)
           {
               if(board[row][col].equals("X"))
                    numX++;
                else if(board[row][col].equals("O"))
                    numO++;
           }
           if(numX == 3){
               currentWin = "Player 1";
               return true;
           }
            else if(numO == 3){
               currentWin = "Player 2";
               return true;
           }
            
       }
       return false;
   }
   
    //This method returns a boolean that returns true if a col has three X or O's
   public boolean checkCol()
   {
       for(int row = 0; row < board.length; row++){
           int numX = 0;
           int numO = 0;
           for(int col = 0; col < board[row].length; col++)
           {
               if(board[col][row].equals("X"))
                    numX++;
                else if(board[col][row].equals("O"))
                    numO++;
           }
           if(numX == 3){
               currentWin = "Player 1";
               return true;
           }
            else if(numO == 3){
               currentWin = "Player 2";
               return true;
           }
       }
       return false;
   }
   
    //This method returns a boolean that returns true if either diagonal has three X or O's
   public boolean checkDiag()
   {
       //special case
       /*
                X O X
                - X -
                X O X
       */
       for(int alt = 0; alt < 2; alt++)
       {
            int target = alt; // % this by 4
            int numX = 0;
            int numO = 0;
            
            for(int row = 0; row < board.length; row++){
               if(board[row][target % 3].equals("X"))
                    numX++;
                else if(board[row][target % 3]. equals("O"))
                    numO++;
               target += 4; 
            }
            if(numX == 3){
               currentWin = "Player 1";
               return true;
           }
            else if(numO == 3){
               currentWin = "Player 2";
               return true;
           }
       }
        return false;
   }
   
   //This method returns a boolean that checks if someone has won the game
   public boolean checkWin()
   {
        if(checkRow() || checkCol() || checkDiag ())
            return true;
        return false;
   }

}
