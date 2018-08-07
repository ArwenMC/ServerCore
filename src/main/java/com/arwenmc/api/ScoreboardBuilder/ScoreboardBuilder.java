package com.arwenmc.api.ScoreboardBuilder;

/*
 Example Of ScoreboardBuilder

 Scoreboard sb = new ScoreboardBuilder("yourObjective", "yourTitle", Arrays.asList("yourScore", "yourNextScore"))
            .build();
 player.setScoreboard(sb);
 */

/*public class ScoreboardBuilder {
    private ScoreboardManager mg = Bukkit.getScoreboardManager();
    private Scoreboard sb = this.mg.getMainScoreboard();

    public ScoreboardBuilder(String objective, String title, List<String> entrys) {
        Objective obj = this.sb.registerNewObjective(objective, "dummy");
        int i = 0;
        for (String score : Lists.reverse(entrys)) {
            i++;
            obj.getScore(score).setScore(i);
        }
        obj.setDisplayName(title);
        obj.setDisplaySlot(DisplaySlot.SIDEBAR);
    }

    public Scoreboard build() {
        return this.sb;
    }
}*/

import org.bukkit.Bukkit;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

public class ScoreboardBuilder {

    private ScoreboardManager scoreboardManager = Bukkit.getScoreboardManager();
    private Scoreboard scoreboard = this.scoreboardManager.getMainScoreboard();

    public ScoreboardBuilder(String objectiveName) {
        Objective objective = this.scoreboard.re
    }

}
