package fantastico.weapons;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class Weapons extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info("Weapons-Plugin enabled");
        getServer().getPluginManager().registerEvents(new WeaponListener(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("Weapons-Plugin disabled");
    }
}
