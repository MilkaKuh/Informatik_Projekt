import greenfoot.Greenfoot;

public class Dog extends Mob{

    public Dog(){
        setDamage(5 + getLevel()*2);
        setLife(35 + getLevel()*2);


    }

    public void act(){
        monsterPerformMovement();
        monsterAttack(15,getDamage());
        draw(getLevel());

    }
}
