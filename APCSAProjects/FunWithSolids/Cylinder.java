import java.lang.Math;

public class Cylinder extends Solid
{
    
    private int radius;
    private int height;
    
    //name, radius, height
    public Cylinder(String n, int r, int h)
    {
        super(n);
        radius = r;
        height = h;
    }

    
    // V=πr^2 h
    @Override
    public double volume()
    {
        return Math.PI * Math.pow(radius,2) * height;
    }
    
    // A=2πrh+2πr^2
    @Override
    public double surfaceArea()
    {
        return 2 * Math.PI * radius * height + 2*Math.PI*Math.pow(radius,2);
    }
}
