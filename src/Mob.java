import greenfoot.Actor;
import greenfoot.Greenfoot;
import greenfoot.World;

import java.util.List;

public class Mob extends Character{

    private int hitCooldown = 10;



    public void monsterPerformMovement() {
        int rngDirection = Greenfoot.getRandomNumber(2);
        int steps = Greenfoot.getRandomNumber(3) + 4;

        if (rngDirection == 0) {
            turn(Direction.WEST);
            move(steps);
        }
        if (rngDirection == 1) {
            turn(Direction.EAST);
            move(steps);
        }

    }

    public void monsterAttack(int radius) {
        if (hitCooldown == 0) {
            hit(Player.class, radius);
            hitCooldown = 10;
            World world = getWorld();
            }
        hitCooldown = hitCooldown - 1;
    }

    public void act(){
        monsterPerformMovement();
        }
    }

