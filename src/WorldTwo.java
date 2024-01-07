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
        int randomizer = 1;/*Greenfoot.getRandomNumber(4);*/
        if(randomizer == 1){
            addObject(new SubwayStation(), 5, 54);
        }
    }
    public void usedStation(){
        System.out.println("benutzt UsedStation");
        getPlayer().setLocation(255, 65);
        getPlayer().setRotation(0);
        System.out.println("UsedStation fertig");
    }
}

