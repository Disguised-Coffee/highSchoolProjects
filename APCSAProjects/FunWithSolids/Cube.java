public class Cube extends RectangularPrism
{
    // Code goes here
    public Cube(String name, int h)
    {
        super(name,h,h,h);
    }
    
    @Override
    public double volume()
    {
        return Math.pow(super.getHeight(),3);
    }
    
    @Override
    public double surfaceArea()
    {
        return 6 * (Math.pow(super.getHeight(),2));
    }
}
