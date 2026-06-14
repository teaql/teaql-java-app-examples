package io.teaql.worldcup.command;

import com.example.fifaworldcupservice.Q;
import com.example.fifaworldcupservice.groupstanding.GroupStanding;
import com.example.fifaworldcupservice.matchgroup.MatchGroup;
import com.example.fifaworldcupservice.tournament.Tournament;
import com.example.fifaworldcupservice.tournamentmatch.TournamentMatch;
import com.example.fifaworldcupservice.tournamentteam.TournamentTeam;
import io.teaql.core.SmartList;
import io.teaql.core.UserContext;
import io.teaql.worldcup.db.DatabaseManager;
import io.teaql.worldcup.util.AnsiColors;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

import java.util.Comparator;

/**
 * Records a match result and recalculates group standings.
 *
 * <p>Updates the tournament_match with the given score, sets the match
 * status to FINISHED, then recomputes standings for every team in the
 * affected group from scratch using all finished matches.</p>
 */
@Command(
        name = "record",
        description = "Record a match result",
        mixinStandardHelpOptions = true
)
public class RecordCommand implements Runnable {

    @Option(names = {"--match", "-m"}, description = "Match number")
    private Integer matchNumber;

    @Option(names = {"--home"}, description = "Home team code (e.g. BRA)")
    private String homeTeamCode;

    @Option(names = {"--away"}, description = "Away team code (e.g. MAR)")
    private String awayTeamCode;

    @Option(names = {"--score", "-s"}, description = "Score (e.g. 3-1)", required = true)
    private String score;

    @Override
    public void run() {
        int homeScore;
        int awayScore;
        try {
            String[] parts = score.split("-");
            if (parts.length != 2) {
                throw new IllegalArgumentException("expected format: H-A");
            }
            homeScore = Integer.parseInt(parts[0].trim());
            awayScore = Integer.parseInt(parts[1].trim());
        } catch (Exception e) {
            System.err.println(AnsiColors.red("❌ Invalid score format '" + score
                    + "'. Expected H-A (e.g. 3-1)"));
            return;
        }

        DatabaseManager db = DatabaseManager.getInstance();
        if (!db.isInitialized()) {
            System.out.println(AnsiColors.red("✗ Database not initialized."));
            System.out.println("  Run " + AnsiColors.bold("wc2026 init") + " to set up the database first.");
            return;
        }

        UserContext ctx = db.getContext();

        try {
            TournamentMatch match = null;
            String groupLetter = null;

            if (matchNumber != null) {
                match = Q.tournamentMatches()
                        .filterByMatchNumber(matchNumber)
                        .selectHomeTeam()
                        .selectAwayTeam()
                        .selectMatchGroup()
                        .comment("Find match by number")
                        .purpose("Record score")
                        .executeForList(ctx)
                        .first();

                if (match == null) {
                    System.err.println(AnsiColors.red("❌ No match found with number " + matchNumber));
                    return;
                }
                if (match.getMatchGroup() != null) {
                    groupLetter = match.getMatchGroup().getGroupLetter();
                }
            } else {
                if (homeTeamCode == null || awayTeamCode == null) {
                    System.err.println(AnsiColors.red("❌ Must provide both --home and --away if --match is not specified"));
                    return;
                }

                String htCode = homeTeamCode.toUpperCase().trim();
                String atCode = awayTeamCode.toUpperCase().trim();

                TournamentTeam home = Q.tournamentTeams().filterByTeamCode(htCode).comment("Find home").purpose("Record score").executeForList(ctx).first();
                TournamentTeam away = Q.tournamentTeams().filterByTeamCode(atCode).comment("Find away").purpose("Record score").executeForList(ctx).first();

                if (home == null) {
                    System.err.println(AnsiColors.red("❌ Unknown team code: " + htCode));
                    return;
                }
                if (away == null) {
                    System.err.println(AnsiColors.red("❌ Unknown team code: " + atCode));
                    return;
                }

                groupLetter = home.getGroupLetter();

                match = Q.tournamentMatches()
                        .filterByHomeTeam(home)
                        .filterByAwayTeam(away)
                        .selectHomeTeam()
                        .selectAwayTeam()
                        .selectMatchGroup()
                        .comment("Find match by teams")
                        .purpose("Record score")
                        .executeForList(ctx)
                        .first();

                if (match == null) {
                    Tournament t = Q.tournaments().comment("Find t").purpose("Record").executeForList(ctx).first();
                    MatchGroup mg = Q.matchGroups().filterByGroupLetter(groupLetter).comment("Find group").purpose("Record score").executeForList(ctx).first();
                    
                    match = new TournamentMatch();
                    match.updateHomeTeam(home);
                    match.updateAwayTeam(away);
                    match.updateMatchGroup(mg);
                    match.updateTournament(t);
                    match.updateMatchStageToGroup();
                }
            }

            match.updateHomeScore(homeScore);
            match.updateAwayScore(awayScore);
            match.updateMatchStatusToFinished();
            match.auditAs("Record match score").save(ctx);

            if (groupLetter != null) {
                recalculateGroupStandings(ctx, groupLetter);
            }

            TournamentTeam ht = match.getHomeTeam();
            TournamentTeam at = match.getAwayTeam();
            
            String homeName = ht != null ? ht.getTeamName() : "TBD";
            String awayName = at != null ? at.getTeamName() : "TBD";
            String homeFlag = ht != null && ht.getEmojiFlag() != null ? ht.getEmojiFlag() + " " : "";
            String awayFlag = at != null && at.getEmojiFlag() != null ? at.getEmojiFlag() + " " : "";

            System.out.println();
            System.out.println(AnsiColors.green("✅ Match recorded: "
                    + homeFlag + homeName + " " + homeScore + " - " + awayScore + " " + awayFlag + awayName
                    + (groupLetter != null ? " (Group " + groupLetter + ")" : "")));
            System.out.println();

            if (groupLetter != null) {
                printGroupStandings(ctx, groupLetter);
            }

        } catch (Exception e) {
            System.err.println(AnsiColors.red("❌ Failed to record match: " + e.getMessage()));
            e.printStackTrace();
        }
    }

