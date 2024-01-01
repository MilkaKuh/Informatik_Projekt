import greenfoot.World;


public class RightWorld extends World
{
    public RightWorld()
    {
        super(100, 75, 10);
        setBackground("./images/BackgroundRight.png");
        setPaintOrder(Player.class);
        addObject(new Player(), 0,75);
    }
}
