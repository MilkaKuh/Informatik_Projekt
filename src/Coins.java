import greenfoot.Actor;
import greenfoot.*;
import java.util.List;
public class Coins extends ImprovedActor{

    private int coins;

    private static final GreenfootImage COINS_IMG = new GreenfootImage(".\\images\\Coin.png");

    public Coins(){
        setImage(new GreenfootImage(Coins.COINS_IMG));
    }

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }


    public void act() {
        super.act();
        draw(coins);
    }
}
