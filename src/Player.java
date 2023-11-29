import greenfoot.*;

import java.util.List;

/**
 * @author SAE
 * @version 1.0
 */
public class Player extends MovingActor {
    //Attribute

    private int life = 100;
    private int level = 1;
    private int stamina = 25;
    private int coins = 0;
    private int speed = 1;
    private int experience = 0;

    //Getter & Setter

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    //Methoden

    private void performMovement() {
        if (Greenfoot.isKeyDown("W")) {
            turn(Direction.NORTH);
            if (!canMove()) {
                setLife(this.life - 10);
            } else {
                move();
            }
        }
        if (Greenfoot.isKeyDown("A")) {
            turn(Direction.WEST);
            if (!canMove()) {
                setLife(this.life - 10);
            } else {
                move();
            }
        }
        if (Greenfoot.isKeyDown("S")) {
            turn(Direction.SOUTH);
            if (!canMove()) {
                setLife(this.life - 10);
            } else {
                move();
            }
        }

        if (Greenfoot.isKeyDown("D")) {
            turn(Direction.EAST);
            if (!canMove()) {
                setLife(this.life - 10);
            } else {
                move();
            }
        }
    }

    public void move() {
        if (stamina > 0) {
            move(1);
            setStamina(this.stamina - 10);
        }

    }
}
