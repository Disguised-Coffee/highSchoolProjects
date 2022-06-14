import java.util.ArrayList;

public class DataPurge
{
    public static void removeDuplicates(ArrayList<String> array)
    {
        //find similar names?
        //Double loop?
        for(int a = 0; a < array.size(); a++)
        {
            for(int b = 0; b < array.size();b++)
            {
                if(a != b && array.get(a).equals(array.get(b)))
                {
                    System.out.println("Remvoing " + array.remove(b) + " by removeDuplicates");
                    b--;
                }
                    
            }
        }
    }
    
    public static void removeName(ArrayList<String> array, String find)
    {
        //find
        for(int i = 0; i < array.size(); i++)
        {
            String current = array.get(i).toLowerCase();
            // First piece or last piece should trigger this
            if(current.indexOf(find.toLowerCase()) >= 0)
            {
                System.out.println("Remvoing " + array.remove(i) + " by removeName");
                i--;
            }
                
            
        }
            
    }
    
    public static boolean correctlyFormatted(ArrayList<String> array)
    {
        
        //Go into String of array
        int i = 0;
        while(i < array.size())
        {
            
            //made of first + " " + last && first char of first is upper.
            //if first name and last name
            int space = array.get(i).indexOf(" ");
            System.out.println(space);
            if(space == -1)
            {
                System.out.println("First check denied.");
                return false;
            }
            
            //if first letter is uppercase
            String first = array.get(i).substring(0,space);
            String last = array.get(i).substring(space + 1);
            if(!(first.substring(0,1).toUpperCase().equals(first.substring(0,1)) && 
                (last.substring(0,1).toUpperCase().equals(last.substring(0,1)))))
            {
                System.out.println("Second check denied.");
                return false;   
            }
            i++;
            
            
            
            
            //second check
            
        }
        
        return true;
        
    }
}
