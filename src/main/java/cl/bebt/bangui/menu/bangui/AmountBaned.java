package cl.bebt.bangui.menu.bangui;

import cl.bebt.bangui.main;
import cl.bebt.bangui.menu.PaginatedMenu;
import cl.bebt.bangui.menu.PlayerMenuUtility;
import cl.bebt.bangui.utils.utils;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class AmountBaned extends PaginatedMenu {
    private final main plugin;
    private final Player player;
    private final String baned;
    private final String reason;
    private final int amount = 49;

    public AmountBaned(PlayerMenuUtility playerMenuUtility, main plugin, Player player, String baned, String reason) {
        super(playerMenuUtility);
        this.plugin = plugin;
        this.player = player;
        this.baned = baned;
        this.reason = reason;
    }

    @Override
    public String getMenuName() {
        return utils.chat("&cChose the amount:");
    }

    @Override
    public int getSlots() {
        return 54;
    }

    @Override
    public void handleMenu(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        ItemStack itemInMainHand = e.getCurrentItem();
        if (itemInMainHand.getType().equals(Material.WATCH)) {
            p.closeInventory();
            new QuantityBaned(playerMenuUtility, plugin, player, baned, reason, e.getCurrentItem().getAmount()).open(p);
        } else if (close().equals(itemInMainHand)) {
            p.closeInventory();
            if (e.getClick().isLeftClick()) {
                new ChoseBanType(playerMenuUtility, plugin, player, baned, reason).open(p);
            }
        } else if (back().equals(itemInMainHand)) {
            if (page == 0) {
                utils.tell(p, "&cYou are already in the first page.");
            } else {
                page = page - 1;
                p.closeInventory();
                super.open(p);
            }
        } else if (next().equals(itemInMainHand)) {
            if (!((index + 1) >= amount)) {
                page = page + 1;
                p.closeInventory();
                super.open(p);
            } else {
                utils.tell(p, "&cYou are in the last page!.");
            }
        }
    }

    @Override
    public void setMenuItems() {
        addMenuBorder();
        //main.amount.clear();
        for (int i = 1; i < getMaxItemsPerPage() + 1; i++) {
            index = getMaxItemsPerPage() * page + i;
            if (index >= amount) {
                break;
            } else {
                //////////////////////////////
                inventory.addItem(makeItem(Material.WATCH, "&7Ban for:&c " + index, index, 1));
                /////////////////////////////
            }
        }


    }
}
