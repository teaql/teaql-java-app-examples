package io.teaql.worldcup.db;

import com.example.fifaworldcupservice.Q;
import com.example.fifaworldcupservice.confederation.Confederation;
import com.example.fifaworldcupservice.groupstanding.GroupStanding;
import com.example.fifaworldcupservice.matchgroup.MatchGroup;
import com.example.fifaworldcupservice.tournament.Tournament;
import com.example.fifaworldcupservice.tournamentteam.TournamentTeam;
import io.teaql.core.UserContext;

public final class SeedData {

    private SeedData() {}

    private static final int AFC      = 1;
    private static final int CAF      = 2;
    private static final int CONCACAF = 3;
    private static final int CONMEBOL = 4;
    private static final int OFC      = 5;
    private static final int UEFA     = 6;

    public static void seed(UserContext ctx) {
        if (isInitialized(ctx)) {
            return;
        }
        seedTournament(ctx);
        if (Q.matchGroups().comment("Check match groups").purpose("Seed data").executeForList(ctx).isEmpty()) seedGroups(ctx);
        if (Q.groupStandings().comment("Check standings").purpose("Seed data").executeForList(ctx).isEmpty()) seedTeamsAndStandings(ctx);
    }

    public static boolean isInitialized(UserContext ctx) {
        return Q.groupStandings().comment("Check if initialized").purpose("Seed data").executeForList(ctx).size() > 0;
    }

    private static void seedTournament(UserContext ctx) {
        if (Q.tournaments().comment("Check tournament").purpose("Seed data").executeForList(ctx).size() > 0) return;
        Tournament t = new Tournament();
        t.updateTournamentName("FIFA World Cup 2026");
        t.updateHostCountries("United States, Mexico, Canada");
        t.updateStartDate(java.time.LocalDate.parse("2026-06-11"));
        t.updateEndDate(java.time.LocalDate.parse("2026-07-19"));
        t.updateTotalTeams(48);
        t.auditAs("Seed tournament").save(ctx);
    }



    private static void seedGroups(UserContext ctx) {
        Tournament t = Q.tournaments().comment("Load tournament").purpose("Seed groups").executeForList(ctx).first();
        for (char letter = 'A'; letter <= 'L'; letter++) {
            MatchGroup g = new MatchGroup();
            g.updateGroupLetter(String.valueOf(letter));
            g.updateTournament(t);
            g.auditAs("Seed match group").save(ctx);
        }
    }

    private record TeamDef(String name, String code, String flag, int ranking,
                           int confederationId, String group) {}

