import greenfoot.World;


public class RightWorld extends Worlds
{
    public RightWorld()
    {
        super();
        setBackground("./images/BackgroundRight.png");
        setPaintOrder(Player.class);
        addObject(new Player(), 0,75);
        getWorldList().add(this);
    }
}
