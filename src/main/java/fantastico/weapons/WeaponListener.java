package fantastico.weapons;

import io.papermc.paper.event.entity.EntityLoadCrossbowEvent;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.CrossbowMeta;

public class WeaponListener implements Listener {

    private final Weapons plugin;

    public WeaponListener(Weapons plugin){
        this.plugin = plugin;
    }

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
                            player.getWorld().playSound(player.getLocation(), "zyneon:crossbow.shotgun_shoot",1f,1f);
                            break;
                        case String s when s.startsWith("zyneon:marksman_pistol"):
                            player.getWorld().playSound(player.getLocation(), "zyneon:crossbow.marksman_pistol_shoot",1f,1f);
                            break;
                        case String s when s.startsWith("zyneon:mauser_c96"):
                            player.getWorld().playSound(player.getLocation(), "zyneon:crossbow.mauser_c96_shoot",1f,1f);
                            break;
                        case String s when s.startsWith("zyneon:lewis_gun"):
                            player.getWorld().playSound(player.getLocation(), "zyneon:crossbow.lewis_gun_shoot",1f,1f);
                            break;
                        case String s when s.startsWith("zyneon:luger"):
                            player.getWorld().playSound(player.getLocation(), "zyneon:crossbow.luger_shoot",1f,1f);
                            break;
                        case String s when s.startsWith("zyneon:rifle"):
                            player.getWorld().playSound(player.getLocation(), "zyneon:crossbow.rifle_shoot",1f,1f);
                            break;
                        case String s when s.startsWith("zyneon:sniper_rifle"):
                            player.getWorld().playSound(player.getLocation(), "zyneon:crossbow.rifle_shoot",1f,1f);
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

                if(meta instanceof CrossbowMeta cbMeta){
                    if(cbMeta.hasChargedProjectiles()){
                        return;
                    }
                }

                if(!meta.hasItemModel()){
                    player.getWorld().playSound(player.getLocation(), "zyneon:crossbow.crossbow_loading_start", 1f, 1f);
                    playWeaponReloadingMiddle(player,"zyneon:crossbow.crossbow_loading_middle");
                }
                else if(meta.hasItemModel()){
                    String weaponModel = meta.getItemModel().toString();

                    switch (weaponModel){
                        case String s when s.startsWith("zyneon:revolver"):
                            player.getWorld().playSound(player.getLocation(), "zyneon:crossbow.revolver_loading_start",1f,1f);
                            playWeaponReloadingMiddle(player,"zyneon:crossbow.revolver_loading_middle");
                            break;
                        case String s when s.startsWith("zyneon:shotgun"):
                            player.getWorld().playSound(player.getLocation(), "zyneon:crossbow.shotgun_loading_start",1f,1f);
                            playWeaponReloadingMiddle(player,"zyneon:crossbow.shotgun_loading_middle");
                            break;
                        case String s when s.startsWith("zyneon:marksman_pistol"):
                            player.getWorld().playSound(player.getLocation(), "zyneon:crossbow.marksman_pistol_loading_start",1f,1f);
                            playWeaponReloadingMiddle(player,"zyneon:crossbow.marksman_pistol_loading_middle");
                            break;
                        case String s when s.startsWith("zyneon:mauser_c96"):
                            player.getWorld().playSound(player.getLocation(), "zyneon:crossbow.mauser_c96_loading_start",1f,1f);
                            playWeaponReloadingMiddle(player,"zyneon:crossbow.mauser_c96_loading_middle");
                            break;
                        case String s when s.startsWith("zyneon:lewis_gun"):
                            player.getWorld().playSound(player.getLocation(), "zyneon:crossbow.lewis_gun_loading_start",1f,1f);
                            playWeaponReloadingMiddle(player,"zyneon:crossbow.lewis_gun_loading_middle");
                            break;
                        case String s when s.startsWith("zyneon:luger"):
                            player.getWorld().playSound(player.getLocation(), "zyneon:crossbow.luger_loading_start",1f,1f);
                            playWeaponReloadingMiddle(player,"zyneon:crossbow.luger_loading_middle");
                            break;
                        case String s when s.startsWith("zyneon:rifle"):
                            player.getWorld().playSound(player.getLocation(), "zyneon:crossbow.rifle_loading_start",1f,1f);
                            playWeaponReloadingMiddle(player,"zyneon:crossbow.rifle_loading_middle");
                            break;
                        case String s when s.startsWith("zyneon:sniper_rifle"):
                            player.getWorld().playSound(player.getLocation(), "zyneon:crossbow.rifle_loading_start",1f,1f);
                            playWeaponReloadingMiddle(player,"zyneon:crossbow.rifle_loading_middle");
                            break;
                        default:
                            player.getWorld().playSound(player.getLocation(), "zyneon:crossbow.crossbow_loading_start", 1f, 1f);
                            playWeaponReloadingMiddle(player,"zyneon:crossbow.crossbow_loading_middle");
                            break;
                    }
                }
            }
        }
    }

    private void playWeaponReloadingMiddle(Player player, String sound){
        Bukkit.getScheduler().runTaskLater(plugin, ()->{
            if(player.isHandRaised()){
                player.getWorld().playSound(player.getLocation(), sound, 1f, 1f);
            }
        }, 10L);
    }

    @EventHandler
    public void onWeapomReloadingEnd(EntityLoadCrossbowEvent event){
        if(event.getEntity() instanceof Player player){
            var meta = event.getCrossbow().getItemMeta();
            if(!meta.hasItemModel()){
                player.getWorld().playSound(player.getLocation(), "zyneon:crossbow.crossbow_loading_end", 1f, 1f);
            }
            else if(meta.hasItemModel()){
                String weaponModel = meta.getItemModel().toString();

                switch(weaponModel){
                    case String s when s.startsWith("zyneon:revolver"):
                        player.getWorld().playSound(player.getLocation(), "zyneon:crossbow.revolver_loading_end",1f,1f);
                        break;
                    case String s when s.startsWith("zyneon:shotgun"):
                        player.getWorld().playSound(player.getLocation(), "zyneon:crossbow.shotgun_loading_end",1f,1f);
                        break;
                    case String s when s.startsWith("zyneon:marksman_pistol"):
                        player.getWorld().playSound(player.getLocation(), "zyneon:crossbow.marksman_pistol_loading_end",1f,1f);
                        break;
                    case String s when s.startsWith("zyneon:mauser_c96"):
                        player.getWorld().playSound(player.getLocation(), "zyneon:crossbow.mauser_c96_loading_end",1f,1f);
                        break;
                    case String s when s.startsWith("zyneon:lewis_gun"):
                        player.getWorld().playSound(player.getLocation(), "zyneon:crossbow.lewis_gun_loading_end",1f,1f);
                        break;
                    case String s when s.startsWith("zyneon:luger"):
                        player.getWorld().playSound(player.getLocation(), "zyneon:crossbow.luger_loading_end",1f,1f);
                        break;
                    case String s when s.startsWith("zyneon:rifle"):
                        player.getWorld().playSound(player.getLocation(), "zyneon:crossbow.rifle_loading_end",1f,1f);
                        break;
                    case String s when s.startsWith("zyneon:sniper_rifle"):
                        player.getWorld().playSound(player.getLocation(), "zyneon:crossbow.rifle_loading_end",1f,1f);
                        break;
                    default:
                        player.getWorld().playSound(player.getLocation(), "zyneon:crossbow.crossbow_loading_end", 1f, 1f);
                        break;
                }
            }
        }
    }
}
