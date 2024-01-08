import greenfoot.Actor;
import greenfoot.Greenfoot;

import java.lang.reflect.Array;
import java.util.*;
import greenfoot.*;

public class UndergroundTrashCan extends Actor implements Interactable {
    private int coins;
    private Bottle[] bottle = new Bottle[2];

    private boolean looted = false;
    public UndergroundTrashCan() {
        coins = 3 + Greenfoot.getRandomNumber(7);

        int blabla = Greenfoot.getRandomNumber(4);
        System.out.println(blabla);

        for (int i = 0; i < 2; i++) {
            int containedBottle = Greenfoot.getRandomNumber(4);
            if (containedBottle == 0) {
                bottle[i] = new WineBottle();
            }
            else if (containedBottle == 1) {
                bottle[i] = new VodkaBottle();
                }
            else if (containedBottle == 2) {
                bottle[i] = new BeerBottle();
                }
            else {
                bottle[i] = new PlasticBottle();
                }
            }
        }
    public int getCoins(){
        return coins;
    }
    public Bottle[] getBottle(){
        return bottle;
    }
    public void lootedCoins(){
        this.coins = 0;
    }
    public void lootedBottle(){
            for(int i= 0 ; i< 2 ; i++){
                bottle[i] = null;
                setImage("./images/TrashCanOpen.png");
            }
    }

    public void setLooted(boolean looted) {
        setImage("./images/TrashCanOpen.png");
        this.looted = looted;
    }

    public boolean getLooted(){
        return looted;
    }

    public Interactable interact(Player trigger, Interactable target) {
        return target;
    }
}
