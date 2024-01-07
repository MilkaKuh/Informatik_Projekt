public class SubwayWorldFour extends Underground{

    public SubwayWorldFour(){
        this(new Player());
    }

    public SubwayWorldFour(Player player)
    {
        super(player);
        setBackground("./images/SubwayWorldFour.png");
        setPaintOrder(Player.class);
        addObject(player, 10,56);
    }
    public SubwayWorldFour(Player player, String identifier)
    {
        super(player);
        setBackground("./images/SubwayWorldFour.png");
        setPaintOrder(Player.class);
        addObject(player, 10,56);
    }
}

