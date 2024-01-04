public class SubwayWorldThree extends Underground{

    public SubwayWorldThree()
    {
        super();
        setBackground("./images/BackgroundLeft.png");
        setPaintOrder(Player.class);
        addObject(new Player(), 0,75);
    }
    public SubwayWorldThree(Player p)
    {
        super();
        setBackground("./images/BackgroundLeft.png");
        setPaintOrder(Player.class);
        addObject(p, 0,75);
    }
}
