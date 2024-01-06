import greenfoot.*;

import java.util.LinkedList;
import java.util.List;

public class WorldHandler extends World {
    private static List<WorldHandler> worlds = new LinkedList<>();
    private static int currentPosAtWorldList = 0;
    private Player player;

    public WorldHandler(Player player){
        super(260, 90, 10);
        this.player = player;
        worlds.add(this);


        int activator = Greenfoot.getRandomNumber(4);
        if(activator == 1) {
            addObject(new Spawner(),100 + Greenfoot.getRandomNumber(70), 65);
        }
        int randomizer = Greenfoot.getRandomNumber(2);
        if(randomizer == 1){
            addObject(new TrashCan(), Greenfoot.getRandomNumber(90),65);
        } else{
            addObject(new TrashCan(), Greenfoot.getRandomNumber(90),65);
            addObject(new TrashCan(), 180 + Greenfoot.getRandomNumber(70),65);
        }
        worlds.get(0).addObject(new NPC(), 30, 69);
    }


    public List<WorldHandler> getWorldList(){
        return worlds;
    }


    public void checkWorldChange(){
        Greenfoot.delay(1);
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
    }

    public void act(){
        checkWorldChange();
    }

    public Player getPlayer(){
        return player;
    }

    public int HigherX (Actor a1, Actor a2){
        int a = a1.getX();
        int b = a2.getX();
        if(a < b){
            return b;
        } else if(b < a){
            return a;
        }
        else{
            return 0;
        }
    }
    public int LowerX (Actor a1, Actor a2){
        int a = a1.getX();
        int b = a2.getX();
        if(a < b){
            return a;
        } else if(b < a){
            return b;
        }
        else{
            return 0;
        }
    }
}
