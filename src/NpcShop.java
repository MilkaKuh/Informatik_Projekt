import greenfoot.*;

public class NpcShop extends NPC{
    private Player player;
    public NpcShop(Player player){
        this.player = player;
    }
    public void act(){
        if(Greenfoot.isKeyDown("Escape")){
            player.getWorld().removeObject(this);
        }
    }
    public void addedToWorld(World world){
        addShopButtons(player, player.getWorld());
    }

    public void addShopButtons(Player player, World world){
        world.addObject(new SellButton(player,world),getX()-8 ,getY() +10);
        world.addObject(new NeckLaceBuyButton(player,world),getX() + 7,getY()+10);
    }

}
