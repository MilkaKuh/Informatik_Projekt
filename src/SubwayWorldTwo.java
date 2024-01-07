import java.util.*;
public class SubwayWorldTwo extends Underground{

    public SubwayWorldTwo(){
        this(new Player());
    }

    public SubwayWorldTwo(Player player)
    {
        super(player);
        setBackground("./images/SubwayWorldTwo.png");
        setPaintOrder(Player.class);
        addObject(player, 10,56);
    }
    public SubwayWorldTwo(Player player, String identifier)

    {
        super(player);
        setBackground("./images/SubwayWorldTwo.png");
        setPaintOrder(Player.class);
        addObject(player, 10,56);
    }
}