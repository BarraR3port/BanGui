package cl.bebt.bangui.menu.lunar;

import cl.bebt.bangui.main;
import cl.bebt.bangui.menu.PaginatedMenu;
import cl.bebt.bangui.menu.PlayerMenuUtility;
import cl.bebt.bangui.utils.SMManager;
import cl.bebt.bangui.utils.utils;
import com.lunarbreaker.api.LunarBreakerAPI;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class LunarPlayerList extends PaginatedMenu {

    private final main plugin;

    private final LunarBreakerAPI api = LunarBreakerAPI.getInstance();

    public LunarPlayerList(PlayerMenuUtility playerMenuUtility, main plugin) {
        super(playerMenuUtility);
        this.plugin = plugin;
    }

    @Override
    public String getMenuName() {
        return utils.chat("&cMute Players Chat");
    }

    @Override
    public int getSlots() {
        return 54;
    }

    @Override
    public void handleMenu(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        ArrayList<Player> players = new ArrayList<>(Bukkit.getServer().getOnlinePlayers());
        ItemStack itemInMainHand = e.getCurrentItem();
        if (e.getCurrentItem().getType().equals(Material.SKULL_ITEM)) {
            try {
                p.teleport(Bukkit.getPlayer(e.getCurrentItem().getItemMeta().getDisplayName()).getLocation());
            } catch (NullPointerException error) {
                utils.tell(p, "&cEl jugador +&a" + e.getCurrentItem().getItemMeta().getDisplayName() + "&c no está conectado");
            }
        } else if (close().equals(itemInMainHand)) {
            p.closeInventory();
        } else if (back().equals(itemInMainHand)) {
            if (page == 0) {
                utils.tell(p, "&cYa estás en la primera pag!.");
            } else {
                page = page - 1;
                super.open(p);
            }
        } else if (next().equals(itemInMainHand)) {
            if (!((index + 1) >= players.size())) {
                page = page + 1;
                super.open(p);
            } else {
                utils.tell(p, "&cEstás en la última pag!.");
            }
        }
    }

    @Override
    public void setMenuItems() {
        addMenuBorder();
        ArrayList<Player> players = new ArrayList<>(Bukkit.getServer().getOnlinePlayers());
        if (players != null && !players.isEmpty()) {
            for (int i = 0; i < getMaxItemsPerPage(); i++) {
                index = getMaxItemsPerPage() * page + i;
                if (index >= players.size()) break;
                if (players.get(index) != null) {
                    //////////////////////////////
                    ItemStack p_head = utils.getPlayerHead(players.get(index).getName());
                    ItemMeta meta = p_head.getItemMeta();
                    ArrayList<String> lore = new ArrayList<>();
                    meta.setDisplayName(players.get(index).getName());
                    lore.add(utils.chat("&a" + players.get(index).getDisplayName() + " &7info"));
                    if (api.isRunningLunarClient(players.get(index))) {
                        lore.add(utils.chat("&7LunarClient: &aTRUE"));
                    } else {
                        lore.add(utils.chat("&7LunarClient: &cFALSE"));
                    }
                    String ip = players.get(index).getAddress().getAddress().toString();
                    ip = ip.replace("/", "");
                    if (SMManager.hasStaffModules(players.get(index))) {
                        lore.add(utils.chat("&7StaffMods: &aTRUE"));
                    } else {
                        lore.add(utils.chat("&7StaffMods: &cFALSE"));
                    }
                    lore.add(utils.chat("&7IP: &a" + ip));
                    lore.add(utils.chat("&7Mundo: &a" + players.get(index).getWorld().getName()));
                    meta.setLore(lore);
                    p_head.setItemMeta(meta);
                    inventory.addItem(p_head);
                    /////////////////////////////
                }
            }
        }
    }
}
