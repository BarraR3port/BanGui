package cl.bebt.bangui.commands;

import cl.bebt.bangui.main;
import cl.bebt.bangui.menu.PlayerMenuUtility;
import cl.bebt.bangui.menu.lunar.LunarPlayerList;
import cl.bebt.bangui.utils.SMManager;
import cl.bebt.bangui.utils.utils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class lunarStaff implements CommandExecutor {

    private final main plugin;

    public lunarStaff(main plugin) {
        this.plugin = plugin;
        plugin.getCommand("lunar").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (p.hasPermission("bangui.lunar")) {
                if (args.length == 0) {
                    SMManager.setStaffModules(p);
                } else if (args.length == 1) {
                    if (args[0].equals("gui")) {
                        new LunarPlayerList(new PlayerMenuUtility(p), plugin).open(p);
                    } else {
                        utils.tell(p, plugin.getConfig().getString("server_prefix")+"&cUse /lunar gui");
                    }
                }
            } else {
                utils.tell(p, plugin.getConfig().getString("server_prefix")+plugin.getConfig().getString("no_permissions"));
            }
        } else{
            utils.tell(sender,plugin.getConfig().getString("server_prefix")+"&cThis command can only be used by players");
        }
        return false;
    }
}
