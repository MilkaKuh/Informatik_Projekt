public class Dog extends Mob{

    public void Dog(){
        setDamage(5);
        setLife(35);

    }

    public void act(){
        monsterPerformMovement();
        monsterAttack(15);
    }
}
