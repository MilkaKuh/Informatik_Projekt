import greenfoot.Greenfoot;

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
        int randomizer = Greenfoot.getRandomNumber(2);
        if(randomizer == 1){
            addObject(new SubwayStation(), 24, 54);
        }
    }
    public void usedStation(){
        getPlayer().setLocation(255, 65);
        getPlayer().setRotation(0);
    }
}

