import greenfoot.World;


public class MiddleWorld extends World
{
    public MiddleWorld()
    {
        super(100, 75, 10);
        setBackground("./images/BackgroundMiddle.png");
        setPaintOrder(Player.class);
        addObject(new Player(), 0,75);
    }
}

