import java.util.*;

public class WorldThree extends Overground{

    public WorldThree(){
        this(new Player());
    }

    public WorldThree(Player player)
    {
        super(player);
        setBackground("./images/WorldThree.png");
        setPaintOrder(Player.class);
        addObject(player, 10,60);
    }
}
