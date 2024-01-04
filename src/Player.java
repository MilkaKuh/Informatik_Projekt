import greenfoot.*;

import java.util.List;

/**
 * @author SAE
 * @version 1.0
 */
public class Player extends Character {
    //Attribute
    private InventoryVisualizer visualizer;
    Pickable[] inventory = new Pickable[8];

    //Getter & Setter

    public Player() {
        setLevel(1);
        setLife(100);
        setStamina(100);
        setCoins(0);
        setExperience(0);
        setSpeed(1);
        setExperience(0);
    }

    //Methoden
    public void addedToWorld(Worlds world) {
        visualizer = new InventoryVisualizer(inventory);
        getWorld().addObject(visualizer, 0, world.getHeight() - 1);
    }

    private void performMovement() {
        if (Greenfoot.isKeyDown("A")) {
            turn(Direction.WEST);
            if (!canMove()) {
                setLife(getLife() - 10);
            } else {
                move();
            }
        }
        if (Greenfoot.isKeyDown("D")) {
            turn(Direction.EAST);
            if (!canMove()) {
                setLife(getLife() - 10);
            } else {
                move();
            }
        }
    }

    public void move() {
        if (getStamina() > 0) {
            move(1);
            setStamina(getStamina() - 10);
        }

    }

    public void interact() {
        if (Greenfoot.isKeyDown("E")) {
            List<Interactable> interactable = getObjectsInRange(1, Interactable.class);
            if (interactable.size() > 0) {
                if (interactable.get(0) instanceof Bottle) {
                    interactBottle(interactable);
                }
                if (interactable.get(0) instanceof TrashCan) {
                    interactTrashCan(interactable);
                }
                /*
                if (interactable.get(0) instanceof NPC) {
                    interactNPC(interactable);
                }

                */
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
        for (int i = 0; i < inventory.length; i++) {
            if (inventory[i] == null) {
                inventory[i] = tc.getBottle();
                tc.lootedBottle();
            } else {
                System.out.println("Dein Inventar ist bereits voll");
            }
        }
    }

    public void interactSubway(){

    }

    /*
    public void interactNPC(List<Interactable> objects){
        NPC npc = (NPC) objects.get(0);

    }
    */
}
