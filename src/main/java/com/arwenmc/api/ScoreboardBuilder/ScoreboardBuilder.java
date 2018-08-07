package com.arwenmc.api.ScoreboardBuilder;

import com.google.common.collect.Lists;
import org.bukkit.Bukkit;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

import java.util.List;

public class ScoreboardBuilder {

    private ScoreboardManager scoreboardManager = Bukkit.getScoreboardManager();
    private Scoreboard scoreboard = this.scoreboardManager.getMainScoreboard();
    private Objective objective;

    public ScoreboardBuilder(String objectiveName) {
        this.objective = this.scoreboard.registerNewObjective(objectiveName, "dummy", objectiveName);
    }

    public ScoreboardBuilder addEntries(List<String> entries) {
        int i = 0;
        for (String score : Lists.reverse(entries)) {
            i++;
            objective.getScore(score).setScore(i);
        }
        return this;
    }

    public ScoreboardBuilder setTitle(String title) {
        objective.setDisplayName(title);
        return this;
    }

    public Scoreboard build() {
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);
        return this.scoreboard;
    }

}
