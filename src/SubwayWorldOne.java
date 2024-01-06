import java.util.*;

public class SubwayWorldOne extends Overground{

    public SubwayWorldOne(){
        this(new Player());
    }

    public SubwayWorldOne(Player player)
    {
        super(player);
        setBackground("./images/SubwayWorldOne.png");
        setPaintOrder(Player.class);
        addObject(player, 10,60);
    }
}
