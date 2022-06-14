import java.util.ArrayList;
import java.util.Scanner;

public class FantasyFootball
{
    public static void main(String[] args)
    {
        //input
        Scanner input = new Scanner(System.in);
        
        //Required commands
        ArrayList<String> availablePlayers = new ArrayList<String>();
        addPlayers(availablePlayers);
        //
        
        //create array
        ArrayList<String> roster = new ArrayList<String>();
        
        //prompt
        for(int i = 0; i < 5; i++){
            //false when successfully added player
            boolean stillGrabbing = true;
            String iPlayer = null;
            
            int index = 0;
            while(stillGrabbing){
                System.out.println("Enter name of player to add: ");
                iPlayer = input.nextLine(); //NoSuchElementException in Test Cases...
                index = search(availablePlayers,iPlayer);
                if(index != -1)
                    stillGrabbing = false;
                else
                    System.out.println(iPlayer + " is not an available player.\n");
            }
            roster.add(availablePlayers.remove(index));
            System.out.println("Successfully added player\n");
        }
        
        //Final roaster
        System.out.println("Final Team Roster: ");
        for(String a : roster)
            System.out.println(a);
        
        
    }
    
    
    /*
        BOOLEAN RETURN WOULD'VE BEEN SOOOOO MUCH BETTER
    */
    public static int search(ArrayList<String> array, String player)
    {
        //Linearly search for player
        int i = 0;
        while(i < array.size())
        {
            if(array.get(i).equals(player))
                return i;
            i++;
        }
        //Nope
        return -1;
    }
    
    public static void addPlayers(ArrayList<String> array)
    {
        //Feel free to add names of your favorite players to this list!
        //But make sure you DON'T remove any players from it!
        array.add("null");
        array.add("Cam Newton");
        array.add("Antonio Brown");
        array.add("Leveon Bell");
        array.add("Patrick Mahomes");
        array.add("Saquon Barkley");
        array.add("Mike Evans");
        array.add("Odell Beckham Jr.");
        array.add("Travis Kelce");
        array.add("Baker Mayfield");
        array.add("Michael Thomas");
        array.add("Julio Jones");
        array.add("Ezekial Elliott");
        array.add("Alvin Kamara");
        array.add("Davante Adams");
        array.add("Aaron Rogers");
    }
}
