package cl.bebt.bangui.menu;

import org.bukkit.entity.Player;

public class PlayerMenuUtility {

    private Player owner;

    private Player reported;


    public PlayerMenuUtility(Player owner) {
        this.owner = owner;
    }

    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }

    public Player getReported() {
        return reported;
    }

    public void setReported(Player reported) {
        this.reported = reported;
    }


}
