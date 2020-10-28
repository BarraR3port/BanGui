package cl.bebt.bangui.menu.bangui;

import cl.bebt.bangui.main;
import cl.bebt.bangui.menu.BanPlayerMenu;
import cl.bebt.bangui.menu.PlayerMenuUtility;
import cl.bebt.bangui.utils.utils;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class BanMenu extends BanPlayerMenu {
    private final main plugin;

    public BanMenu(PlayerMenuUtility playerMenuUtility, main plugin, Player p, String p2) {
        super(playerMenuUtility);
        this.plugin = plugin;
        super.baned = p2;
        super.baner = p;
    }

    @Override
    public String getMenuName() {
        return utils.chat("&cBan &4" + baned);
    }

    @Override
    public int getSlots() {
        return 54;
    }

    @Override
    public void handleMenu(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        ItemStack itemInMainHand = e.getCurrentItem();
        if (hacked_client().equals(itemInMainHand)) {
            p.closeInventory();
            new ChoseBanType(new PlayerMenuUtility(p), plugin, baner, baned, "Hacked Client").open(p);
        }
        if (auto_click_macros().equals(itemInMainHand)) {
            p.closeInventory();
            new ChoseBanType(new PlayerMenuUtility(p), plugin, baner, baned, "Auto Click/Macros").open(p);
        }
        if (bug_abuse().equals(itemInMainHand)) {
            p.closeInventory();
            new ChoseBanType(new PlayerMenuUtility(p), plugin, baner, baned, "Bug Abuse").open(p);
        }
        if (fly().equals(itemInMainHand)) {
            p.closeInventory();
            new ChoseBanType(new PlayerMenuUtility(p), plugin, baner, baned, "Fly").open(p);
        }
        if (staff_lie().equals(itemInMainHand)) {
            p.closeInventory();
            new ChoseBanType(new PlayerMenuUtility(p), plugin, baner, baned, "Lie to STAFF").open(p);
        }
        if (inside_betray().equals(itemInMainHand)) {
            p.closeInventory();
            new ChoseBanType(new PlayerMenuUtility(p), plugin, baner, baned, "Inside/Betray").open(p);
        }
        if (warn_accumulation().equals(itemInMainHand)) {
            p.closeInventory();
            new ChoseBanType(new PlayerMenuUtility(p), plugin, baner, baned, "Warn Accumulation").open(p);
        }
        if (illegal_mods().equals(itemInMainHand)) {
            p.closeInventory();
            new ChoseBanType(new PlayerMenuUtility(p), plugin, baner, baned, "Illegal Mods").open(p);
        }
        if (refusal_ss().equals(itemInMainHand)) {
            p.closeInventory();
            new ChoseBanType(new PlayerMenuUtility(p), plugin, baner, baned, "Refuse to SS").open(p);
        }
        if (ban_evading().equals(itemInMainHand)) {
            p.closeInventory();
            new ChoseBanType(new PlayerMenuUtility(p), plugin, baner, baned, "Ban Evading").open(p);
        }
        if (advertising().equals(itemInMainHand)) {
            p.closeInventory();
            new ChoseBanType(new PlayerMenuUtility(p), plugin, baner, baned, "Advertising").open(p);
        }
        if (xray().equals(itemInMainHand)) {
            p.closeInventory();
            new ChoseBanType(new PlayerMenuUtility(p), plugin, baner, baned, "Xray").open(p);
        }
        if (duping().equals(itemInMainHand)) {
            p.closeInventory();
            new ChoseBanType(new PlayerMenuUtility(p), plugin, baner, baned, "Duping").open(p);
        }
        if (other().equals(itemInMainHand)) {
            p.closeInventory();
            main.banning.put(p, true);
            main.baned.put(p, baned);
            utils.tell(p, plugin.getConfig().getString("server_prefix") + "&cType the reason in the chat");
        } else if (close().equals(itemInMainHand)) {
            p.closeInventory();
        }
    }

    @Override
    public void setMenuItems() {
        addMenuBorder();
        inventory.addItem(hacked_client());
        inventory.addItem(auto_click_macros());
        inventory.addItem(bug_abuse());
        inventory.addItem(staff_lie());
        inventory.addItem(inside_betray());
        inventory.addItem(warn_accumulation());
        inventory.addItem(illegal_mods());
        inventory.addItem(refusal_ss());
        inventory.addItem(ban_evading());
        inventory.addItem(advertising());
        inventory.addItem(xray());
        inventory.addItem(fly());
        inventory.addItem(duping());
        inventory.addItem(other());
        try {
            main.ban_ip.remove(baner);
        } catch (NullPointerException a) {
            a.printStackTrace();
        }
    }

    public ItemStack hacked_client() {
        return makeItem(Material.BOOK, "&cHacked Client", utils.chat("&7Ban &a" + baned + " &cfor &4Hacked Client"), utils.chat("&7(Suggestion: &b120d&7)"));
    }

    public ItemStack auto_click_macros() {
        return makeItem(Material.BOOK, "&cAuto Click/Macros", utils.chat("&7Ban &a" + baned + " &cfor &4Auto Click/Macros"), utils.chat("&7(Suggestion: &b60d&7)"));
    }

    public ItemStack bug_abuse() {
        return makeItem(Material.BOOK, "&cBug Abuse", utils.chat("&7Ban &a" + baned + " &cfor &4Bug Abuse"), utils.chat("&7(Suggestion: &b4d&7)"));
    }

    public ItemStack staff_lie() {
        return makeItem(Material.BOOK, "&cLie To Staff", utils.chat("&7Ban &a" + baned + " &cfor &4Lie To Staff"), utils.chat("&7(Suggestion: &b30d&7)"));
    }

    public ItemStack inside_betray() {
        return makeItem(Material.BOOK, "&cInside/Betray", utils.chat("&7Ban &a" + baned + " &cfor &4Inside/Betray"), utils.chat("&7(Suggestion: &b15d&7)"));
    }

    public ItemStack warn_accumulation() {
        return makeItem(Material.BOOK, "&cWarn Accumulation", utils.chat("&7Ban &a" + baned + " &cfor &4Warn Accumulation"), utils.chat("&7(Suggestion: &b24h&7)"));
    }

    public ItemStack illegal_mods() {
        return makeItem(Material.BOOK, "&cIlegal Mods/Addons", utils.chat("&7Ban &a" + baned + " &cfor &4Illegal Mods/Addons"), utils.chat("&7(Suggestion: &b8d&7)"));
    }

    public ItemStack refusal_ss() {
        return makeItem(Material.BOOK, "&cRefusal-SS", utils.chat("&7Ban &a" + baned + " &cfor &4Refusal-SS"), utils.chat("&7(Suggestion: &bPERMANENT + IP&7)"));
    }

    public ItemStack ban_evading() {
        return makeItem(Material.BOOK, "&cBan-Evading", utils.chat("&7Ban &a" + baned + " &cfor &4Ban-Evading"), utils.chat("&7(Suggestion: &bPERMANENT + IP&7)"));
    }

    public ItemStack advertising() {
        return makeItem(Material.BOOK, "&cAdvertising", utils.chat("&7Ban &a" + baned + " &cfor &4Advertising"), utils.chat("&7(Suggestion: &bPERMANENT + IP&7)"));
    }

    public ItemStack xray() {
        return makeItem(Material.BOOK, "&cXray", utils.chat("&7Ban &a" + baned + " &cfor &4Xray"), utils.chat("&7(Suggestion: &b30d&7)"));
    }

    public ItemStack duping() {
        return makeItem(Material.BOOK, "&cDuping", utils.chat("&7Ban &a" + baned + " &cfor &4Duping"), utils.chat("&7(Suggestion: &b30d&7)"));
    }

    public ItemStack fly() {
        return makeItem(Material.BOOK, "&cFly", utils.chat("&7Ban &a" + baned + " &cfor &4Fly"), utils.chat("&7(Suggestion: &b30d&7)"));
    }

    public ItemStack other() {
        return makeItem(Material.EMPTY_MAP, "&cOther", utils.chat("&7Ban &a" + baned + " &cfor other reason"), utils.chat("&7Type in the chat the reason:"));
    }

}
