import java.util.LinkedList;
import java.util.List;

public class Spawner extends ImprovedActor {

    private int delay;

    private int amount;

    private int countdown;

    private int activator;

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
        this.amount = countdown;
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

    public void setActivator(int activator) {
        this.activator = activator;
    }

    private List<Mob> mobs = new LinkedList<Mob>();

    public Spawner(int maxAmount, int spawnDelay) {
        this.amount = maxAmount;
        this.delay = spawnDelay;
        this.countdown = spawnDelay;
        this.activator = 0;
    }

    public void act(){
        if(countdown<=0 && mobs.size() <= amount){
            Mob mob = new Mob();
            getWorld().addObject(mob, getX(), getY());
            countdown=delay;
            mobs.add(mob);
        }
        countdown--;

        checkMobs();
    }
    private void checkMobs(){
        for(Mob mob:mobs){
            if(!getWorld().getObjects(Mob.class).contains(mob)){
                mobs.remove(mobs);
            }
        }
    }
}