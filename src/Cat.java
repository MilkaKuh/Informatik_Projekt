public class Cat extends Mob{
    public void Cat(){
        setDamage(40);
        setLife(100);

    }
    public void act(){
        monsterPerformMovement();
        monsterAttack(10);
    }
}
