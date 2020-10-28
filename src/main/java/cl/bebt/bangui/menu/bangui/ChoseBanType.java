package cl.bebt.bangui.menu.bangui;

import cl.bebt.bangui.main;
import cl.bebt.bangui.menu.Menu;
import cl.bebt.bangui.menu.PlayerMenuUtility;
import cl.bebt.bangui.utils.utils;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class ChoseBanType extends Menu {
    private final main plugin;
    private final Player player;
    private final String baned;
    private final String reason;

    public ChoseBanType(PlayerMenuUtility playerMenuUtility, main plugin, Player player, String baned, String reason) {
        super(playerMenuUtility);
        this.plugin = plugin;
        this.player = player;
        this.baned = baned;
        this.reason = reason;
    }

    @Override
    public String getMenuName() {
        return utils.chat("&cChose Ban Type");
    }

    @Override
    public int getSlots() {
        return 45;
    }

    @Override
    public void handleMenu(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        ItemStack itemInMainHand = e.getCurrentItem();
        if (tempBan().equals(itemInMainHand)) {
            p.closeInventory();
            new AmountBaned(new PlayerMenuUtility(p), plugin, p, baned, reason).open(p);
        } else if (permBan().equals(itemInMainHand)) {
            p.closeInventory();
            BanPlayer(p, baned, reason);
        } else if (ban_normal().equals(itemInMainHand)) {
            p.closeInventory();
            main.ban_ip.put(p, true);
            new ChoseBanType(playerMenuUtility, plugin, player, baned, reason).open(p);
        } else if (ban_ip().equals(itemInMainHand)) {
            p.closeInventory();
            try {
                main.ban_ip.remove(p);
            } catch (NullPointerException ignored) {
            }
            new ChoseBanType(playerMenuUtility, plugin, player, baned, reason).open(p);
        } else if (admitted().equals(itemInMainHand)) {
            p.closeInventory();
            try {
                main.admitted.remove(p);
            } catch (NullPointerException ignored) {
            }
            new ChoseBanType(playerMenuUtility, plugin, player, baned, reason).open(p);
        } else if (not_admitted().equals(itemInMainHand)) {
            p.closeInventory();
            main.admitted.put(p, true);
            new ChoseBanType(playerMenuUtility, plugin, player, baned, reason).open(p);
        } else if (close().equals(itemInMainHand)) {
            p.closeInventory();
            if (e.getClick().isLeftClick()) {
                new ChoseBanType(playerMenuUtility, plugin, player, baned, reason).open(p);
            }
        }
    }

    @Override
    public void setMenuItems() {
        for (int i = 0; i < 10; i++) {
            if (inventory.getItem(i) == null) {
                inventory.setItem(i, super.bluePanel());
            }
        }
        for (int i = 10; i < 17; i++) {
            if (inventory.getItem(i) == null) {
                inventory.setItem(i, super.redPanel());
            }
        }
        inventory.setItem(17, super.bluePanel());
        inventory.setItem(18, super.bluePanel());
        inventory.setItem(25, super.redPanel());
        inventory.setItem(26, super.bluePanel());
        inventory.setItem(27, super.bluePanel());
        inventory.setItem(22, super.redPanel());
        for (int i = 28; i < 35; i++) {
            if (inventory.getItem(i) == null) {
                inventory.setItem(i, super.redPanel());
            }
        }
        for (int i = 35; i < 45; i++) {
            if (inventory.getItem(i) == null) {
                inventory.setItem(i, super.bluePanel());
            }
        }
        inventory.setItem(19, tempBan());
        inventory.setItem(20, super.redPanel());
        try {
            if (main.ban_ip.get(player)) {
                inventory.setItem(21, ban_ip());
            } else {
                inventory.setItem(21, ban_normal());
            }
        } catch (NullPointerException exception) {
            inventory.setItem(21, ban_normal());
        }
        try {
            if (main.admitted.get(player)) {
                inventory.setItem(23, admitted());
            } else {
                inventory.setItem(23, not_admitted());
            }
        } catch (NullPointerException exception) {
            inventory.setItem(23, not_admitted());
        }
        inventory.setItem(24, super.redPanel());
        inventory.setItem(25, permBan());
        inventory.setItem(31, close());
    }

    public ItemStack tempBan() {
        ArrayList<String> lore = new ArrayList<>();
        ItemStack item = new ItemStack(Material.PUMPKIN);
        ItemMeta meta = item.getItemMeta();
        lore.add(utils.chat("&7Click to &cTemp Ban &a" + baned));
        meta.setLore(lore);
        meta.setDisplayName(utils.chat("&aTemp Ban"));
        item.setItemMeta(meta);
        return item;
    }

    public ItemStack permBan() {
        ArrayList<String> lore = new ArrayList<>();
        ItemStack item = new ItemStack(Material.JACK_O_LANTERN);
        ItemMeta meta = item.getItemMeta();
        lore.add(utils.chat("&7Click to &4Perm Ban &a" + baned));
        meta.setLore(lore);
        meta.setDisplayName(utils.chat("&4Perm Ban"));
        item.setItemMeta(meta);
        return item;
    }

    public ItemStack ban_ip() {
        ItemStack item = new ItemStack(Material.REDSTONE_BLOCK);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(utils.chat("&7Ban IP: &aTrue"));
        item.setItemMeta(meta);
        return item;
    }

    public ItemStack ban_normal() {
        ItemStack item = new ItemStack(Material.REDSTONE_BLOCK);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(utils.chat("&7Ban IP: &cFalse"));
        item.setItemMeta(meta);
        return item;
    }

    public ItemStack admitted() {
        ItemStack item = new ItemStack(Material.LAPIS_BLOCK);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(utils.chat("&7Admitted: &aTrue"));
        item.setItemMeta(meta);
        return item;
    }

    public ItemStack not_admitted() {
        ItemStack item = new ItemStack(Material.LAPIS_BLOCK);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(utils.chat("&7Admitted: &cFalse"));
        item.setItemMeta(meta);
        return item;
    }
}
