public class SubwayWorldFour extends Overground{

    public SubwayWorldFour(){
        this(new Player());
    }

    public SubwayWorldFour(Player player)
    {
        super(player);
        setBackground("./images/SubwayWorldThree.png");
        setPaintOrder(Player.class);
        addObject(player, 10,60);
    }
}

