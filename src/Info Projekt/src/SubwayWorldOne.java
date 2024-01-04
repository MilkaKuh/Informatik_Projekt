public class SubwayWorldOne extends Underground{

    public SubwayWorldOne()
    {
        super();
        setBackground("./images/BackgroundLeft.png");
        setPaintOrder(Player.class);
        addObject(new Player(), 0,75);
    }
    public SubwayWorldOne(Player p)
    {
        super();
        setBackground("./images/BackgroundLeft.png");
        setPaintOrder(Player.class);
        addObject(p, 0,75);
    }
}
