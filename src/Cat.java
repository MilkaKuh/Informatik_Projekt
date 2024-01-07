public class Cat extends Mob{

    private int catDamage = 10;
    public void Cat(){
        setDamage(10);
        setLife(50);
    }
    public void act(){
        monsterPerformMovement();
        monsterAttack(10, getCatDamage());
    }

    public int getCatDamage() {
        return catDamage;
    }

    public void setCatDamage(int catDamage) {
        this.catDamage = catDamage;
    }
}
