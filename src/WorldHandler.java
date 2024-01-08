import greenfoot.*;
import java.util.*;


public class WorldHandler extends World {
    private static List<WorldHandler> worlds = new LinkedList<>();
    private static List<WorldHandler> undergroundWorlds = new LinkedList<>();
    private static int currentPosAtWorldList = 0;
    private static int currentPosAtUndergroundWorldList = 0;
    private Player player;
    private Wife wife;

    public WorldHandler(Player player){
        super(260, 90, 10);
        this.player = player;
        worlds.add(this);


        int activator = Greenfoot.getRandomNumber(4);
        if(activator == 1) {
            addObject(new Spawner(),100 + Greenfoot.getRandomNumber(66), 65);
        }
        int randomizer = Greenfoot.getRandomNumber(2);
        if(randomizer == 1){
            addObject(new TrashCan(), Greenfoot.getRandomNumber(90),63);
        } else{
            addObject(new TrashCan(), Greenfoot.getRandomNumber(90),63);
            addObject(new TrashCan(), 180 + Greenfoot.getRandomNumber(66),63);
        }
        int activatorNPC = Greenfoot.getRandomNumber(5);
        if (activatorNPC == 1){
            addObject(new NPC(),230, 57);
        }
        for (int i = 0; i < 2; i++) {
            int containedBottle = Greenfoot.getRandomNumber(4);
            if (containedBottle == 0) {
                addObject(new PlasticBottle(), 90 + Greenfoot.getRandomNumber(70),66);
            }
            else if (containedBottle == 1) {
                addObject(new VodkaBottle(), 90 + Greenfoot.getRandomNumber(70),66);
            }
            else if (containedBottle == 2) {
                addObject(new BeerBottle(), 90 + Greenfoot.getRandomNumber(70),66);
            }
            else {
                addObject(new PlasticBottle(), 90 + Greenfoot.getRandomNumber(70),66);
            }
        }
        wife = new Wife();
        worlds.get(0).addObject(wife, 25, 45);
        setPaintOrder(Player.class,Pickable.class);
        addObject(new Coins(),5, 5);
        addObject(new Hearts(),5,85);



    }
    public WorldHandler(Player player, String identifier){
        super(260, 90, 10);
        this.player = player;
        undergroundWorlds.add(this);


        int randomizer = Greenfoot.getRandomNumber(2);
        if(randomizer == 1){
            addObject(new UndergroundTrashCan(), 90 + Greenfoot.getRandomNumber(90),61);
        } else{
            addObject(new UndergroundTrashCan(), 66 +Greenfoot.getRandomNumber(90),61);
            addObject(new UndergroundTrashCan(), 190 + Greenfoot.getRandomNumber(50),61);
        }
        int randomizerHomeless = Greenfoot.getRandomNumber(3);
        if (randomizer == 1){
            addObject(new Homeless(), 166 + Greenfoot.getRandomNumber(50), 56);
        }
        for (int i = 0; i < 2; i++) {
            int containedBottle = Greenfoot.getRandomNumber(4);
            if (containedBottle == 0) {
                addObject(new PlasticBottle(),170 +  Greenfoot.getRandomNumber(70),64);
            }
            else if (containedBottle == 1) {
                addObject(new VodkaBottle(), 170 +  Greenfoot.getRandomNumber(70),64);
            }
            else if (containedBottle == 2) {
                addObject(new BeerBottle(), 170 +  Greenfoot.getRandomNumber(70),64);
            }
            else {
                addObject(new PlasticBottle(), 170 +  Greenfoot.getRandomNumber(70),64);
            }
        }
        player.setIsOverground(false);
        addObject(new Coins(),5, 5);
        addObject(new Hearts(),5,85);

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
                        if(player.getHasNecklace() == true){
                            Wife wife = new Wife();
                            wife.setImage("./images/Woman/End1.png");
                            newWorld.addObject(wife,230,53);

                            for(int i = 0 ; i < player.getInventory().length ; i++){
                                if(player.getInventory()[i] instanceof Necklace){
                                    player.getInventory()[i] = null;
                                }
                            }
                            Greenfoot.delay(80);
                            wife.setImage("./images/Woman/End2.png");
                            Greenfoot.delay(100);
                            Wife actor = new Wife();
                            // GAME ENDER
                            System.out.println("YOU WON!!!");
                            for(int i = 0; i < 1 ; i++){
                                actor.setImage("");

                            }
                        }

                        worlds.remove(OutOfBouncePrevention);
                        return;
                    } else {
                        WorldHandler worldToActivate = worlds.get(currentPosAtWorldList + 1);
                        worldToActivate.addObject(getPlayer(), 10, 60);
                        Greenfoot.setWorld(worldToActivate);
                        currentPosAtWorldList++;
                        worlds.remove(OutOfBouncePrevention);
                        if(player.getHasNecklace() == true){
                            Wife wife = new Wife();
                            wife.setImage("./images/Woman/End1.png");
                            worldToActivate.addObject(wife,230,53);
                            for(int i = 0 ; i < player.getInventory().length ; i++){
                                if(player.getInventory()[i] instanceof Necklace){
                                    player.getInventory()[i] = null;
                                }
                            }
                            Greenfoot.delay(80);
                            wife.setImage("./images/Woman/End2.png");
                            Greenfoot.delay(100);
                            Wife actor = new Wife();
                            // GAME ENDER
                            System.out.println("YOU WON!!!");
                            for(int i = 0; i < 1 ; i++){
                                actor.setImage("");
                            }
                        }
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
        setPaintOrder(ShopButtons.class,NpcShop.class,Player.class,Spawner.class,Mob.class,Bottle.class,TrashCan.class,Elevator.class,SubwayStation.class, NPC.class);
        checkWorldChange();
        checkWorldChangeUnderGround();
    }

    public Player getPlayer(){
        return player;
    }


}
