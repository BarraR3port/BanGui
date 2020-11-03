package cl.bebt.bangui.utils;

import com.lunarbreaker.api.LunarBreakerAPI;
import com.lunarbreaker.api.object.CBNotification;
import com.sun.istack.internal.NotNull;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SMManager {

    public static List<String> players;

    static {players = new ArrayList<>();}

    /**
     * @param player The player to add or remove the Staff Modules
     */
    public static void setStaffModules(@NotNull Player player) {
        if (LunarBreakerAPI.getInstance().isRunningLunarClient(player)) {
            if (players.contains(player.getName())) {
                players.remove(player.getName());
                LunarBreakerAPI.getInstance().disableAllStaffModules(player);
                utils.tell(player, utils.getString("server_prefix") + utils.getString("lunar.staff_modules") + " &cOFF");
                LunarBreakerAPI.getInstance().sendNotification(player, new CBNotification(utils.chat("&cStaff Modules Deactivated"),3L, TimeUnit.SECONDS));
            } else {
                players.add(player.getName());
                LunarBreakerAPI.getInstance().giveAllStaffModules(player);
                utils.tell(player, utils.getString("server_prefix") + utils.getString("lunar.staff_modules") + " &aON");
                LunarBreakerAPI.getInstance().sendNotification(player, new CBNotification(utils.chat("&aStaff Modules Activated"),3L, TimeUnit.SECONDS));
            }
        } else {
            utils.tell(player, utils.getString("server_prefix") + utils.getString("lunar.not_using"));
        }
    }

    /**
     * @param p The player to check.
     * @return A Boolean indicating whether the player has or not the Staff Modules
     */
    public static Boolean hasStaffModules(@NotNull Player p) {
        return players.contains(p.getName());
    }
}