import greenfoot.Greenfoot;
import greenfoot.World;

import java.util.ArrayList;
import java.util.List;

public class Worlds extends World {
    private ArrayList<Worlds> world = new ArrayList<Worlds>();
    public Worlds() {
        super(100, 75, 10);
        int x = Greenfoot.getRandomNumber(1);
        if (x == 0) {
            addObject(new TrashCan(), Greenfoot.getRandomNumber(90), 0);
        } else {
            TrashCan tC = new TrashCan();
            addObject(tC, Greenfoot.getRandomNumber(90), 0);
            boolean canSpawn = false;
            while (canSpawn = false){
                int secondTrashCanX = Greenfoot.getRandomNumber(90);
                if (tC.getX() + 10 > secondTrashCanX && tC.getX() - 10 < secondTrashCanX){
                    addObject(new TrashCan(),secondTrashCanX , 0);
                    canSpawn = true;
                }
            }
        }
    }
    public ArrayList<Worlds> getWorldList(){
        return world;
    }
}
