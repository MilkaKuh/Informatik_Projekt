import greenfoot.Greenfoot;
import greenfoot.World;


public class LeftWorld extends Worlds{

    public LeftWorld()
    {
        super();
        setBackground("./images/BackgroundLeft.png");
        setPaintOrder(Player.class);
        addObject(new Player(), 0,75);
        getWorldList().add(this);
    }

}
