public class Dog extends Mob{

    public void Dog(){
        setDamage(20);
        setLife(140);

    }

    public void act(){
        monsterPerformMovement();
        monsterAttack(15);
    }
}
