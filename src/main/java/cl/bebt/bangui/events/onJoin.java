package cl.bebt.bangui.events;

import cl.bebt.bangui.main;
import cl.bebt.bangui.utils.utils;
import com.lunarbreaker.api.LunarBreakerAPI;
import com.lunarbreaker.api.object.CBNotification;
import com.lunarbreaker.api.object.TitleType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.time.Duration;
import java.util.concurrent.TimeUnit;


public class onJoin implements Listener {
    private final LunarBreakerAPI api = LunarBreakerAPI.getInstance();

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onAchievements(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        api.sendNotification(player, new CBNotification(utils.chat(main.plugin.getConfig().getString("lunar.join_notification")), 5L, TimeUnit.SECONDS));
        api.sendTitle(player, TitleType.TITLE, utils.chat(main.plugin.getConfig().getString("lunar.join_title")), Duration.ofSeconds(2L), Duration.ofSeconds(6L), Duration.ofSeconds(2L));
        api.sendTitle(player, TitleType.SUBTITLE, utils.chat(main.plugin.getConfig().getString("lunar.join_subtitle")), Duration.ofSeconds(2L), Duration.ofSeconds(6L), Duration.ofSeconds(2L));
        if (main.plugin.getConfig().getBoolean("lunar.join_staff_utils") && player.hasPermission("ashland.lunar.staff")) {
            api.giveAllStaffModules(player);
            utils.PlaySound(player, "join_sound");
            //player.sendMessage(utils.chat("&8[&3STAFF&8] &7Staff-Modules &aActivado!!!"));
        }
    }
}
