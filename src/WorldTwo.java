import java.util.*;

public class WorldTwo extends Overground{

    public WorldTwo(){
        this(new Player());
    }

    public WorldTwo(Player player)
    {
        super(player);
        setBackground("./images/WorldTwo.png");
        setPaintOrder(Player.class);
        addObject(player, 10,60);
    }
}

