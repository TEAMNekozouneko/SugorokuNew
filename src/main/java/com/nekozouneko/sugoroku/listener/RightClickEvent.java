package com.nekozouneko.sugoroku.listener;

import com.nekozouneko.sugoroku.Sugoroku;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.*;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;
import java.util.Random;

public class RightClickEvent implements Listener {

    private final Sugoroku plugin = Sugoroku.getInstance();
    private final FileConfiguration cfg = plugin.getConfig();
    private final Random r = new Random();

    @EventHandler
    public void RightClicked(PlayerInteractEvent e) {
        Action act = e.getAction();
        String in = "§aサイコロ §7[右クリック]";
        if (act == Action.RIGHT_CLICK_AIR || act == Action.RIGHT_CLICK_BLOCK) {
            ItemStack is = e.getItem();
            ItemMeta im = e.getItem().getItemMeta();

            if (im != null) {
                if (im.getDisplayName().equalsIgnoreCase(in)) {
                    e.setCancelled(true);
                    int smin = cfg.getInt("dice.squares.min");
                    int smax = cfg.getInt("dice.squares.max");

                    List<String> od = cfg.getStringList("values");

                    int s = r.nextInt(smax) + smin;
                    int o = r.nextInt(od.size());

                    Bukkit.broadcastMessage("§6" + e.getPlayer().getDisplayName() + "は" + s + "マス進みます。");
                    Bukkit.broadcastMessage("§6" + e.getPlayer().getDisplayName() + "のお題: " + od.get(o));

                    e.getPlayer().sendTitle(" ", "§6" + s + "マス進む", 5, 40, 5);
                }
            }
        }
    }

}
