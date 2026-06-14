package io.teaql.worldcup.command;

import com.example.fifaworldcupservice.Q;
import com.example.fifaworldcupservice.groupstanding.GroupStanding;
import com.example.fifaworldcupservice.groupstanding.GroupStandingRequest;
import com.example.fifaworldcupservice.matchgroup.MatchGroup;
import com.example.fifaworldcupservice.tournamentteam.TournamentTeam;
import io.teaql.core.SmartList;
import io.teaql.core.UserContext;
import io.teaql.worldcup.db.DatabaseManager;
import io.teaql.worldcup.util.AnsiColors;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Displays global power rankings across all 48 teams.
 *
 * <p>Queries group standings joined with tournament teams, ordered by
 * points, goal difference, and goals scored. Supports filtering by
 * group letter and limiting the number of displayed rows.</p>
 */
@Command(
        name = "rank",
        description = "Show global power rankings across all 48 teams",
        mixinStandardHelpOptions = true
)
public class RankCommand implements Runnable {

    @Option(names = {"--top", "-t"}, description = "Show top N teams", defaultValue = "48")
    private int top;

    @Option(names = {"--group", "-g"}, description = "Filter by group letter")
    private String group;

    @Override
    public void run() {
        DatabaseManager db = DatabaseManager.getInstance();
        if (!db.isInitialized()) {
            System.out.println(AnsiColors.red("✗ Database not initialized."));
            System.out.println("  Run " + AnsiColors.bold("wc2026 init") + " to set up the database first.");
            return;
        }

        UserContext ctx = db.getContext();

        try {
            GroupStandingRequest req = Q.groupStandings()
                    .selectTournamentTeam()
                    .selectMatchGroup()
                    .orderByPointsDescending()
                    .orderByGoalDifferenceDescending()
                    .orderByGoalsForDescending();

            if (group != null && !group.isBlank()) {
                MatchGroup g = Q.matchGroups().filterByGroupLetter(group.toUpperCase().trim()).comment("Find group").purpose("Display").executeForList(ctx).first();
                req = req.filterByMatchGroup(g);
            }

            SmartList<GroupStanding> standings = req
                    .comment("Load rankings")
                    .purpose("Display")
                    .executeForList(ctx);

            List<GroupStanding> topStandings = standings.stream()
                    .limit(top)
                    .collect(Collectors.toList());

            printRankings(ctx, topStandings);

        } catch (Exception e) {
            System.err.println(AnsiColors.red("❌ Query failed: " + e.getMessage()));
            e.printStackTrace();
        }
    }

    private void printRankings(UserContext ctx, List<GroupStanding> standings) {
        String title = (group != null && !group.isBlank())
                ? "🏆 WORLD CUP 2026 RANKINGS — GROUP " + group.toUpperCase()
                : "🏆 WORLD CUP 2026 RANKINGS";

        System.out.println();
        System.out.println(AnsiColors.bold(AnsiColors.CYAN + title + AnsiColors.RESET));
        System.out.println(AnsiColors.DIM + "══════════════════════════════════════════════════════════════════" + AnsiColors.RESET);
        System.out.printf(AnsiColors.BOLD + "%s %s %-4s %2s %2s %2s %2s  %2s %2s  %3s  %3s"
                + AnsiColors.RESET + "%n",
                AnsiColors.padRight("Rank", 5), AnsiColors.padRight("Team", 40), "Grp", "P", "W", "D", "L", "GF", "GA", "GD", "Pts");

        if (standings.isEmpty()) {
            System.out.println();
            System.out.println(AnsiColors.yellow("  ⚠  No standings data found. "
                    + "Run 'wc2026 init' to set up the database."));
            System.out.println();
            return;
        }

        int rank = 0;
        for (GroupStanding gs : standings) {
            rank++;

            TournamentTeam team = gs.getTournamentTeam();
            if (team != null && team.getTeamName() == null) {
                team = Q.tournamentTeams().withIdIs(team.getId()).comment("Load team").purpose("Display").executeForList(ctx).first();
                gs.updateTournamentTeam(team);
            }
            String teamName = team != null ? team.getTeamName() : "TBD";
            String emojiFlag = team != null ? team.getEmojiFlag() : "";
            String groupLetter = team != null ? team.getGroupLetter() : "?";
            
            int played = gs.getPlayed() != null ? gs.getPlayed() : 0;
            int won = gs.getWon() != null ? gs.getWon() : 0;
            int drawn = gs.getDrawn() != null ? gs.getDrawn() : 0;
            int lost = gs.getLost() != null ? gs.getLost() : 0;
            int goalsFor = gs.getGoalsFor() != null ? gs.getGoalsFor() : 0;
            int goalsAgainst = gs.getGoalsAgainst() != null ? gs.getGoalsAgainst() : 0;
            int goalDiff = gs.getGoalDifference() != null ? gs.getGoalDifference() : 0;
            int points = gs.getPoints() != null ? gs.getPoints() : 0;

            String gdStr = goalDiff > 0 ? "+" + goalDiff : String.valueOf(goalDiff);

            String coloredGd;
            if (goalDiff > 0) {
                coloredGd = AnsiColors.green(String.format("%3s", gdStr));
            } else if (goalDiff < 0) {
                coloredGd = AnsiColors.red(String.format("%3s", gdStr));
            } else {
                coloredGd = String.format("%3s", gdStr);
            }

            String coloredPts;
            if (points > 0) {
                coloredPts = AnsiColors.green(String.format("%3d", points));
            } else {
                coloredPts = String.format("%3d", points);
            }

            String flagStr = (emojiFlag != null && !emojiFlag.isEmpty() ? emojiFlag : "🏳");

            String fullTeamName = flagStr + " " + teamName;
            System.out.printf("%4d  %s %-4s %2d %2d %2d %2d  %2d %2d  %s  %s%n",
                    rank, AnsiColors.padRight(fullTeamName, 40), groupLetter,
                    played, won, drawn, lost,
                    goalsFor, goalsAgainst,
                    coloredGd, coloredPts);
        }

        System.out.println();
    }
}
