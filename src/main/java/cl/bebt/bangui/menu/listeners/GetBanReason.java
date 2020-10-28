package cl.bebt.bangui.menu.listeners;

import cl.bebt.bangui.main;
import cl.bebt.bangui.menu.PlayerMenuUtility;
import cl.bebt.bangui.menu.bangui.ChoseBanType;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class GetBanReason implements Listener {
    private final main plugin;

    public GetBanReason(main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void GetBanReason(AsyncPlayerChatEvent e) {
        Player p = e.getPlayer();
        if (main.banning.get(p)) {
            String reason = e.getMessage();
            String baned = main.baned.get(p);
            Bukkit.getScheduler().runTask(plugin, () -> new ChoseBanType(new PlayerMenuUtility(p), plugin, p, baned, reason).open(p));
            main.baned.remove(p);
            main.banning.remove(p);
            e.setCancelled(true);
        }


    }
}
