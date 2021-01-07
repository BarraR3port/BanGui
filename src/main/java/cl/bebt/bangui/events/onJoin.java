package cl.bebt.bangui.events;

import cl.bebt.bangui.main;
import cl.bebt.bangui.utils.utils;
import com.cheatbreaker.nethandler.server.CBPacketNotification;
import com.cheatbreaker.nethandler.server.CBPacketTitle;
import com.lunarbreaker.api.LunarBreakerAPI;
import com.lunarbreaker.api.handlers.title.TitleType;
import com.lunarclient.bukkitapi.nethandler.client.LCPacketNotification;
import com.lunarclient.bukkitapi.nethandler.client.LCPacketTitle;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;



public class onJoin implements Listener {
    private final LunarBreakerAPI api = LunarBreakerAPI.getInstance();

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onAchievements(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        api.sendPacket( player, new LCPacketNotification( utils.chat(main.plugin.getConfig().getString("lunar.join_notification") ), 5L, "INFO"  ));
        api.sendPacket( player, new CBPacketNotification( utils.chat(main.plugin.getConfig().getString("lunar.join_notification") ), 5L, "INFO"  ));
        api.sendPacket( player, new LCPacketTitle( "TITLE", utils.chat(main.plugin.getConfig().getString("lunar.join_title")), 2L, 6L, 2L) );
        api.sendPacket( player, new LCPacketTitle( "SUBTITLE", utils.chat(main.plugin.getConfig().getString("lunar.join_title")), 2L, 6L, 2L) );
        api.sendPacket( player, new CBPacketTitle( "TITLE", utils.chat(main.plugin.getConfig().getString("lunar.join_title")), 2L, 6L, 2L) );
        api.sendPacket( player, new CBPacketTitle( "SUBTITLE", utils.chat(main.plugin.getConfig().getString("lunar.join_title")), 2L, 6L, 2L) );
        if (main.plugin.getConfig().getBoolean("lunar.join_staff_utils") && player.hasPermission("ashland.lunar.staff")) {
            api.getStaffModuleHandler().giveAllStaffModules( player );
            utils.PlaySound(player, "join_sound");
            //player.sendMessage(utils.chat("&8[&3STAFF&8] &7Staff-Modules &aActivado!!!"));
        }
    }
}
