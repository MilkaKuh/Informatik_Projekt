
public class WorldTwo extends Overground
{
    public WorldTwo()
    {
        super();
        setBackground("./images/BackgroundLeft.png");
        setPaintOrder(Player.class);
        addObject(new Player(), 20,60);
    }
    public WorldTwo(Player p)
    {
        super();
        setBackground("./images/BackgroundLeft.png");
        setPaintOrder(Player.class);
        addObject(p, 10,60);
    }
}

