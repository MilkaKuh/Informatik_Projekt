import greenfoot.Greenfoot;

public class Cat extends Mob{
    public Cat(){
        setDamage(8+ getLevel()*2);
        setLife(35 + getLevel()*5);

    }
    public void act(){
        monsterPerformMovement();
        monsterAttack(10,10);
        draw(getLevel());
    }
}
