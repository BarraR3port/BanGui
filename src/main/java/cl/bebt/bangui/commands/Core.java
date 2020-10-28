package cl.bebt.bangui.commands;

import cl.bebt.bangui.main;
import cl.bebt.bangui.utils.utils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;

import java.util.ArrayList;
import java.util.List;

public class Core implements TabExecutor {
    private final main plugin;

    public Core(main plugin) {
        this.plugin = plugin;
        plugin.getCommand("core").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender.hasPermission("ashland.core")) {
            if (args.length == 0) {
                utils.tell(sender, plugin.getConfig().getString("error_msg"));
            } else if (args.length == 1) {
                if (args[0].equalsIgnoreCase("reload")) {
                    plugin.reloadConfig();
                    utils.tell(sender, plugin.getConfig().getString("reload"));
                }
            }
        } else {
            utils.tell(sender, plugin.getConfig().getString("no_permissions"));
        }
        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if (args.length == 1) {
            List<String> version = new ArrayList<>();
            version.add("reload");
            return version;
        }
        return null;
    }
}
