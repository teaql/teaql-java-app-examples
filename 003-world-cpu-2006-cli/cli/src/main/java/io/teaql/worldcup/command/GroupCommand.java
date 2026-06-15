package io.teaql.worldcup.command;

import com.example.fifaworldcupservice.Q;
import com.example.fifaworldcupservice.groupstanding.GroupStanding;
import com.example.fifaworldcupservice.tournamentmatch.TournamentMatch;
import com.example.fifaworldcupservice.tournamentteam.TournamentTeam;
import io.teaql.core.SmartList;
import io.teaql.core.UserContext;
import io.teaql.worldcup.db.DatabaseManager;
import io.teaql.worldcup.util.AnsiColors;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import com.example.fifaworldcupservice.matchgroup.MatchGroup;

@Command(
        name = "group",
        description = "Show detailed standings for a specific group",
        mixinStandardHelpOptions = true
)
public class GroupCommand implements Runnable {

    @Parameters(index = "0", description = "Group letter (A-L)")
    private String groupLetter;

    private static final int HEADER_WIDTH = 50;

    private static final DateTimeFormatter DATE_FMT =
            DateTimeFormatter.ofPattern("MMM dd");

    @Override
    public void run() {
        DatabaseManager db = DatabaseManager.getInstance();
        if (!db.isInitialized()) {
            System.out.println(AnsiColors.red("✗ Database not initialized."));
            System.out.println("  Run " + AnsiColors.bold("wc2026 init") + " to set up the database first.");
            return;
        }

        String letter = groupLetter.trim().toUpperCase();
        if (letter.length() != 1 || letter.charAt(0) < 'A' || letter.charAt(0) > 'L') {
            System.out.println(AnsiColors.red("✗ Invalid group letter: " + groupLetter));
            System.out.println("  Please specify a letter from A to L.");
            return;
        }

        printGroupHeader(letter);

        UserContext ctx = db.getContext();

        List<StandingRow> standings = loadStandings(ctx, letter);
        if (standings.isEmpty()) {
            System.out.println(AnsiColors.yellow("  ⚠ No standings found for Group " + letter));
            System.out.println();
            return;
        }
        printStandings(standings);

        List<MatchRow> matches = loadMatches(ctx, letter);
        printResults(matches);
        printUpcoming(matches);
    }

    private List<StandingRow> loadStandings(UserContext ctx, String letter) {
        List<StandingRow> rows = new ArrayList<>();
        try {
            MatchGroup g = Q.matchGroups().filterByGroupLetter(letter).comment("Find group").purpose("Display").executeForList(ctx).first();
            SmartList<GroupStanding> standings = Q.groupStandings()
                    .selectTournamentTeam()
                    .filterByMatchGroup(g)
                    .orderByPointsDescending()
                    .orderByGoalDifferenceDescending()
                    .orderByGoalsForDescending()
                    .comment("Load group standings")
                    .purpose("Display single group detail")
                    .executeForList(ctx);

            for (GroupStanding gs : standings) {
                TournamentTeam team = gs.getTournamentTeam();
                if (team != null && team.getTeamName() == null) {
                    team = Q.tournamentTeams().withIdIs(team.getId()).comment("Load team").purpose("Display").executeForList(ctx).first();
                    gs.updateTournamentTeam(team);
                }
                rows.add(new StandingRow(
                        team != null ? team.getEmojiFlag() : "🏳",
                        team != null ? team.getTeamName() : "TBD",
                        gs.getPlayed(),
                        gs.getWon(),
                        gs.getDrawn(),
                        gs.getLost(),
                        gs.getGoalsFor(),
                        gs.getGoalsAgainst(),
                        gs.getGoalDifference(),
                        gs.getPoints()
                ));
            }
        } catch (Exception e) {
            System.out.println(AnsiColors.red("  ✗ Database error: ") + e.getMessage());
        }
        return rows;
    }

