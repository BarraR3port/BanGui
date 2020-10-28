package cl.bebt.bangui.utils;

import cl.bebt.bangui.main;
import com.sun.istack.internal.NotNull;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.Arrays;
import java.util.stream.Collectors;

public class utils {

    private static main plugin;

    public utils(main plugin) {
        utils.plugin = plugin;
    }

    public static String chat(String s) {
        return ChatColor.translateAlternateColorCodes('&', s);
    }

    /**
     * @param sender  The Target to sent a MSG.
     * @param message The MSG.
     */
    public static void tell(@NotNull CommandSender sender, @NotNull String message) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            player.sendMessage(utils.chat(message));
        } else {
            Bukkit.getConsoleSender().sendMessage(utils.chat(message));
        }
    }

    /**
     * @param p The Player Name.
     * @return The Head of the Player.
     */
    public static ItemStack getPlayerHead(@NotNull String p) {
        boolean isNewVersion = Arrays.stream(Material.values())
                .map(Material::name).collect(Collectors.toList()).contains("PLAYER_HEAD");
        Material type = Material.matchMaterial(isNewVersion ? "PLAYER_HEAD" : "SKULL_ITEM");
        ItemStack item = new ItemStack(type, 1);
        if (!(isNewVersion)) {
            item.setDurability((short) 3);
        }
        SkullMeta meta = (SkullMeta) item.getItemMeta();
        meta.setOwner(p);
        item.setItemMeta(meta);
        return item;
    }

    /**
     * @param p    The Player.
     * @param path The Player.
     */
    public static void PlaySound(@NotNull Player p, @NotNull String path) {
        Sound sound = Sound.valueOf(main.plugin.getConfig().getString("lunar." + path));
        p.playSound(p.getLocation(), sound, 1, 1);

    }

    /**
     * @param path The Path you wanna use.
     * @return The String from the Path.
     */
    public static String getString(@NotNull String path) {
        try {
            return main.plugin.getConfig().getString(path);
        } catch (NullPointerException error) {
            utils.tell(Bukkit.getConsoleSender(), "&7[&4ERROR&7] &cEstá mal configurado el &2" + path);
            return "";
        }
    }
    /**
     *
     * @param path The Path you wanna use.
     * @return The Boolean from the Path.
     */

}
