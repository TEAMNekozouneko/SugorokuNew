package com.nekozouneko.sugoroku;

import com.nekozouneko.sugoroku.command.SuCommand;
import com.nekozouneko.sugoroku.command.getdice;
import com.nekozouneko.sugoroku.listener.RightClickEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class Sugoroku extends JavaPlugin {

    public static Sugoroku instance;

    public static Sugoroku getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        saveDefaultConfig();
        instance = this;
        getCommand("sugoroku").setExecutor(new SuCommand());
        getCommand("get-dice").setExecutor(new getdice());
        getServer().getPluginManager().registerEvents(new RightClickEvent(), this);
    }

    @Override
    public void onDisable() {
    }


}
