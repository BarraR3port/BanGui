package cl.bebt.bangui.commands;

import cl.bebt.bangui.main;
import cl.bebt.bangui.menu.PlayerMenuUtility;
import cl.bebt.bangui.menu.bangui.BanMenu;
import cl.bebt.bangui.utils.utils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Ban implements CommandExecutor {
    private final main plugin;

    public Ban(main plugin) {
        this.plugin = plugin;
        plugin.getCommand("punish").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (p.hasPermission("bangui.ban")) {
                if (args.length == 1) {
                    new BanMenu(new PlayerMenuUtility(p), plugin, p, args[0]).open(p);
                } else {
                    utils.tell(p, utils.getString("server_prefix") + "&cUse /punish <PlayerName>");
                }
            } else {
                utils.tell(p, utils.getString("server_prefix") + utils.getString("no_permissions"));
            }
        } else {
            utils.tell(sender, "&cThis command can only be used by players.");
        }

        return true;
    }
}
