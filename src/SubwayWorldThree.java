import java.util.*;
public class SubwayWorldThree extends Underground{

    public SubwayWorldThree(){
        this(new Player());
    }

    public SubwayWorldThree(Player player)
    {
        super(player);
        setBackground("./images/SubwayWorldThree.png");
        setPaintOrder(Player.class);
        addObject(player, 10,56);
    }
    public SubwayWorldThree(Player player, String identifier)

    {
        super(player);
        setBackground("./images/SubwayWorldThree.png");
        setPaintOrder(Player.class);
        addObject(player, 10,56);
    }
}

