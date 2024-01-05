import greenfoot.Greenfoot;
import greenfoot.World;
import java.util.*;

import java.util.ArrayList;
import java.util.List;

public class Worlds extends World {
    private ArrayList<Worlds> world = new ArrayList<Worlds>();
    private int currentPosAtWorldList = 0;

    private int activator;
    private Worlds currentWorld;
    public Worlds() {
        super(260, 90, 10);
        currentWorld = this;
        world.add(currentWorld);
        int x = Greenfoot.getRandomNumber(2);
        if (x == 1) {
            addObject(new TrashCan(), Greenfoot.getRandomNumber(250), 65);
        } else {
            TrashCan tC = new TrashCan();
            addObject(tC, Greenfoot.getRandomNumber(260), 65);
            boolean canSpawn = false;
            while (canSpawn = false) {
                int secondTrashCanX = Greenfoot.getRandomNumber(260);
                if (tC.getX() + 10 > secondTrashCanX && tC.getX() - 10 < secondTrashCanX) {
                    addObject(new TrashCan(), secondTrashCanX, 65);
                    canSpawn = true;

                }
            }
        }
        setActivator(Greenfoot.getRandomNumber(3));
        if(activator == 0){
            addObject(new Spawner(),200,65);
        }

    }

    public Worlds(ArrayList<Worlds> w) {
        super(260,90,10);
        int x = Greenfoot.getRandomNumber(2);
        if (x == 1) {
            addObject(new TrashCan(), Greenfoot.getRandomNumber(260), 65);

        } else {
            TrashCan tC = new TrashCan();
            addObject(tC, Greenfoot.getRandomNumber(260), 65);
            boolean canSpawn = false;
            while (canSpawn = false) {
                int secondTrashCanX = Greenfoot.getRandomNumber(260);

            }
        }
        setCurrentWorld(this);
        setWorld(w);
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

    public void setWorld(ArrayList<Worlds> world) {
        this.world = world;
    }
    public ArrayList<Worlds> getWorld() {
        return world;
    }

    public void checkWorldChange(){
        if (getPlayer().getNextX(6) > 260 ){
            if (getPlayer().getIsOverground() == true){
                int randomizer = Greenfoot.getRandomNumber(3);
                if(randomizer==0){
                    Worlds newWorlds = new WorldOne(getPlayer(), world);
                    currentPosAtWorldList = currentPosAtWorldList +1;
                    setCurrentWorld(newWorlds);
                    world.add(currentWorld);
                    Greenfoot.setWorld(currentWorld);

                } else if (randomizer==1) {
                    Worlds newWorlds = new WorldTwo(getPlayer(), world);
                    currentPosAtWorldList = currentPosAtWorldList +1;
                    setCurrentWorld(newWorlds);
                    world.add(currentWorld);
                    Greenfoot.setWorld(currentWorld);
                }else{
                    Worlds newWorlds = new WorldThree(getPlayer(), world);
                    currentPosAtWorldList = currentPosAtWorldList +1;
                    setCurrentWorld(newWorlds);
                    world.add(currentWorld);
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
        System.out.print(getWorldList().size());
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

    public void setActivator(int activator) {
        this.activator = activator;
    }
}

