import greenfoot.Greenfoot;
import greenfoot.World;
import java.util.*;

import java.util.ArrayList;
import java.util.List;

public class Worlds extends World {
    private ArrayList<Worlds> world = new ArrayList<Worlds>();

    private Worlds currentWorld;
    public Worlds() {
        super(100, 75, 10);
        currentWorld = this;
        int x = Greenfoot.getRandomNumber(2);
        if (x == 1) {
            addObject(new TrashCan(), Greenfoot.getRandomNumber(90), 72);
        } else {
            TrashCan tC = new TrashCan();
            addObject(tC, Greenfoot.getRandomNumber(90), 72);
            boolean canSpawn = false;
            while (canSpawn = false) {
                int secondTrashCanX = Greenfoot.getRandomNumber(90);
                if (tC.getX() + 10 > secondTrashCanX && tC.getX() - 10 < secondTrashCanX) {
                    addObject(new TrashCan(), secondTrashCanX, 72);
                    canSpawn = true;
                }
            }
        }
    }
    public void setCurrentWorld(Worlds w){
        this.currentWorld = w;
    }

    public Worlds getCurrentWorld() {
        return currentWorld;
    }
    public ArrayList<Worlds> getWorldList(){
        return world;
    }

    public void checkWorldChange(){
        List<Player> players = currentWorld.getObjects(Player.class);
        Player player = players.get(0);
        if (player.getNextX(6) > 100 ){
            if (player.getIsOverground() == true){
                int randomizer = Greenfoot.getRandomNumber(2);
                if(randomizer==0){
                    Worlds newWorlds = new WorldOne(player);
                    setCurrentWorld(newWorlds);
                    getWorldList().add(newWorlds);
                    setBackgroundToCurrentWorld();
                } else if (randomizer==1) {
                    Worlds newWorlds = new WorldTwo(player);
                    setCurrentWorld(newWorlds);
                    getWorldList().add(newWorlds);
                    setBackgroundToCurrentWorld();
                }else{
                    Worlds newWorlds = new WorldThree(player);
                    setCurrentWorld(newWorlds);
                    getWorldList().add(newWorlds);
                    setBackgroundToCurrentWorld();
                }
            }
            if(player.getIsOverground() == false){
                int randomizer = Greenfoot.getRandomNumber(2);
                if(randomizer==0){
                    Worlds newSubwayWorlds = new SubwayWorldOne(player);
                    setCurrentWorld(newSubwayWorlds);
                    getWorldList().add(newSubwayWorlds);
                } else if (randomizer==1) {
                    Worlds newSubwayWorlds = new SubwayWorldTwo(player);
                    setCurrentWorld(newSubwayWorlds);
                    getWorldList().add(newSubwayWorlds);
                }else{
                    Worlds newSubwayWorlds = new SubwayWorldThree(player);
                    setCurrentWorld(newSubwayWorlds);
                    getWorldList().add(newSubwayWorlds);
                }
            }
        }
    }
    public void setBackgroundToCurrentWorld(){
        setBackground(currentWorld.getBackground());
    }
    public void act(){
        checkWorldChange();
    }
}

