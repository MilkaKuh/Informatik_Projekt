import greenfoot.World;

public class HitAnimation extends ImprovedActor{

    private int stayTime= 7;

    public void setStayTime(int stayTime) {
        this.stayTime = stayTime;
    }
    public int getStayTime() {
        return stayTime;
    }



    public void act(){
        if(stayTime == 0){
            World world = getWorld();
            world.removeObject(this);
        }   else{
            setStayTime(getStayTime() - 1);
        }

    }
}