    private void recalculateGroupStandings(UserContext ctx, String groupLetter) throws Exception {
        MatchGroup g = Q.matchGroups().filterByGroupLetter(groupLetter).comment("Find group").purpose("Recalculate").executeForList(ctx).first();
        SmartList<GroupStanding> standings = Q.groupStandings()
                .selectTournamentTeam()
                .filterByMatchGroup(g)
                .comment("Load standings")
                .purpose("Recalculate")
                .executeForList(ctx);

        for (GroupStanding standing : standings) {
            TournamentTeam team = standing.getTournamentTeam();
            if (team == null) continue;

            SmartList<TournamentMatch> allMatches = Q.tournamentMatches()
                    .withMatchStatusIsFinished()
                    .filterByMatchGroup(g)
                    .comment("Load matches")
                    .purpose("Recalculate")
                    .executeForList(ctx);

            int played = 0, won = 0, drawn = 0, lost = 0;
            int gf = 0, ga = 0;

            for (TournamentMatch m : allMatches) {
                boolean isHome = m.getHomeTeam() != null && m.getHomeTeam().getId().equals(team.getId());
                boolean isAway = m.getAwayTeam() != null && m.getAwayTeam().getId().equals(team.getId());

                if (!isHome && !isAway) continue;

                int hs = m.getHomeScore() != null ? m.getHomeScore() : 0;
                int as = m.getAwayScore() != null ? m.getAwayScore() : 0;

                played++;
                if (isHome) {
                    gf += hs; ga += as;
                    if (hs > as) won++;
                    else if (hs == as) drawn++;
                    else lost++;
                } else {
                    gf += as; ga += hs;
                    if (as > hs) won++;
                    else if (as == hs) drawn++;
                    else lost++;
                }
            }

            standing.updatePlayed(played);
            standing.updateWon(won);
            standing.updateDrawn(drawn);
            standing.updateLost(lost);
            standing.updateGoalsFor(gf);
            standing.updateGoalsAgainst(ga);
            standing.updateGoalDifference(gf - ga);
            standing.updatePoints((won * 3) + drawn);
        }

        java.util.List<GroupStanding> sortedStandings = standings.stream().sorted(Comparator.comparing(GroupStanding::getPoints).reversed()
                .thenComparing(Comparator.comparing(GroupStanding::getGoalDifference).reversed())
                .thenComparing(Comparator.comparing(GroupStanding::getGoalsFor).reversed()))
                .collect(java.util.stream.Collectors.toList());

        int rank = 1;
        for (GroupStanding standing : sortedStandings) {
            standing.updateStandingRank(rank++);
            standing.auditAs("Update standing rank").save(ctx);
        }
    }

