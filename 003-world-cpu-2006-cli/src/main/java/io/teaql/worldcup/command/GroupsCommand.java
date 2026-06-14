package io.teaql.worldcup.command;

import com.example.fifaworldcupservice.Q;
import com.example.fifaworldcupservice.groupstanding.GroupStanding;
import com.example.fifaworldcupservice.matchgroup.MatchGroup;
import com.example.fifaworldcupservice.tournamentteam.TournamentTeam;
import io.teaql.core.SmartList;
import io.teaql.core.UserContext;
import io.teaql.worldcup.db.DatabaseManager;
import io.teaql.worldcup.util.AnsiColors;
import picocli.CommandLine.Command;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Command(
        name = "groups",
        description = "Show all 12 World Cup groups",
        mixinStandardHelpOptions = true
)
public class GroupsCommand implements Runnable {

    private static final int COL_WIDTH = 38;

    @Override
    public void run() {
        DatabaseManager db = DatabaseManager.getInstance();
        if (!db.isInitialized()) {
            System.out.println(AnsiColors.red("✗ Database not initialized."));
            System.out.println("  Run " + AnsiColors.bold("wc2026 init") + " to set up the database first.");
            return;
        }

        Map<String, List<TeamRow>> groups = loadGroups(db.getContext());
        if (groups.isEmpty()) {
            System.out.println(AnsiColors.yellow("⚠ No group data found in the database."));
            return;
        }

        printHeader();
        printGroups(groups);
    }

    private Map<String, List<TeamRow>> loadGroups(UserContext ctx) {
        Map<String, List<TeamRow>> groups = new LinkedHashMap<>();
        try {
            SmartList<GroupStanding> standings = Q.groupStandings()
                    .selectTournamentTeam()
                    .selectMatchGroup()
                    .orderByMatchGroupAscending()
                    .orderByPointsDescending()
                    .orderByGoalDifferenceDescending()
                    .orderByGoalsForDescending()
                    .comment("Load all group standings")
                    .purpose("Display groups overview")
                    .executeForList(ctx);

            for (GroupStanding gs : standings) {
                MatchGroup group = gs.getMatchGroup();
                if (group != null && group.getGroupLetter() == null) {
                    group = Q.matchGroups().withIdIs(group.getId()).comment("Load group").purpose("Display").executeForList(ctx).first();
                    gs.updateMatchGroup(group);
                }
                TournamentTeam team = gs.getTournamentTeam();
                if (team != null && team.getTeamName() == null) {
                    team = Q.tournamentTeams().withIdIs(team.getId()).comment("Load team").purpose("Display").executeForList(ctx).first();
                    gs.updateTournamentTeam(team);
                }
                
                String letter = group != null ? group.getGroupLetter() : "?";
                String flag = team != null ? team.getEmojiFlag() : "🏳";
                String name = team != null ? team.getTeamName() : "TBD";
                
                groups.computeIfAbsent(letter, k -> new ArrayList<>())
                      .add(new TeamRow(
                              flag,
                              name,
                              gs.getPoints(),
                              gs.getPlayed(),
                              gs.getGoalDifference()
                      ));
            }
        } catch (Exception e) {
            System.out.println(AnsiColors.red("✗ Database error: ") + e.getMessage());
        }
        return groups;
    }

    private void printHeader() {
        System.out.println();
        System.out.println(AnsiColors.BOLD + AnsiColors.CYAN
                + "  ⚽ FIFA WORLD CUP 2026 — GROUP OVERVIEW"
                + AnsiColors.RESET);
        System.out.println();
    }

    private void printGroups(Map<String, List<TeamRow>> groups) {
        List<String> letters = new ArrayList<>(groups.keySet());

        for (int i = 0; i < letters.size(); i += 2) {
            String leftLetter  = letters.get(i);
            String rightLetter = (i + 1 < letters.size()) ? letters.get(i + 1) : null;

            List<TeamRow> leftTeams  = groups.get(leftLetter);
            List<TeamRow> rightTeams = rightLetter != null ? groups.get(rightLetter) : List.of();

            String leftHeader  = AnsiColors.BOLD + "  GROUP " + leftLetter + AnsiColors.RESET;
            String rightHeader = rightLetter != null
                    ? AnsiColors.BOLD + "GROUP " + rightLetter + AnsiColors.RESET
                    : "";
            System.out.printf("  %-" + (COL_WIDTH + ansiOverhead(leftHeader) - 2) + "s  %s%n",
                    leftHeader, rightHeader);

            int maxRows = Math.max(leftTeams.size(), rightTeams.size());
            for (int r = 0; r < maxRows; r++) {
                String leftLine  = r < leftTeams.size()  ? formatTeamLine(leftTeams.get(r))  : "";
                String rightLine = r < rightTeams.size() ? formatTeamLine(rightTeams.get(r)) : "";

                int leftVisible = visibleLength(leftLine);
                int padding = COL_WIDTH - leftVisible;
                if (padding < 0) padding = 0;

                System.out.println("  " + leftLine + " ".repeat(padding) + "  " + rightLine);
            }
            System.out.println();
        }
    }

    private String formatTeamLine(TeamRow row) {
        String flag = row.emojiFlag != null ? row.emojiFlag : "🏳";
        String name = row.teamName != null ? row.teamName : "TBD";

        String nameStr = flag + " " + name;
        int nameVisible = flagDisplayWidth(flag) + 1 + name.length();

        String ptsStr = row.points + " pts";

        int totalTarget = 30;
        int dotsNeeded = totalTarget - nameVisible - ptsStr.length();
        if (dotsNeeded < 2) dotsNeeded = 2;

        String dots = AnsiColors.DIM + " " + ".".repeat(dotsNeeded) + " " + AnsiColors.RESET;

        String coloredPts;
        if (row.points >= 6) {
            coloredPts = AnsiColors.GREEN + ptsStr + AnsiColors.RESET;
        } else if (row.points >= 3) {
            coloredPts = AnsiColors.YELLOW + ptsStr + AnsiColors.RESET;
        } else if (row.played > 0) {
            coloredPts = AnsiColors.RED + ptsStr + AnsiColors.RESET;
        } else {
            coloredPts = AnsiColors.DIM + ptsStr + AnsiColors.RESET;
        }

        return " " + nameStr + dots + coloredPts;
    }

    private int flagDisplayWidth(String flag) {
        if (flag == null || flag.isEmpty()) return 0;
        return 2;
    }

    private int visibleLength(String s) {
        return AnsiColors.visibleLength(s);
    }

    private int ansiOverhead(String s) {
        return s.length() - visibleLength(s);
    }

    private record TeamRow(
            String emojiFlag,
            String teamName,
            int points,
            int played,
            int goalDifference
    ) {}
}
