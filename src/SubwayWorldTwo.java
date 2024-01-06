import java.util.*;
public class SubwayWorldTwo extends Overground{

    public SubwayWorldTwo(){
        this(new Player());
    }

    public SubwayWorldTwo(Player player)
    {
        super(player);
        setBackground("./images/SubwayWorldTwo.png");
        setPaintOrder(Player.class);
        addObject(player, 10,60);
    }
}