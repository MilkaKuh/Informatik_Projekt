
public class WorldThree extends Worlds
{
    public WorldThree()
    {
        super();
        setBackground("./images/BackgroundLeft.png");
        setPaintOrder(Player.class);
        addObject(new Player(), 20,60);
    }
    public WorldThree(Player p)
    {
        super();
        setBackground("./images/BackgroundLeft.png");
        setPaintOrder(Player.class);
        addObject(p, 10,60);
    }
}
