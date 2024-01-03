import greenfoot.Actor;
import greenfoot.World;
public class Bottle extends Pickable{

    private int worth;


    public int getWorth() {
        return worth;
    }
    public void setWorth(int newWorth){
        this.worth = newWorth;
        getImage().drawString(String.valueOf(worth), 0, 10);
    }
}

