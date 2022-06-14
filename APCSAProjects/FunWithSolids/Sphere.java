import java.lang.Math;

public class Sphere extends Solid
{
    // Code goes here
    private int radius;
    public Sphere(String name, int r)
    {
        super(name);
        radius = r;
    }
    
    //V=(4/3)πr^3
    // This should be overriden in the subclass
    public double volume()
    {
        return (4.0/3) * Math.PI * Math.pow(radius,3);
    }
    
    //A=4πr^2
    // This should be overriden in the subclass
    public double surfaceArea()
    {
        return 4*Math.PI*Math.pow(radius,2);
    }
}
