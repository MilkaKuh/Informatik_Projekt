import greenfoot.Greenfoot;
import greenfoot.MouseInfo;
import greenfoot.*;
import java.util.*;
public class NeckLaceBuyButton extends ShopButtons{
    private ShopButtons sb;
    public NeckLaceBuyButton(Player player, World world){
        super(player, world);
        this.sb = this;

    }
    public void act(){
        if(Greenfoot.isKeyDown("Escape")){
            world.removeObject(sb);
        }
        buyNecklace(player,sb);

    }
}
