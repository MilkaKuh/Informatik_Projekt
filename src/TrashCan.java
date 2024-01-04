import greenfoot.Actor;
import greenfoot.Greenfoot;
import greenfoot.*;
public class TrashCan extends Actor implements Interactable {
    private int coins;
    private Bottle bottle;
    TrashCan() {
        coins = Greenfoot.getRandomNumber(5);
        int containedBottle = Greenfoot.getRandomNumber(3);
        if (containedBottle == 0) {
            bottle = new WineBottle();
        }
        if (containedBottle == 1) {
            bottle = new VodkaBottle();
        }
        if (containedBottle == 2) {
            bottle = new BeerBottle();
        }
        if (containedBottle == 3) {
            bottle = new PlasticBottle();
        }
        this.setImage("TrashCan.png");
    }
    public int getCoins(){
        return coins;
    }
    public Bottle getBottle(){
        return bottle;
    }
    public void lootedCoins(){
        this.coins = 0;
    }
    public void lootedBottle(){
        this.bottle = null;
    }
    public Interactable interact(Player trigger, Interactable target) {
        return target;
    }
}
