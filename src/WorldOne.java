import java.util.*;

public class WorldOne extends Overground{

    public WorldOne()
    {
        new Worlds();
        setBackground("./images/WorldOne.png");
        setPaintOrder(Player.class);
        Player p = new Player();
        addObject(p, 20,60);
        p.addedToWorld(this);
    }
    public WorldOne(Player p, ArrayList<Worlds> w)
    {
        new Worlds(w);
        setBackground("./images/WorldOne.png");
        setPaintOrder(Player.class);
        addObject(p, 10,60);
    }
}


