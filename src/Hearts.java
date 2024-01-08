import greenfoot.Actor;
import greenfoot.*;
import java.util.List;
public class Hearts extends ImprovedActor{

    private int hearts;

    private static final GreenfootImage Hearts_IMG = new GreenfootImage(".\\images\\Hearts.png");

    public Hearts(){
        setImage(new GreenfootImage(Hearts.Hearts_IMG));
    }

    public int getHearts() {
        return hearts;
    }

    public void setHearts(int hearts) {
        this.hearts = hearts;
    }


    public void act() {
        super.act();
        draw(hearts);
    }
}
