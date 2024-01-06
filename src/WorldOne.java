import java.util.*;

public class WorldOne extends Overground{

    public WorldOne(){
        this(new Player());
    }

    public WorldOne(Player player)
    {
        super(player);
        setBackground("./images/WorldOne.png");
        setPaintOrder(Player.class);
        addObject(player, 10,60);
    }
}


