import greenfoot.Greenfoot;
import greenfoot.World;


public class LeftWorld extends Worlds {

    public LeftWorld() {
        super();
        setBackground("./images/BackgroundLeft.png");
        setPaintOrder(Player.class);
        addObject(new Player(), 0, 75);
        getWorldList().add(this);
        int treeAmount = Greenfoot.getRandomNumber(3);
        for (int i = 1; i <= treeAmount; i++) {
            int treeCoordinates = Greenfoot.getRandomNumber(100);
            addObject(new Tree(), treeCoordinates, 65);

        }
    }
}
