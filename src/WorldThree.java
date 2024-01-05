import java.util.ArrayList;

public class WorldThree extends Worlds
{
    public WorldThree()
    {
        super();
        setBackground("./images/WorldThree.png");
        setPaintOrder(Player.class);
        addObject(new Player(), 20,60);
    }
    public WorldThree(Player p, ArrayList<Worlds> w)
    {
        new Worlds(w);
        setBackground("./images/WorldThree.png");
        setPaintOrder(Player.class);
        addObject(p, 10,60);
    }
}
