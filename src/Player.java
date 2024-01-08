import greenfoot.*;

import java.lang.reflect.Array;
import java.math.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author SAE
 * @version 1.0
 */

public class Player extends Character {
    //Attribute
    private int healCooldown;
    private String direction;
    private boolean isOverground;
    private InventoryVisualizer visualizer;
    private boolean usedSubwayStation = false;
    private Pickable[] inventory = new Pickable[12];
    private int currentHearts;
    private boolean hasNecklace;

    //Getter & Setter
    public boolean getIsOverground(){
        return isOverground;
    }

    public void setIsOverground(boolean x){
        this.isOverground = x;
    }

    public void setHealCooldown(int healCooldown) {
        this.healCooldown = healCooldown;
    }

    public int getHealCooldown() {
        return healCooldown;
    }

    public void setHasNecklace(boolean a){
        hasNecklace = a;
    }
    public boolean getHasNecklace(){
        return hasNecklace;
    }



    public Player() {
        setLevel(1);
        setLife(100);
        setStamina(100);
        setCoins(749);
        setExperience(0);
        setSpeed(1);
        setExperience(0);
        setIsOverground(true);
        setDamage(15);
        hasNecklace = false;
    }

    public void act() {
        System.out.println(this.getLife());
        performMovement();
        interact();
        if(Greenfoot.isKeyDown("F")){
            hit(Character.class, 30, this.getDamage());
            int xpGain = Greenfoot.getRandomNumber(100);
            if(xpGain == 7){
                setLevel(getLevel() + 1);
            }
        }
        if(this.healCooldown == 0 && getLife()<100){
            regenerateLife(1);
            setHealCooldown(10);
        }
        if(getLife()<100){
            setHealCooldown(getHealCooldown()-1);
        }
        List <Coins> coins = getWorld().getObjects(Coins.class);
        int coinsRn = this.getCoins();
        coins.get(0).setCoins(coinsRn);
        draw(getLevel());
        List <Hearts> hearts = getWorld().getObjects(Hearts.class);
        int lifeRn = this.getLife();
        hearts.get(0).setHearts(lifeRn);
        draw(getLevel());

    }
    //Methoden
    public void addedToWorld(World world) {
        visualizer = new InventoryVisualizer(inventory);
        world.addObject(visualizer, 0, world.getHeight() - 4);
    }


    public void regenerateLife(int healAmount){
        setLife(getLife()+1);
    }

    private void performMovement() {

        if (Greenfoot.isKeyDown("A")) {
            turn(Direction.WEST);
            if (getNextX(2) < 255 ){
                move(5);
            }

        }
        if (Greenfoot.isKeyDown("D")) {
            turn(Direction.EAST);
            if (getNextX(2) < 255 ){
                move(5);
            }

        }
    }



    public void interact() {
        if (Greenfoot.isKeyDown("E")) {
            List<Interactable> interactable = getObjectsInRange(13, Interactable.class);
            if (interactable.size() > 0) {
                for(int i = 0 ; i < interactable.size() ; i++){
                    if (interactable.get(i) instanceof SubwayStation){
                        interactSubway((SubwayStation) interactable.get(i));
                    }
                }
                for(int i = 0 ; i < interactable.size() ; i++){
                    if (interactable.get(i) instanceof Bottle) {
                        interactBottle( (Bottle) interactable.get(i));
                    }
                }
                for(int i = 0 ; i < interactable.size() ; i++) {
                    if (interactable.get(i) instanceof TrashCan) {
                        interactTrashCan((TrashCan) interactable.get(i));

                    }
                }
                for(int i = 0 ; i < interactable.size() ; i++){
                    if (interactable.get(i) instanceof NPC) {
                        interactNPC((NPC) interactable.get(i));
                    }
                }
                for(int i = 0 ; i < interactable.size() ; i++){
                    if (interactable.get(0) instanceof UndergroundTrashCan) {
                        interactUndergroundTrashCan((UndergroundTrashCan) interactable.get(i));
                    }
                }
                for(int i = 0 ; i < interactable.size() ; i++){
                    if (interactable.get(0) instanceof Elevator) {
                        interactElevator((Elevator) interactable.get(i));
                    }
                }
            }
        }
        Greenfoot.delay(1);
    }

    public void interactBottle(Bottle b) {
        for (int i = 0; i < inventory.length; i++) {
            if (inventory[i] == null) {
                inventory[i] = b;
                getWorld().removeObject(b);
                break;
            } else {
                System.out.println("Dein Inventar ist bereits voll");
            }
        }
    }

    public void interactTrashCan(TrashCan tc) {
        setCoins(getCoins() + tc.getCoins());
        tc.lootedCoins();
        if (tc.getLooted() == false) {
            for (int i = 0; i < inventory.length; i++) {
                if (inventory[i] == null) {
                    inventory[i] = tc.getBottle();
                    tc.lootedBottle();
                    tc.setLooted(true);
                }
                if(inventory[inventory.length - 1] != null){
                    System.out.println("Dein Inventar ist voll");
                }
            }

        }
    }
    public void interactUndergroundTrashCan(UndergroundTrashCan uTC ){
        setCoins(getCoins() + uTC.getCoins());
        uTC.lootedCoins();
        if (uTC.getLooted() == false) {
            for (int j = 0; j < inventory.length; j++) {
                if (inventory[j] == null) {
                    inventory[j] = uTC.getBottle()[0];
                    break;
                }
            }
            for (int i = 0 ; i < inventory.length; i++){
                if (inventory[i] == null) {
                    inventory[i] = uTC.getBottle()[1];
                    break;
                }
            }
            if(inventory[11] != null){
                System.out.println("Dein Inventar ist bereits voll");
            } else{
                uTC.lootedBottle();
            }
        }
    }

    public void interactSubway(SubwayStation s) {
        World w = s.getWorld();
        ((WorldTwo) w).usedStation();
        setUsedSubwayStation(true);
    }
    public void interactElevator(Elevator e) {
        World w = e.getWorld();
        ((SubwayWorldOne) w).usedElevator();
        setUsedSubwayStation(false);
    }
    public void setUsedSubwayStation(boolean a){
        this.usedSubwayStation = a;
    }
    public boolean getUsedSubwayStation(){
        return usedSubwayStation;
    }



    public void interactNPC(NPC npc){
        npc.openShop(this);

    }


    public Pickable[] getInventory() {
        return inventory;
    }
}
