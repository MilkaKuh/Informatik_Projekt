public class NPC extends Character{
    public NPC(){
        setLife(Integer.MAX_VALUE);
        setSpeed(0);
        setStamina(0);
        setCoins(Integer.MAX_VALUE);
        setDamage(0);
    }
    public int sellBottle(Bottle b){
        return b.getWorth();
    }
}
//Shopsystem mit flaschenankauf und item verkauf