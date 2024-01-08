import greenfoot.Greenfoot;

public class Rat extends Mob{

    public Rat(){
        setDamage(2+ getLevel()*6);
        setLife(20 + getLevel()*8);

    }
    public void act(){
        monsterAttack(10,5);
        monsterPerformMovement();
        draw(getLevel());
    }

}