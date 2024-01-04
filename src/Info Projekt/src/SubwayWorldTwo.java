
public class SubwayWorldTwo extends Underground{

    public SubwayWorldTwo()
    {
        super();
        setBackground("./images/BackgroundLeft.png");
        setPaintOrder(Player.class);
        addObject(new Player(), 0,75);
    }
    public SubwayWorldTwo(Player p)
    {
        super();
        setBackground("./images/BackgroundLeft.png");
        setPaintOrder(Player.class);
        addObject(p, 0,75);
    }
}
