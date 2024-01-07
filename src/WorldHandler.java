import greenfoot.*;

import java.util.LinkedList;
import java.util.List;

public class WorldHandler extends World {
    private static List<WorldHandler> worlds = new LinkedList<>();
    private static List<WorldHandler> undergroundWorlds = new LinkedList<>();
    private static int currentPosAtWorldList = 0;
    private static int currentPosAtUndergroundWorldList = 0;
    private Player player;

    public WorldHandler(Player player){
        super(260, 90, 10);
        this.player = player;
        worlds.add(this);


        int activator = Greenfoot.getRandomNumber(5);
        if(activator == 1) {
            addObject(new Spawner(),100 + Greenfoot.getRandomNumber(70), 65);
        }
        int randomizer = Greenfoot.getRandomNumber(2);
        if(randomizer == 1){
            addObject(new TrashCan(), Greenfoot.getRandomNumber(90),63);
        } else{
            addObject(new TrashCan(), Greenfoot.getRandomNumber(90),63);
            addObject(new TrashCan(), 180 + Greenfoot.getRandomNumber(70),63);
        }
        worlds.get(0).addObject(new NPC(), 30, 57);
        setPaintOrder(Player.class,Pickable.class);
        addObject(new Coins(),256, 3);
    }
    public WorldHandler(Player player, String identifier){
        super(260, 90, 10);
        this.player = player;
        undergroundWorlds.add(this);


        int randomizer = Greenfoot.getRandomNumber(2);
        if(randomizer == 1){
            addObject(new UndergroundTrashCan(), 90 + Greenfoot.getRandomNumber(90),61);
        } else{
            addObject(new UndergroundTrashCan(), 70 +Greenfoot.getRandomNumber(90),61);
            addObject(new UndergroundTrashCan(), 190 + Greenfoot.getRandomNumber(50),61);
        }
        player.setIsOverground(false);
        addObject(new Coins(),256, 3);
    }


    public List<WorldHandler> getWorldList(){
        return worlds;
    }


    public void checkWorldChange(){
        if(getPlayer().getUsedSubwayStation() == true) {
            getPlayer().setIsOverground(false);
        }
        if(getPlayer().getUsedSubwayStation() == false) {
            getPlayer().setIsOverground(true);
        }
        if(getPlayer().getIsOverground() == true) {
                if (getPlayer().getNextX(6) > 260 && getPlayer().getRotation() == 0) {
                    WorldHandler OutOfBouncePrevention = null;
                    worlds.add(OutOfBouncePrevention);
                    if (worlds.get(currentPosAtWorldList + 1) == null) {
                        //todo abfragen ob nÃ¤chste Welt leer ist => dann neu erstellen, sonst die aus der Liste nehmen (und den Player wieder reinsetzen)
                        WorldHandler newWorld;
                        int randomizer = Greenfoot.getRandomNumber(3);
                        if (randomizer == 0) {
                            newWorld = new WorldOne(getPlayer());
                        } else if (randomizer == 1) {
                            newWorld = new WorldTwo(getPlayer());
                        } else {
                            newWorld = new WorldThree(getPlayer());
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
                } else if (currentPosAtWorldList > 0) {
                    if (getPlayer().getNextX(6) < 0 && getPlayer().getRotation() == 180) {
                        currentPosAtWorldList--;
                        WorldHandler worldToActivate = worlds.get(currentPosAtWorldList);
                        worldToActivate.addObject(getPlayer(), 250, 60);
                        Greenfoot.setWorld(worldToActivate);
                        return;
                    }
                }
        }
    }
    public void checkWorldChangeUnderGround(){
        if(getPlayer().getIsOverground() == false) {
            if(undergroundWorlds.size() == 0) {
                WorldHandler starterWorldUnderground = new SubwayWorldOne(player);
                undergroundWorlds.add(starterWorldUnderground);
                Greenfoot.setWorld(starterWorldUnderground);
            }
            if (getPlayer().getNextX(6) > 260 && getPlayer().getRotation() == 0) {
                WorldHandler outOfBouncePrevention = null;
                undergroundWorlds.add(outOfBouncePrevention);
                    if (undergroundWorlds.get(currentPosAtUndergroundWorldList + 1) == null) {
                        //todo abfragen ob nÃ¤chste Welt leer ist => dann neu erstellen, sonst die aus der Liste nehmen (und den Player wieder reinsetzen)
                        WorldHandler newWorld;
                        int randomizer = Greenfoot.getRandomNumber(3);

                        if (randomizer == 0) {
                            newWorld = new SubwayWorldOne(getPlayer(), "identifier");
                        } else if (randomizer == 1) {
                            newWorld = new SubwayWorldTwo(getPlayer(), "identifier");
                        } else if (randomizer == 2) {
                            newWorld = new SubwayWorldThree(getPlayer(), "identifier");
                        } else{
                            newWorld = new SubwayWorldFour(getPlayer(), "identifier");
                        }

                        currentPosAtUndergroundWorldList++;
                        Greenfoot.setWorld(newWorld);
                        for(int i  = 0 ; i< undergroundWorlds.size() ; i++){
                            if(undergroundWorlds.get(i) == null){
                                undergroundWorlds.add(newWorld);
                                break;
                            }
                        }
                        undergroundWorlds.remove(outOfBouncePrevention);
                        return;
                    } else {
                        WorldHandler worldToActivate = undergroundWorlds.get(currentPosAtUndergroundWorldList + 1);
                        worldToActivate.addObject(getPlayer(), 10, 56);
                        Greenfoot.setWorld(worldToActivate);
                        currentPosAtUndergroundWorldList++;
                        undergroundWorlds.remove(outOfBouncePrevention);
                        return;
                    }
            } else if (currentPosAtUndergroundWorldList > 0) {
                    if (getPlayer().getNextX(6) < 0 && getPlayer().getRotation() == 180) {
                        currentPosAtUndergroundWorldList--;
                        WorldHandler worldToActivate = undergroundWorlds.get(currentPosAtUndergroundWorldList);
                        worldToActivate.addObject(getPlayer(), 250, 56);
                        Greenfoot.setWorld(worldToActivate);
                        return;
                    }
            }
        }
    }

    public void act(){
        setPaintOrder(Player.class,TrashCan.class,Elevator.class,SubwayStation.class, Spawner.class,NPC.class);
        checkWorldChange();
        checkWorldChangeUnderGround();
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
