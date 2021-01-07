package cl.bebt.bangui;

import cl.bebt.bangui.commands.Ban;
import cl.bebt.bangui.commands.Core;
import cl.bebt.bangui.commands.lunarStaff;
import cl.bebt.bangui.menu.listeners.GetBanReason;
import cl.bebt.bangui.menu.listeners.MenuListener;
import cl.bebt.bangui.utils.UpdateChecker;
import cl.bebt.bangui.utils.utils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import java.util.HashMap;

public final class main extends JavaPlugin {

    public static HashMap<Player, Boolean> admitted = new HashMap<>();
    public static HashMap<Player, Boolean> ban_ip = new HashMap<>();
    public static HashMap<Player, Boolean> banning = new HashMap<>();
    public static HashMap<Player, String> baned = new HashMap<>();
    public static main plugin;

    @Override
    public void onEnable() {
        reloadConfig();
        saveDefaultConfig();
        plugin = this;
        Bukkit.getPluginManager().registerEvents(new MenuListener(), this);
        Bukkit.getPluginManager().registerEvents(new GetBanReason(this), this);
        new Core(this);
        new lunarStaff(this);
        new Ban(this);
        new UpdateChecker(this, 85444).getLatestVersion(version -> {
            if (plugin.getDescription().getVersion().equals(version)) {
                Bukkit.getConsoleSender().sendMessage(utils.chat(plugin.getConfig().getString("server_prefix") + "&aYou are using &bBanGui++!"+plugin.getDescription().getVersion()));
            } else {
                Bukkit.getConsoleSender().sendMessage(utils.chat(plugin.getConfig().getString("server_prefix") + "&cHey, there is a new version out!"));
                Bukkit.getConsoleSender().sendMessage(utils.chat(plugin.getConfig().getString("server_prefix") + "&b      BanGui++ "+version));
            }
        });
        Bukkit.getConsoleSender().sendMessage(utils.chat("&aThe plugin BanGui++ has being correctly activated!"));
    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage(utils.chat("&cThe plugin BanGui++ has being correctly deactivated!"));
    }
}
