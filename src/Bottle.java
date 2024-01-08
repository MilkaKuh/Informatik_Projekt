
public class Bottle extends Pickable implements Interactable{

    private int worth;


    public int getWorth() {
        return worth;
    }
    public void setWorth(int newWorth){
        this.worth = newWorth;
    }

    @Override
    public Interactable interact(Player trigger, Interactable target) {
        return null;
    }

    @Override
    public int getCoins() {
        return 0;
    }
}