    private List<MatchRow> loadMatches(UserContext ctx, String letter) {
        List<MatchRow> rows = new ArrayList<>();
        try {
            MatchGroup g = Q.matchGroups().filterByGroupLetter(letter).comment("Find group").purpose("Display").executeForList(ctx).first();
            SmartList<TournamentMatch> matches = Q.tournamentMatches()
                    .selectHomeTeam()
                    .selectAwayTeam()
                    .filterByMatchGroup(g)
                    .orderByMatchDateAscending()
                    .orderByMatchNumberAscending()
                    .comment("Load group matches")
                    .purpose("Display single group fixtures")
                    .executeForList(ctx);

            for (TournamentMatch m : matches) {
                LocalDate date = m.getMatchDate();
                TournamentTeam home = m.getHomeTeam();
                if (home != null && home.getTeamName() == null) {
                    home = Q.tournamentTeams().withIdIs(home.getId()).comment("Load home").purpose("Display").executeForList(ctx).first();
                    m.updateHomeTeam(home);
                }
                TournamentTeam away = m.getAwayTeam();
                if (away != null && away.getTeamName() == null) {
                    away = Q.tournamentTeams().withIdIs(away.getId()).comment("Load away").purpose("Display").executeForList(ctx).first();
                    m.updateAwayTeam(away);
                }
                rows.add(new MatchRow(
                        date,
                        home != null ? home.getEmojiFlag() : "🏳",
                        home != null ? home.getTeamName() : "TBD",
                        away != null ? away.getEmojiFlag() : "🏳",
                        away != null ? away.getTeamName() : "TBD",
                        m.getHomeScore(),
                        m.getAwayScore(),
                        m.getVenueName(),
                        m.getVenueCity(),
                        m.getMatchStatus() != null ? m.getMatchStatus().getCode() : null
                ));
            }
        } catch (Exception e) {
            System.out.println(AnsiColors.red("  ✗ Database error: ") + e.getMessage());
        }
        return rows;
    }

    private void printGroupHeader(String letter) {
        System.out.println();
        String title = " GROUP " + letter + " ";
        int pad = (HEADER_WIDTH - title.length()) / 2;
        String line = "═".repeat(pad) + title + "═".repeat(HEADER_WIDTH - pad - title.length());
        System.out.println(AnsiColors.BOLD + AnsiColors.CYAN + "  " + line + AnsiColors.RESET);
        System.out.println();
    }

    private void printStandings(List<StandingRow> standings) {
        System.out.println(AnsiColors.BOLD + "  STANDINGS" + AnsiColors.RESET);

        System.out.printf(AnsiColors.DIM + "  %s   %s  %2s  %2s  %2s  %2s  %3s %3s  %3s  %3s"
                + AnsiColors.RESET + "%n",
                "#",
                AnsiColors.padRight("Team", 40),
                "P", "W", "D", "L", "GF", "GA", "GD", "Pts"
        );

        int rank = 1;
        for (StandingRow row : standings) {
            String flag = row.emojiFlag != null ? row.emojiFlag : "🏳";
            String name = row.teamName != null ? row.teamName : "TBD";
            String teamDisplay = flag + " " + AnsiColors.bold(name);

            String gdStr;
            if (row.goalDifference > 0) {
                gdStr = AnsiColors.green("+" + row.goalDifference);
            } else if (row.goalDifference < 0) {
                gdStr = AnsiColors.red(String.valueOf(row.goalDifference));
            } else {
                gdStr = AnsiColors.DIM + " 0" + AnsiColors.RESET;
            }

            String ptsStr;
            if (row.points >= 6) {
                ptsStr = AnsiColors.GREEN + AnsiColors.BOLD + row.points + AnsiColors.RESET;
            } else if (row.points >= 3) {
                ptsStr = AnsiColors.YELLOW + AnsiColors.BOLD + row.points + AnsiColors.RESET;
            } else {
                ptsStr = AnsiColors.DIM + String.valueOf(row.points) + AnsiColors.RESET;
            }

            String paddedTeam = AnsiColors.padRight(teamDisplay, 40);

            int ptsVisible = String.valueOf(row.points).length();
            String ptsPadding = ptsVisible < 3 ? " ".repeat(3 - ptsVisible) : "";

            System.out.printf("  %s   %s  %2d  %2d  %2d  %2d  %3d %3d  %s  %s%n",
                    AnsiColors.BOLD + rank + AnsiColors.RESET,
                    paddedTeam,
                    row.played,
                    row.won,
                    row.drawn,
                    row.lost,
                    row.goalsFor,
                    row.goalsAgainst,
                    padAfterAnsi(gdStr, 3) + gdStr,
                    ptsPadding + ptsStr
            );
            rank++;
        }
        System.out.println();
    }

