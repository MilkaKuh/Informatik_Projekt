import greenfoot.Greenfoot;

import java.util.LinkedList;
import java.util.List;

public class Spawner extends ImprovedActor {

    private int delay;

    private int amount;

    private int countdown;

    private int activator;


    private int maxMonsterCount;

    private int spawnerType;

    public int getDelay() {
        return delay;
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getCountdown() {
        return countdown;
    }

    public void setCountdown(int countdown) {
        this.countdown = countdown;
    }

    public int getActivator() {
        return activator;
    }

    public void setmaxMonsterCount(int maxMonsterCount) {
        this.maxMonsterCount = maxMonsterCount;
    }

    public int getmaxMonsterCount() {
        return maxMonsterCount;
    }


    public void setActivator(int activator) {
        this.activator = activator;
    }

    private List<Mob> mobs = new LinkedList<Mob>();

    public Spawner() {
        this.amount = Greenfoot.getRandomNumber(15);
        while(amount < 7){
            this.amount = Greenfoot.getRandomNumber(8);
        }
        this.delay = 100;
        this.countdown = 10;
        this.activator = 0;
        maxMonsterCount = Greenfoot.getRandomNumber(6);
        while(maxMonsterCount < 3){
            maxMonsterCount = Greenfoot.getRandomNumber(5);
        }
        System.out.println(amount);
    }

    public void act() {
        if(getNumMobs() == maxMonsterCount){
            countdown = countdown -1;
        }else{
            countdown = countdown -3;
        }
        int spawnerType = Greenfoot.getRandomNumber(3);
        if(spawnerType == 0){
            if (countdown <= 0 && getNumMobs() < maxMonsterCount && amount > 0) {
                Cat cat = new Cat();
                getWorld().addObject(new Cat(), getX(), getY());
                countdown = delay;
                setAmount(amount - 1);
                getNumMobs();

            }
        }

        if(spawnerType == 1){
            if (countdown <= 0 && getNumMobs() < maxMonsterCount && amount > 0) {
                Dog dog = new Dog();
                getWorld().addObject(new Dog(), getX(), getY());
                countdown = delay;
                setAmount(amount - 1);
                getNumMobs();

            }
        }   else {
            if(spawnerType == 2){
                if (countdown <= 0 && getNumMobs() < maxMonsterCount && amount > 0) {
                    Rat rat = new Rat();
                    getWorld().addObject(new Rat(), getX(), getY());
                    countdown = delay;
                    setAmount(amount - 1);
                    getNumMobs();

                }
            }
        }



    }
    public int getNumMobs(){

        List <Mob> mobs = getWorld().getObjects(Mob.class);
        int numMobs = mobs.size();
        return numMobs;


    }
}

