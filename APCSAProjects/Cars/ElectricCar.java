public class ElectricCar extends Car {

    // Complete the constructor
    // Note we're reinterpreting "fuelLevel" as "batteryLevel"
    public ElectricCar(String model, int batteryLevel){
       super(model,batteryLevel);
    }

    // Override getFuelLevel
    // Reinterprets fuelLevel() as a percentage
    // Remember super.getFuelLevel will return fuelLevel!
    @Override
    public double getFuelLevel(){
        return super.getFuelLevel() / 100;
    }
    

    // Override milesLeft
    // Takes one parameter - the total number of miles an ElectricCar
    // gets on a full charge.
    // Computes miles left by interpreting fuelLevel as the
    // battery percentage left in the car
    @Override
    public double milesLeft(double mpg){
        return (super.getFuelLevel() * mpg)/100;
    }
    
    // Override toString
    // Should print: model electric car
    @Override
    public String toString()
    {
        return super.getModel() + " electric car";
    }
    
}
