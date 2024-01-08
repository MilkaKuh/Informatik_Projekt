import greenfoot.*;
public class SellButton extends ShopButtons {
    private ShopButtons sb;
    public SellButton(Player player, World world){
        super(player, world);
        this.sb = this;
    }
    public void act(){
        if(Greenfoot.isKeyDown("Escape")){
            player.getWorld().removeObject(sb);
        }
        sellInv(player,sb);
    }
}
