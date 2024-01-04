import greenfoot.World;


public class MiddleWorld extends Worlds
{
    public MiddleWorld() {
        super();
        setBackground("./images/BackgroundMiddle.png");
        setPaintOrder(Player.class);
        addObject(new Player(), 0,75);
        getWorldList().add(new MiddleWorld());
    }
}

