public class Consumables extends ImprovedActor{

    private int worth;

    private int hydration;

    public int getWorth() {
        return worth;
    }
    public void setWorth(int newWorth){
        this.worth = newWorth;
        getImage().drawString(String.valueOf(worth), 0, 10);
    }

    public int getHydration(){
        return worth;
    }

    public void setHydration(int hydration){
        this.hydration = hydration;
    }
}