    private static final TeamDef[] ALL_TEAMS = {
        new TeamDef("Mexico",        "MEX", "\uD83C\uDDF2\uD83C\uDDFD", 15, CONCACAF, "A"),
        new TeamDef("South Africa",  "RSA", "\uD83C\uDDFF\uD83C\uDDE6", 58, CAF,      "A"),
        new TeamDef("South Korea",   "KOR", "\uD83C\uDDF0\uD83C\uDDF7", 22, AFC,      "A"),
        new TeamDef("Denmark",       "DEN", "\uD83C\uDDE9\uD83C\uDDF0", 21, UEFA,     "A"),

        new TeamDef("Canada",        "CAN", "\uD83C\uDDE8\uD83C\uDDE6", 41, CONCACAF, "B"),
        new TeamDef("Qatar",         "QAT", "\uD83C\uDDF6\uD83C\uDDE6", 35, AFC,      "B"),
        new TeamDef("Switzerland",   "SUI", "\uD83C\uDDE8\uD83C\uDDED", 17, UEFA,     "B"),
        new TeamDef("Italy",         "ITA", "\uD83C\uDDEE\uD83C\uDDF9",  4, UEFA,     "B"),

        new TeamDef("Brazil",        "BRA", "\uD83C\uDDE7\uD83C\uDDF7",  3, CONMEBOL, "C"),
        new TeamDef("Morocco",       "MAR", "\uD83C\uDDF2\uD83C\uDDE6", 14, CAF,      "C"),
        new TeamDef("Haiti",         "HAI", "\uD83C\uDDED\uD83C\uDDF9", 89, CONCACAF, "C"),
        new TeamDef("Scotland",      "SCO", "\uD83C\uDFF4",             55, UEFA,     "C"),

        new TeamDef("United States", "USA", "\uD83C\uDDFA\uD83C\uDDF8", 11, CONCACAF, "D"),
        new TeamDef("Paraguay",      "PAR", "\uD83C\uDDF5\uD83C\uDDFE", 57, CONMEBOL, "D"),
        new TeamDef("Australia",     "AUS", "\uD83C\uDDE6\uD83C\uDDFA", 24, AFC,      "D"),
        new TeamDef("Türkiye",       "TUR", "\uD83C\uDDF9\uD83C\uDDF7", 42, UEFA,     "D"),

        new TeamDef("Germany",       "GER", "\uD83C\uDDE9\uD83C\uDDEA",  2, UEFA,     "E"),
        new TeamDef("Curaçao",       "CUW", "\uD83C\uDDE8\uD83C\uDDFC", 85, CONCACAF, "E"),
        new TeamDef("Ivory Coast",   "CIV", "\uD83C\uDDE8\uD83C\uDDEE", 49, CAF,      "E"),
        new TeamDef("Ecuador",       "ECU", "\uD83C\uDDEA\uD83C\uDDE8", 31, CONMEBOL, "E"),

        new TeamDef("Netherlands",   "NED", "\uD83C\uDDF3\uD83C\uDDF1",  6, UEFA,     "F"),
        new TeamDef("Japan",         "JPN", "\uD83C\uDDEF\uD83C\uDDF5", 13, AFC,      "F"),
        new TeamDef("Tunisia",       "TUN", "\uD83C\uDDF9\uD83C\uDDF3", 39, CAF,      "F"),
        new TeamDef("Ukraine",       "UKR", "\uD83C\uDDFA\uD83C\uDDE6", 23, UEFA,     "F"),

        new TeamDef("Belgium",       "BEL", "\uD83C\uDDE7\uD83C\uDDEA",  5, UEFA,     "G"),
        new TeamDef("Egypt",         "EGY", "\uD83C\uDDEA\uD83C\uDDEC", 33, CAF,      "G"),
        new TeamDef("Iran",          "IRN", "\uD83C\uDDEE\uD83C\uDDF7", 20, AFC,      "G"),
        new TeamDef("New Zealand",   "NZL", "\uD83C\uDDF3\uD83C\uDDFF", 93, OFC,      "G"),

        new TeamDef("Spain",         "ESP", "\uD83C\uDDEA\uD83C\uDDF8",  1, UEFA,     "H"),
        new TeamDef("Cape Verde",    "CPV", "\uD83C\uDDE8\uD83C\uDDFB", 74, CAF,      "H"),
        new TeamDef("Saudi Arabia",  "KSA", "\uD83C\uDDF8\uD83C\uDDE6", 56, AFC,      "H"),
        new TeamDef("Uruguay",       "URU", "\uD83C\uDDFA\uD83C\uDDFE",  9, CONMEBOL, "H"),

        new TeamDef("France",        "FRA", "\uD83C\uDDEB\uD83C\uDDF7",  7, UEFA,     "I"),
        new TeamDef("Senegal",       "SEN", "\uD83C\uDDF8\uD83C\uDDF3", 18, CAF,      "I"),
        new TeamDef("Norway",        "NOR", "\uD83C\uDDF3\uD83C\uDDF4", 46, UEFA,     "I"),
        new TeamDef("UAE",           "UAE", "\uD83C\uDDE6\uD83C\uDDEA",       69, AFC,      "I"),

        new TeamDef("Argentina",     "ARG", "\uD83C\uDDE6\uD83C\uDDF7",  8, CONMEBOL, "J"),
        new TeamDef("Algeria",       "ALG", "\uD83C\uDDE9\uD83C\uDDFF", 36, CAF,      "J"),
        new TeamDef("Austria",       "AUT", "\uD83C\uDDE6\uD83C\uDDF9", 27, UEFA,     "J"),
        new TeamDef("Jordan",        "JOR", "\uD83C\uDDEF\uD83C\uDDF4", 68, AFC,      "J"),

        new TeamDef("Portugal",      "POR", "\uD83C\uDDF5\uD83C\uDDF9", 10, UEFA,     "K"),
        new TeamDef("Uzbekistan",    "UZB", "\uD83C\uDDFA\uD83C\uDDFF", 62, AFC,      "K"),
        new TeamDef("Colombia",      "COL", "\uD83C\uDDE8\uD83C\uDDF4", 12, CONMEBOL, "K"),
        new TeamDef("Chile",         "CHI", "\uD83C\uDDE8\uD83C\uDDF1",       40, CONMEBOL, "K"),

        new TeamDef("England",       "ENG", "\uD83C\uDFF4",              4, UEFA,     "L"),
        new TeamDef("Croatia",       "CRO", "\uD83C\uDDED\uD83C\uDDF7", 16, UEFA,     "L"),
        new TeamDef("Ghana",         "GHA", "\uD83C\uDDEC\uD83C\uDDED", 65, CAF,      "L"),
        new TeamDef("Panama",        "PAN", "\uD83C\uDDF5\uD83C\uDDE6", 47, CONCACAF, "L")
    };

    private static void seedTeamsAndStandings(UserContext ctx) {
        Tournament t = Q.tournaments().comment("Load tournament").purpose("Seed teams").executeForList(ctx).first();
        for (TeamDef def : ALL_TEAMS) {
            MatchGroup g = Q.matchGroups().filterByGroupLetter(def.group()).comment("Load group").purpose("Seed teams").executeForOne(ctx);

            TournamentTeam team = new TournamentTeam();
            team.updateTeamName(def.name());
            team.updateTeamCode(def.code());
            team.updateEmojiFlag(def.flag());
            team.updateFifaRanking(def.ranking());
            team.updateGroupLetter(def.group());
            team.updateTournament(t);
            
            switch (def.confederationId()) {
                case AFC: team.updateConfederationToAfc(); break;
                case CAF: team.updateConfederationToCaf(); break;
                case CONCACAF: team.updateConfederationToConcacaf(); break;
                case CONMEBOL: team.updateConfederationToConmebol(); break;
                case OFC: team.updateConfederationToOfc(); break;
                case UEFA: team.updateConfederationToUefa(); break;
            }
            team = (TournamentTeam) team.auditAs("Seed tournament team").save(ctx);

            GroupStanding standing = new GroupStanding();
            standing.updateTournamentTeam(team);
            standing.updateMatchGroup(g);
            standing.updateTournament(t);
            standing.updatePlayed(0);
            standing.updateWon(0);
            standing.updateDrawn(0);
            standing.updateLost(0);
            standing.updateGoalsFor(0);
            standing.updateGoalsAgainst(0);
            standing.updateGoalDifference(0);
            standing.updatePoints(0);
            standing.auditAs("Seed group standing").save(ctx);
        }
    }
}
