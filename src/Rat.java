public class Rat extends Mob{

    public void Rat(){
        setDamage(12);
        setLife(48);

    }
    public void act(){
        monsterAttack(10);
        monsterPerformMovement();
    }

}