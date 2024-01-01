public class Bottle extends ImprovedActor{

    private int worth;


    public int getWorth() {
        return worth;
    }
    public void setWorth(int newWorth){
        this.worth = newWorth;
        getImage().drawString(String.valueOf(worth), 0, 10);
    }
}

