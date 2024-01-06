import greenfoot.Greenfoot;
import greenfoot.World;

import java.util.LinkedList;
import java.util.List;

public class WorldHandler extends World {
    private static List<WorldHandler> worlds = new LinkedList<>();
    private static int currentPosAtWorldList = 0;
    private int activator;
    private Player player;

    public WorldHandler(Player player){
        super(260, 90, 10);
        this.player = player;
        worlds.add(this);
        int x = Greenfoot.getRandomNumber(2);
        if (x == 1) {
            TrashCan tC = new TrashCan();
            addObject(tC, Greenfoot.getRandomNumber(250), 65);
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


    public List<WorldHandler> getWorldList(){
        return worlds;
    }

    public void checkWorldChange(){

        if (getPlayer().getNextX(6) > 260 && getPlayer().getRotation() == 0 ){
            WorldHandler OutOfBouncePrevention = null;
            worlds.add(OutOfBouncePrevention);
            if (worlds.get(currentPosAtWorldList + 1) == null){
                //todo abfragen ob nÃ¤chste Welt leer ist => dann neu erstellen, sonst die aus der Liste nehmen (und den Player wieder reinsetzen)
                WorldHandler newWorld;
                int randomizer = Greenfoot.getRandomNumber(3);
                if (getPlayer().getIsOverground()) {
                    if (randomizer == 0) {
                        newWorld = new WorldOne(getPlayer());
                    } else if (randomizer == 1) {
                        newWorld = new WorldTwo(getPlayer());
                    } else {
                        newWorld = new WorldThree(getPlayer());
                    }
                } else {
                    if (randomizer == 0) {
                        newWorld = new SubwayWorldOne(getPlayer());
                    } else if (randomizer == 1) {
                        newWorld = new SubwayWorldTwo(getPlayer());
                    } else {
                        newWorld = new SubwayWorldThree(getPlayer());
                    }
                }
                currentPosAtWorldList++;
                Greenfoot.setWorld(newWorld);
                worlds.remove(OutOfBouncePrevention);
                return;
            } else {
                WorldHandler worldToActivate = worlds.get(currentPosAtWorldList + 1);
                worldToActivate.addObject(getPlayer(), 10, 60);
                Greenfoot.setWorld(worldToActivate);
                currentPosAtWorldList++;
                worlds.remove(OutOfBouncePrevention);
                return;
            }
        } else if(currentPosAtWorldList > 0){
                if (getPlayer().getNextX(6) < 5 && getPlayer().getRotation() == 180) {
                    currentPosAtWorldList--;
                    WorldHandler worldToActivate = worlds.get(currentPosAtWorldList);
                    worldToActivate.addObject(getPlayer(), 250, 60);
                    Greenfoot.setWorld(worldToActivate);
                return;
             }
        }

        System.out.println("ListLength :" + worlds.size());
        System.out.println("PlayerPos :" + currentPosAtWorldList);
    }

    public void act(){
        checkWorldChange();
    }

    public Player getPlayer(){
        return player;
    }

    public void setActivator(int activator) {
        this.activator = activator;
    }
}
