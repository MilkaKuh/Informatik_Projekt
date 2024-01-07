import java.util.*;

public class SubwayWorldOne extends Underground{

    public SubwayWorldOne(){
        this(new Player());
    }

    public SubwayWorldOne(Player player)

    {
        super(player);
        setBackground("./images/SubwayWorldOne.png");
        setPaintOrder(Player.class);
        addObject(player, 10,56);
    }
    public SubwayWorldOne(Player player, String identifier)

    {
        super(player);
        setBackground("./images/SubwayWorldOne.png");
        setPaintOrder(Player.class);
        addObject(player, 10,56);
    }
}
