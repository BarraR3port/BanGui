package cl.bebt.bangui.utils;

import com.cheatbreaker.nethandler.server.CBPacketNotification;
import com.lunarbreaker.api.LunarBreakerAPI;
import com.lunarbreaker.api.handlers.staffmodule.StaffModule;
import com.lunarclient.bukkitapi.nethandler.client.LCPacketNotification;
import com.sun.istack.internal.NotNull;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

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
                LunarBreakerAPI.getInstance().getStaffModuleHandler().setStaffModuleState( player, StaffModule.BUNNY_HOP, false );
                LunarBreakerAPI.getInstance().getStaffModuleHandler().setStaffModuleState( player, StaffModule.NAME_TAGS, false );
                LunarBreakerAPI.getInstance().getStaffModuleHandler().setStaffModuleState( player, StaffModule.XRAY, false );
                utils.tell(player, utils.getString("server_prefix") + utils.getString("lunar.staff_modules") + " &cOFF");
                LunarBreakerAPI.getInstance().sendPacket( player, new LCPacketNotification( utils.chat( utils.chat("&cStaff Modules Deactivated") ), 5L, "INFO" ));
                LunarBreakerAPI.getInstance().sendPacket( player, new CBPacketNotification( utils.chat( utils.chat("&cStaff Modules Deactivated") ), 5L, "INFO" ));
    
            } else {
                players.add(player.getName());
                LunarBreakerAPI.getInstance().getStaffModuleHandler().setStaffModuleState( player, StaffModule.BUNNY_HOP, true );
                LunarBreakerAPI.getInstance().getStaffModuleHandler().setStaffModuleState( player, StaffModule.NAME_TAGS, true );
                LunarBreakerAPI.getInstance().getStaffModuleHandler().setStaffModuleState( player, StaffModule.XRAY, true );
                //LunarBreakerAPI.getInstance().getStaffModuleHandler().giveAllStaffModules( player );
                utils.tell(player, utils.getString("server_prefix") + utils.getString("lunar.staff_modules") + " &aON");
                LunarBreakerAPI.getInstance().sendPacket( player, new LCPacketNotification( utils.chat( utils.chat("&aStaff Modules Activated") ), 5L, "INFO" ));
                LunarBreakerAPI.getInstance().sendPacket( player, new CBPacketNotification( utils.chat( utils.chat("&aStaff Modules Activated") ), 5L, "INFO" ));
    
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