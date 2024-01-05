
public class WorldOne extends Overground{

    public WorldOne()
    {
        new Worlds();
        setBackground("./images/WorldOne.png");
        setPaintOrder(Player.class);
        addObject(new Player(), 20,60);
    }
    public WorldOne(Player p)
    {
        new Worlds();
        setBackground("./images/WorldOne.png");
        setPaintOrder(Player.class);
        addObject(p, 10,60);
    }
}
