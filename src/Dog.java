public class Dog extends Mob{
    private int dogDamage = 15;
    public void Dog(){
        setDamage(15);
        setLife(75);

    }

    public void act(){
        monsterPerformMovement();
        monsterAttack(15, getDogDamage());
    }

    public int getDogDamage() {
        return dogDamage;
    }

    public void setDogDamage(int dogDamage) {
        this.dogDamage = dogDamage;
    }
}
