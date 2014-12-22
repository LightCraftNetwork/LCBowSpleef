package net.lightcraftmc.bowspleef;

import net.lightcraftmc.bowspleef.Executors.EndGame;
import net.lightcraftmc.bowspleef.Executors.StartGame;
import net.lightcraftmc.fusebox.gameapi.Data;
import net.lightcraftmc.fusebox.gameapi.GameManager;
import net.lightcraftmc.fusebox.gameapi.PreventionSet;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Copyright Elliott Olson (c) 2014. All Rights Reserved.
 * Any code contained within this document, and any associated APIs with similar brandings
 * are the sole property of Elliott Olson. Distribution, reproduction, taking snippits, or
 * claiming any contents as your own will break the terms of the license, and void any
 * agreements with you, the third party.
 */
public class Core extends JavaPlugin{

    public static Core core;


    @Override
    public void onEnable(){

        getLogger().info("[BowSpleef] Initializing BowSpleef...");
        intialize();
        getLogger().info("[BowSpleef] Initialized BowSpleef");



    }


    @Override
    public void onDisable(){



    }

    public Core getInstance(){
        return core;
    }

    public void intialize(){

        //Setup Game
        Game game = new Game();
        game.setupGame();

        //Get Game Data
        Data data = new Data();

            String name = data.getName();
            ChatColor color = data.getColor();
            PreventionSet set = data.getSet();

        //Call the GameManager using Game Data
        GameManager gameManager = new GameManager(name, color, set);

        //Set Fusebox's GameAPI Executors with what we have.
        gameManager.setEndGameExecutor(new EndGame());
        gameManager.setStartGameExecutor(new StartGame());


    }

}
