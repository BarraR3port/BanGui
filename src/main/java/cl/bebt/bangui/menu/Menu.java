package cl.bebt.bangui.menu;

import cl.bebt.bangui.main;
import cl.bebt.bangui.utils.utils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public abstract class Menu implements InventoryHolder {

    protected Inventory inventory;

    protected PlayerMenuUtility playerMenuUtility;
    String type = main.plugin.getConfig().getString("ban_plugin");

    public Menu(PlayerMenuUtility playerMenuUtility) {
        this.playerMenuUtility = playerMenuUtility;
    }

    public static ItemStack makeItem(Material material, String displayName, String... lore) {
        ItemStack item = new ItemStack(material);
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.setDisplayName(utils.chat(displayName));
        itemMeta.setLore(Arrays.asList(lore));
        item.setItemMeta(itemMeta);

        return item;
    }

    protected ItemStack redPanel() {
        ItemStack panel = makeItem(Material.STAINED_GLASS_PANE, " ", 1, 14);
        return panel;
    }

    protected ItemStack greenPanel() {
        ItemStack panel = makeItem(Material.STAINED_GLASS_PANE, " ", 1, 13);
        return panel;
    }

    protected ItemStack bluePanel() {
        ItemStack panel = makeItem(Material.STAINED_GLASS_PANE, " ", 1, 11);
        return panel;
    }

    protected ItemStack close() {
        ItemStack panel = makeItem(Material.REDSTONE, utils.chat("&cCerrar"));
        return panel;
    }

    protected ItemStack back() {
        return makeItem(Material.STONE_BUTTON, "&aPag Anterior");
    }

    protected ItemStack next() {
        return makeItem(Material.WOOD_BUTTON, "&aSiguiente Pag");
    }

    public abstract String getMenuName();

    public abstract int getSlots();

    public abstract void handleMenu(InventoryClickEvent e);

    public abstract void setMenuItems();

    protected void BanPlayer(Player p, String baned, String reason) {
        try {
            if (main.ban_ip.get(p)) {
                if (main.admitted.get(p)) {
                    Bukkit.getServer().dispatchCommand(p, type + ":banip " + baned + " " + reason + " (Admitted)");
                } else {
                    Bukkit.getServer().dispatchCommand(p, type + ":banip " + baned + " " + reason);
                }
            } else {
                if (main.admitted.get(p)) {
                    Bukkit.getServer().dispatchCommand(p, type + ":ban " + baned + " " + reason + " (Admitted)");
                } else {
                    Bukkit.getServer().dispatchCommand(p, type + ":ban " + baned + " " + reason);
                }
            }
        } catch (NullPointerException error) {
            try {
                if (main.admitted.get(p)) {
                    Bukkit.getServer().dispatchCommand(p, type + ":ban " + baned + " " + reason + " (Admitted)");
                } else {
                    Bukkit.getServer().dispatchCommand(p, type + ":ban " + baned + " " + reason);
                }
            } catch (NullPointerException error2) {
                Bukkit.getServer().dispatchCommand(p, type + ":ban " + baned + " " + reason);
            }
        }


    }

    protected void BanPlayer(Player p, String baned, String reason, String quantity, int amount) {
        try {
            if (main.ban_ip.get(p)) {
                if (main.admitted.get(p)) {
                    Bukkit.getServer().dispatchCommand(p, type + ":banip " + baned + " " + amount + quantity + " " + reason + " (Admitted)");
                } else {
                    Bukkit.getServer().dispatchCommand(p, type + ":banip " + baned + " " + amount + quantity + " " + reason);
                }
            } else {
                if (main.admitted.get(p)) {
                    Bukkit.getServer().dispatchCommand(p, type + ":ban " + baned + " " + amount + quantity + " " + reason + " (Admitted)");
                } else {
                    Bukkit.getServer().dispatchCommand(p, type + ":ban " + baned + " " + amount + quantity + " " + reason);
                }
            }
        } catch (NullPointerException error) {
            try {
                if (main.admitted.get(p)) {
                    Bukkit.getServer().dispatchCommand(p, type + ":ban " + baned + " " + amount + quantity + " " + reason + " (Admitted)");
                } else {
                    Bukkit.getServer().dispatchCommand(p, type + ":ban " + baned + " " + amount + quantity + " " + reason);
                }
            } catch (NullPointerException error2) {
                Bukkit.getServer().dispatchCommand(p, type + ":ban " + baned + " " + amount + quantity + " " + reason);
            }
        }
    }

    public void open(Player p) {
        inventory = Bukkit.createInventory(this, getSlots(), getMenuName());

        //grab all the items specified to be used for this menu and add to inventory
        this.setMenuItems();
        //open the inventory for the player
        playerMenuUtility.getOwner().openInventory(inventory);

    }

    public ItemStack makeItem(Material material, String displayName, int amount, int id, String... lore) {
        ItemStack item = new ItemStack(material, amount, (short) id);
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.setDisplayName(utils.chat(displayName));
        itemMeta.setLore(Arrays.asList(lore));
        item.setItemMeta(itemMeta);

        return item;
    }

    @Override
    public Inventory getInventory() {
        return inventory;
    }

}
