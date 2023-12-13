import greenfoot.*;

import java.util.List;

/**
 * @author SAE
 * @version 1.0
 */
public class Player extends Character {
    //Attribute

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

    private void performMovement() {
        if (Greenfoot.isKeyDown("W")) {
            turn(Direction.NORTH);
            if (!canMove()) {
                setLife(getLife() - 10);
            } else {
                move();
            }
        }
        if (Greenfoot.isKeyDown("A")) {
            turn(Direction.WEST);
            if (!canMove()) {
                setLife(getLife() - 10);
            } else {
                move();
            }
        }
        if (Greenfoot.isKeyDown("S")) {
            turn(Direction.SOUTH);
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
            List<Character> characters = getObjectsInRange(1, Character.class);
            if (characters.size() > 0) {
                Character character = characters.get(0);
                character.setInteract(true);
            }

        }
    }
}
