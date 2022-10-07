package com.nekozouneko.sugoroku.command;

import com.nekozouneko.sugoroku.Sugoroku;
import org.bukkit.command.*;

public class SuCommand implements CommandExecutor {

    Sugoroku plugin = Sugoroku.getInstance();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        plugin.reloadConfig();
        return true;
    }

}
