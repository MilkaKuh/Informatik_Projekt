import java.util.*;
public class SubwayWorldThree extends Overground{

    public SubwayWorldThree(){
        this(new Player());
    }

    public SubwayWorldThree(Player player)
    {
        super(player);
        setBackground("./images/SubwayWorldThree.png");
        setPaintOrder(Player.class);
        addObject(player, 10,60);
    }
}

