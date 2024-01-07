public class Rat extends Mob{

    private int ratDamage = 5;

    public void Rat(){
        setDamage(5);
        setLife(30);

    }
    public void act(){
        monsterAttack(10, getRatDamage());
        monsterPerformMovement();
    }

    public void setRatDamage(int ratDamage) {
        this.ratDamage = ratDamage;
    }

    public int getRatDamage() {
        return ratDamage;
    }
}