    private void printGroupStandings(UserContext ctx, String groupLetter) {
        System.out.println(AnsiColors.bold("Updated Group " + groupLetter + " standings:"));
        System.out.printf(AnsiColors.BOLD + " %s %s %2s  %2s  %2s  %2s   %2s  %2s  %3s  %3s"
                + AnsiColors.RESET + "%n",
                AnsiColors.padRight("#", 3), AnsiColors.padRight("Team", 40), "P", "W", "D", "L", "GF", "GA", "GD", "Pts");

        MatchGroup g = Q.matchGroups().filterByGroupLetter(groupLetter).comment("Find group").purpose("Display").executeForList(ctx).first();
        SmartList<GroupStanding> standings = Q.groupStandings()
                .selectTournamentTeam()
                .filterByMatchGroup(g)
                .orderByStandingRankAscending()
                .comment("Load sorted standings")
                .purpose("Display")
                .executeForList(ctx);

        for (GroupStanding gs : standings) {
            TournamentTeam team = gs.getTournamentTeam();
            if (team != null && team.getTeamName() == null) {
                team = Q.tournamentTeams().withIdIs(team.getId()).comment("Load team").purpose("Display").executeForList(ctx).first();
                gs.updateTournamentTeam(team);
            }
            String teamName = team != null ? team.getTeamName() : "TBD";
            String emojiFlag = team != null ? team.getEmojiFlag() : "";
            
            int rank = gs.getStandingRank() != null ? gs.getStandingRank() : 0;
            int played = gs.getPlayed() != null ? gs.getPlayed() : 0;
            int won = gs.getWon() != null ? gs.getWon() : 0;
            int drawn = gs.getDrawn() != null ? gs.getDrawn() : 0;
            int lost = gs.getLost() != null ? gs.getLost() : 0;
            int gf = gs.getGoalsFor() != null ? gs.getGoalsFor() : 0;
            int ga = gs.getGoalsAgainst() != null ? gs.getGoalsAgainst() : 0;
            int gd = gs.getGoalDifference() != null ? gs.getGoalDifference() : 0;
            int pts = gs.getPoints() != null ? gs.getPoints() : 0;

            String gdStr = gd > 0 ? "+" + gd : String.valueOf(gd);
            String coloredGd;
            if (gd > 0) {
                coloredGd = AnsiColors.green(String.format("%3s", gdStr));
            } else if (gd < 0) {
                coloredGd = AnsiColors.red(String.format("%3s", gdStr));
            } else {
                coloredGd = String.format("%3s", gdStr);
            }

            String coloredPts = pts > 0 ? AnsiColors.green(String.format("%3d", pts)) : String.format("%3d", pts);
            String flagStr = (emojiFlag != null && !emojiFlag.isEmpty() ? emojiFlag : "🏳");

            String fullTeamName = flagStr + " " + teamName;
            System.out.printf(" %-3d %s %2d  %2d  %2d  %2d   %2d  %2d  %s  %s%n",
                    rank, AnsiColors.padRight(fullTeamName, 40),
                    played, won, drawn, lost,
                    gf, ga,
                    coloredGd, coloredPts);
        }
        System.out.println();
    }
}