    private void printResults(List<MatchRow> matches) {
        List<MatchRow> finished = matches.stream()
                .filter(m -> "FINISHED".equals(m.statusCode))
                .toList();

        if (finished.isEmpty()) {
            System.out.println(AnsiColors.DIM + "  RESULTS" + AnsiColors.RESET);
            System.out.println(AnsiColors.DIM + "  No completed matches yet." + AnsiColors.RESET);
            System.out.println();
            return;
        }

        System.out.println(AnsiColors.BOLD + "  RESULTS" + AnsiColors.RESET);
        for (MatchRow m : finished) {
            String dateStr = m.matchDate != null
                    ? m.matchDate.format(DATE_FMT)
                    : "TBD";
            String homeName = m.homeName != null ? m.homeName : "TBD";
            String awayName = m.awayName != null ? m.awayName : "TBD";
            int hs = m.homeScore != null ? m.homeScore : 0;
            int as = m.awayScore != null ? m.awayScore : 0;

            String homeScoreStr, awayScoreStr;
            if (hs > as) {
                homeScoreStr = AnsiColors.green(String.valueOf(hs));
                awayScoreStr = AnsiColors.red(String.valueOf(as));
            } else if (hs < as) {
                homeScoreStr = AnsiColors.red(String.valueOf(hs));
                awayScoreStr = AnsiColors.green(String.valueOf(as));
            } else {
                homeScoreStr = AnsiColors.yellow(String.valueOf(hs));
                awayScoreStr = AnsiColors.yellow(String.valueOf(as));
            }

            String venue = formatVenue(m.venueName, m.venueCity);

            System.out.printf("  %s   %s %s %s - %s %s   🏟️  %s%n",
                    AnsiColors.DIM + dateStr + AnsiColors.RESET,
                    orBlank(m.homeFlag), AnsiColors.bold(homeName),
                    homeScoreStr,
                    awayScoreStr,
                    AnsiColors.bold(awayName) + " " + orBlank(m.awayFlag),
                    AnsiColors.DIM + venue + AnsiColors.RESET
            );
        }
        System.out.println();
    }

    private void printUpcoming(List<MatchRow> matches) {
        List<MatchRow> scheduled = matches.stream()
                .filter(m -> "SCHEDULED".equals(m.statusCode))
                .toList();

        if (scheduled.isEmpty()) {
            System.out.println(AnsiColors.DIM + "  UPCOMING" + AnsiColors.RESET);
            System.out.println(AnsiColors.DIM + "  All matches completed." + AnsiColors.RESET);
            System.out.println();
            return;
        }

        System.out.println(AnsiColors.BOLD + "  UPCOMING" + AnsiColors.RESET);
        for (MatchRow m : scheduled) {
            String dateStr = m.matchDate != null
                    ? m.matchDate.format(DATE_FMT)
                    : "TBD";
            String homeName = m.homeName != null ? m.homeName : "TBD";
            String awayName = m.awayName != null ? m.awayName : "TBD";
            String venue = formatVenue(m.venueName, m.venueCity);

            System.out.printf("  %s   %s %s vs %s %s   🏟️  %s%n",
                    AnsiColors.DIM + dateStr + AnsiColors.RESET,
                    orBlank(m.homeFlag), AnsiColors.bold(homeName),
                    AnsiColors.bold(awayName), orBlank(m.awayFlag),
                    AnsiColors.DIM + venue + AnsiColors.RESET
            );
        }
        System.out.println();
    }

    private String formatVenue(String venueName, String city) {
        if (venueName != null && city != null) {
            return venueName + ", " + city;
        } else if (venueName != null) {
            return venueName;
        } else if (city != null) {
            return city;
        }
        return "TBD";
    }

    private String orBlank(String s) {
        return s != null ? s : "";
    }

    private String padAfterAnsi(String ansiStr, int targetWidth) {
        int visible = ansiStr.replaceAll("\u001B\\[[0-9;]*m", "").length();
        int needed = targetWidth - visible;
        return needed > 0 ? " ".repeat(needed) : "";
    }

    private record StandingRow(
            String emojiFlag,
            String teamName,
            int played,
            int won,
            int drawn,
            int lost,
            int goalsFor,
            int goalsAgainst,
            int goalDifference,
            int points
    ) {}

    private record MatchRow(
            LocalDate matchDate,
            String homeFlag,
            String homeName,
            String awayFlag,
            String awayName,
            Integer homeScore,
            Integer awayScore,
            String venueName,
            String venueCity,
            String statusCode
    ) {}
}
