import greenfoot.World;


public class LeftWorld extends World
{
    public LeftWorld()
    {
        super(100, 75, 10);
        setBackground("./images/BackgroundLeft.png");
        setPaintOrder(Player.class);
        addObject(new Player(), 0,75);
    }
}
