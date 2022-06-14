import java.util.Scanner;

public class TicTacToeTester
{
    private static Scanner input = new Scanner(System.in);
    private static TicTacToe board = new TicTacToe();
    
    
    /**
     * Running method of this file!
    */
    public static void main(String[] args)
    {
        start();
        System.out.println("Type '1' to play or '2' to stop the program.");
        
        String[] asking = {"1","2"};
        while(! ask(asking).equals("2"))
        {
            run();
            System.out.println("Type '1' to play again or '2' to stop the program.");
        }
        //end program when user inputs 2.
        end();
    }
    
    /**
     * Desc:
     *  Runs Tic Tac Toe game!
     * 
     * 
     * 
    */
    public static void run()
    {
        //reset board for new game
        board.reset();
        
        //run game
        while(!(board.checkWin()))
        {
            updateBoard();
            //SOP whose turn it is
            if(board.getTurn() % 2 == 0)
                System.out.println("Player1's turn");
            else
                System.out.println("Player2's turn");
            
            //take turn
            takeTurn();
            
            
            // String[] op1 = {"X", "O"};
            // String decodeMe;
            // if(board.getTurn() % 2 == 0){
            //     System.out.println("Player1's turn");
            //     decodeMe = askCoords(op1);
            // }
            // //decifer input
                
            // System.out.println("Enter two");
            // board.pickLocation(row,col);
        }
        updateBoard();
        System.out.println(board.getWin() + " wins!");
        
        return;
    }
    
    
    public static void takeTurn()
    {
        System.out.println("Row: ");
        int row = input.nextInt();
        
        System.out.println("Column: ");
        int col = input.nextInt();
        
        while(!(board.pickLocation(row,col))){
            updateBoard();
            System.out.println("Valid coordiante values are 0, 1, and 2!\nAlso they cannot be filled coordiantes!");
           
            System.out.println("Row: ");
            row = input.nextInt();
            
            System.out.println("Column: ");
            col = input.nextInt();
        }
        input.nextLine();
        board.takeTurn(row,col);
    }
    
    /*
        //really nice code that makes an error (coordinate input)
        System.out.println("Enter coordinates (enter as 'x,y')");
        String decodeMe = input.nextLine();
        
        int target = decodeMe.indexOf(",");
        String t = decodeMe.substring(0,target);
        System.out.println(t);
        //NullPointerException
        int row = (Integer.getInteger(t)).intValue();
        int col = Integer.getInteger(decodeMe.substring(target + 1));
        
        //while input is incorrect or unvalid, 
        while(!(board.pickLocation(row,col))){
            System.out.println("Input incorrect enter coordinates as 'x,y'");
            decodeMe = input.nextLine();
            target = decodeMe.indexOf(",");
            row = Integer.getInteger(decodeMe.substring(0,target));
            col = Integer.getInteger(decodeMe.substring(target + 1));
        }
        board.takeTurn(row,col);
        */
    
    /**
     * Waits for input and asks for input if the inputted text does 
     * not match with any of the acceptable Strings
     * 
     * 
     * @param accStr must have 3 Strings
    */
    public static String ask(String[] accStr)
    {
        String toReturn = input.nextLine();
        while(!(hasString(accStr,toReturn))){
            //supposed to clear console?
            //  https://stackoverflow.com/questions/2979383/how-to-clear-the-console
            
            System.out.print("\nPlease type in ");
            for(int i = 0; i < accStr.length; i++){
                if(i == accStr.length - 1)
                    System.out.print("or '" + accStr[i] + "'" + ", ");
                else
                    System.out.print("'" + accStr[i] + "'" + ", ");
            }
            System.out.println(" to continue.");
            toReturn = input.nextLine();
        }
        return toReturn;
    }
    
    public static void updateBoard()
    {
        System.out.print("\033[H\033[2J");  
        System.out.flush();
        
        board.printBoard();
    }
    
    // //overloaded method with two error codes
    // public static String askCoords(String[] accStr)
    // {
    //     String toReturn = input.nextLine();
    //     while(board.isAcceptableCoord(toReturn) != null){
    //         toReturn = input.nextLine();
    //     }
    //     return toReturn;
    // }
    
    
    /**
     * Used for ask() method for checking if string is in an input 
     * choice
     * 
     * @param accStr - String array that is greater than 0
     * @param input - String to search for in accStr
     * 
     * @return true if input is in accStr, false otherwise.
    */
    public static boolean hasString(String[] accStr, String input)
    {
        for(String c : accStr)
        {
            if(c != null && c.equals(input))
                return true;
        }
        return false;
    }
    
    /**
     * @return returns error code
     *  - a0 = No comma specified in coordinates
     *  - a1 = input too long
     *  - a2 = coordinate is out of bounds
     *  - null = coordinate is acceptable
    // */
    // public static String isAcceptableCoord(String input)
    // {
    //     if(input.indexOf(",") != -1)
    //     {
    //         System.out.println("No comma was specified");
    //         return "a0";
    //     }
    //     else if(input.length() > 3)
    //     {
    //         System.out.println("Input is too long.\nBe sure to format the coordinates as 'row,column'");
    //         return "a1";
    //     }
            
        
    //     String target = input.indexOf(",");
    //     int row = Integer.getInteger(input.substring(0,target));
    //     int col = Integer.getInteger(input.substring(target + 1));
        
    //     if(row > 2 || col > 2)
    //         System.out.println("Coordinates are out of bounds. Enter values less than 3.");
    //         return "a2";
    //     //else
    //     return null;
    // }
    
    
    
    /* Picture:
        _____________ ____  ___________
        |           | |  |  |          |
        |___     ___| |__|  |    ______|
            |   |     ____  |   |
            |   |     |  |  |   |______
            |   |     |  |  |          |
            |___|     |__|  |__________|
    */
    public static void start()
    {
        System.out.println("_____________ ____  ___________\n"+
                           "|           | |  |  |          |\n"+
                           "|___     ___| |__|  |    ______|\n"+
                           "    |   |     ____  |   |\n"+
                           "    |   |     |  |  |   |______\n"+
                           "    |   |     |  |  |          |\n"+
                           "    |___|     |__|  |__________|");
        System.out.println("\nWelcome to Dan's Tic Tac Toe!");
        System.out.println("\nClassic game of X's and O's, best played with two people.");
    }
    
    public static void end()
    {
        System.out.println("Thanks for playing!\n");
        System.out.println("Closing program...");
    }
}
