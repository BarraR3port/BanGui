package cl.bebt.bangui.menu.listeners;

import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class onThrowEnderPearl implements Listener {
    
    @EventHandler
    public void onPlayerInteract( PlayerInteractEvent e ) {
        Player p = e.getPlayer();
        
        if(e.getMaterial() == Material.ENDER_PEARL){
            if(     p.getLocation().getBlock().getRelative(BlockFace.NORTH).getType()==Material.FENCE ||
                    p.getLocation().getBlock().getRelative(BlockFace.NORTH_EAST).getType()==Material.FENCE ||
                    /*p.getLocation().getBlock().getRelative(BlockFace.NORTH_NORTH_EAST).getType()==Material.FENCE ||
                    p.getLocation().getBlock().getRelative(BlockFace.NORTH_NORTH_WEST).getType()==Material.FENCE ||*/
                    p.getLocation().getBlock().getRelative(BlockFace.SOUTH).getType()==Material.FENCE ||
                    /*p.getLocation().getBlock().getRelative(BlockFace.SOUTH_EAST).getType()==Material.FENCE ||
                    p.getLocation().getBlock().getRelative(BlockFace.SOUTH_SOUTH_EAST).getType()==Material.FENCE ||*/
                    p.getLocation().getBlock().getRelative(BlockFace.EAST).getType()==Material.FENCE ||
                    /*p.getLocation().getBlock().getRelative(BlockFace.EAST_NORTH_EAST).getType()==Material.FENCE ||
                    p.getLocation().getBlock().getRelative(BlockFace.EAST_SOUTH_EAST).getType()==Material.FENCE ||*/
                    p.getLocation().getBlock().getRelative(BlockFace.WEST).getType()==Material.FENCE ||
                    /*p.getLocation().getBlock().getRelative(BlockFace.WEST_NORTH_WEST).getType()==Material.FENCE ||
                    p.getLocation().getBlock().getRelative(BlockFace.WEST_SOUTH_WEST).getType()==Material.FENCE ||*/
                    p.getLocation().getBlock().getRelative(BlockFace.DOWN).getType()==Material.FENCE ||
                    p.getLocation().getBlock().getRelative(BlockFace.UP).getType()==Material.FENCE ) {
                e.setCancelled( true );
            }
            if(     p.getLocation().getBlock().getRelative(BlockFace.NORTH).getType()==Material.FENCE_GATE ||
                    p.getLocation().getBlock().getRelative(BlockFace.NORTH_EAST).getType()==Material.FENCE_GATE ||
                    /*p.getLocation().getBlock().getRelative(BlockFace.NORTH_NORTH_EAST).getType()==Material.FENCE_GATE ||
                    p.getLocation().getBlock().getRelative(BlockFace.NORTH_NORTH_WEST).getType()==Material.FENCE_GATE ||*/
                    p.getLocation().getBlock().getRelative(BlockFace.SOUTH).getType()==Material.FENCE_GATE ||
                    /*p.getLocation().getBlock().getRelative(BlockFace.SOUTH_EAST).getType()==Material.FENCE_GATE ||
                    p.getLocation().getBlock().getRelative(BlockFace.SOUTH_SOUTH_EAST).getType()==Material.FENCE_GATE ||*/
                    p.getLocation().getBlock().getRelative(BlockFace.EAST).getType()==Material.FENCE_GATE ||
                    /*p.getLocation().getBlock().getRelative(BlockFace.EAST_NORTH_EAST).getType()==Material.FENCE_GATE ||
                    p.getLocation().getBlock().getRelative(BlockFace.EAST_SOUTH_EAST).getType()==Material.FENCE_GATE ||*/
                    p.getLocation().getBlock().getRelative(BlockFace.WEST).getType()==Material.FENCE_GATE ||
                    /*p.getLocation().getBlock().getRelative(BlockFace.WEST_NORTH_WEST).getType()==Material.FENCE_GATE ||
                    p.getLocation().getBlock().getRelative(BlockFace.WEST_SOUTH_WEST).getType()==Material.FENCE_GATE ||*/
                    p.getLocation().getBlock().getRelative(BlockFace.DOWN).getType()==Material.FENCE_GATE ||
                    p.getLocation().getBlock().getRelative(BlockFace.UP).getType()==Material.FENCE_GATE ) {
                e.setCancelled( true );
            }
        }
    }
    
    
    
}
