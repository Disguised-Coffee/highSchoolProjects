import java.util.*;

public class CarTester
{
    public static void main(String[] args)
    {
        System.out.println("Enter you cars' information\n");
        
        for(Car e : askForCar())
        {
            System.out.println(e + "\n" + "Fuel Amount: " + e.getFuelLevel() + "\n");
        }
    }
    
    public static ArrayList<Car> askForCar()
    {
        Scanner input = new Scanner(System.in);
        ArrayList<Car> toR = new ArrayList<Car>();
        
        System.out.println("Model (exit to quit): ");
        String name = input.nextLine();
        while(!(name.toLowerCase().equals("exit")))
        {
            System.out.println("Electric car (y/n): ");
            if(input.nextLine().toLowerCase().equals("y"))
            {
                System.out.println("Percent of battery left (as a whole number): ");
                Car e = new ElectricCar(name,input.nextInt());
                toR.add(e);
            }
            else
            {
                System.out.println("Gallons of fuel left: ");
                Car e = new Car(name,input.nextInt());
                toR.add(e);
            }
            input.nextLine();
            System.out.println("Model (exit to quit): ");
            name = input.nextLine();
        }
        
        return toR;
    }
}
