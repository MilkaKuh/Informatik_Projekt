import greenfoot.*;
import java.util.*;
public class NPC extends Character implements Interactable{
    private World world;
    public NPC(){
        setLife(10000);
        setSpeed(0);
        setStamina(0);
        setCoins(10000);
        setDamage(0);
    }
    public int sellBottle(Bottle b){
        return b.getWorth();
    }
    public void openShop(Player player){
        getWorld().addObject(new NpcShop(player), getX(),getY());
    }


    public void act(){
        if(getLife() <= 0){

        }
    }
    @Override
    public Interactable interact(Player trigger, Interactable target) {
        return null;
    }
}

//Shopsystem mit flaschenankauf und item verkauf