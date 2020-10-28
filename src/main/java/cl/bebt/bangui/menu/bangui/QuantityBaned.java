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

public class QuantityBaned extends Menu {
    private final main plugin;
    private final Player player;
    private final String baned;
    private final String reason;
    private final int Amount;

    public QuantityBaned(PlayerMenuUtility playerMenuUtility, main plugin, Player player, String baned, String reason, int amount) {
        super(playerMenuUtility);
        this.plugin = plugin;
        this.player = player;
        this.baned = baned;
        this.reason = reason;
        this.Amount = amount;
    }

    @Override
    public String getMenuName() {
        return utils.chat("&cChose between &ds/m/h/d");
    }

    @Override
    public int getSlots() {
        return 45;
    }

    @Override
    public void handleMenu(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        ItemStack itemInMainHand = e.getCurrentItem();
        if (seconds().equals(itemInMainHand)) {
            p.closeInventory();
            BanPlayer(p, baned, reason, "s", Amount);
        } else if (minutes().equals(itemInMainHand)) {
            p.closeInventory();
            BanPlayer(p, baned, reason, "m", Amount);
        } else if (hours().equals(itemInMainHand)) {
            p.closeInventory();
            BanPlayer(p, baned, reason, "h", Amount);
        } else if (days().equals(itemInMainHand)) {
            p.closeInventory();
            BanPlayer(p, baned, reason, "d", Amount);
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
                inventory.setItem(i, bluePanel());
            }
        }
        for (int i = 10; i < 17; i++) {
            if (inventory.getItem(i) == null) {
                inventory.setItem(i, redPanel());
            }
        }
        inventory.setItem(17, bluePanel());
        inventory.setItem(18, bluePanel());
        inventory.setItem(19, redPanel());
        inventory.setItem(25, redPanel());
        inventory.setItem(26, bluePanel());
        inventory.setItem(27, bluePanel());
        for (int i = 28; i < 35; i++) {
            if (inventory.getItem(i) == null) {
                inventory.setItem(i, redPanel());
            }
        }
        for (int i = 35; i < 45; i++) {
            if (inventory.getItem(i) == null) {
                inventory.setItem(i, bluePanel());
            }
        }
        inventory.setItem(20, seconds());
        inventory.setItem(21, minutes());
        inventory.setItem(22, close());
        inventory.setItem(23, hours());
        inventory.setItem(24, days());
    }

    public ItemStack seconds() {
        ArrayList<String> lore = new ArrayList<>();
        ItemStack item = makeItem(Material.WOOL, "&4SECONDS", Amount, 2);
        ItemMeta meta = item.getItemMeta();
        lore.add(utils.chat("&cBan &r" + baned + " &c for &a" + Amount + " &cSeconds."));
        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;
    }

    public ItemStack minutes() {
        ArrayList<String> lore = new ArrayList<>();
        ItemStack item = makeItem(Material.WOOL, "&4MINUTES", Amount, 10);
        ItemMeta meta = item.getItemMeta();
        lore.add(utils.chat("&cBan &r" + baned + " &c for &a" + Amount + " &cMinutes."));
        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;
    }

    public ItemStack hours() {
        ArrayList<String> lore = new ArrayList<>();
        ItemStack item = makeItem(Material.WOOL, "&4HOURS", Amount, 11);
        ItemMeta meta = item.getItemMeta();
        lore.add(utils.chat("&cBan &r" + baned + " &c for &a" + Amount + " &cHours."));
        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;
    }

    public ItemStack days() {
        ArrayList<String> lore = new ArrayList<>();
        ItemStack item = makeItem(Material.WOOL, "&4DAYS", Amount, 14);
        ItemMeta meta = item.getItemMeta();
        lore.add(utils.chat("&cBan &r" + baned + " &c for &a" + Amount + " &cDays."));
        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;
    }

}
