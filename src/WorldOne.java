public class WorldOne extends Overground{

    public WorldOne()
    {
        new Worlds();
        setBackground("./images/BackgroundLeft.png");
        setPaintOrder(Player.class);
        addObject(new Player(), 20,60);
    }
    public WorldOne(Player p)
    {
        new Worlds();
        setBackground("./images/BackgroundLeft.png");
        setPaintOrder(Player.class);
        addObject(p, 10,60);
    }
}
