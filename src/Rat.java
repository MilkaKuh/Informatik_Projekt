import greenfoot.Greenfoot;

public class Rat extends Mob{

    public Rat(){
        setDamage(2+ getLevel()*3);
        setLife(20 + getLevel()*3);

    }
    public void act(){
        monsterAttack(10,getDamage());
        monsterPerformMovement();
        draw(getLevel());
    }

}