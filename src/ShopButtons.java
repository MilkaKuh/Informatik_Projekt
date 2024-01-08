import greenfoot.*;

import java.util.List;

public class ShopButtons extends Actor{
    protected Player player;
    protected World world;
    public ShopButtons(Player player, World world){
        this.player = player;
        this.world = world;
    }
    public void sellInv(Player player,ShopButtons sB){
        if(Greenfoot.isKeyDown("S")){
            for(int i = 0 ; i < player.getInventory().length ; i++){
                if(player.getInventory()[i] instanceof Bottle){
                    player.setCoins(player.getCoins() + ((Bottle) player.getInventory()[i]).getWorth());
                    player.getInventory()[i] = null;
                }
            }
        }
    }
    public void buyNecklace(Player player,ShopButtons sB){
        if(Greenfoot.isKeyDown("B")){
            if(player.getCoins() >= 750) {
                for (int i = 0; i < player.getInventory().length; i++) {
                    if (player.getInventory()[i] == null) {
                        player.getInventory()[i] = new Necklace();
                        player.setHasNecklace(true);
                        break;
                    }
                }
                player.setCoins(player.getCoins() - 750);
                List<NPC> npc = world.getObjects(NPC.class);
                if(npc.size() != 0){
                    npc.get(0).setImage("./images/NPCWN.png");
                }
            }else{
                System.out.println("Du hast noch nicht genügend Coins");
            }
        }
    }
}
