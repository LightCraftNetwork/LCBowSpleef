package net.lightcraftmc.bowspleef;

import net.lightcraftmc.bowspleef.Executors.EndGame;
import net.lightcraftmc.bowspleef.Executors.StartGame;
import net.lightcraftmc.fusebox.gameapi.*;
import org.bukkit.ChatColor;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright Elliott Olson (c) 2014. All Rights Reserved.
 * Any code contained within this document, and any associated APIs with similar brandings
 * are the sole property of Elliott Olson. Distribution, reproduction, taking snippits, or
 * claiming any contents as your own will break the terms of the license, and void any
 * agreements with you, the third party.
 */
public class Game extends GameCore{

    @Override
    public GameManager setupGame() {


        PreventionSet set = new PreventionSet();
        {
            set.setBuild(true);
            set.setDestroy(true);
            set.setDropItem(true);
            set.setPickupItem(true);
            set.setPve(true);
            set.setPvp(true);
        }


        GameManager game = new GameManager("BowSpleef", ChatColor.DARK_AQUA, set);
        {

            //Description
            List<String> description = new ArrayList<String>();
            description.add(ChatColor.GRAY + "BowSpleef is an archery game where you put your");
            description.add(ChatColor.GRAY + "skills to the test, in order to shoot the blocks");
            description.add(ChatColor.GRAY + "out from under your opponents feet, before they");
            description.add(ChatColor.GRAY + "shoot out yours.");

            game.setDescription(description);

            List<Team> teams = new ArrayList<Team>();
            {

                Team team = new Team("Players", "players", ChatColor.GREEN);
                team.setCanViewMembers(true);
                team.setHidden(false);
                team.setJoinable(false);
                team.setMaximumSize(24);
                team.setMinimumSize(2);
                teams.add(team);

            }
            {

                Team team = new Team("Spectators", "spectators", ChatColor.RED);
                team.setCanViewMembers(false);
                team.setHidden(true);
                team.setJoinable(false);
                team.setMaximumSize(23);
                team.setMinimumSize(0);
                teams.add(team);

            }

            game.setTeamBased(true);
            game.setTeams(teams);

            game.setStartGameExecutor(new StartGame());
            game.setEndGameExecutor(new EndGame());

            game.setEnforcePlayableArea(true);

            game.setKitsEnabled(true);

            game.setState(GameState.STARTING);

            game.setUseMotd(true);

            game.setSubTitle("An Archery Game plus Spleef");

            game.setup();


        }

        return game;
    }
}
