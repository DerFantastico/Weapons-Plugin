package fantastico.weapons;

import io.papermc.paper.event.entity.EntityLoadCrossbowEvent;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

public class WeaponListener implements Listener {

    @EventHandler
    public void onWeaponShot(EntityShootBowEvent event){
        if(event.getEntity() instanceof Player player){
            ItemStack weapon = event.getBow();
            if(weapon != null && weapon.getType() == Material.CROSSBOW){
                var meta = weapon.getItemMeta();

                if(!meta.hasItemModel()){
                    player.getWorld().playSound(player.getLocation(), "zyneon:crossbow.crossbow_shoot", 1f,1f);
                }
                else if(meta.hasItemModel()){
                    String weaponModel = meta.getItemModel().toString();

                    switch (weaponModel){
                        case String s when s.startsWith("zyneon:revolver"):
                            player.getWorld().playSound(player.getLocation(), "zyneon:crossbow.revolver_shoot",1f,1f);
                            break;
                        case String s when s.startsWith("zyneon:shotgun"):

                            break;
                        case String s when s.startsWith("zyneon:marksman_pistol"):

                            break;
                        case String s when s.startsWith("zyneon:mauser_c96"):

                            break;
                        case String s when s.startsWith("zyneon:lewis_gun"):

                            break;
                        case String s when s.startsWith("zyneon:luger"):

                            break;
                        case String s when s.startsWith("zyneon:rifle"):

                            break;
                        case String s when s.startsWith("zyneon:sniper_rifle"):

                            break;
                        default:
                            player.getWorld().playSound(player.getLocation(), "zyneon:crossbow.crossbow_shoot", 1f,1f);
                            break;
                    }
                }
            }
        }
    }

    @EventHandler
    public void onWeaponReloadingStart(PlayerInteractEvent event){
        //TODO verhindern, dass das event auch bei schießen triggert
        if(event.getAction().isRightClick() && event.hasItem()){
            ItemStack weapon = event.getItem();
            if(weapon != null && weapon.getType() == Material.CROSSBOW){
                var meta = weapon.getItemMeta();
                Player player = event.getPlayer();

                if(!meta.hasItemModel()){
                    //default crossbow nachlade sound start
                }
                else if(meta.hasItemModel()){
                    String weaponModel = meta.getItemModel().toString();

                    switch (weaponModel){
                        case String s when s.startsWith("zyneon:revolver"):
                            player.getWorld().playSound(player.getLocation(), "zyneon:crossbow.revolver_loading_start",1f,1f);
                            //delay?
                            player.getWorld().playSound(player.getLocation(), "zyneon:crossbow.revolver_loading_middle",1f,1f);
                            break;
                        case String s when s.startsWith("zyneon:shotgun"):

                            break;
                        case String s when s.startsWith("zyneon:marksman_pistol"):

                            break;
                        case String s when s.startsWith("zyneon:mauser_c96"):

                            break;
                        case String s when s.startsWith("zyneon:lewis_gun"):

                            break;
                        case String s when s.startsWith("zyneon:luger"):

                            break;
                        case String s when s.startsWith("zyneon:rifle"):

                            break;
                        case String s when s.startsWith("zyneon:sniper_rifle"):

                            break;
                        default:
                            //default crossbow nachlade sound start
                            break;
                    }
                }
            }
        }
    }

    @EventHandler
    public void onWeapomReloadingEnd(EntityLoadCrossbowEvent event){
        if(event.getEntity() instanceof Player player){
            var meta = event.getCrossbow().getItemMeta();
            if(!meta.hasItemModel()){

            }
            else if(meta.hasItemModel()){
                String weaponModel = meta.getItemModel().toString();

                switch(weaponModel){
                    case String s when s.startsWith("zyneon:revolver"):
                        player.getWorld().playSound(player.getLocation(), "zyneon:crossbow.revolver_loading_end",1f,1f);
                        break;
                    case String s when s.startsWith("zyneon:shotgun"):

                        break;
                    case String s when s.startsWith("zyneon:marksman_pistol"):

                        break;
                    case String s when s.startsWith("zyneon:mauser_c96"):

                        break;
                    case String s when s.startsWith("zyneon:lewis_gun"):

                        break;
                    case String s when s.startsWith("zyneon:luger"):

                        break;
                    case String s when s.startsWith("zyneon:rifle"):

                        break;
                    case String s when s.startsWith("zyneon:sniper_rifle"):

                        break;
                    default:

                        break;
                }
            }
        }
    }
}
