import java.lang.Math;

public class Pyramid extends Solid
{
    // Code goes here
    //name, length, width, height
    
    private int width; //Y axis
    private int length; //hight X and Y
    private int height; //height Z
    
    public Pyramid(String name, int l, int w, int h)
    {
        super(name);
        length = l;
        width = w;
        height = h;
    }
    
    //V= (lwh) / 3
    // This should be overriden in the subclass
    public double volume()
    {
        return (length*width*height)/3.0;
    }
    
    
    //A= lw + l * sqrt((w/2)^2 + h^2) + w * sqrt((l/2)^2 + h^2)
    // This should be overriden in the subclass
    public double surfaceArea()
    {
        return (length* width) + (length*Math.sqrt(Math.pow(width/2.0,2) + Math.pow(height,2))) + (width * Math.sqrt(Math.pow(length/2.0,2) + Math.pow(height,2))) ;
    }
}
