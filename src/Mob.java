import greenfoot.Actor;
import greenfoot.Greenfoot;

public class Mob extends Character{
    public void monsterPerformMovement() {
        int rngDirection = Greenfoot.getRandomNumber(2);
        int steps = Greenfoot.getRandomNumber(2);

        if (rngDirection == 0) {
            turn(Direction.WEST);
            move(steps);
        }
        if (rngDirection == 1) {
            turn(Direction.EAST);
            move(steps);
        }

    }

    public void act(){
        monsterPerformMovement();
    }
}
