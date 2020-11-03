package cl.bebt.bangui.menu;

import cl.bebt.bangui.utils.utils;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public abstract class BanPlayerMenu extends Menu {

    protected String baned;
    protected Player baner;
    protected int page = 0;
    protected int maxItemsPerPage = 55;
    protected int index = 0;
    protected String reason;
    protected DateTimeFormatter time;


    public BanPlayerMenu(PlayerMenuUtility playerMenuUtility) {
        super(playerMenuUtility);
    }

    public void addMenuBorder() {
        for (int i = 0; i < 10; i++) {
            inventory.setItem(i, super.redPanel());
        }
        for (int i = 10; i < 17; i++) {
            inventory.setItem(i, super.greenPanel());
        }
        for (int i = 44; i < 54; i++) {
            inventory.setItem(i, super.redPanel());
        }
        ItemStack p_head = utils.getPlayerHead(baned);
        ItemMeta meta = p_head.getItemMeta();
        ArrayList<String> lore = new ArrayList<>();
        meta.setDisplayName(utils.chat("&5" + baned));
        lore.add(utils.chat(utils.chat("&7Why you wanna ban &c") + baned + "&7?"));
        meta.setLore(lore);
        p_head.setItemMeta(meta);
        inventory.setItem(13, p_head);
        inventory.setItem(17, super.redPanel());
        inventory.setItem(18, super.redPanel());
        inventory.setItem(26, super.redPanel());
        inventory.setItem(27, super.redPanel());
        inventory.setItem(35, super.redPanel());
        inventory.setItem(36, super.redPanel());
        inventory.setItem(49, makeItem(Material.REDSTONE, "&cClose"));

    }

    public int getMaxItemsPerPage() {
        return maxItemsPerPage;
    }
}

