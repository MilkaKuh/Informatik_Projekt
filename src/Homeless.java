public class Homeless extends Mob{

    public Homeless(){
        setDamage(30);
    }
    public void act(){

        monsterPerformMovement();
        monsterAttack(30, this.getDamage());
    }
}
