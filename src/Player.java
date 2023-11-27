import greenfoot.*;

import java.util.List;

/**
 * @author SAE
 * @version 1.0
 */
public class Player extends Actor {
    //Attribute

    private int life = 100;
    private int level = 1;
    private int stamina = 25;
    private int coins = 0;
    private int speed = 1;


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
}
