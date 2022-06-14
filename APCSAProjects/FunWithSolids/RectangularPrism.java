public class RectangularPrism extends Solid
{
    private int width; //Y axis
    private int length; //hight X and Y
    private int height; //height Z
    
    public RectangularPrism(String name, int l, int w, int h)
    {
        super(name);
        length = l;
        width = w;
        height = h;
    }
    
    public int getHeight()
    {
        return height;
    }
    
    @Override
    public double volume()
    {
        return length*width*height;
    }
    
    @Override
    // A=2(wl+hl+hw)
    public double surfaceArea()
    {
        return 2 * (width * length + height * length + height * width);
    }
}
