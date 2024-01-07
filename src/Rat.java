public class Rat extends Mob{

    public void Rat(){
        setDamage(3);
        setLife(12);

    }
    public void act(){
        monsterAttack(10,5);
        monsterPerformMovement();
    }

}