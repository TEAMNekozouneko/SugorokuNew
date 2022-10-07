package com.nekozouneko.sugoroku.command;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.*;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class getdice implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        List<Player> players = new ArrayList<>();
        ItemStack d = new ItemStack(Material.ENDER_CHEST, 1);
        ItemMeta dm = d.getItemMeta();

        dm.setDisplayName("§aサイコロ §7[右クリック]");
        d.setItemMeta(dm);

        if (args.length == 0) {
            if (sender instanceof Player) {
                players.add((Player) sender);
            }
            else {
                sender.sendMessage(ChatColor.RED + "コンソールではプレイヤーを指定することで実行できます。");
                return true;
            }
        } else {
            if (args[1].equalsIgnoreCase("@a")) {
                players.addAll(Bukkit.getOnlinePlayers());
            } else {
                Player p = Bukkit.getPlayer(args[1]);
                if (p == null) {
                    sender.sendMessage(ChatColor.RED + "そのようなプレイヤーは存在しません。");
                    return true;
                }
                players.add(p);
            }
        }

        for (Player py : players) {
            py.getInventory().addItem(d);
            py.sendMessage("§aサイコロを支給しました。");
        }

        return true;
    }

}
