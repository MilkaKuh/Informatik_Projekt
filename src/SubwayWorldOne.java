import greenfoot.Greenfoot;

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
        int randomizer = Greenfoot.getRandomNumber(4);
        if(randomizer == 1){
            addObject(new Elevator(), 64, 50);
        }
    }
    public void usedElevator(){
        System.out.println("benutzt UsedElevator");
        getPlayer().setLocation(255, 65);
        getPlayer().setRotation(0);
        System.out.println("UsedElevator fertig");
    }
}
