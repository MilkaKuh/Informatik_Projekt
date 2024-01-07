import greenfoot.Actor;
import greenfoot.*;
import java.util.List;
import greenfoot.GreenfootImage;

public class Hearts extends ImprovedActor{

    private int hearts;

    public int getHearts() {
        return hearts;
    }

    public void setHearts(int hearts) {
        this.hearts = hearts;
    }

    private static final GreenfootImage HEARTS_IMG = new GreenfootImage(".\\images\\Hearts.png");

    public Hearts(){
        setImage(new GreenfootImage(Hearts.HEARTS_IMG));
    }

    public void act() {
        super.act();
    }
}
