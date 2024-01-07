import greenfoot.*;

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

    Pickable[] inventory = new Pickable[12];

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

    public Player() {
        setLevel(1);
        setLife(100);
        setStamina(100);
        setCoins(0);
        setExperience(0);
        setSpeed(1);
        setExperience(0);
        setIsOverground(true);
        setDamage(15);
    }

    public void act() {
        performMovement();
        interact();
        if(Greenfoot.isKeyDown("F")){
            hit(Character.class, 30, this.getDamage());
        }
        if(healCooldown==0 && getLife()<100){
            regenerateLife(1);
            setHealCooldown(10);
        }
        if(getLife()<100){
            setHealCooldown(getHealCooldown()-1);
        }
        List <Coins> coins = getWorld().getObjects(Coins.class);
        int coinsRn = this.getCoins();
        coins.get(0).setCoins(coinsRn);
    }
    //Methoden
    public void addedToWorld(World world) {
        visualizer = new InventoryVisualizer(inventory);
        world.addObject(visualizer, 0, world.getHeight() - 3);
    }



    public void setDirection(String direction){
        this.direction = direction;
    }
    public String getDirection(){
        return direction;
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
                        interactSubway(interactable);
                    }
                }
                for(int i = 0 ; i < interactable.size() ; i++){
                    if (interactable.get(i) instanceof Bottle) {
                        interactBottle(interactable);
                    }
                }
                for(int i = 0 ; i < interactable.size() ; i++) {
                    if (interactable.get(0) instanceof TrashCan) {
                        interactTrashCan(interactable);

                    }
                }
                for(int i = 0 ; i < interactable.size() ; i++){
                    if (interactable.get(0) instanceof NPC) {
                        interactNPC(interactable);
                    }
                }
            }
        }
    }

    public void interactBottle(List<Interactable> objects) {
        Bottle b = (Bottle) objects.get(0);
        for (int i = 0; i < inventory.length; i++) {
            if (inventory[i] == null) {
                inventory[i] = b;
                getWorld().removeObject(b);
            } else {
                System.out.println("Dein Inventar ist bereits voll");
            }
        }
    }

    public void interactTrashCan(List<Interactable> objects) {
        TrashCan tc = (TrashCan) objects.get(0);
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

    public void interactSubway(List<Interactable> objects) {
        SubwayStation s = (SubwayStation) objects.get(0);
        World w = s.getWorld();
        ((WorldTwo) w).usedStation();
        setUsedSubwayStation(true);
    }
    public void setUsedSubwayStation(boolean a){
        this.usedSubwayStation = a;
    }
    public boolean getUsedSubwayStation(){
        return usedSubwayStation;
    }



    public void interactNPC(List<Interactable> objects){
        NPC npc = (NPC) objects.get(0);
        for (int i = 0; i < inventory.length; i++) {
            setCoins(getCoins()+npc.sellBottle((Bottle) inventory[i]));
            inventory[i] = null;
        }

    }


}
