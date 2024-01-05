import greenfoot.Greenfoot;
import greenfoot.World;
import java.util.*;

import java.util.ArrayList;
import java.util.List;

public class Worlds extends World {
    private ArrayList<Worlds> world = new ArrayList<Worlds>();
    private int currentPosAtWorldList = 0;

    private Worlds currentWorld;
    public Worlds() {
        super(100, 75, 10);
        currentWorld = this;
        world.add(currentWorld);
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
    public List<Worlds> getWorldList(){

        return world;
    }

    public void checkWorldChange(){
        if (getPlayer().getNextX(6) > 100 ){
            if (getPlayer().getIsOverground() == true){
                int randomizer = Greenfoot.getRandomNumber(3);
                if(randomizer==0){
                    Worlds newWorlds = new WorldOne(getPlayer());
                    currentPosAtWorldList = currentPosAtWorldList +1;
                    setCurrentWorld(newWorlds);
                    Greenfoot.setWorld(currentWorld);

                } else if (randomizer==1) {
                    Worlds newWorlds = new WorldTwo(getPlayer());
                    currentPosAtWorldList = currentPosAtWorldList +1;
                    setCurrentWorld(newWorlds);
                    Greenfoot.setWorld(currentWorld);
                }else{
                    Worlds newWorlds = new WorldThree(getPlayer());
                    currentPosAtWorldList = currentPosAtWorldList +1;
                    setCurrentWorld(newWorlds);
                    Greenfoot.setWorld(currentWorld);
                }
            }
            if(getPlayer().getIsOverground() == false){
                int randomizer = Greenfoot.getRandomNumber(3);
                if(randomizer==0){
                    Worlds newSubwayWorlds = new SubwayWorldOne(getPlayer());
                    setCurrentWorld(newSubwayWorlds);
                    getWorldList().add(newSubwayWorlds);
                } else if (randomizer==1) {
                    Worlds newSubwayWorlds = new SubwayWorldTwo(getPlayer());
                    setCurrentWorld(newSubwayWorlds);
                    getWorldList().add(newSubwayWorlds);
                }else{
                    Worlds newSubwayWorlds = new SubwayWorldThree(getPlayer());
                    setCurrentWorld(newSubwayWorlds);
                    getWorldList().add(newSubwayWorlds);
                }
            }
        }
        if (getPlayer().getNextX(6) < 5){
            setCurrentWorld(world.get(currentPosAtWorldList));
            Greenfoot.setWorld(currentWorld);

        }
    }
    public void setBackgroundToCurrentWorld(){
        setBackground(currentWorld.getBackground());
    }
    public void act(){
        checkWorldChange();

    }
    public Player getPlayer(){
       List<Player> player = getCurrentWorld().getObjects(Player.class);
       return player.get(0);
    }
}

