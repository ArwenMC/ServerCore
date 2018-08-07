package com.arwenmc.events;

import com.arwenmc.ServerCore;
import com.arwenmc.api.ScoreboardBuilder.ScoreboardBuilder;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scoreboard.Scoreboard;

import java.util.Arrays;

public class PlayerJoin implements Listener {

    ServerCore plugin;

    public PlayerJoin(ServerCore instance) {
        plugin = instance;
    }

    @EventHandler
    public void PlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        ScoreboardBuilder sb = new ScoreboardBuilder("")

        Scoreboard sb = new ScoreboardBuilder("MainBoard", "Test Server 1.12.2", Arrays.asList("yourScore", "yourNextScore"))
                .build();
        player.setScoreboard(sb);

    }
}

