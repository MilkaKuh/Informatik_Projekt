import greenfoot.Actor;
import greenfoot.Greenfoot;
import greenfoot.World;

import java.util.List;

public class Character extends MovingActor {
    //Attribute

    private int life = 100;
    private int level = 1;
    private int stamina = 25;
    private int coins = 0;
    private int speed = 1;
    private int experience = 0;
    private int damage = 10;

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

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    //Methoden

    public void hit(Class<? extends Character> cls){
        World world = getWorld();
        List<? extends Character> enemies = getObjectsInRange(1, cls);
        if(enemies.size() > 0) {
            Character enemy = enemies.get(0);
            enemy.setLife(getLife() - getDamage()*getLevel());
            if (enemy.getLife() < 1){
                world.removeObject(enemy);
            }
        }
    }

}
